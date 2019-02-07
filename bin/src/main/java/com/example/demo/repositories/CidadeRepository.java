package com.example.demo.repositories;

//Camada de acesso a dados (Repository ou DAO) referente a Categoria


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Cidade;

@Repository 			// Acessa a tabela "Categoria", faz as consultas...
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{ 
	
						// JpaRepository é capaz de buscar nas tabela pelo obj e tipo do atributo identificador (id=integer)
						// esse obj (CategoriaRepository) faz as cunsultas de buscar, deletar, salvar, atualizar da tabela (Categoria)

}
