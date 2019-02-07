package com.example.demo.services;
		//Camada de serviço

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Pedido;
import com.example.demo.repositories.PedidoRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;



@Service
public class PedidoService {

	@Autowired 			//Dependencia Automaticamente instanciada pelo spring
	private PedidoRepository repo;  //dependencia dentro da classe 
						//O serviço acessa o obj de acesso a dados Repository ou DAO
				
	
	public Pedido find(Integer id) {
		Pedido obj = repo.findOne(id); //Busca pelo id e retorna um obj categoria
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+", Tipo: "+Pedido.class.getName());
		}
		return obj;
	}
	
}
