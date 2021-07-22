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
public class userController {
	
	@Autowired
	private userService usser;
	
	@PostMapping("/user")
	public RedirectView add(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("phone") long phone, @RequestParam("password") String password, Model model) {
		model.addAttribute("name",name);
		model.addAttribute("email",email);
		model.addAttribute("phone",phone);
		model.addAttribute("password",password);
		user user = new user(name,email,phone,password);
		usser.save(user);
		return ulogin();
	}
	public RedirectView ulogin() {
        return new RedirectView("ulogin");
    }
	
	@RequestMapping(value = "userlog", method = RequestMethod.POST)
    public String get(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
        try {
             user user = usser.get(email);
             if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
            	session.setAttribute("email", email);
            	return "ulogedin"; 
             }
            return "wrong";
        } catch (NoSuchElementException e) {
        	return "wrong";
        }
    }
	@RequestMapping(value = "userinfo", method = RequestMethod.GET)
    public String get1(HttpSession session, Model model) {
        try {
        	 Object ob = session.getAttribute("email");
        	 String email = (String)ob;
        	 //System.out.println(name);
             user user = usser.get(email);
             model.addAttribute("user", user);
            return "dispus";
        } catch (NoSuchElementException e) {
        	return "error";
        }
    }
	
	@RequestMapping(value = "userup", method = RequestMethod.GET)
	public String userup() {
		return "updateus";
	}
	
	@RequestMapping(value = "userupdate", method = RequestMethod.POST)
    public String update(@RequestParam("name") String name, @RequestParam("phone") long phone, @RequestParam("password") String password, Model model, HttpSession session) {
        try {
        	 Object ob = session.getAttribute("email");
        	 String email = (String)ob;
        	 user user = new user(name,email,phone,password);
            usser.save(user);
            user user1 = usser.get(email);
            model.addAttribute("user", user1);
            return "dispus";
        } catch (NoSuchElementException e) {
            return "error";
        }      
    }
	
	@RequestMapping("userdel")
    public String delete(HttpSession session) {
		Object ob = session.getAttribute("email");
   	    String email = (String)ob;
        usser.delete(email);
        if (session != null) {
	        session.invalidate();
	    }
        return "index";
    }

}
