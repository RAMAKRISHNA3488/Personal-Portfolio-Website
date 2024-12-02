package com.Personal.Portfolio.Personal_Portfolio_Website.Demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Demo {
	@RequestMapping("/hello")
	@ResponseBody
	public String Greeting() {
		return "Hello World!";
	}
	
	@RequestMapping("/hi")
	@ResponseBody
	public String hi() {
		return "Hi, I am Ram";
	}

}
