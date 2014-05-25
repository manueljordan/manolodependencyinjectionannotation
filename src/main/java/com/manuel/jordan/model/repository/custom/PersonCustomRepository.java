package com.manuel.jordan.model.repository.custom;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.LinkedHashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Repository;

import com.manuel.jordan.domain.Person;
import com.manuel.jordan.model.repository.PersonRepository;

/**
 * <p>Repository class.
 *    Does not exists a real interaction with a Database.</p>
 *
 * @author Manuel Jordan - dr_pompeii
 *
 */
@Repository
public class PersonCustomRepository implements PersonRepository {

	private static final Logger logger = LoggerFactory.getLogger(PersonCustomRepository.class);
	
	private Map<String,Person> personsMap;

	public PersonCustomRepository(){
		logger.info("PersonCustomRepository no-arg constructor");
		personsMap = new HashMap<String,Person>();
	}
	
	@Override
	public void insertPerson(Person person) {
		personsMap.put(person.getId(), person);
	}
	
	@Override
	public Person getPersonById(String id) {
		return personsMap.get(id);
	}

	@Override
	public Set<Person> getAllPerson() {
		return new LinkedHashSet<Person>(personsMap.values());
	}

	@Override
	public Person updatePerson(Person person) {
		personsMap.put(person.getId(), person);
		return person;
	}

	@Override
	public void deletePersonById(String id) {
		personsMap.remove(id);
	}
	
}
