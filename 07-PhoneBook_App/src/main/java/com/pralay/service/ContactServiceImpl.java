package com.pralay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pralay.entity.Contact;
import com.pralay.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSw("y");
		Contact savedObj = contactRepo.save(contact);
		return savedObj.getContactId() !=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = contactRepo.findById(contactId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updateContact(Contact contact) {
		try {
			Contact save = contactRepo.save(contact);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return true;	
		}
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		try {
			contactRepo.deleteById(contactId);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
			
	}

}
