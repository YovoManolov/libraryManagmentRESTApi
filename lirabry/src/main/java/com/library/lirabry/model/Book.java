package com.library.lirabry.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "book")
public class Book extends RepresentationModel<Book>{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@Column(name = "name")
	private String name;

	@Column(name = "copies_available")
	private Integer copiesAvailable;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "author_id")
	private Author author;
	
	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;

	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "book_condition_id")
	private BookCondition bookCondition;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<BookLoan> bookLoans;
}
