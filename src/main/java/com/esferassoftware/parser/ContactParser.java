package com.esferassoftware.parser;

import com.esferassoftware.dto.ContactDTO;
import com.esferassoftware.model.Contact;

public class ContactParser {
	public static ContactParser get() {
		return new ContactParser();
	}

	public ContactDTO dto(Contact entity) {
		ContactDTO dto = new ContactDTO();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setSobrenome(entity.getSobrenome());
		dto.setEmail(entity.getEmail());
		dto.setCpf(entity.getCpf());
		dto.setTelefone(entity.getTelefone());
		
		return dto;
	}
	public Contact model(ContactDTO entity) {
		Contact model = new Contact();
		model.setId(entity.getId());
		model.setNome(entity.getNome());
		model.setSobrenome(entity.getSobrenome());
		model.setEmail(entity.getEmail());
		model.setCpf(entity.getCpf());
		model.setTelefone(entity.getTelefone());
		
		return model;
	}
}
