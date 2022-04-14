package com.cvtheque.cvtheque.bo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExperience;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idPersonne")
	private Personne pers;

	private Integer anneeDebut;
	private Integer anneeFin;
	private String posteOccupe;
	private String description;

	public Experience() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Experience(Integer anneeDebut, Integer anneeFin, String posteOccupe, String description) {
		super();
		this.anneeDebut = anneeDebut;
		this.anneeFin = anneeFin;
		this.posteOccupe = posteOccupe;
		this.description = description;
	}

	public Personne getPers() {
		return pers;
	}

	public void setPers(Personne pers) {
		this.pers = pers;
	}

	public String getPosteOccupe() {
		return posteOccupe;
	}

	public Integer getAnneeDebut() {
		return anneeDebut;
	}

	public void setAnneeDebut(Integer anneeDebut) {
		this.anneeDebut = anneeDebut;
	}

	public Integer getAnneeFin() {
		return anneeFin;
	}

	public void setAnneeFin(Integer anneeFin) {
		this.anneeFin = anneeFin;
	}

	public void setPosteOccupe(String posteOccupe) {
		this.posteOccupe = posteOccupe;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getIdExperience() {
		return idExperience;
	}

	public void setIdExperience(Long idExperience) {
		this.idExperience = idExperience;
	}

	@Override
	public String toString() {
		return "Experience [anneeDebut=" + anneeDebut + ", anneeFin=" + anneeFin + ", posteOccupe=" + posteOccupe
				+ ", description=" + description + "]";
	}

}
