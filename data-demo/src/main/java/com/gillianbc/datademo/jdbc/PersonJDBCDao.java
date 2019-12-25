package com.gillianbc.datademo.jdbc;


import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gillianbc.datademo.entity.Person;

@Repository
public class PersonJDBCDao {
	@Autowired
	JdbcTemplate jdbctemplate;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<Person> findAll() {
		return jdbctemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));

	}
	
	public Person findById(int id) {
		return jdbctemplate.queryForObject("select * from person where id = ?", 
				new Object[] {id},
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	public List<Person> findByLocation(String location) {
		return jdbctemplate.query("select * from person where location = ?", 
				new Object[] {location},
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public List<Person> findByLocationAndName(String location, String name) {
		return jdbctemplate.query("select * from person where location = ? and name = ?", 
				new Object[] {location,name},
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id) {
		return jdbctemplate.update("delete from person where id = ?", 
				new Object[] {id});
	}
	
	public int insert(Person person) {
		Object[] personDetails = new Object[] {person.getId(), 
				person.getName(),
				person.getLocation(),
				new Timestamp(person.getBirthDate().getTime())};
		return jdbctemplate.update("insert into person "
				+ "(id, name, location, birth_date) "
				+ "values (?,?,?,?)", 
				personDetails);
	}
	
	public int update(Person person) {
		Object[] personDetails = new Object[] { 
				person.getName(),
				person.getLocation(),
				new Timestamp(person.getBirthDate().getTime()),
				person.getId()};
		return jdbctemplate.update("update person "
				+ "set name = ?,"
				+ " location = ?,"
				+ " birth_date = ?"
				+ " where id = ?",personDetails);
	}
}
