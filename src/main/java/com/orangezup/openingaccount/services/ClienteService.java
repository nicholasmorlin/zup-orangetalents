package com.orangezup.openingaccount.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangezup.openingaccount.domain.Cliente;
import com.orangezup.openingaccount.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienterepo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = clienterepo.findById(id);
		return obj.orElse(null);
	}
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return clienterepo.save(obj);
	}
	
	public Cliente update(Cliente obj) {
		find(obj.getId());
		return clienterepo.save(obj);
	}
	
	public void delete (Integer id) {
		find(id);
		clienterepo.deleteById(id);
	}
}
