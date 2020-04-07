package com.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ims.Service.AuthService;
import com.ims.beans.users;
 
@Controller
public class userLoginController {
	@Autowired
	AuthService authService;
	  @RequestMapping(method = RequestMethod.POST)
	  public String loginView(Model model) {
		  
	 model.addAttribute("user",new users());
	 return "index"; 
	 }
	 
	
	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String doLogin(@RequestParam("email")String email, @RequestParam("password")String password, Model model) {
		
		System.out.println("Email : "+email+" Password : "+password);
		
		boolean isValid = authService.checkUser(email, password);
		if(isValid) {
			model.addAttribute("message",email);
			return "/welcome";
		}
		else {
			model.addAttribute("message","Wrong username and password.");
			return "/error";
		}
	}
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	  public String addItems() {
		  
			/* model.addAttribute("user",new users()); */
	 return "/AddItems"; 
	 }
	@RequestMapping(value="/addItems",method = RequestMethod.POST)
	  public String addItemDetails() {
		  System.out.println("addItems called.. ...");
			/* model.addAttribute("user",new users()); */
	 return "redirect:add"; 
	 }
}
