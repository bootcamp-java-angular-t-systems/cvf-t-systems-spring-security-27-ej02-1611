package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICientificoDAO;
import com.example.demo.dto.Cientifico;


@Service
public class CientificoServiceImpl implements ICientificoService {
	
	@Autowired
	ICientificoDAO cientificoDAO;
	
	public List<Cientifico> findAll() {
		return cientificoDAO.findAll();
	}
	
	public Cientifico findById(String id) {
		return cientificoDAO.findById(id).get();
	}
	
	public Cientifico save(Cientifico cientifico) {
		return cientificoDAO.save(cientifico);
	}
	
	public Cientifico update(Cientifico cientifico) {
		return cientificoDAO.save(cientifico);
	}
	
	public void delete(String id) {
		cientificoDAO.deleteById(id);
	}

}
