package com.library.lirabry.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.Author;
import com.library.lirabry.model.Book;
import com.library.lirabry.repository.AuthorRepository;
import com.library.lirabry.services.AuthorServiceI;

@Service
public class AuthorService implements AuthorServiceI {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	BookService bookService;
	
	@Override
	public List<Author> getAllAuthors() throws RecordNotFoundException {
		
		List<Author> authorList = authorRepository.findAll();
		
        if(authorList.size() > 0) {
            return authorList;
        } else {
            throw new RecordNotFoundException("No author records exist!");
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
	
		Optional<Object> updatedAuthor = 
				authorRepository.findById(id).map(authorUpdated -> {

			authorUpdated.setBitrthDate(newAuthor.getBitrthDate());
			authorUpdated.setBitrthPlace(newAuthor.getBitrthPlace());
			authorUpdated.setFirstName(newAuthor.getFirstName());
			authorUpdated.setLastName(newAuthor.getLastName());
			
			return authorRepository.save(authorUpdated);
		});

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
