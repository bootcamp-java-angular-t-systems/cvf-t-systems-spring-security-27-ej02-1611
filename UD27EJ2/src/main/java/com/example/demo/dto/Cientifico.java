package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cientificos")
public class Cientifico {

	@Id
	private String dni;
	private String nomApels;

	@ManyToMany(cascade = { CascadeType.ALL }, mappedBy = "cientificos")
	@JsonIgnoreProperties("cientificos")
	private List<Proyecto> proyectos  = new ArrayList<>();
		
	public Cientifico() {
		super();
	}

	public Cientifico(String dni, String nomApels, List<Proyecto> proyectos) {
		super();
		this.dni = dni;
		this.nomApels = nomApels;
		this.proyectos = proyectos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

}
