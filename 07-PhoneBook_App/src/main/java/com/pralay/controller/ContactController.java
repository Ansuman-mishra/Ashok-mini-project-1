package com.pralay.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pralay.constants.AppConstants;
import com.pralay.entity.Contact;
import com.pralay.props.AppProperties;
import com.pralay.service.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private AppProperties appProps;
	
	@GetMapping("/loadForm")
	public String loadForm(Model model) {
		
		model.addAttribute("contact",new Contact());
		
		return AppConstants.INDEX_VIEW;
	}
	
	@PostMapping("/saveContact")
	public String handleSaveContactBtn(Contact contact, RedirectAttributes attributes) {
		Map<String, String> messages = appProps.getMessages();
		String msgTxt= null;
		
		if(contact.getContactId()==null) {
			msgTxt = messages.get(AppConstants.SUCCESS_MSG);
		}else {
			msgTxt = messages.get(AppConstants.UPDATE_SUCCESS);
		}
		
		boolean isSaved = contactService.saveContact(contact);
		
		if(isSaved) {
			attributes.addFlashAttribute(AppConstants.SUCCESS_MSG, msgTxt);
		}else {
			attributes.addFlashAttribute(AppConstants.ERROR_MSG, messages.get(AppConstants.SAVE_FAIL));
		}
		return "redirect:/loadForm";
	}
	
	
	
	
	
	
	@GetMapping("/viewContacts")
	public String handleViewContactsHyperlink(Model model) {
		List<Contact> contactsList = contactService.getAllContacts();
//		System.out.println("-----------------------------"+contactsList.toString());
		model.addAttribute("contacts", contactsList);
		return "viewContacts";
	}
	
	@GetMapping("/edit")
	public String handleEditClick(@RequestParam("CONTACT_ID") Integer cid, Model model) {
		Contact contactObj = contactService.getContactById(cid);
		
		model.addAttribute("contact", contactObj);
		
		return AppConstants.INDEX_VIEW;
	}
	
	@GetMapping("/delete")
	public String handleDeleteClick(@RequestParam("CONTACT_ID") Integer cid) {
		
		contactService.deleteContactById(cid);
		
		return "redirect:/viewContacts";
	}
	
}
