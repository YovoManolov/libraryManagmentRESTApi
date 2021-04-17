package com.library.lirabry.services;

import java.util.List;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.Book;

public interface BookServiceI {

	List<Book> getAllBooks() throws RecordNotFoundException;

	Book getBookById(Long bookId) throws RecordNotFoundException;

	Book createBook(Book newBook);

	Book updateBook(Book newBook, Long id);

	boolean deleteBook(Long id);

	List<Book> findAllBooksByAuthor(Long authorId);
	
}
