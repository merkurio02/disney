package com.merkq.disney.service;

import java.util.List;

import com.merkq.disney.dao.PersonajeDao;
import com.merkq.disney.model.Pelicula;
import com.merkq.disney.model.Personaje;

public interface PersonajeService {
	public List<PersonajeDao> getPersonajes();
	
	public List<PersonajeDao> getPersonajeByNombre(String nombre);
	public List<PersonajeDao> getPersonajeByEdad(int edad);
	public List<PersonajeDao> getPersonajeByPelicula(int id);

	
	public Personaje getById(int id);
	public void save(Personaje personaje);
	public void update(Personaje personaje);
	public void delete(int id);
}
