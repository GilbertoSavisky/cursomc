package com.example.demo.repositories;

import java.util.List;

//Camada de acesso a dados (Repository ou DAO) referente a Categoria


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Estado;

@Repository 			// Acessa a tabela "Categoria", faz as consultas...
public interface EstadoRepository extends JpaRepository<Estado, Integer>{ 
	
	@Transactional(readOnly=true)
	public List<Estado> findAllByOrderByNome();
	
						// JpaRepository é capaz de buscar nas tabela pelo obj e tipo do atributo identificador (id=integer)
						// esse obj (CategoriaRepository) faz as cunsultas de buscar, deletar, salvar, atualizar da tabela (Categoria)

}
