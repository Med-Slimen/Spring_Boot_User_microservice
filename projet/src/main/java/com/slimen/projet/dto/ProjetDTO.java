package com.slimen.projet.dto;

import java.util.Date;
import java.util.List;

import com.slimen.projet.entities.Departement;
import com.slimen.projet.entities.Image;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjetDTO {
	private Long idProjet;
	private String nomProjet;
	private String nomClient;
	private Date dateDeb;
	private String emailClient;
	private Departement departement;
	private List<Image> images;
}
