package pro.budthapa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.mkopylec.recaptcha.validation.RecaptchaValidator;
import com.github.mkopylec.recaptcha.validation.ValidationResult;

import pro.budthapa.domain.Contact;
import pro.budthapa.service.ContactService;

@Controller
public class ContactController {
	
	private static final String INDEX_PAGE = "contact/index";
	private static final String CONTACT_PAGE = "contact";
	private static final String SHOW_MESSAGE_PAGE = "contact/showContact";
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private RecaptchaValidator recaptchaValidator;
	
	@GetMapping("/contact/all")
	public String index(Model model){
		model.addAttribute("messages",contactService.findAllContact());
		return INDEX_PAGE;
	}
	
	@PostMapping("/contact/new")
	public String addContact(@Valid Contact contact, BindingResult result, Model model, HttpServletRequest request){
		ValidationResult captchaResult = recaptchaValidator.validate(request);
		if(captchaResult.isFailure()) {
			model.addAttribute("captchaValidationFailed", true);
			return CONTACT_PAGE;
		}
		
		if(!result.hasErrors()){
			contactService.saveContact(contact);
			model.addAttribute("contactMessageSaved", true);
		}
		
		return CONTACT_PAGE;
	}
	
	@GetMapping("/contact/message/{id}")
	public String viewMessage(@PathVariable Long id, Model model){
		model.addAttribute("message",contactService.findContactById(id));
		return SHOW_MESSAGE_PAGE;
	}
}
