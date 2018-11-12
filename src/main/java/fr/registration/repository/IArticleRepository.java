package fr.registration.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import fr.registration.model.Article;


@Service
public interface IArticleRepository extends JpaRepository<Article, Integer>{

	public Article findArticleById(Integer id);
	
	public Page<Article> findAllByOrderByIdDesc(Pageable pageable);
	
	@Query("select t from Article t where t.email = ?1")
	public List<Article> findAllByEmail(String email);
	
}
