package com.cvtheque.cvtheque.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cvtheque.cvtheque.bo.Formation;

@Repository
public interface Formationrepository extends CrudRepository<Formation, Long>{
	
}
