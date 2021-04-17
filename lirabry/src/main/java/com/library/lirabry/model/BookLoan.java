package com.library.lirabry.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "book_loan")
public class BookLoan extends RepresentationModel<BookLoan> {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "checkout_date")
	private LocalDate checkoutDate; 
	
	@Column(name = "to_be_returned_date")
	private LocalDate toBeReturnedDate; 
	
	@ManyToOne
	@JsonBackReference(value="book_loan_book")
	@JoinColumn(name = "book_id")
	private Book book; 
	
	@ManyToOne
	@JsonBackReference(value="book_loan_patron")
	@JoinColumn(name = "patron_id")
	private Patron patron; 
	
	@ManyToOne
	@JsonBackReference(value="book_loan_employee")
	@JoinColumn(name = "employee_id")
	private Employee employee; 
}
