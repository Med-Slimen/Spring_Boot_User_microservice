package com.slimen.projet;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.slimen.projet.entities.Departement;
import com.slimen.projet.entities.Projet;
import com.slimen.projet.repos.ProjetRepository;

@SpringBootTest
class ProjetApplicationTests {

	@Autowired
	private ProjetRepository projetRepository;
	@Test
	public void testCreateProjet() {
	Projet proj = new Projet("Creation d un app mobile","3isam",new Date(),"3isam01@gmail.com");
	projetRepository.save(proj);
	}
	@Test
	public void testFindProjet()
	{
	Projet p = projetRepository.findById(1L).get();
	System.out.println(p);
	}
	@Test
	public void testUpdateProjet()
	{
	Projet p = projetRepository.findById(1L).get();
	p.setNomProjet("APP MOBILE");
	projetRepository.save(p);
	System.out.println(p);
	}
	@Test
	public void testDeleteProjet()
	{
	projetRepository.deleteById(1L);;
	}
	@Test
	public void testFindAllProjet()
	{
		List<Projet> projs=projetRepository.findAll();
		for(Projet p:projs) {
			System.out.println(p);
		}
	}
	@Test
	public void testFindProjetByNom()
	{
	List<Projet> projs = projetRepository.findByNomProjet("Creation d un site");
	for(Projet p:projs) {
		System.out.println(p);
	}
	}
	@Test
	public void testFindProjetByNomContains()
	{
	List<Projet> projs = projetRepository.findByNomProjetContains("C");
	for(Projet p:projs) {
		System.out.println(p);
	}
	}
	@Test
	public void testfindByNomPrix()
	{
	List<Projet> projs = projetRepository.findByNomDate("Creation d un site", new Date());
	for (Projet p : projs)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testfindByCategorie()
	{
	Departement dep = new Departement();
	dep.setIdDepart(1L);;
	List<Projet> projs = projetRepository.findByDepartement(dep);
	for (Projet p : projs)
	{
	System.out.println(p);
	}
	}
	@Test
	public void findByDepartementIdDepart()
	{
		List<Projet> projs = projetRepository.findByDepartementIdDepart(1L);
		for (Projet p : projs)
		{
		System.out.println(p);
		}
	 }
	@Test
	public void testfindByOrderByNomProjetAsc()
	{
	List<Projet> prods =
	projetRepository.findByOrderByNomProjetAsc();
	for (Projet p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testTrierProduitsNomsPrix()
	{
	List<Projet> prods = projetRepository.trierProjetsNomsDate();
	for (Projet p : prods)
	{
	System.out.println(p);
	}
	}

}
