package com.library.lirabry.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "author")
public class Author extends RepresentationModel<Author> {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birth_place")
	private String bitrthPlace; 

	@Column(name = "birth_date")
	private LocalDate bitrthDate; 
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	@JsonBackReference(value="author-books")
	private Set<Book> books;
	
}
