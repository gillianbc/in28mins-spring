# Basic Spring MVC Web Application

From course:  https://www.udemy.com/course/spring-tutorial-for-beginners/learn/lecture/5783088

The tutor's sourcecode is here:

https://github.com/in28minutes/spring-master-class/tree/master/02-basic-web-application

# Description

We now convert the standard web app (see branch mvc) into a Spring MVC webapp.

Step 11 : Configure application to use Spring MVC
Step 12 : First Spring MVC Controller, @ResponseBody, @Controller
Step 13 : Redirect to Login JSP - LoginController, @ResponseBody and View Resolver
Step 14 : DispatcherServlet and Log4j
Step 15 : Show userid and password on the welcome page - ModelMap and @RequestParam
Step 16 : LoginService and Remove all JEE Servlets based code
Step 17 : Spring Auto-wiring and Dependency Management - @Autowired and @Service

The JSPs live in the WEB-INF folder.

# To run from Eclipse
Right-click, Run as, Maven .. ==> enter `tomcat7:run`  in Goals field of the launch configuration
Access the app on http://localhost:8080/spring-mvc
Later we add request params e.g. http://localhost:8080?name=something

# Issues
bind exception - address already in use.  You've probably run it before and it's not been terminated on 8080.  Click the xx double-cross in the Console tab - remove all terminated launches

# How does it work?
web.xml - we have defined a servlet called `dispatcher` associated with `todo-servlet.xml`
Anything that comes in on <url-pattern>/spring-mvc/*</url-pattern> will be passed to `dispatcher`

The dispatcher, i.e. `todo-servlet.xml`, does a component scan on the `com.gillianbc` package.

In the com.gillianbc.springmvc package, it will find a method flagged with the @Controller annotation in the `LoginController` class.  The `LoginController` class is associated with path @RequestMapping(value = "/login") so will respond to `http://localhost.8080/spring-mvc/login`.
Since the method is also flagged with @ResponseBody, the return value will be returned to the browser.  (If it didn't have the @ResponseBody annotation, it would think the return value was a url to go to, rather than a response).
