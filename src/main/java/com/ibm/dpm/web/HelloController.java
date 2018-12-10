package com.ibm.dpm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/say")
	public String sayHello(ModelMap map) {
		System.out.println("test");
		map.addAttribute("name","admin");
		return "hello/hello";
		
	}
	
	
}
