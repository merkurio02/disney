package com.merkq.disney.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.merkq.disney.model.Pelicula;
import com.merkq.disney.repository.PeliculaRepository;
import com.merkq.disney.service.PeliculaService;

@RestController
@RequestMapping("/movies")
public class PeliculaController {
	
	
	@Autowired
	PeliculaService service;
	
	
	@GetMapping
	public List<Pelicula> getAll(){
		return service.getPeliculas();
		}
	
	@PostMapping("/save")
	public void save(@RequestBody Pelicula pelicula) {
		service.save(pelicula);
	}
	

	@GetMapping("/{id}")
	public Pelicula getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Pelicula pelicula) {

		service.update(pelicula);
		
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}


}
