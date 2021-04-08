package com.library.lirabry.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@Column(name = "name")
	private String name;

	@Column(name = "copies_available")
	private Integer copiesAvailable;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "author_id")
	private Author author;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "publisher_id")
	private Publisher publisher;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "book_condition_id")
	private BookCondition bookCondition;
	
	@OneToMany(mappedBy = "book",
			 fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name="book_id", nullable = true)
	private Set<BookLoan> bookLoans;
}
