package fr.registration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.registration.model.Book;

@Service
public interface BookService {

	public void createBook(Book book);

	public void updateBook(Book book);

	public void deleteBookById(Integer id);

	public List<Book> findAllBooks();

}
