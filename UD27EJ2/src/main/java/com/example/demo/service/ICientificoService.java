package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cientifico;

public interface ICientificoService {

	public List<Cientifico> findAll();

	public Cientifico findById(String id);

	public Cientifico update(Cientifico pieza);

	public Cientifico save(Cientifico pieza);

	public void delete(String id);

	
}
