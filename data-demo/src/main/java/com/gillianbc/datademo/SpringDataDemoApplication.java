package com.gillianbc.datademo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gillianbc.datademo.entity.Person;
import com.gillianbc.datademo.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonSpringDataRepository dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All persons {}",dao.findAll());
		logger.info("One person {}",dao.findById(10002));
//		logger.info("Persons by location {}",dao.findByLocation("New York"));
//		logger.info("Persons by location and name {}",dao.findByLocationAndName("New York", "James"));
		logger.info("Delete person 10001");
		dao.deleteById(10001);
		logger.info("All persons {}",dao.findAll());
//		
		Person p1 = new Person(10005,"Fred","Chesterfield",new Date());
		logger.info("New person {}",dao.save(p1));
		logger.info("All persons {}",dao.findAll());
//		
		p1.setLocation("Derby");
		logger.info("Update person {}",dao.save(p1));
		logger.info("All persons {}",dao.findAll());
	}

}
