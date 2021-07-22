package org.jss.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class bookService {
	
	@Autowired
	private bookRepository btrepo;
	
	 public void save(book book) {
	        btrepo.save(book);
	    }
	 
	 public List<book> get(java.sql.Date date) {
	        return btrepo.findAllById(date);
	    }
	 
	 public List<book> get(java.sql.Date date, String email) {
	        return btrepo.findAllById(date,email);
	    }

	public book get(int idbook) {
		return btrepo.findById(idbook).get();
	}

	public void delete(int idbook) {
		btrepo.deleteById(idbook);
		
	}

}
