package fr.registration.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.registration.model.Article;
import fr.registration.service.ArticleService;

@Controller
public class AdminController {
	
	@Autowired
	private ArticleService articleService;
	
	
	@GetMapping("/admin")
	public String admin(Model model) {
		
		List<Article> articles = articleService.findAllArticles();
    	model.addAttribute("articles", articles);
    	
		 return "/admin/admin";
	 }
	
	@GetMapping("/user")
	public String user(Model model) {
		
		List<Article> articles = articleService.findAllArticles();
    	model.addAttribute("articles", articles);
    	
		 return "/user/user";
	 }
}
