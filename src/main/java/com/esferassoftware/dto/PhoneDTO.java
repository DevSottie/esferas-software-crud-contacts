package com.esferassoftware.dto;

import javax.validation.constraints.NotEmpty;

public class PhoneDTO {
	
	private Long id;
	
	@NotEmpty
	private String telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
