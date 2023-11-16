package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Cientifico;
import com.example.demo.service.CientificoServiceImpl;

@RestController
@RequestMapping("/cientifico")
public class CientificoController {

	@Autowired
	CientificoServiceImpl cientificoService;
	
	@GetMapping("/all")
	public List<Cientifico> getAll() {
		return cientificoService.findAll();
	}
	
	@GetMapping("/{id}")
	public Cientifico getById(@PathVariable(name="id") String id) {
		return cientificoService.findById(id);
	}
	
	
	@PostMapping("")
	public Cientifico createCientifico(@RequestBody Cientifico cientifico) {
		return cientificoService.save(cientifico);
	}
	
	@PutMapping("/{id}")
	public Cientifico updateCientifico(@PathVariable(name="id")String id,@RequestBody Cientifico cientifico) {
		
		Cientifico cientificoSeleccionada= new Cientifico();
		
		cientificoSeleccionada= cientificoService.findById(id);
		
		cientificoSeleccionada.setDni(cientifico.getDni());
		cientificoSeleccionada.setNomApels(cientifico.getNomApels());
		cientificoSeleccionada.setProyectos(cientifico.getProyectos());
		
		cientificoSeleccionada = cientificoService.update(cientificoSeleccionada);
		
		return cientificoSeleccionada;
	}
	
	@DeleteMapping("/{id}")
	public void deleteCientifico(@PathVariable(name="id") String id) {
		cientificoService.delete(id);
	}
}
