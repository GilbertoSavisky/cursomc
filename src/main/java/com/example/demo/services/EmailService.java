package com.example.demo.services;

import org.springframework.mail.SimpleMailMessage;

import com.example.demo.domain.Cliente;
import com.example.demo.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
