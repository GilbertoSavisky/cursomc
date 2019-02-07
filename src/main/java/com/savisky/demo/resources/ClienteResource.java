//Controlador Rest


package com.savisky.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.savisky.demo.domain.Cliente;
import com.savisky.demo.services.ClienteService;

@RestController
@RequestMapping(value="/clientes") // mapeando um end point
public class ClienteResource {
	
	

	@Autowired // instancia automaticamente
	private ClienteService service;  //Controlador Rest está acessando o Serviço
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) 		// add um and point p/ o metodo ResponseEntity
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {		// id vem da URL 
		//  ResponseEntity é um tipo especial do Spring que já encapsula, armazena várias informações de uma respota HTTP para um serviço Rest
		
		Cliente obj = service.find(id); //
		return ResponseEntity.ok().body(obj);
	}

}
