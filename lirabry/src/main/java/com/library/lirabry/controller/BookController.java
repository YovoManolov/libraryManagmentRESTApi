package com.library.lirabry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.Book;
import com.library.lirabry.servicesImpl.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> bookList = bookService.getAllBooks();
		return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId) throws RecordNotFoundException {

		Book book = bookService.getBookById(bookId);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@GetMapping("?author={id}")
	public ResponseEntity<List<Book>> findBooksByAuthorId(@PathVariable(value = "id") Long authorId) throws RecordNotFoundException {
		List<Book> bookList = bookService.findAllBooksByAuthor(authorId);
		return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {

		Book createdBook = bookService.createBook(book);
		return new ResponseEntity<Book>(createdBook, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book newBook, @PathVariable Long id)
			throws RecordNotFoundException {

		Book updatedBook = bookService.updateBook(newBook, id);
		return new ResponseEntity<Book>(updatedBook, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteBookById(@PathVariable("id") Long bookId)
			throws RecordNotFoundException {
		boolean result = bookService.deleteBook(bookId);
		if(result) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
