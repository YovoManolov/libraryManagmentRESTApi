package com.library.lirabry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.lirabry.model.BookLoan;

public interface BookLoanRepository extends JpaRepository<BookLoan,Long>{

}