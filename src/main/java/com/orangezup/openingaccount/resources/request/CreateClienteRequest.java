package com.orangezup.openingaccount.resources.request;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.orangezup.openingaccount.domain.Cliente;

public class CreateClienteRequest {

	@NotNull
	@NotBlank
	private String name;

	@NotNull
	@Email
	@NotBlank
	@Column(unique = true)
	private String email;

	@NotNull
	@CPF
	@Column(unique = true)
	private String cpf;

	@NotNull
	private Date birthday;
	
	public CreateClienteRequest() {
	}
	
	public CreateClienteRequest(String name, String email, String cpf, Date birthday) {
		super();
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthday = birthday;
	}
	
	public Cliente toDomain () {
		Cliente cl = new Cliente(null, name, email, cpf, birthday);
		return cl;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getBirthday() {
		return birthday;
	}
	
}
