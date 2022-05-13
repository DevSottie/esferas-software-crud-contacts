package com.esferassoftware.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.esferassoftware.dto.ContactDTO;
import com.esferassoftware.model.Contact;
import com.esferassoftware.model.Email;
import com.esferassoftware.service.ContactsService;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

	@Autowired
	private ContactsService service;
	
	@GetMapping
	public ResponseEntity<List<ContactDTO>> findAllContacts(){
		List<ContactDTO> contacts = service.findAll();
		return ResponseEntity.ok().body(contacts);
	}
	
	@GetMapping(value = "/contactid={contactId}")
	public ResponseEntity<Contact> findById(@PathVariable Long contactId){
		Contact contact = service.findById(contactId);
		return ResponseEntity.ok().body(contact);
	}
	
	@PostMapping
	public ResponseEntity<Void> insertContact(@RequestBody @Valid ContactDTO contactDTO){
		service.insertContact(contactDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{contactId}").buildAndExpand(contactDTO.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/contactid={contactId}")
	public ResponseEntity<String> deleteContact(@PathVariable Long contactId) throws Exception{
		Contact contact = service.findById(contactId);
		service.deleteContact(contactId);
		return ResponseEntity.ok().body("Contato: " + contact.getNome() + "\nIdentificação: "+ contactId + "\nDeletado com sucesso");
	}
	
	@PutMapping(value = "/contactid={contactId}")
	public Contact updateContact(@RequestBody Contact contact, @PathVariable Long contactId) {
		return service.updateContact(contactId, contact);
	}
	
}
