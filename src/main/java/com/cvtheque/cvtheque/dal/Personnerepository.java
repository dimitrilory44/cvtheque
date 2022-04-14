package com.cvtheque.cvtheque.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cvtheque.cvtheque.bo.Personne;

@Repository
public interface Personnerepository extends CrudRepository<Personne, Long> {
	

}
