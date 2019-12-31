# Basic Spring MVC Web Application

From course:  https://www.udemy.com/course/spring-tutorial-for-beginners/learn/lecture/5783088

The tutor's sourcecode is here:

https://github.com/in28minutes/spring-master-class/tree/master/02-basic-web-application

# Description

First we build a standard web application.  We start with a servlet then progress to a JSP which makes it easier to output HTML (though that gets converted to a servlet by the framework).
Later we convert the app to a Spring MVC webapp.

The JSPs live in the WEB-INF folder.

# To run from Eclipse
Right-click, Run as, Maven .. ==> enter `tomcat7:run`  in Goals field of the launch configuration
Access the app on http://localhost:8080 - or http://localhost:8080/login.do
Later we add request params e.g. http://localhost:8080?name=something

# Issues
bind exception - address already in use.  You've probably run it before and it's not been terminated on 8080.  Click the xx double-cross in the Console tab - remove all terminated launches

## pom.xml
javaee-web-api - for our javax servlet so that we can have gets, posts etc
maven-compiler-plugin - maven will build the war file for us
tomcat7-maven-plugin - maven will run the tomcat webserver for us and reload when source changes detected

## LoginServlet.java
Processes an HTTP request and sends a response

## web.xml
Defines the default page for localhost:8080 as login.do