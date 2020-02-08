package com.ims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class userLoginController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@RequestParam("username")String username, @RequestParam("password")String password) {
		System.out.println("UserName : "+username+" Password : "+password);
		
		return "/welcome";
		
	}
}
