package com.cvtheque.cvtheque.ws;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.cvtheque.cvtheque.bo.Formation;
import com.cvtheque.cvtheque.bo.Personne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cvtheque.cvtheque.bll.CVManager;

@RestController
public class CVWS {
	
	private static final Logger logger = LoggerFactory.getLogger(CVWS.class);

	@Autowired
	CVManager manager;
	
	@GetMapping("/")
	@CrossOrigin("http://localhost:4200")
	private ResponseEntity<String> requestRest() {
		Long count = manager.compteurPersonne();
		String countString = String.valueOf(count);
		return new ResponseEntity<>("Bienvenue sur mon service RESTFUL. Le nombre d'utilisateur est de " + countString, HttpStatus.BAD_REQUEST);
	}
	
	// Récupération de l'entité USERS

	@PostMapping("/users")
	@CrossOrigin("http://localhost:4200")
	private ResponseEntity<Personne> ajoutPersonne(@RequestBody Personne personne) {
		return new ResponseEntity<>(manager.ajoutpersonne(personne), HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/users")
	public List<Personne> listePersonne() {
		return manager.lstPersonne();
	}
	
	@GetMapping("/users/{id}")
	public Optional<Personne> afficherPersonne(@PathVariable String id) {
		Long personid = (long) Integer.parseInt(id);
		return (Optional<Personne>) manager.findPersonneById(personid);
	}
	
	@PutMapping("/users/{id}")
	public Personne updatePersonne(@PathVariable String id, @RequestBody Personne personne) throws NullPointerException {
		Personne p = new Personne();
		try {
			// Je récupère la personne en fonction de l'id
			p = manager.findPersonneById((long) Integer.parseInt(id)).get();
			p.setNom(personne.getNom());
			p.setPrenom(personne.getPrenom());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return manager.ajoutpersonne(p);
	}
	
	@DeleteMapping("/users/{id}")
	public String deletePersonne(@PathVariable String id) {
		Long personid = (long) Integer.parseInt(id);
		manager.deleteById(personid);
		return "la personne a bien été supprimé";
	}
	
	// Récupération de l'entité FORMATION

//	// La formation avec la personne qui l'a réalisé
//	// Problème lié à l'ID personne 
//	@GetMapping("/users/{id}/formations")
//	public Set<Formation> listeFormation(@PathVariable("id") String id) {
//		Long personid = (long) Integer.parseInt(id);
//		Set<Formation> lsteFormation = new HashSet<Formation>();
//						
//		for(Formation f : manager.lstFormation()) {
//			if(f.getPers().getId() == personid) {
//				lsteFormation.add(f);
//			}
//		}
//		System.out.println("listeFormation");
//		System.out.println("------------------");
//		System.out.println(lsteFormation);
//		return lsteFormation;
//	}
	
	@PostMapping("/users/{id}/formations")
	public Formation ajoutFormation(@PathVariable String id, @RequestBody Formation f) {
		Long idPersonne = (long) Integer.parseInt(id);
		Formation formation = manager.addFormation(idPersonne, f).get();
		
		return formation;
	}
	
	@PutMapping("/users/{idUser}/formations/{idFormation}")
	public Formation updateFormation(@PathVariable("idUser") String idUser, @PathVariable("idFormation") String idForm, @RequestBody Formation f) {
		Long idPersonne = (long) Integer.parseInt(idUser);
		Formation formation = new Formation();
				
		formation.setDureeForm(f.getDureeForm());
		formation.setDescription(f.getDescription());
		formation.setSpecialite(f.getSpecialite());
		
		return manager.addFormation(idPersonne, formation).get();
	}
	
	@DeleteMapping("/users/{idUser}/formations/{idFormation}")
	public Formation deleteFormation(@PathVariable("idUser") String idUser, @PathVariable("idFormation") String idFormation) {
		return null;
	}

}
