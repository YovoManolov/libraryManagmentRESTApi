package com.library.lirabry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.Author;
import com.library.lirabry.servicesImpl.AuthorService;

public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
    @GetMapping("/getAll")
    public ResponseEntity<List<Author>> getAllAuthors() {
    	 List<Author> authorList = authorService.getAllAuthors();
         return new ResponseEntity<List<Author>>(authorList, HttpStatus.OK);
    }

    @GetMapping("/getOneById/{id}")
    public ResponseEntity<Author> 
    	getAuthorById(@PathVariable(value = "id") Long authorId) throws RecordNotFoundException {
    	
        Author author = authorService.getAuthorById(authorId);
        return new ResponseEntity<Author>(author, HttpStatus.OK);
    }
   
    @PutMapping("/create")
	public ResponseEntity<Author> createAuthor(
			@RequestBody Author author) {
    	
    		Author createdAuthor = authorService.createAuthor(author);
    		return new ResponseEntity<Author>(createdAuthor, HttpStatus.OK);
    	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Author> updateAuthor(
			@RequestBody Author newAuthor, @PathVariable Long id )
			throws RecordNotFoundException {
		Author updatedAuthor = authorService.updateAuthor(newAuthor,id);
		return new ResponseEntity<Author>(updatedAuthor, HttpStatus.OK);
	}
}
