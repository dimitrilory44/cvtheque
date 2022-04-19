
package com.cvtheque.cvtheque.bo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Formation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFormation;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idPersonne", nullable = false)
	private Personne personne;
	
	@Column(nullable = false)
	private Integer dureeForm;
	
	private String description;
	
	private String specialite;
	
	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formation(Integer dureeForm, String description, String specialite) {
		super();
		this.dureeForm = dureeForm;
		this.description = description;
		this.specialite = specialite;
	}
	
	
	
	public Formation(Long idFormation, Integer dureeForm, String description, String specialite) {
		super();
		this.idFormation = idFormation;
		this.dureeForm = dureeForm;
		this.description = description;
		this.specialite = specialite;
	}

	public Personne getPers() {
		return personne;
	}

	public void setPers(Personne personne) {
		this.personne = personne;
	}

	public Integer getDureeForm() {
		return dureeForm;
	}
	
	public void setDureeForm(Integer dureeForm) {
		this.dureeForm = dureeForm;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSpecialite() {
		return specialite;
	}
	
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}
	
	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", dureeForm=" + dureeForm + ", description=" + description
				+ ", specialite=" + specialite + ", personne=" + personne + "]";
	}
	
}
