package pro.budthapa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pro.budthapa.domain.Contact;
import pro.budthapa.service.ContactService;

@Controller
public class ContactController {
	
	private static final String INDEX_PAGE = "contact/index";
	private static final String CONTACT_PAGE = "contact";

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contact/all")
	public String index(Model model){
		model.addAttribute("messages",contactService.findAllContact());
		return INDEX_PAGE;
	}
	
	@PostMapping("/contact/new")
	public String addContact(@Valid Contact contact, BindingResult result, Model model ){
		if(!result.hasErrors()){
			contactService.saveContact(contact);
			model.addAttribute("contactMessageSaved", true);
		}
		
		return CONTACT_PAGE;
	}
}
