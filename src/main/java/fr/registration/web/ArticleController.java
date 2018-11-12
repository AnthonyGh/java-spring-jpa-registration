package fr.registration.web;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.registration.model.Article;
import fr.registration.service.ArticleService;


@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;

	@GetMapping("/article/{id}")
    public String home1(Model model, @PathVariable("id") Integer id) {
    	Article article = articleService.findArticleById(id);
    	model.addAttribute("article", article);
        return "/article/article";
    }
	
	
	
	
	
	
	
	@RequestMapping(value="/creer-article", method=RequestMethod.GET)
	public String formArticle(Model model) {
		model.addAttribute("article", new Article());
		return "/user/createformarticle";
	}
	
	@RequestMapping(value="/saveArticle", method=RequestMethod.POST)
	public String saveArticle(@Valid Article article, BindingResult bindingResult, Principal principal) throws IllegalStateException, IOException {
		if(bindingResult.hasErrors()) {
			return "/user/createformarticle";
		}
		
		String userEmail = principal.getName();
		
		article.setDateCreate(LocalDate.now());
		article.setEmail(userEmail);
		articleService.createArticle(article);
		
		return "redirect:user";
	}
	
	
	
	@RequestMapping(value="/editer")
	public String showFormEdit(Integer id, Model model) {
		Article article = articleService.findArticleById(id);		
		model.addAttribute("article", article);
		return "/user/editformarticle";
	}
	
	@RequestMapping(value="/updateArticle", method=RequestMethod.POST)
	public String updateArticle(@Valid Article article, BindingResult bindingResult) throws IllegalStateException, IOException {
		if(bindingResult.hasErrors()) {
			return "/user/editformarticle";
		}

		articleService.updateArticle(article);
		
		return "redirect:user";
	}
	
	
	
	@RequestMapping(value="/supprimer")
	public String supprimer(Integer id) {
		articleService.deleteArticleById(id);
		return "redirect:/user";
	}
	
	
	
	
}