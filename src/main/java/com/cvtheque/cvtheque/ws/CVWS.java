package com.cvtheque.cvtheque.ws;

import java.util.List;

import com.cvtheque.cvtheque.bo.Formation;
import com.cvtheque.cvtheque.bo.Personne;

import org.springframework.beans.factory.annotation.Autowired;
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

@CrossOrigin(origins= "http://localhost:4200")
@RestController
public class CVWS {
	
	@Autowired
	CVManager manager;
	
	// Récupération de l'entité USERS
	@PostMapping("/users")
	private ResponseEntity<String> ajoutPersonne(@RequestBody Personne personne) {
		manager.ajoutpersonne(personne);
		return new ResponseEntity<>("La personne a bien été ajouté", HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<Personne>> listePersonne() {
		return new ResponseEntity<>(manager.lstPersonne(), HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public Personne afficherPersonne(@PathVariable String id) {
		Long personid = (long) Integer.parseInt(id);
		return manager.findPersonneById(personid);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Personne> updatePersonne(@PathVariable String id, @RequestBody Personne personne) throws NullPointerException {
		Personne p = new Personne();
		
		// Je récupère la personne en fonction de l'id
		p = manager.findPersonneById((long) Integer.parseInt(id));
		p.setNom(personne.getNom());
		p.setPrenom(personne.getPrenom());
		
		return new ResponseEntity<>(manager.ajoutpersonne(p), HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	public String deletePersonne(@PathVariable String id) {
		Long personid = (long) Integer.parseInt(id);
		manager.deleteById(personid);
		return "la personne a bien été supprimé";
	}
		
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
	public ResponseEntity<String> deleteFormation(@PathVariable("idUser") String idUser, @PathVariable("idFormation") String idForm) {
		Long idFormation = (long) Integer.parseInt(idForm);
		manager.deleteFormation(idFormation);
		return new ResponseEntity<>("la formation a bien été supprimé", HttpStatus.OK);
	}

}
