package com.cvtheque.cvtheque.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@OneToMany(mappedBy = "pers")
	private List<Experience> Experience = new ArrayList<>();

	@OneToMany(mappedBy = "personne")
	private List<Formation> Formation = new ArrayList<>();

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Temporal(TemporalType.DATE)
	@Column(name = "naissance")
	private Date dateNaissance;

	@Column(name = "telephone")
	private String tel;

	@Column(name = "mail")
	private String mail;

	@Column(name = "titre")
	private String titre;

	@Column(name = "photo")
	private String photo;

	@Column(name = "pdf")
	private String pdf;

	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne(String nom, String prenom, Date dateNaissance, String tel, String mail, String titre, String photo,
			String pdf) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.tel = tel;
		this.mail = mail;
		this.titre = titre;
		this.photo = photo;
		this.pdf = pdf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Experience> getExperience() {
		return Experience;
	}

	public void setExperience(List<Experience> experience) {
		Experience = experience;
	}

	public List<Formation> getFormation() {
		return Formation;
	}

	public void setFormation(List<Formation> formation) {
		Formation = formation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	@Override
	public String toString() {
		return "Personne [idPersonne=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", tel=" + tel + ", mail=" + mail + ", titre=" + titre + ", photo=" + photo + ", pdf="
				+ pdf + "]";
	}
	
}
