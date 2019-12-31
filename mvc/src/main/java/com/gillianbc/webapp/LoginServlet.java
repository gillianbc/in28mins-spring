package com.gillianbc.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gillianbc.business.UserValidationService;

/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do") - see https://www.codejava.net/java-ee/servlet/webservlet-annotation-examples
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	
	UserValidationService userValidationService = new UserValidationService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set an attribute from the request param http://localhost:8080?name=xxxx
		request.setAttribute("nameattr", request.getParameter("username"));
		System.out.println(request.getAttribute("nameattr"));
		//redirect to the JSP
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set an attribute from the request param http://localhost:8080?name=xxxx
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		request.setAttribute("nameattr", username);
		request.setAttribute("password", pwd);
		
		System.out.println(request.getAttribute("nameattr") + " - " + request.getAttribute("password"));
		
		if (userValidationService.isUserValid(username, pwd))
			//redirect to the Welcome JSP
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		else
			//redirect to the Login JSP
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

}
