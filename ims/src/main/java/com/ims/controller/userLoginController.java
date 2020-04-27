package com.ims.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ims.Service.AuthService;
import com.ims.Service.ItemsService;
import com.ims.beans.Category;
import com.ims.beans.Items;
import com.ims.beans.users;
 
@Controller
public class userLoginController {
	@Autowired
	AuthService authService;
	@Autowired
	ItemsService itemsService;
	  @RequestMapping(method = RequestMethod.POST)
	  public String loginView(Model model) {
		  
	 model.addAttribute("user",new users());
	 return "index"; 
	 }
	  @RequestMapping("/home")
	public String home() {
		  return "/welcome";
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
	  public String addItems(Model model) {
			 List<Category> catList = itemsService.getCategory();
			 List<Items> items = itemsService.getItems(1,5);
			 int totalRecords = itemsService.getTotalRecords();
			 System.out.println(" I user ontroller : "+totalRecords);
			  System.out.println("List size : "+catList.size());
			  System.out.println("List Items : "+items.size());
			  model.addAttribute("itemList",items); 
			 model.addAttribute("cateList",catList);
			 model.addAttribute("totalCount",totalRecords);
	 return "/AddItems"; 
	 }
	
}
