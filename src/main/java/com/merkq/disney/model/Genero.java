package com.merkq.disney.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Genero {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	private String nombre;
	private String imagen;
	@OneToMany(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("personajes")
	private List<Pelicula> peliculas;
}
