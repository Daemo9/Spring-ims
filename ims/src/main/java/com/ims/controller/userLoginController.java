package com.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ims.Service.AuthService;
import com.ims.model.users;

@Controller
public class userLoginController {
	@Autowired
	AuthService authService;
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("users", new users());
		return "/index";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@RequestParam("email")String email, @RequestParam("password")String password) {
		System.out.println("Email : "+email+" Password : "+password);
		boolean isValid = authService.checkUser(email, password);
		if(isValid)
			return "/welcome";
		else
			return "/error";
	}
}
