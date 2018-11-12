package fr.registration.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.registration.model.Article;
import fr.registration.service.ArticleService;

@Controller
public class MainController {

	@Autowired
	ArticleService articleService;
	
    @RequestMapping(value={"/", "index"})
    public String home(Model model, @RequestParam(name="page", defaultValue="0") int page) {
    	
    	
    	
    	Pageable pageable = new PageRequest(page,12);
    	Page<Article> pageArticles = articleService.findAllByOrderByIdDesc(pageable);

    	int pagesCount = pageArticles.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pagesCount; i++) {
			pages[i] =i;
		}
		
		
		model.addAttribute("pageCourante", page);
		model.addAttribute("pages", pages);
		model.addAttribute("pageArticles", pageArticles);
    	
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
