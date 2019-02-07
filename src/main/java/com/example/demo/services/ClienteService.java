package com.example.demo.services;
		//Camada de serviço

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cliente;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;



@Service
public class ClienteService {

	@Autowired 			//Dependencia Automaticamente instanciada pelo spring
	private ClienteRepository repo;  //dependencia dentro da classe 
						//O serviço acessa o obj de acesso a dados Repository ou DAO
				
	
	public Cliente find(Integer id) {
		Cliente obj = repo.findOne(id); //Busca pelo id e retorna um obj cliente
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+", Tipo: "+Cliente.class.getName());
		}
		return obj;
	}
	
}
