package com.library.lirabry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.lirabry.model.Book;

public interface BookRepository extends JpaRepository<Book,Long>{
	
	List<Book> findByAuthorId(Long authorId);
	
}