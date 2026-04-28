package com.slimen.projet.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Departement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDepart;
	private String nomDepart;
	@JsonIgnore
	@OneToMany(mappedBy="departement")
	private List<Projet> projets;
	
	public Long getIdDepart() {
		return idDepart;
	}
	public void setIdDepart(Long idDepart) {
		this.idDepart = idDepart;
	}
	public String getNomDepart() {
		return nomDepart;
	}
	public void setNomDepart(String nomDepart) {
		this.nomDepart = nomDepart;
	}
	public List<Projet> getProjets() {
		return projets;
	}
	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}
}
