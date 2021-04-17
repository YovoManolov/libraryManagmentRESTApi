package com.library.lirabry.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.Book;
import com.library.lirabry.repository.BookRepository;
import com.library.lirabry.services.BookServiceI;

@Service
public class BookService implements BookServiceI {
	
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks() throws RecordNotFoundException {
		
		List<Book> bookList = bookRepository.findAll();
		
        if(bookList.size() > 0) {
            return bookList;
        } else {
            throw new RecordNotFoundException("No book records exist!");
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
	public Book updateBookInfo(Book newBook, Long id) {

		Optional<Object> updatedBook = bookRepository.findById(id).map(bookUpdated -> {

			bookUpdated.setName(newBook.getName());
			bookUpdated.setCopiesAvailable(newBook.getCopiesAvailable());
			bookUpdated.setBookCondition(newBook.getBookCondition());
			
			return bookRepository.save(bookUpdated);
		});

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
	
	@Override
	public List<Book> findAllBooksByAuthor(Long authorId){
		return bookRepository.findByAuthorId(authorId);
	}
}
