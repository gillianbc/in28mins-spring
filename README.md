# in28mins-spring
For Udemy Course - Spring Framework Masterclass - Learn Spring the Modern Way

I've used branches for various chapters e.g. JBDC example (Lecture 89) is on branch JDBCCrud

- JDBCCrud - h2 database using jdbc template
- JPACrud - h2 database using JPA i.e. hibernate entities
- SpringDataJPA - h2 database using SpringJPA - we don't write a DAO/@Repository class with the CRUD methods. We just let spring work it out
- PostgresDB - same as SpringDataJPA but uses the local postgres database defined in the application.properties
- mvc - servlet, jsp then Spring mvc
  
# Issues
If you get a port 8080 in use, it's probably after you've had some errors when running and Eclipse has held on to the port.
Close and restart Eclipse.
