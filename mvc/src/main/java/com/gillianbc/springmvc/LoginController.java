package com.gillianbc.springmvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// See todo-servlet.xml for how the return value is decorated with a prefix and a suffix 
// so that it redirects to /WEB-INF/views/login.jsp
@Controller
public class LoginController {
	
	private Log logger = LogFactory.getLog(this.getClass());
	
	@RequestMapping(value = "/login")
	public String goToLoginJSP() {
		logger.info("Hello");
		return "login";
	}
	
	@RequestMapping(value = "/joke")
	public String goToJokeJSP() {
		logger.info("Joke");
		return "joke";
	}

}
