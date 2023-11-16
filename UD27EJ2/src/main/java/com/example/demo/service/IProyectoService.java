package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proyecto;

public interface IProyectoService {

	public List<Proyecto> findAll();

	public Proyecto findById(String id);

	public Proyecto update(Proyecto proyecto);

	public Proyecto save(Proyecto proyecto);

	public void delete(String id);

}
