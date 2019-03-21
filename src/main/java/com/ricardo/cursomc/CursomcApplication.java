package com.ricardo.cursomc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	// inicio p/ rodar aplicação
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	// Alimenta nossa BD online,
	@Override
	public void run(String... args) throws Exception {
	}

}
