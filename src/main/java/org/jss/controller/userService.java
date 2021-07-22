package org.jss.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class userService {
	
	@Autowired
	private userRepository usrepo;
	
	public void save(user user) {
        usrepo.save(user);
    }
	
	public user get(String email) {
        return usrepo.findById(email).get();
    }
	
	public void delete(String email) {
        usrepo.deleteById(email);
    }

}
