package com.slimen.projet.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Projet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProjet;
	private String nomProjet;
	private String nomClient;
	private Date dateDeb;
	private String emailClient;
	@ManyToOne
	private Departement departement;
	/*
	@OneToOne
	private Image image;*/
	@OneToMany (mappedBy = "projet",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Image> images;
	//private String imagePath;
	public Projet(String nomProjet, String nomClient, Date dateDeb, String emailClient) {
		super();
		this.nomProjet = nomProjet;
		this.nomClient = nomClient;
		this.dateDeb = dateDeb;
		this.emailClient = emailClient;
	}
	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(Long idProjet) {
		this.idProjet = idProjet;
	}
	public String getNomProjet() {
		return nomProjet;
	}
	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public Date getDateDeb() {
		return dateDeb;
	}
	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}
	public String getEmailClient() {
		return emailClient;
	}
	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}
	@Override
	public String toString() {
		return "Projet [idProjet=" + idProjet + ", nomProjet=" + nomProjet + ", nomClient=" + nomClient + ", dateDeb="
				+ dateDeb + ", emailClient=" + emailClient + "]";
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}/*
	public Image getImage() {
		return image;
		}
	public void setImage(Image image) {
		this.image = image;
	}*/
	public List<Image> getImages() {
		return images;
		}
	/*
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}*/
	
}
