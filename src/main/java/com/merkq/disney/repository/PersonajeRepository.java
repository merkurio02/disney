package com.merkq.disney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.merkq.disney.model.Personaje;

@Repository
public interface PersonajeRepository extends CrudRepository<Personaje, Integer> {

}
