package fr.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.registration.model.Article;


@Service
public interface IArticleRepository extends JpaRepository<Article, Integer>{

	public  Article findArticleById(Integer id);
	
}
