package com.orangezup.openingaccount.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orangezup.openingaccount.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

}