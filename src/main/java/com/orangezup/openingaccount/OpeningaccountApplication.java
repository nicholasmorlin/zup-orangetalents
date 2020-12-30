package com.orangezup.openingaccount;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orangezup.openingaccount.domain.Cliente;
import com.orangezup.openingaccount.repositories.ClienteRepository;

@SpringBootApplication
public class OpeningaccountApplication implements CommandLineRunner {
	
	@Autowired
	private ClienteRepository clienterepository;

	public static void main(String[] args) {
		SpringApplication.run(OpeningaccountApplication.class, args);
		}
		

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Cliente c1 = new Cliente(null, "Nicholas Passos Morlin", "nicholas_morlin@hotmail.com", "11291316612", sdf.parse("09/02/1994"));
		
		clienterepository.saveAll(Arrays.asList(c1));
		
	}

}
