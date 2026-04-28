package com.slimen.projet.service;

import java.util.Date;
import java.util.List;

import com.slimen.projet.dto.ProjetDTO;
import com.slimen.projet.entities.Departement;
import com.slimen.projet.entities.Projet;

public interface ProjetService {
	ProjetDTO saveProjet(ProjetDTO p);
	ProjetDTO updateProjet(ProjetDTO p);
	void deleteProjet(Projet p);
	 void deleteProjetById(Long id);
	 ProjetDTO getProjet(Long id);
	List<ProjetDTO> getAllProjets();
	List<Projet> findByNomProjet(String nom);
	List<Projet> findByNomProjetContains(String nom);
	List<Projet> findByNomDate (String nom, Date date);
	List<Projet> findByDepartement (Departement departement);
	List<Projet> findByDepartementIdDepart(Long id);
	List<Projet> findByOrderByNomProjetAsc();
	List<Projet> trierProjetsNomsDate();
	ProjetDTO convertEntityToDto (Projet produit);
	Projet convertDtoToEntity(ProjetDTO produitDto);



}
