package fr.registration.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import fr.registration.model.Article;
import fr.registration.model.User;
import fr.registration.service.ArticleService;
import fr.registration.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/admin")
	public String admin(Model model, Principal principal) {
		
		String userEmail = principal.getName();
		
		User user = userService.findByEmail(userEmail);
		
		
		List<Article> articles = articleService.findAllArticles();
		
		model.addAttribute("articles", articles);
		model.addAttribute("user", user);
    	
		 return "/admin/admin";
	 }
	
	
	
	@GetMapping("/user")
	public String user(Model model, Principal principal) {
		
		// principal me permet de récupérer le nom de la personne identifier avec Spring security
		String userEmail = principal.getName();
		
		User user = userService.findByEmail(userEmail);
		
		List<Article> articles = articleService.findAllArticlesByEmail(userEmail);
		model.addAttribute("articles", articles);
		model.addAttribute("user", user);
		
		return "/user/user";
	 }
}
