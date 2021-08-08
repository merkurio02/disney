package com.merkq.disney.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.merkq.disney.dao.PeliculaDao;
import com.merkq.disney.model.Pelicula;
import com.merkq.disney.repository.PeliculaRepository;
import com.merkq.disney.service.PeliculaService;

@RestController
@RequestMapping("/movies")
public class PeliculaController {
	
	
	@Autowired
	PeliculaService service;
	
	
	@GetMapping
	public List<PeliculaDao> getAll(@RequestParam Map<String,String> rParams){
		String name=rParams.getOrDefault("name", null);
		int genre=Integer.parseInt(rParams.getOrDefault("genre", "-1"));
		String order=rParams.getOrDefault("name", null);
		
		if(name!=null)
			//segun el titulo
			return service.findByTitulo(name);
		else
			if(genre>=0) {
				//segun el genero
				return service.findByGenero(genre);
			}
			else
				if(order!=null)
					//el orden
					return null;
				else
		return service.findAll();
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
