package com.merkq.disney.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.merkq.disney.model.Genero;
import com.merkq.disney.service.GeneroService;

@RestController
@RequestMapping("/genre")
public class GeneroController {
	
	@Autowired
	GeneroService service;
	
	@GetMapping
	public List<Genero> getAll() {
		return service.findAll();
	}
	
	@PostMapping("/save")
	public void save(@RequestBody Genero genero) {
		service.save(genero);
	}
	

}
