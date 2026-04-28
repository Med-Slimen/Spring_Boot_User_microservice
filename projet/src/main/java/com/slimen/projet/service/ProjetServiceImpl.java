package com.slimen.projet.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slimen.projet.dto.ProjetDTO;
import com.slimen.projet.entities.Departement;
import com.slimen.projet.entities.Projet;
import com.slimen.projet.repos.ImageRepository;
import com.slimen.projet.repos.ProjetRepository;
@Service
public class ProjetServiceImpl implements ProjetService{
	@Autowired
	ProjetRepository projetRepository;
	@Autowired
	ImageRepository imageRepository;
	@Override
	public ProjetDTO saveProjet(ProjetDTO p) {
		// TODO Auto-generated method stub
		return convertEntityToDto( projetRepository.save(convertDtoToEntity(p)));
	}
	@Autowired
	ModelMapper modelMapper;
/*
	@Override
	public Projet updateProjet(Projet p) {
		// TODO Auto-generated method stub
		return projetRepository.save(p);
	}*/
	@Override
	public ProjetDTO updateProjet(ProjetDTO p) {
		
		// ✅ load existing project WITH its images from DB
	    Projet existingProjet = projetRepository.findById(p.getIdProjet())
	        .orElseThrow(() -> new RuntimeException("Projet not found"));
	    
	    // ✅ only update the fields you want, images stay untouched
	    existingProjet.setNomProjet(p.getNomProjet());
	    existingProjet.setNomClient(p.getNomClient());
	    existingProjet.setDateDeb(p.getDateDeb());
	    existingProjet.setEmailClient(p.getEmailClient());
	    existingProjet.setDepartement(p.getDepartement());
	    // ❌ never call existingProjet.setImages() here
	    
	    return convertEntityToDto(projetRepository.save(existingProjet));
	}

	@Override
	public void deleteProjet(Projet p) {
		// TODO Auto-generated method stub
		projetRepository.delete(p);
	}

	@Override
	public void deleteProjetById(Long id) {
		// TODO Auto-generated method stub
		/*
		Projet p = getProjet(id);
		try {
			Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
			} catch (IOException e) {
			e.printStackTrace();
			} */
		projetRepository.deleteById(id);
	}

	@Override
	public ProjetDTO getProjet(Long id) {
		// TODO Auto-generated method stub
		return convertEntityToDto( projetRepository.findById(id).get());
	}

	@Override
	public List<ProjetDTO> getAllProjets() {
		// TODO Auto-generated method stub
		return projetRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public List<Projet> findByNomProjet(String nom) {
		// TODO Auto-generated method stub
		return projetRepository.findByNomProjet(nom);
	}

	@Override
	public List<Projet> findByNomProjetContains(String nom) {
		// TODO Auto-generated method stub
		return projetRepository.findByNomProjetContains(nom);
	}

	@Override
	public List<Projet> findByNomDate(String nom, Date date) {
		// TODO Auto-generated method stub
		return projetRepository.findByNomDate(nom,date);
	}

	@Override
	public List<Projet> findByDepartement(Departement departement) {
		// TODO Auto-generated method stub
		return projetRepository.findByDepartement(departement);
	}

	@Override
	public List<Projet> findByDepartementIdDepart(Long id) {
		// TODO Auto-generated method stub
		return projetRepository.findByDepartementIdDepart(id);
	}

	@Override
	public List<Projet> findByOrderByNomProjetAsc() {
		// TODO Auto-generated method stub
		return projetRepository.findByOrderByNomProjetAsc();
	}

	@Override
	public List<Projet> trierProjetsNomsDate() {
		// TODO Auto-generated method stub
		return projetRepository.trierProjetsNomsDate();
	}
	/*
	@Override
	public ProjetDTO convertEntityToDto(Projet projet) {
	ProjetDTO projetDTO = new ProjetDTO();
	projetDTO.setIdProjet(projet.getIdProjet());
	projetDTO.setNomClient(projet.getNomClient());
	projetDTO.setNomProjet(projet.getNomProjet());
	projetDTO.setEmailClient(projet.getEmailClient());
	projetDTO.setDateDeb(projet.getDateDeb());
	//projetDTO.setDepartement(projet.getDepartement());
	projetDTO.setDepartement(projet.getDepartement());
	 return projetDTO;

	 /*return ProduitDTO.builder()
	.idProduit(produit.getIdProduit())
	.nomProduit(produit.getNomProduit())
	.prixProduit(produit.getPrixProduit())
	.dateCreation(p.getDateCreation())
	.categorie(produit.getCategorie())
	.build();*/
	 
	//}
	@Override
	public ProjetDTO convertEntityToDto(Projet projet) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProjetDTO projetDTO = modelMapper.map(projet, ProjetDTO.class);
	 return projetDTO;
	 }
	@Override
	public Projet convertDtoToEntity(ProjetDTO projetDTO) {
		/*
		Projet projet = new Projet();
		projet.setIdProjet(projetDTO.getIdProjet());
		projet.setNomClient(projetDTO.getNomClient());
		projet.setEmailClient(projetDTO.getEmailClient());
		projet.setDateDeb(projetDTO.getDateDeb());
		projet.setDepartement(projetDTO.getDepartement());*/
		Projet projet = new Projet();
		projet = modelMapper.map(projetDTO, Projet.class);
	 return projet;
	}
	
	
}
