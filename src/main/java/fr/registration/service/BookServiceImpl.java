package fr.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.registration.model.Book;
import fr.registration.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository dao;
	
	@Override
	public void createBook(Book book) {
		dao.save(book);		
	}

	@Override
	public void updateBook(Book book) {
		dao.save(book);
	}

	@Override
	public void deleteBookById(Integer id) {
		dao.delete(id);
	}

	@Override
	public List<Book> findAllBooks() {
		return dao.findAll();
	}

	@Override
	public Book findBookById(Integer id) {
		return dao.findBookById(id);
	}

	
	
}
