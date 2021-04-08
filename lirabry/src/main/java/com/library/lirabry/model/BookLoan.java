package com.library.lirabry.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "book_loan")
public class BookLoan {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "checkout_date")
	private LocalDate checkoutDate; 
	
	@Column(name = "to_be_returned_date")
	private LocalDate toBeReturnedDate; 
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "book_id")
	private Book book; 
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "patron_id")
	private Patron patron; 
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "employee_id")
	private Employee employee; 
}
