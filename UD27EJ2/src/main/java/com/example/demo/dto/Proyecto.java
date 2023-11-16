package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyectos")
public class Proyecto {

	@Id
	private String id;
	private String nombre;
	private int horas;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "asignado_a", joinColumns = { @JoinColumn(name = "proyecto_id") }, inverseJoinColumns = {
			@JoinColumn(name = "cientifico_id") })

	@JsonIgnoreProperties("proyectos")
	private List<Cientifico> cientificos = new ArrayList<>();

	public Proyecto() {
		super();
	}

	public Proyecto(String nombre, int horas, List<Cientifico> cientificos) {
		super();
		this.nombre = nombre;
		this.horas = horas;
		this.cientificos = cientificos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public List<Cientifico> getCientificos() {
		return cientificos;
	}

	public void setCientificos(List<Cientifico> cientificos) {
		this.cientificos = cientificos;
	}

}
