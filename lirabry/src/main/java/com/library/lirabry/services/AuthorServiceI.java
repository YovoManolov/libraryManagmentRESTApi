package com.library.lirabry.services;

import java.util.List;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.Author;

public interface AuthorServiceI {
	
	List<Author> getAllAuthors();

	Author getAuthorById(Long authorId) throws RecordNotFoundException;

	Author createAuthor(Author newAuthor);

	Author updateAuthor(Author newAuthor, Long id);

	boolean deleteAuthor(Long id);
	
}
