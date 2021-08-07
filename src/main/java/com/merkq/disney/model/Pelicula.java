package com.merkq.disney.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.merkq.disney.dao.PeliculaDao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","personajes"})

public class Pelicula {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String titulo;
	private String imagen;
	private Date fechaCreacion;
	private double calificacion;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("peliculas")
	private List<Personaje> personajes;

}
