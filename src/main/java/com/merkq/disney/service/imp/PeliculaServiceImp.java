package com.merkq.disney.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merkq.disney.dao.PeliculaDao;
import com.merkq.disney.model.Pelicula;
import com.merkq.disney.model.Personaje;
import com.merkq.disney.repository.PeliculaRepository;
import com.merkq.disney.service.PeliculaService;

@Service
public class PeliculaServiceImp implements PeliculaService {

	@Autowired
	private PeliculaRepository repo;
	
	@Override
	public List<Pelicula> getPeliculas() {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		repo.findAll().forEach(peliculas::add);
		return peliculas;
	}

	@Override
	public Pelicula getById(int id) {
		// TODO Auto-generated method stub
		Optional<Pelicula> pelicula=repo.findById(id);
		return pelicula.isPresent()?pelicula.get():null;
	}

	@Override
	public void save(Pelicula pelicula) {

		repo.save(pelicula);
	}

	@Override
	public void update(Pelicula pelicula) {
		repo.save(pelicula);
		
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
		
	}

}
