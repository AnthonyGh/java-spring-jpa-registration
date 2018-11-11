package fr.registration.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.registration.model.Article;
import fr.registration.service.ArticleService;

@Controller
public class MainController {

	@Autowired
	ArticleService articleService;
	
    @GetMapping("/")
    public String home(Model model) {
    	
    	List<Article> articles = articleService.findAllArticles();
    	model.addAttribute("articles", articles);
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
    
    
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

}
