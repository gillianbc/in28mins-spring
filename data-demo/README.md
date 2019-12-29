# Spring Boot Data Demo

From https://www.udemy.com/course/spring-tutorial-for-beginners/learn/lecture/7725846

For the JPA example, I had to delete the Create Table  script.  It still drops and creates the table, but when I left schema.sql in, I got no data.
I think it's because with JPA, we are letting JPA create our table from the Person Entity.  If we have a create table statement, then this runs additionally i.e. 
- JPA creates table (if it doesn't exist)
- data.sql seeds it with data
- create table statement drops and recreates table again
Hence, no data.

# FindAll
@NamedQuery(name = "find all persons", query="select p from Person p")
This is JPQL, hence the non-standard sql-like syntax