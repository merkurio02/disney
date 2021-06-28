package com.merkq.disney.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

public class Pelicula {
	
	@Id
	private int id;
	private String titulo;
	private String imagen;
	private Date fechaCreacion;
	private double calificacion;
	@ManyToMany(fetch = FetchType.LAZY )
	@JoinTable(name = "pelicula_personajes"
	//,joinColumns = @JoinColumn(name="pelicula_id"),
	//inverseJoinColumns = @JoinColumn(name="personajes_id")
		)
	private List<Personaje> personajes;

}
