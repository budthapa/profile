package pro.budthapa.service;

import java.util.List;

import pro.budthapa.domain.Contact;

public interface ContactService {
	public List<Contact> findAllContact();
	public Contact saveContact(Contact contact);
}
