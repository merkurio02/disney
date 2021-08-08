package com.merkq.disney.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.merkq.disney.dao.PersonajeDao;
import com.merkq.disney.model.Pelicula;
import com.merkq.disney.model.Personaje;

@Repository
public interface PersonajeRepository extends CrudRepository<Personaje, Integer> {

	List<Personaje> findByNombre(String nombre);
	List<Personaje> findByEdad(int edad);

}
