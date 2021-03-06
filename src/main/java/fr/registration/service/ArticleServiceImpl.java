package fr.registration.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.registration.model.Article;
import fr.registration.repository.IArticleRepository;



@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private IArticleRepository dao;
	
	@Override
	public void createArticle(Article article) {
			dao.save(article);
	}

	@Override
	public void updateArticle(Article article) {
		if(article.getId() != null) {
			dao.save(article);
		}
	}

	@Override
	public void deleteArticleById(Integer id) {
		dao.delete(id);
	}

	@Override
	public List<Article> findAllArticles() {
		List<Article> articles = new ArrayList<>(dao.findAll());
		return articles;
	}

	@Override
	public Article findArticleById(Integer id) {
		return dao.findArticleById(id);
	}

	@Override
	public Page<Article> findAllByOrderByIdDesc(Pageable pageable) {
		return dao.findAllByOrderByIdDesc(pageable);
	}

	@Override
	public List<Article> findAllArticlesByEmail(String email) {
		return dao.findAllByEmail(email);
	}

}
