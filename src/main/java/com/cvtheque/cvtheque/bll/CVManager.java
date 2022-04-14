package com.cvtheque.cvtheque.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cvtheque.cvtheque.bo.Experience;
import com.cvtheque.cvtheque.bo.Formation;
import com.cvtheque.cvtheque.bo.Personne;

public interface CVManager {
	
	/**
	 * Methode qui permet de renvoyer le nombre de personne en base
	 * @return le nombre de personne
	 */
	public Long compteurPersonne();
	
	/**
	 * Méthode qui permet d'ajouter la personne
	 * @param p
	 * @return l'objet personne
	 */
	public Personne ajoutpersonne(Personne p);
	
	/**
	 * Méthode qui permet de renvoyer l'objet personne suivant son ID
	 * @param id
	 * @return l'objet personne de type optional
	 */
	public Optional<Personne> findPersonneById(Long id);
	
	/**
	 * Méthode qui permet de supprimer une personne suivant son ID
	 * @param pId Correspond à l'ID de la personne
	 */
	public void deleteById(Long pId);
	
	/**
	 * Méthode qui permet de renvoyer la liste de personne
	 * @return la liste de personne
	 */
	public List<Personne> lstPersonne();
	
	/**
	 * Méthode qui permet de renvoyer la liste de formation
	 * @return la liste des formations
	 */
	public List<Formation> lstFormation();
	/**
	 * Méthode qui permet d'ajouter une formation à l'utilisateur
	 * @param fid correspond à l'ID de la personne
	 * @param f correspond à l'objet à ajouter
	 * @return la formation ajouté
	 */
	public Optional<Formation> addFormation(Long fid, Formation f);
	
	public Optional<Formation> findFormationById(Long id);
	/**
	 * Méthode qui permet de renvoyer la liste des expérience
	 * @return la liste des expériences
	 */
	public List<Experience> lstExperience();
	
	/**
	 * Méthode qui permet de renvoyer la liste des expériences 
	 * @return la liste des expérience qui n'ont pas de trou
	 */
	public List<Experience> Dettrou();
		
}
