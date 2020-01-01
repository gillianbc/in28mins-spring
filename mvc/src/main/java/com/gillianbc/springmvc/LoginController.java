package com.gillianbc.springmvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gillianbc.jee.business.UserValidationService;

// See todo-servlet.xml for how the return value is decorated with a prefix and a suffix 
// so that it redirects to /WEB-INF/views/login.jsp
@Controller
public class LoginController {
	
	private Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private UserValidationService userValidationService;
	
	@ResponseBody
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String basic() {
		logger.debug("Slash only");
		return "You need to send login or joke to go anywhere";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String goToLoginJSP() {
		logger.info("Hello");
		return "login";
	}
	
	// RequestParam must have the same names as was used on the form in login.jspq
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String username, 
			@RequestParam String password,
			ModelMap model) {
		logger.info("Checking credentials " + username + " " + password);
		// The ModelMap is used to transfer data between the controller and the view 
		model.put("nameattr", username);
		if (userValidationService.isUserValid(username, password))
			return "welcome";
		return "login";
	}
	
	@RequestMapping(value = "/joke", method=RequestMethod.GET)
	public String goToJokeJSP() {
		logger.info("Joke");
		return "joke";
	}

}
