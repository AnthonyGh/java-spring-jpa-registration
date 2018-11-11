package fr.registration.service;

import java.util.List;
import org.springframework.stereotype.Service;

import fr.registration.model.Article;



@Service
public interface ArticleService{

	public void createArticle(Article article);
	
	public void updateArticle(Article article);
	
	public void deleteArticleById(Integer id);
	
	public List<Article> findAllArticles();

	public Article findArticleById(Integer id);

}
