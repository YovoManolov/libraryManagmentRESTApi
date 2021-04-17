package com.library.lirabry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.library.lirabry.model.Author;
import com.library.lirabry.servicesImpl.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;

	@GetMapping("/")
	public ResponseEntity<List<Author>> getAllAuthors() throws RecordNotFoundException {
		List<Author> authorList = authorService.getAllAuthors();
		return new ResponseEntity<List<Author>>(authorList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable(value = "id") Long authorId) throws RecordNotFoundException {

		Author author = authorService.getAuthorById(authorId);
		return new ResponseEntity<Author>(author, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Author> createAuthor(@RequestBody Author author) {

		Author createdAuthor = authorService.createAuthor(author);
		return new ResponseEntity<Author>(createdAuthor, HttpStatus.CREATED);
	}

	@PutMapping(value="/{id}",
			consumes={ MediaType.APPLICATION_JSON_VALUE},
			produces = { MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Author> updateAuthor(@RequestBody Author newAuthor, @PathVariable Long id)
			throws RecordNotFoundException {

		Author updatedAuthor = authorService.updateAuthor(newAuthor, id);
		return new ResponseEntity<Author>(updatedAuthor, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAuthorById(@PathVariable("id") Long authorId)
			throws RecordNotFoundException {
		boolean result = authorService.deleteAuthor(authorId);
		if(result) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
