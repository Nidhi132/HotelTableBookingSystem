package org.jss.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
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
public class bookController {
	
	@Autowired
	private bookService btser;
	
	@RequestMapping(value = "booktable", method = RequestMethod.GET)
	public String bookadd(Model model, HttpSession session) {
		LocalDate date1 = LocalDate.now();
		java.sql.Date date = Date.valueOf(date1);
		//System.out.print(date);
		session.setAttribute("date", date);
		LocalTime time = LocalTime.now();
		
		LocalTime time1 = LocalTime.of(9,30,00);
		LocalTime time2 = LocalTime.of(13,00,00);
		LocalTime time3 = LocalTime.of(16,00,00);
		LocalTime time4 = LocalTime.of(19,00,00);
		LocalTime time5 = LocalTime.of(00,00,00);
		
		session.setAttribute("time", time);
		
		session.setAttribute("time1", time1);
		session.setAttribute("time2", time2);
		session.setAttribute("time3", time3);
		session.setAttribute("time4", time4);
		session.setAttribute("time5", time5);
		
		List<book> book = btser.get(date);
        model.addAttribute("book", book);
		return "booktable";
	}
	
	@PostMapping("/book")
	public String add(@RequestParam("email") String email, @RequestParam("time_slot") String time_slot, @RequestParam("nop") int nop) {
		LocalDate date1 = LocalDate.now();
		java.sql.Date date = Date.valueOf(date1);
		book book = new book(email,date,time_slot,nop);
		btser.save(book);
		 return "redirect:/listbook";
	}
	
	@RequestMapping(value = "listbook", method = RequestMethod.GET)
	public String booklist(Model model, HttpSession session) {
		Object ob = session.getAttribute("date");
		java.sql.Date date = (java.sql.Date)ob;
		Object ob1 = session.getAttribute("email");
   	    String email = (String)ob1;
		List<book> book = btser.get(date,email);
		//System.out.print(book);
        model.addAttribute("book", book);
		return "listbook";
	}
	
	@RequestMapping(value = "viewbook", method = RequestMethod.GET)
	public String viewbook(Model model, HttpSession session) {
		Object ob = session.getAttribute("date");
		java.sql.Date date = (java.sql.Date)ob;
		List<book> book1 = btser.get(date);
        model.addAttribute("book", book1);
        //System.out.print(book1);
		return "viewbook";
	}
	
	@RequestMapping(value = "infobook", method = RequestMethod.GET)
	public String listbook(Model model, HttpSession session) {
		LocalDate date1 = LocalDate.now();
		java.sql.Date date = Date.valueOf(date1);
		session.setAttribute("date", date);
		Object ob1 = session.getAttribute("email");
   	    String email = (String)ob1;
		List<book> book = btser.get(date,email);
		//System.out.print(book);
        model.addAttribute("book", book);
		return "infobook";
	}
	
	 @RequestMapping(value="bookup")    
	    public String update(@RequestParam("idbook") int idbook, Model model, HttpSession session){  
		 try {
			 session.setAttribute("idbook", idbook);
			 LocalDate date1 = LocalDate.now();
				java.sql.Date date = Date.valueOf(date1);
				//System.out.print(date);
				session.setAttribute("date", date);
			 LocalTime time = LocalTime.now();
			 		LocalTime time1 = LocalTime.of(9,30,00);
			 		LocalTime time2 = LocalTime.of(13,00,00);
			 		LocalTime time3 = LocalTime.of(16,00,00);
			 		LocalTime time4 = LocalTime.of(19,00,00);
			 		LocalTime time5 = LocalTime.of(00,00,00);
			 		
			 		session.setAttribute("time", time);
			 		
			 		session.setAttribute("time1", time1);
			 		session.setAttribute("time2", time2);
			 		session.setAttribute("time3", time3);
			 		session.setAttribute("time4", time4);
			 		session.setAttribute("time5", time5);
			 		
			 book book = btser.get(idbook);
             model.addAttribute("book", book);  
	         return "bookupdate";
		 } catch (NoSuchElementException e) {
	        	return "error";
	     }   
	  } 
	
	@RequestMapping("bookedit")
	public String update(@RequestParam("time_slot") String time_slot, @RequestParam("nop") int nop, Model model, HttpSession session) {
	 try {
		 Object ob = session.getAttribute("idbook");
    	 int idbook = (int)ob;
    	 Object ob1 = session.getAttribute("date");
 		java.sql.Date date = (java.sql.Date)ob1;
 		Object ob2 = session.getAttribute("email");
    	String email = (String)ob2;
		book book = new book(idbook,email,date,time_slot,nop);
		btser.save(book);
		 return "redirect:/infobook";
	 } catch (NoSuchElementException e) {
            return "error";
        }
	 }
 
 @RequestMapping("delbook")
    public String delete(@RequestParam("idbook") int idbook,  HttpSession session) {
        btser.delete(idbook);
        return "redirect:/infobook";
    }
}
