package com.merkq.disney.service;

import java.util.List;

import com.merkq.disney.model.Genero;

public interface GeneroService {

	public List<Genero> findAll();
	public void save(Genero genero);
}
