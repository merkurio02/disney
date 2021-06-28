package com.merkq.disney.controller;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.merkq.disney.model.Personaje;
import com.merkq.disney.repository.PersonajeRepository;


@RestController
@RequestMapping("/characters")
public class PersonajeController {
	
	@Autowired
	PersonajeRepository repo;
	
	@GetMapping
	public List<Personaje> getPersonajes() {
		return repo.findAll();
	}
	
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Personaje personaje) {

		repo.save(personaje);
		
	}
	
	
	@GetMapping("/{id}")
	public Personaje getById(@PathVariable int id) {
		System.out.println(	repo.getById(id));
		return repo.getById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Personaje personaje) {

		repo.save(personaje);
		
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		System.out.println(	id);
		 repo.deleteById(id);
	}

	

}
 