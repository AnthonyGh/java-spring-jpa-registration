package fr.registration.web;

import java.io.IOException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fr.registration.model.Chapitre;
import fr.registration.service.BookService;
import fr.registration.service.ChapitreService;


@Controller
public class ChapitreController {
	
	
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ChapitreService chapitreService;
	

	@GetMapping("/chapitre/{id}")
    public String showChapitreById(Model model, @PathVariable("id") Integer id) {
    	Chapitre chapitre = chapitreService.findChapitreById(id);
    	model.addAttribute("chapitre", chapitre);
        return "/chapitre/chapitre";
    }
	
	
	@RequestMapping(value="/admin/creer-chapitre", method=RequestMethod.GET)
	public String formChapitre(Model model) {
		model.addAttribute("chapitre", new Chapitre());
		model.addAttribute("bookList", bookService.findAllBooks());
		
		return "/admin/createformchapitre";
	}
	
	@RequestMapping(value="/admin/saveChapitre", method=RequestMethod.POST)
	public String saveChapitre(@Valid Chapitre chapitre, BindingResult bindingResult) throws IllegalStateException, IOException {
		if(bindingResult.hasErrors()) {
			return "/admin/createformchapitre";
		}
		
		chapitreService.createChapitre(chapitre);

		return "redirect:/admin";
	}
	
	
	@RequestMapping(value="/admin/editer-chapitre")
	public String showFormEdit(Integer id, Model model) {
		Chapitre chapitre = chapitreService.findChapitreById(id);		
		model.addAttribute("chapitre", chapitre);
		model.addAttribute("bookList", bookService.findAllBooks());
		return "/admin/editformchapitre";
	}
	
	@RequestMapping(value="/admin/updateChapitre", method=RequestMethod.POST)
	public String updateChapitre(@Valid Chapitre chapitre, BindingResult bindingResult) throws IllegalStateException, IOException {
		if(bindingResult.hasErrors()) {
			return "/admin/editformchapitre";
		}
		
		chapitreService.updateChapitre(chapitre);
		
		return "redirect:/admin";
	}
	
	
	
	@RequestMapping(value="/admin/supprimer-chapitre")
	public String supprimer(Integer id) {
		chapitreService.deleteChapitreById(id);
		return "redirect:/admin";
	}
	
	
	
	
}