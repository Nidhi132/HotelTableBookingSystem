package org.jss.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface bookRepository extends JpaRepository<book, Integer> {

	@Query("select u from book u where date = CURRENT_DATE()")
	List<book> findAllById(Date date);

	@Query("select u from book u where u.date = ?1 and u.email = ?2")
	List<book> findAllById(Date date, String email);



}
