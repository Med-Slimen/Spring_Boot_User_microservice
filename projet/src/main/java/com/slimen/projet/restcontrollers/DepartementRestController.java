package com.slimen.projet.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slimen.projet.entities.Departement;
import com.slimen.projet.repos.DepartementRepository;

@RestController
@RequestMapping("/api/dep")
@CrossOrigin("*")
public class DepartementRestController {
	@Autowired
	DepartementRepository departementRepository;
	@GetMapping()
	public List<Departement> getAllProjets() {
		return departementRepository.findAll();
	}
	@GetMapping("/{id}")
	public Departement getDepartementById(@PathVariable("id") Long id) {
		return departementRepository.findById(id).get();
	}
}
