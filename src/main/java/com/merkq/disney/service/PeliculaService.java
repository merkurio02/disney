package com.merkq.disney.service;

import java.util.List;

import com.merkq.disney.dao.PeliculaDao;
import com.merkq.disney.model.Pelicula;
import com.merkq.disney.model.Personaje;

public interface PeliculaService {

	public List<PeliculaDao> findAll();
	

	public List<PeliculaDao> findByTitulo(String titulo);
	
	public List<PeliculaDao> findByGenero(int id);
	
	public Pelicula getById(int id);
	public void save(Pelicula pelicula);
	public void update(Pelicula pelicula);
	public void delete(int id);

}
