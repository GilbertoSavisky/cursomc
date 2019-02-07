//Controlador Rest


package com.example.demo.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Pedido;
import com.example.demo.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos") // mapeando um end point
public class PedidoResource {
	
	

	@Autowired // instancia automaticamente
	private PedidoService service;  //Controlador Rest está acessando o Serviço
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) 		// add um and point p/ o metodo ResponseEntity
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {		// id vem da URL 
		//  ResponseEntity é um tipo especial do Spring que já encapsula, armazena várias informações de uma respota HTTP para um serviço Rest
		
		Pedido obj = service.find(id); //
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert (@Valid @RequestBody Pedido obj){ // @RequestBody convert Json para obj java
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri(); // pega a novva URI do novo recurso inserido
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<Pedido>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="instante") String orderBy, 
			@RequestParam(value="direction", defaultValue="DESC") String direction) {
		Page<Pedido> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
}
