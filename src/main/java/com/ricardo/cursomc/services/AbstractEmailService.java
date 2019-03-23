package com.ricardo.cursomc.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.ricardo.cursomc.domain.Pedido;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.sender}")	// Pega valor setado em application.properties, e seta var abaixo
	private String sender;
	
	@Override	
	public void sendOrderConfirmationEmail(Pedido obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getCliente().getEmail());	// Destinatario
		sm.setFrom(sender);		// Remetente
		sm.setSubject("Pedido confirmado! Codigo: " + obj.getId());	//
		sm.setSentDate(new Date(System.currentTimeMillis())); 	// Pega data do servidor
		sm.setText(obj.toString()); 	// Corpo do E-mail
		return sm;
	}
	
}
