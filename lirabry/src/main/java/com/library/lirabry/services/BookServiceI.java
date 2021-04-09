package com.library.lirabry.services;

import java.util.List;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.Author;
import com.library.lirabry.model.Book;

public interface BookServiceI {

	List<Book> getAllBooks();

	Book getBookById(Long bookId) throws RecordNotFoundException;

	Book createBook(Book newBook);

	Book updateBook(Book newBook, Long id);

	void deleteBook(Long id);
	
	List<Book> findAllBooksByAuthor(Author author);
}
