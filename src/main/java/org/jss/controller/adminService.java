package org.jss.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class adminService {

	@Autowired
	private adminRepository adrepo;
	
	 public void save(admin admin) {
	        adrepo.save(admin);
	    }
	 
	 public admin get(String name) {
	        return adrepo.findById(name).get();
	    }
	 
	 public void delete(String name) {
	        adrepo.deleteById(name);
	    }

}
