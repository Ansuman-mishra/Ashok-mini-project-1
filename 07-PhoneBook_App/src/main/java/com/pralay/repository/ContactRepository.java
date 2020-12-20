package com.pralay.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pralay.entity.Contact;


public interface ContactRepository extends JpaRepository<Contact, Serializable> {
	
	
	public List<Contact> findByActiveSw(String activeSw);
	
}
