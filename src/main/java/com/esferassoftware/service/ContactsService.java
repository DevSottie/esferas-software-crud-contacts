package com.esferassoftware.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esferassoftware.dto.ContactDTO;
import com.esferassoftware.model.Contact;
import com.esferassoftware.parser.ContactParser;
import com.esferassoftware.repository.ContactsRepository;
import com.esferassoftware.service.exception.NotFoundException;

@Service
public class ContactsService {

	@Autowired
	private ContactsRepository repository;
	
	public List<ContactDTO> findAll(){
		return repository.findAll().stream().map(ContactParser.get()::dto).collect(Collectors.toList());
	}
	
	public Contact insertContact(ContactDTO contactDTO) {
		ContactParser parser = new ContactParser();
		Contact contact = parser.model(contactDTO);
		return repository.save(contact);
	}
	
	public Contact findById(Long id) {
		Optional<Contact> contact = repository.findById(id);
		
		return contact.orElseThrow(() -> new NotFoundException(
				"Contato não encontrado! Identificação: " + id + " Tipo: " + Contact.class.getName(), null)); 
	}
	
	public void deleteContact(Long id) throws Exception{
		Contact contact = findById(id);
		
		if(contact == null) {
			throw new NotFoundException("Contato não encontrado");
		}
		
		repository.deleteById(id);
	}
	
	public Contact updateContact(Long id, Contact contact) {
		Contact newContact = findById(id);
		if(newContact == null) {
			throw new NotFoundException("Contato não encontrado");
		}
		
		updateData(newContact, contact);
		
		return repository.save(newContact);
	}
	
	@Transactional
	void updateData(Contact newContact, Contact contact) {
		if(newContact.getNome()!= null) {
			newContact.setNome(contact.getNome());
		}
		if(newContact.getSobrenome()!= null) {
			newContact.setSobrenome(contact.getSobrenome());
		}
		if(newContact.getCpf()!= null) {
			newContact.setCpf(contact.getCpf());
		}
		if(newContact.getEmails()!= null) {
			newContact.setEmails(contact.getEmails());
		}
		if(newContact.getTelefones()!= null) {
			newContact.setTelefone(contact.getTelefones());
		}
	}
}
