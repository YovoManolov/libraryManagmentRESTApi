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
@Table(name = "patron")
public class Patron extends RepresentationModel<Patron> {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "password")
	private String password;

	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "register_date")
	private LocalDate registerDate;
	
	@OneToMany(mappedBy = "patron", cascade = CascadeType.ALL)
	@JsonBackReference(value="patron_bookLoans")
	private Set<BookLoan> bookLoans;

}
