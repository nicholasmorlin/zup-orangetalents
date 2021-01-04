package com.orangezup.openingaccount.resources.response;

import java.util.Date;

public class ClienteResponse {
	
	private Integer id;
	private String name;
	private String email;
	private String cpf;
	private Date birthday;
	
	public ClienteResponse() {
	}
	
	public ClienteResponse(Integer id, String name, String email, String cpf, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthday = birthday;
	}

	public Integer getId() {
		return id;
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
