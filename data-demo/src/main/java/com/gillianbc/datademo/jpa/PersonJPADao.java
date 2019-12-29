package com.gillianbc.datademo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gillianbc.datademo.entity.Person;


@Repository
@Transactional
public class PersonJPADao {
	
	//connect to the database
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);//JPA
	}
	
	//Insert and Update are the same - JPA knows which is which by looking for the id
	public Person insertUpdate(Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		
		entityManager.remove(findById(id));
	}
	
}
