package fr.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.registration.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
