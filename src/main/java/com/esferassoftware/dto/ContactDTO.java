package com.esferassoftware.dto;

import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.esferassoftware.model.Email;
import com.esferassoftware.model.Phone;

public class ContactDTO {
	
	private Long id;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String sobrenome;
	
	@CPF
	private String cpf;
	
	@Valid
	private List<Email> emails;
	
	@NotEmpty
	private List<Phone> telefones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public List<Phone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Phone> telefones) {
		this.telefones = telefones;
	}
	
}
