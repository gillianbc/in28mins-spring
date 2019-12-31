# Basic Spring MVC Web Application

From course:  https://www.udemy.com/course/spring-tutorial-for-beginners/learn/lecture/5783088

The tutor's sourcecode is here.  Read the various md files for the steps:

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
## Front Controller
web.xml - we have defined a servlet called `dispatcher` associated with `todo-servlet.xml.  This is the "Front Controller" - the receptionist on the front desk.
Anything that comes in on <url-pattern>/spring-mvc/*</url-pattern> will be passed to `dispatcher`

The dispatcher, i.e. `todo-servlet.xml`, does a component scan on the `com.gillianbc` package.

## Handler
In the com.gillianbc.springmvc package, it will find a method flagged with the @Controller annotation in the `LoginController` class.  The `LoginController` class is associated with path @RequestMapping(value = "/login") so will respond to `http://localhost.8080/spring-mvc/login`.

If the method is also flagged with @ResponseBody, the return value will be returned to the browser (see HelloController.java).  

If it doesn't have the @ResponseBody annotation, it considers the return value as a url of a View Resolver, rather than a response body.  So if we return "login', it tries to find a page called "login".

Our views are in **/WEB-INF/views**. We want it to go to login.jsp.  To add that path and the .jsp suffix, we use the InternalResourceViewResolver which extends UrlBasedViewResolver.  The UrlBasedViewResolver has a prefix and a suffix property for exactly this purpose.
We create a bean for the InternalResourceViewResolver in our servlet i.e. todo-servlet.xml.

# Flow of Control
Spring MVC Request Flow

DispatcherServlet receives HTTP Request.
DispatcherServlet identifies the right Controller based on the URL.
Controller executes Business Logic.
Controller returns a) Model b) View Name Back to DispatcherServlet.
DispatcherServlet identifies the correct view (ViewResolver).
DispatcherServlet makes the model available to view and executes it.
DispatcherServlet returns HTTP Response Back.
Flow : http://docs.spring.io/spring-framework/docs/2.0.8/reference/images/mvc.png

