package com.merkq.disney.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merkq.disney.dao.PeliculaDao;
import com.merkq.disney.model.Genero;
import com.merkq.disney.model.Pelicula;
import com.merkq.disney.model.Personaje;
import com.merkq.disney.repository.GeneroRepository;
import com.merkq.disney.repository.PeliculaRepository;
import com.merkq.disney.service.PeliculaService;

@Service
public class PeliculaServiceImp implements PeliculaService {

	@Autowired
	private PeliculaRepository repo;
	@Autowired
	private GeneroRepository repoGenero;
	
	@Override
	public List<PeliculaDao> findAll() {
		List<PeliculaDao> peliculas = new ArrayList<PeliculaDao>();
		repo.findAll().forEach(x->peliculas.add(x.toDao()));
		return peliculas;
	}
	
	@Override
	public List<PeliculaDao> findByTitulo(String titulo) {
		// TODO Auto-generated method stub
		List<PeliculaDao> peliculas = new ArrayList<PeliculaDao>();
		repo.findByTitulo(titulo).forEach(x->peliculas.add(x.toDao()));
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


	@Override
	public List<PeliculaDao> findByGenero(int id) {
		
		List<PeliculaDao> peliculas = new ArrayList<PeliculaDao>();
		 Optional<Genero> genero= repoGenero.findById(id);
		 if(genero.isPresent())
			 genero.get().getPeliculas().forEach(x-> peliculas.add(x.toDao()));
		return peliculas ;
	}

	

	

}
