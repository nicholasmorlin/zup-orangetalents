package com.orangezup.openingaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		
	}

}
