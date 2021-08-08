package com.merkq.disney.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merkq.disney.dao.PersonajeDao;
import com.merkq.disney.model.Pelicula;
import com.merkq.disney.model.Personaje;
import com.merkq.disney.repository.PeliculaRepository;
import com.merkq.disney.repository.PersonajeRepository;
import com.merkq.disney.service.PersonajeService;
@Service
public class PersonajeServiceImp implements PersonajeService {
	@Autowired
	PersonajeRepository repo;
	@Autowired
	PeliculaRepository repoPelicula;
	
	@Override
	public List<PersonajeDao> getPersonajes() {
		// TODO Auto-generated method stub
		List<PersonajeDao> personajes=new ArrayList<PersonajeDao>();
		repo.findAll().forEach(p-> personajes.add(p.toDao()));
		return personajes;
	}
	@Override
	public List<PersonajeDao> getPersonajeByNombre(String nombre) {
		// TODO Auto-generated method stub
		List<PersonajeDao> personajes=new ArrayList<PersonajeDao>();
		repo.findByNombre(nombre).forEach(p-> personajes.add(p.toDao()));
		return personajes;
	}

	@Override
	public List<PersonajeDao> getPersonajeByEdad(int edad) {
		List<PersonajeDao> personajes=new ArrayList<PersonajeDao>();
		repo.findByEdad(edad).forEach(p-> personajes.add(p.toDao()));
		return personajes;
	}

	@Override
	public List<PersonajeDao> getPersonajeByPelicula(int id) {
		List<PersonajeDao> personajes=new ArrayList<PersonajeDao>();
		Optional<Pelicula> peli= repoPelicula.findById(id);
		if(peli.isPresent())
			peli.get().getPersonajes().forEach(p->personajes.add(p.toDao()));
		
		return personajes;
			
	} 

	@Override
	public Personaje getById(int id) {
		// TODO Auto-generated method stub
		Optional<Personaje> p=repo.findById(id);
		
		return p.isPresent()? p.get():null;
	}

	@Override
	public void save(Personaje personaje) {
		repo.save(personaje);
	}

	@Override
	public void update(Personaje personaje) {
		repo.save(personaje);
		
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
		
	}
}
