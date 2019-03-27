package com.ricardo.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.ricardo.cursomc.domain.Pedido;

public interface EmailService {

	// Texto plano
	void sendOrderConfirmationEmail(Pedido obj);
	
	// Texto plano
	void sendEmail(SimpleMailMessage msg);
	
	// Versão com HTML
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	// Versão com HTML
	void sendHtmlEmail(MimeMessage msg);
}
