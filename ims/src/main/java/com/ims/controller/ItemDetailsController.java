package com.ims.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ims.Service.ItemsService;
import com.ims.beans.Items;

@Controller
public class ItemDetailsController {
	@Autowired
	ItemsService itemsService;

	@RequestMapping(value = "/addItems", method = RequestMethod.POST)
	public String addItemDetails(Items item,Model model,BindingResult result,HttpServletRequest req ) {
		
		//System.out.println("Item id : "+item.getItmId()+" Actv = "+item.getItmActv());
		itemsService.addItems(item);
		if(!result.hasErrors())
		{
			req.getSession().setAttribute("success", "Item added successfully!!");
			//model.addAttribute("msg","saved");
		}
		else
			model.addAttribute("msg","Error");
		return "redirect:add";
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String deleteItems(Items item, @PathVariable String id) {
		//System.out.println("Item id : "+id);
		itemsService.deleteItems(id);;
		//System.out.println("delete request....");
		return "redirect:/add";
	}
	
	@RequestMapping(value = "/editItems/{id}", method = RequestMethod.POST)
	public String updateItems(Items item, @PathVariable String id) {
		//System.out.println(" editItems == Item id : "+id+" item Name : "+item.getItmDesc());
		itemsService.updateItems(item,id);;
		//System.out.println("update request....");
		return "redirect:/add";
	}
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	
	public String editItemDetails(@PathVariable String id,Model model) {
		Items itm = itemsService.editItemDetails(id);
		model.addAttribute("useItems", itm);	
		//System.out.println(" Retun=rnininin ;;;");
		return "redirect:/add";
	}
	
	@RequestMapping(value = "/next/{pageId}", method = RequestMethod.GET)
	public String getPaginationData(@PathVariable int pageId, Model model) {
		int total = 5;
		if(pageId==1) {
			
		}else {
			pageId = (pageId-1)*total+1;
					
		}
		List<Items> items = itemsService.getItems(pageId,total);
		int totalCount = itemsService.getTotalRecords();
		  System.out.println("List Items : "+items.size()+" Page Id : "+pageId);
		  model.addAttribute("itemList",items);
		  model.addAttribute("totalCount",totalCount); 
		  return null;
	}
}
