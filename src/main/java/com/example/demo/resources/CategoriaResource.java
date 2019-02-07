//Controlador Rest


package com.example.demo.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Categoria;
import com.example.demo.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias") // mapeando um end point
public class CategoriaResource {
	
	

	@Autowired // instancia automaticamente
	private CategoriaService service;  //Controlador Rest está acessando o Serviço
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) 		// add um and point p/ o metodo ResponseEntity
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {		// id vem da URL 
		//  ResponseEntity é um tipo especial do Spring que já encapsula, armazena várias informações de uma respota HTTP para um serviço Rest
		
		Categoria obj = service.find(id); //
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody Categoria obj){ // @RequestBody convert Json para obj java
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri(); // pega a novva URI do novo recurso inserido
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE) 		// add um and point p/ o metodo ResponseEntity
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
