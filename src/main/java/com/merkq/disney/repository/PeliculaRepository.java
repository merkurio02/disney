package com.merkq.disney.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.merkq.disney.model.Pelicula;

@Repository
public interface PeliculaRepository extends  CrudRepository<Pelicula, Integer>{
	
	public List<Pelicula> findByTitulo(String titulo);

}
