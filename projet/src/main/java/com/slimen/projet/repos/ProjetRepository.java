package com.slimen.projet.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.slimen.projet.entities.Departement;
import com.slimen.projet.entities.Projet;
@RepositoryRestResource(path = "rest")
public interface ProjetRepository extends JpaRepository<Projet, Long> {
	List<Projet> findByNomProjet(String nom);
	List<Projet> findByNomProjetContains(String nom);
	/*
	@Query("select p from Projet p where p.nomProjet like %?1 and p.dateDeb < ?2")
	List<Projet> findByNomDate (String nom, Date date);*/
	@Query("select p from Projet p where p.nomProjet like %:nom and p.dateDeb < :date")
	List<Projet> findByNomDate (@Param("nom") String nom,@Param("date") Date date);
	@Query("select p from Projet p where p.departement = ?1")
	List<Projet> findByDepartement (Departement departement);
	List<Projet> findByDepartementIdDepart(Long id);
	List<Projet> findByOrderByNomProjetAsc();
	@Query("select p from Projet p order by p.nomProjet ASC, p.dateDeb ASC")
	List<Projet> trierProjetsNomsDate();

}
