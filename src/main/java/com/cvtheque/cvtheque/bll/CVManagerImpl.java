package com.cvtheque.cvtheque.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvtheque.cvtheque.bo.Experience;
import com.cvtheque.cvtheque.bo.Formation;
import com.cvtheque.cvtheque.bo.Personne;
import com.cvtheque.cvtheque.dal.Experiencerepository;
import com.cvtheque.cvtheque.dal.Formationrepository;
import com.cvtheque.cvtheque.dal.Personnerepository;

@Service
public class CVManagerImpl implements CVManager {

	@Autowired
	Personnerepository dao;

	@Autowired
	Formationrepository daof;

	@Autowired
	Experiencerepository daoe;
	
	@Override
	public Long compteurPersonne() {
		return dao.count();
	}

	@Override
	@Transactional
	public Personne ajoutpersonne(Personne p) {
		return dao.save(p);
	}

	@Override
	@Transactional
	public List<Personne> lstPersonne() {
		return (List<Personne>) dao.findAll();
	}
	
	@Override
	public Optional<Personne> findPersonneById(Long id) {
		return dao.findById(id);
	}
	
	@Override
	public void deleteById(Long pId) {
		dao.deleteById(pId);
	}
	
	@Override
	public Optional<Formation> addFormation(Long fid, Formation f) {
		return dao.findById(fid).map(user -> {
			f.setPers(user);
			return daof.save(f);
		});
	}
	
	@Override
	public Optional<Formation> findFormationById(Long id) {
		return daof.findById(id);
	}

	@Override
	@Transactional
	public List<Formation> lstFormation() {
		return (List<Formation>) daof.findAll();
	}

	@Override
	public List<Experience> lstExperience() {
		return (List<Experience>) daoe.findAll();
	}

	@Override
	public List<Experience> Dettrou() {

		List<Experience> lstExperiencetrou = new ArrayList<>();

		// Je parcours la liste des expériences
		for (Experience e : lstExperience()) {
			
			// Je compare les années de debut et de fin et je l'ajoute dans la liste d'experience
			if (e.getAnneeFin().compareTo(e.getAnneeDebut()) > 0) {
				lstExperiencetrou.add(e);
			} else {
				System.out.println("ca ne s'est pas stocké");
			}
		}
		
		//lstExperiencetrou.sort((Experience o1, Experience o2)->o1.getAnneeFin()-o2.getAnneeDebut());
		
		return lstExperiencetrou;
	}

	@Override
	public void deleteFormation(Long id) {
		daof.deleteById(id);
	}
}
