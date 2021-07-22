package org.jss.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class menuService {
	
	@Autowired
	private menuRepository mnrepo;

	public List<menu> findAll() {
        return mnrepo.findAll();
    }
	
	 public void save(menu menu) {
	        mnrepo.save(menu);
	    }
	 
	 public menu get(int id) {
	        return mnrepo.findById(id).get();
	    }
	 
	 public void delete(int id) {
	        mnrepo.deleteById(id);
	    }
}
