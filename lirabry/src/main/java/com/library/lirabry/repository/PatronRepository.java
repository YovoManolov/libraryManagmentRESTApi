package com.library.lirabry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.lirabry.model.Patron;

public interface PatronRepository extends JpaRepository<Patron,Long>{

}