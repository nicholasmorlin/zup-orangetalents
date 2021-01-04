package com.orangezup.openingaccount.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangezup.openingaccount.domain.Cliente;
import com.orangezup.openingaccount.repositories.ClienteRepository;
import com.orangezup.openingaccount.services.exceptions.DataIntegrityException;
import com.orangezup.openingaccount.services.exceptions.DuplicateKeyViolationException;
import com.orangezup.openingaccount.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienterepo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = clienterepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
	}

	public Cliente insert(Cliente obj) {

		Optional<Cliente> clienteCpf = clienterepo.findByCpf(obj.getCpf());
		Optional<Cliente> clienteEmail = clienterepo.findByEmail(obj.getEmail());
		if (clienteCpf.isPresent() || clienteEmail.isPresent()) {
			throw new DuplicateKeyViolationException("Chave duplicada");
		}

		obj.setId(null);
		try {
			return clienterepo.save(obj);
		} catch (Exception e) {
			throw new DataIntegrityException("Dados inválidos"); 
		}
	}

	public Cliente update(Cliente obj) {
		find(obj.getId());
		return clienterepo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		clienterepo.deleteById(id);
	}
}
