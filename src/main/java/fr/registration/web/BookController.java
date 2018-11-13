package fr.registration.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fr.registration.model.Book;
import fr.registration.service.BookService;


@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Value("${dir.images}")
	private String imageDir;
	

	@GetMapping("/book/{id}")
    public String showBookById(Model model, @PathVariable("id") Integer id) {
    	Book book = bookService.findBookById(id);
    	model.addAttribute("book", book);
        return "/book/book";
    }
	
	
	
	
	
	
	
	@RequestMapping(value="/admin/creer-book", method=RequestMethod.GET)
	public String formBook(Model model) {
		model.addAttribute("book", new Book());
		return "/admin/createformbook";
	}
	
	@RequestMapping(value="/admin/saveBook", method=RequestMethod.POST)
	public String saveBook(@Valid Book book, BindingResult bindingResult, @RequestParam(name="picture", required=false) MultipartFile file) throws IllegalStateException, IOException {
		if(bindingResult.hasErrors()) {
			return "/admin/createformbook";
		}
		
		
		if(!(file.isEmpty())) {
			book.setCover(file.getOriginalFilename());
		}

		bookService.createBook(book);
		
		if(!(file.isEmpty())) {
			book.setCover(file.getOriginalFilename());
			file.transferTo(new File(imageDir+book.getId()));
		}

		return "redirect:/admin";
	}
	
	
	/*Permet de récupérer la vue facilement dans le html avec thymeleaf */
	@RequestMapping(value="/getCover", produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getCouverture(long id) throws FileNotFoundException, IOException {
		File file = new File(imageDir+id);
		
		return IOUtils.toByteArray(new FileInputStream(file));
	}
	
	
	
	@RequestMapping(value="/admin/editer-book")
	public String showFormEdit(Integer id, Model model) {
		Book book = bookService.findBookById(id);		
		model.addAttribute("book", book);
		return "/admin/editformbook";
	}
	
	@RequestMapping(value="/admin/updateBook", method=RequestMethod.POST)
	public String updateBook(@Valid Book book, BindingResult bindingResult, @RequestParam(name="picture") MultipartFile file) throws IllegalStateException, IOException {
		if(bindingResult.hasErrors()) {
			return "/admin/editformbook";
		}
		
		if(!(file.isEmpty())) {
			book.setCover(file.getOriginalFilename());
		}

		bookService.updateBook(book);
		
		if(!(file.isEmpty())) {
			book.setCover(file.getOriginalFilename());
			file.transferTo(new File(imageDir+book.getId()));
		}
		
		return "redirect:/admin";
	}
	
	
	
	@RequestMapping(value="/admin/supprimer-book")
	public String supprimer(Integer id) {
		bookService.deleteBookById(id);
		return "redirect:/admin";
	}
	
	
	
	
}