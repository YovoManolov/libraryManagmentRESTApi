package com.library.lirabry.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.Author;
import com.library.lirabry.repository.AuthorRepository;
import com.library.lirabry.services.AuthorServiceI;

public class AuthorService implements AuthorServiceI {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public List<Author> getAllAuthors() {
		
		List<Author> authorList = authorRepository.findAll();
		
        if(authorList.size() > 0) {
            return authorList;
        } else {
            return new ArrayList<Author>();
        }
	}

	@Override
	public Author getAuthorById(Long authorId) throws RecordNotFoundException {
		
	    Optional<Author> author =  authorRepository.findById(authorId);
	    
	    if(author.isPresent()) {
            return author.get();
        } else {
            throw new RecordNotFoundException("No author record exist for given id");
        }
	}

	@Override
	public Author createAuthor( Author newAuthor) {
	     return authorRepository.save(newAuthor);
	}

	@Override
	public Author updateAuthor(Author newAuthor, Long id ) {
	
			Function<Author,Author> updateAuthor = (authorUpdated) -> {
				
				authorUpdated.setBitrthDate(newAuthor.getBitrthDate());
				authorUpdated.setBitrthPlace(newAuthor.getBitrthPlace());
				authorUpdated.setBooks(newAuthor.getBooks());
				authorUpdated.setFirstName(newAuthor.getFirstName());
				authorUpdated.setLastName(newAuthor.getLastName());
				
				return authorRepository.save(authorUpdated);
			};
			
			Optional<Object> updatedAuthor = 
					authorRepository.findById(id).map(updateAuthor);
				
			return (Author) updatedAuthor.get();
	}
	
	@Override
	public boolean deleteAuthor(Long id) {
		if(authorRepository.findById(id).isPresent()) {
			authorRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

}
