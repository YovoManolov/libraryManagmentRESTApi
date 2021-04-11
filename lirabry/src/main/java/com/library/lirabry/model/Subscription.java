package com.library.lirabry.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "subscription")
public class Subscription extends RepresentationModel<Subscription> {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "type")
    private String type;

	@Column(name = "price")
    private Double price;
	
	@OneToMany(mappedBy = "subscription",
			 fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<PatronSubscription> patronSubscriptions;
}
