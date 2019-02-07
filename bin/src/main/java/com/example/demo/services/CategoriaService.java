package com.example.demo.services;
		//Camada de serviço

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Categoria;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;



@Service
public class CategoriaService {

	@Autowired 			//Dependencia Automaticamente instanciada pelo spring
	private CategoriaRepository repo;  //dependencia dentro da classe 
						//O serviço acessa o obj de acesso a dados Repository ou DAO
				
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id); //Busca pelo id e retorna um obj categoria
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+", Tipo: "+Categoria.class.getName());
		}
		return obj;
	}
	
}