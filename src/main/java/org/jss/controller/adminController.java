package org.jss.controller;


import java.util.NoSuchElementException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class adminController {

	@Autowired
	private adminService adser;
	
	@PostMapping("/admin")
	public RedirectView add(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
		model.addAttribute("name",name);
		model.addAttribute("password",password);
		admin admin = new admin(name,password);
		adser.save(admin);
		return login();
	}
	public RedirectView login() {
        return new RedirectView("login");
    }
	
	@RequestMapping(value = "adminlog", method = RequestMethod.POST)
    public String get(@RequestParam("name") String name, @RequestParam("password") String password, HttpSession session) {
        try {
             admin admin = adser.get(name);
             if(admin.getName().equals(name) && admin.getPassword().equals(password)) {
            	 session.setAttribute("name", name);
            	 //System.out.println(session.getAttribute("name"));
            	return "logedin"; 
             }
            return "wrong";
        } catch (NoSuchElementException e) {
        	return "error";
        }
    }
	
	@RequestMapping(value = "admininfo", method = RequestMethod.GET)
    public String get1(HttpSession session, Model model) {
        try {
        	 Object ob = session.getAttribute("name");
        	 String name = (String)ob;
        	 //System.out.println(name);
             admin admin = adser.get(name);
             model.addAttribute("admin", admin);
            return "dispad";
        } catch (NoSuchElementException e) {
        	return "error";
        }
    }
	
	@RequestMapping(value = "adminup", method = RequestMethod.GET)
	public String adminup() {
		return "updatead";
	}
	
	@RequestMapping(value = "adminupdate", method = RequestMethod.POST)
    public String update(@RequestParam("password") String password, Model model, HttpSession session) {
        try {
        	 Object ob = session.getAttribute("name");
        	 String name = (String)ob;
            admin admin = new admin(name,password);
            adser.save(admin);
            admin admin1 = adser.get(name);
            model.addAttribute("admin", admin1);
            return "dispad";
        } catch (NoSuchElementException e) {
            return "error";
        }      
    }
	
	@RequestMapping("admindel")
    public String delete(HttpSession session) {
		Object ob = session.getAttribute("name");
   	    String name = (String)ob;
        adser.delete(name);
        if (session != null) {
	        session.invalidate();
	    }
        return "index";
    }
}
