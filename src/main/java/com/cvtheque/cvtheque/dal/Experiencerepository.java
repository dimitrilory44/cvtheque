package com.cvtheque.cvtheque.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cvtheque.cvtheque.bo.Experience;

@Repository
public interface Experiencerepository extends CrudRepository<Experience, Long> {

	
}
