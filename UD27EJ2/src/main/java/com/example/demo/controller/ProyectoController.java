package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Cientifico;
import com.example.demo.dto.Proyecto;
import com.example.demo.service.CientificoServiceImpl;
import com.example.demo.service.ProyectoServiceImpl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

	@Autowired
	ProyectoServiceImpl proyectoService;
	
	@Autowired
	CientificoServiceImpl cientificoService;
	
	@Autowired
    private EntityManager entityManager;
	
	
	
	@GetMapping("/all")
	public List<Proyecto> getAll() {
		return proyectoService.findAll();
	}
	
	@GetMapping("/{id}")
	public Proyecto getById(@PathVariable(name="id") String id) {
		return proyectoService.findById(id);
	}
	
	
	@PostMapping("")
	public Proyecto createProyecto(@RequestBody Proyecto proyecto) {
		return proyectoService.save(proyecto);
	}
	
	@PutMapping("/{id}")
	public Proyecto updateProyecto(@PathVariable(name="id")String id,@RequestBody Proyecto proyecto) {
		
		Proyecto proyectoSeleccionada= new Proyecto();
		
		proyectoSeleccionada= proyectoService.findById(id);
		
		proyectoSeleccionada.setNombre(proyecto.getNombre());
		proyectoSeleccionada.setHoras(proyecto.getHoras());
		proyectoSeleccionada.setCientificos(proyecto.getCientificos());
		
		proyectoSeleccionada = proyectoService.update(proyectoSeleccionada);
		
		return proyectoSeleccionada;
	}
	
	@DeleteMapping("/{id}")
	public void deleteProyecto(@PathVariable(name="id") String id) {
		proyectoService.delete(id);
	}
	
	@PostMapping("/proyecto-cientifico/{id}")
	@Transactional
	public ResponseEntity<String> salvarProyectoCientifico(@RequestBody Proyecto proyecto, @PathVariable(name="id")String id) {
	    Proyecto proyectoGuardado = proyectoService.save(proyecto);
	    Cientifico cientifico = cientificoService.findById(id);

	    if (cientifico != null) {
	        proyectoGuardado.getCientificos().add(cientifico);
	        cientifico.getProyectos().add(proyectoGuardado);
	        entityManager.persist(proyectoGuardado);
	        entityManager.persist(cientifico);
	    }

	    return ResponseEntity.ok("Proyecto asociado con éxito al cientifico");
	}
}
