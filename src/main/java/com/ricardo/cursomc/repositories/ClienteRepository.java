package com.ricardo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ricardo.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	// inteface que faz serviços crud p/ Cliente
	
	@Transactional(readOnly=true)	// ñ faz uma trasação de BD, faz a consulta ser mais rapida
	Cliente findByEmail(String email);	// busca um cliente por email
}
