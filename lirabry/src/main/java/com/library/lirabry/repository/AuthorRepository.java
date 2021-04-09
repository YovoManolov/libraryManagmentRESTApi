package com.library.lirabry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.lirabry.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>{

}
