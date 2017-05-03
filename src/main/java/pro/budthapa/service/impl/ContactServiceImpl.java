package pro.budthapa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pro.budthapa.domain.Contact;
import pro.budthapa.repository.ContactRepository;
import pro.budthapa.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;
	@Override
	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public List<Contact> findAllContact() {
		return contactRepository.findAllByOrderByDateDesc();
	}

}
