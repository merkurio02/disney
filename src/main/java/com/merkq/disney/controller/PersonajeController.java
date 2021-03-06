package com.merkq.disney.controller;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.merkq.disney.dao.PersonajeDao;
import com.merkq.disney.model.Personaje;
import com.merkq.disney.service.PersonajeService;


@RestController
@RequestMapping("/characters")
public class PersonajeController {
	
	@Autowired
	PersonajeService service;
	
	/*@GetMapping
	public List<PersonajeDao> getPersonajes() {
		return service.getPersonajes();
	}
	*/
	
	@GetMapping
	public List<PersonajeDao> getPersonajes(@RequestParam Map<String, String> reqParam) {
		
		String name=reqParam.getOrDefault("name", null);
		int age=Integer.parseInt(reqParam.getOrDefault("age", "0"));
		int idMovie=Integer.parseInt(reqParam.getOrDefault("movies", "0"));
		if(name!=null)
			return service.getPersonajeByNombre(name);//service.getPersonajeByNombre();
		else
			if(age!=0)
			return service.getPersonajeByEdad(age);
			else 
				if(idMovie!=0)
					return service.getPersonajeByPelicula(idMovie);
				else
					return service.getPersonajes();
					
					
		
		
	}
	
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Personaje personaje) {
		System.out.println(personaje);
		service.save(personaje);
		
	}
	
	
	@GetMapping("/{id}")
	public Personaje getById(@PathVariable int id) {
		System.out.println(id);
		return service.getById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Personaje personaje) {

		service.save(personaje);
		
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		System.out.println(	id);
		 service.delete(id);
	}

	

}
 