package com.ricardo.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ricardo.cursomc.services.DBService;
import com.ricardo.cursomc.services.EmailService;
import com.ricardo.cursomc.services.SmtpEmailService;

@Configuration	// Class de configuração
@Profile("dev")	// Só vai funcionar quando o profile dev, estiver habilitado
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if(!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instantiateDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailServiceGmail() {
		return new SmtpEmailService();
	}
}
