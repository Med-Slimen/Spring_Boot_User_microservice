package com.slimen.projet.restcontrollers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slimen.projet.dto.ProjetDTO;
import com.slimen.projet.entities.Projet;
import com.slimen.projet.service.ProjetService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProjetRESTController {
	@Autowired
	ProjetService projetService;
	
	//@GetMapping()
	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<ProjetDTO> getAllProjets() {
		return projetService.getAllProjets();
	}
	//@RequestMapping(value="/{id}",method = RequestMethod.GET)
	//@GetMapping("/{id}")
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public ProjetDTO getProduitById(@PathVariable("id") Long id) {
		return projetService.getProjet(id);
	}
	//@RequestMapping(method = RequestMethod.POST)
	//@PostMapping()
	@PostMapping("/addproj")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ProjetDTO createProjet(@RequestBody ProjetDTO projet) {
	return projetService.saveProjet(projet);
	}
	//@RequestMapping(method = RequestMethod.PUT)
	//@PutMapping()
	@PutMapping("/updateproj")
	public ProjetDTO updateProduit(@RequestBody ProjetDTO projet) {
	return projetService.updateProjet(projet);
	}
	//@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	//@DeleteMapping("/{id}")
	@DeleteMapping("/delproj/{id}")
	public void deleteProduit(@PathVariable("id") Long id)
	{
		projetService.deleteProjetById(id);
	}
	//@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	@GetMapping("/projDeps/{idDepart}")
	public List<Projet> getProjetsByDepId(@PathVariable("idDepart") Long idDepart) {
	return projetService.findByDepartementIdDepart(idDepart);
	}
	@GetMapping("/auth")
	Authentication getAuth(Authentication auth)
	{
	return auth;
	}


}
