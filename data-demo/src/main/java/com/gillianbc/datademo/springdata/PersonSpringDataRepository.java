package com.gillianbc.datademo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gillianbc.datademo.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer>{
	

}
