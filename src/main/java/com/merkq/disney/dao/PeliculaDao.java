package com.merkq.disney.dao;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.merkq.disney.model.Personaje;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaDao {
	private int id;
	private String titulo;
	private String imagen;
	private Date fechaCreacion;
	private double calificacion;
	
	private List<PersonajeDao> personajes;
	
	
}
