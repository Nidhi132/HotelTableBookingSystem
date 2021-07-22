package org.jss.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class menuController {
	
	@Autowired
	private menuService mnser;
	
	@RequestMapping(value = "listmenu", method = RequestMethod.GET)
    public String get1(Model model) {
        try {
             List<menu> menu = mnser.findAll();
             model.addAttribute("menu", menu);
            return "dispmenu";
        } catch (NoSuchElementException e) {
        	return "error";
        }
    }
	
	@RequestMapping(value = "addmenu", method = RequestMethod.GET)
	public String menuadd() {
		return "addmenu";
	}
	
	@PostMapping("/menu")
	public String add(@RequestParam("name") String name, @RequestParam("cost") float cost, @RequestParam("id") int id, Model model) {
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		model.addAttribute("cost",cost);
		menu menu = new menu(id,name,cost);
		mnser.save(menu);
		 return "redirect:/listmenu";
	}
	
	@RequestMapping(value = "viewmenu", method = RequestMethod.GET )
	public String menu(Model model) {
		try {
            List<menu> menu = mnser.findAll();
            model.addAttribute("menu", menu);
            return "viewmenu";
       } catch (NoSuchElementException e) {
       	return "error";
       }
	}
	
	 @RequestMapping(value="menuup")    
	    public String update(@RequestParam("id") int id, Model model, HttpSession session){  
		 try {
			 session.setAttribute("id", id);
			 menu menu = mnser.get(id);
             model.addAttribute("menu", menu);  
	         return "updatemenu";
		 } catch (NoSuchElementException e) {
	        	return "error";
	     }   
	  }    
	 @RequestMapping("menuedit")
		public String update(@RequestParam("name") String name, @RequestParam("cost") float cost, Model model, HttpSession session) {
		 try {
			 Object ob = session.getAttribute("id");
        	 int id = (int)ob;
			model.addAttribute("id",id);
			model.addAttribute("name",name);
			model.addAttribute("cost",cost);
			menu menu = new menu(id,name,cost);
			mnser.save(menu);
			 return "redirect:/listmenu";
		 } catch (NoSuchElementException e) {
	            return "error";
	        }
		 }
	 
	 @RequestMapping("delmenu")
	    public String delete(@RequestParam("id") int id,  HttpSession session) {
	        mnser.delete(id);
	        return "redirect:/listmenu";
	    }

}
