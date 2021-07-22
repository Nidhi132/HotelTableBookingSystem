package org.jss.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class sitecontroller {

	
	@RequestMapping(value = "/", method = RequestMethod.GET )
	public String welcome() {
		return "index";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET )
	public String about() {
		return "about";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET )
	public String admin() {
		return "login";
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.GET )
	public String signup() {
		return "signup";
	}
	
	@RequestMapping(value = "usignup", method = RequestMethod.GET )
	public String user() {
		return "usignup";
	}
	
	@RequestMapping(value = "ulogin", method = RequestMethod.GET )
	public String ulogin() {
		return "ulogin";
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	        session.invalidate();
	    }
	    return "index";
	}
}
