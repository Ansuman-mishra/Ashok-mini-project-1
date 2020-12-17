package com.pralay.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pralay.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {
	
}
