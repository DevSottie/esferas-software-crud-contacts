package com.esferassoftware.dto;

import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

public class ContactDTO {
	
	private Long id;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String sobrenome;
	
	@CPF
	private String cpf;
	
	@Valid
	@OneToMany
	private List<EmailDTO> emails;
	
	@NotEmpty
	@OneToMany
	private List<PhoneDTO> telefones;

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

	public List<EmailDTO> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailDTO> emails) {
		this.emails = emails;
	}

	public List<PhoneDTO> getTelefone() {
		return telefones;
	}

	public void setTelefone(List<PhoneDTO> telefones) {
		this.telefones = telefones;
	}
	
}
