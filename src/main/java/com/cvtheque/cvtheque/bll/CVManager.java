package com.cvtheque.cvtheque.bll;

import java.util.List;
import java.util.Optional;

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
	 * M�thode qui permet d'ajouter la personne
	 * @param p
	 * @return l'objet personne
	 */
	public Personne ajoutpersonne(Personne p);
	
	/**
	 * M�thode qui permet de renvoyer l'objet personne suivant son ID
	 * @param id
	 * @return l'objet personne de type optional
	 */
	public Personne findPersonneById(Long id);
	
	/**
	 * M�thode qui permet de supprimer une personne suivant son ID
	 * @param pId Correspond � l'ID de la personne
	 */
	public void deleteById(Long pId);
	
	/**
	 * M�thode qui permet de renvoyer la liste de personne
	 * @return la liste de personne
	 */
	public List<Personne> lstPersonne();
	
	/**
	 * M�thode qui permet de renvoyer la liste de formation
	 * @return la liste des formations
	 */
	public List<Formation> lstFormation();
	
	/**
	 * M�thode qui permet d'ajouter une formation � l'utilisateur
	 * @param fid correspond � l'ID de la personne
	 * @param f correspond � l'objet � ajouter
	 * @return la formation ajout�
	 */
	public Optional<Formation> addFormation(Long fid, Formation f);
	
	/**
	 * Methode qui permet de r�cup�rer les informations li� � la formation
	 * @param id de la formation
	 * @return la formation recherch�e
	 */
	public Formation findFormationById(Long id);
	
	public void deleteFormation(Long id);
	
	/**
	 * M�thode qui permet de renvoyer la liste des exp�rience
	 * @return la liste des exp�riences
	 */
	public List<Experience> lstExperience();
	
	/**
	 * M�thode qui permet de renvoyer la liste des exp�riences 
	 * @return la liste des exp�rience qui n'ont pas de trou
	 */
	public List<Experience> Dettrou();
		
}
