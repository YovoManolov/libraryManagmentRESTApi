package com.library.lirabry.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.Author;
import com.library.lirabry.model.Book;
import com.library.lirabry.repository.BookRepository;
import com.library.lirabry.services.BookServiceI;

public class BookService implements BookServiceI {
	
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks() {
		
		List<Book> bookList = bookRepository.findAll();
		
        if(bookList.size() > 0) {
            return bookList;
        } else {
            return new ArrayList<Book>();
        }
	}

	@Override
	public Book getBookById(Long bookId) throws RecordNotFoundException {
		
	    Optional<Book> book =  bookRepository.findById(bookId);
	    
	    if(book.isPresent()) {
            return book.get();
        } else {
            throw new RecordNotFoundException("No book record exist for given id");
        }
	}

	@Override
	public Book createBook( Book newBook) {
	     return bookRepository.save(newBook);
	}

	@Override
	public Book updateBook(Book newBook, Long id ) {
	
			Function<Book,Book> updateBook = (bookUpdated) -> {
				bookUpdated.setAuthor(newBook.getAuthor());
				bookUpdated.setBookCondition(newBook.getBookCondition());
				bookUpdated.setBookLoans(newBook.getBookLoans());
				bookUpdated.setCopiesAvailable(newBook.getCopiesAvailable());
				bookUpdated.setName(newBook.getName());
				bookUpdated.setPublisher(newBook.getPublisher());
				
				return bookRepository.save(bookUpdated);
			};
			
			Optional<Object> updatedBook = 
					bookRepository.findById(id).map(updateBook);
				
			return (Book) updatedBook.get();
	}
	
	@Override
	public boolean deleteBook(Long id) {
		
		if(bookRepository.findById(id).isPresent()) {
			bookRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
	public List<Book> findAllBooksByAuthor(Author author){
		return bookRepository.findByAuthor(author);
	}
}
