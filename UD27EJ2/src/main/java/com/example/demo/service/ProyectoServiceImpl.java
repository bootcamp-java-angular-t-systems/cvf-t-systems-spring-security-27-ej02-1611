package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProyectoDAO;
import com.example.demo.dto.Proyecto;

@Service
public class ProyectoServiceImpl implements IProyectoService{
	
	@Autowired
	IProyectoDAO proyectoDAO;
	
	public List<Proyecto> findAll() {
		return proyectoDAO.findAll();
	}
	
	public Proyecto findById(String id) {
		return proyectoDAO.findById(id).get();
	}
	
	public Proyecto save(Proyecto proyecto) {
		return proyectoDAO.save(proyecto);
	}
	
	public Proyecto update(Proyecto proyecto) {
		return proyectoDAO.save(proyecto);
	}
	
	public void delete(String id) {
		proyectoDAO.deleteById(id);
	}

}
