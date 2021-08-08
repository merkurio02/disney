package com.merkq.disney.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merkq.disney.model.Genero;
import com.merkq.disney.repository.GeneroRepository;
import com.merkq.disney.service.GeneroService;
@Service
public class GeneroServiceImp implements GeneroService {

	@Autowired
	GeneroRepository repo;
	
	@Override
	public void save(Genero genero) {
		repo.save(genero);
		
	}

	@Override
	public List<Genero> findAll() {
		List<Genero> generos = new ArrayList<Genero>();
		repo.findAll().forEach(generos::add);
		return generos;
	}


}
