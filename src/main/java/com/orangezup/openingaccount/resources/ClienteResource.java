package com.orangezup.openingaccount.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orangezup.openingaccount.domain.Cliente;
import com.orangezup.openingaccount.resources.request.CreateClienteRequest;
import com.orangezup.openingaccount.resources.response.ClienteResponse;
import com.orangezup.openingaccount.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	@GetMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClienteResponse find(@PathVariable Integer id){
		Cliente obj = service.find(id);
		return obj.toResponse();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponse insert(@RequestBody CreateClienteRequest obj){
		Cliente c = service.insert(obj.toDomain());
		return c.toResponse();
	}
	
	@PutMapping(value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ClienteResponse update (@RequestBody Cliente obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return obj.toResponse();
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete (@PathVariable Integer id){
		service.delete(id);
	}
}

