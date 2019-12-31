package com.gillianbc.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Since we have used the @ResponseBody annotation, the return value will be 
 * returned as the Http response
 * @author gillianbc
 *
 */
@Controller
public class HelloController {
	@RequestMapping(value = "/hello")
	@ResponseBody
	public String sayHello() {
		return "Hello World - from the sayHello() method of HelloController.java";
	}

}
