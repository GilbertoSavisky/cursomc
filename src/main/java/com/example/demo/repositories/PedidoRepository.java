package com.example.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//Camada de acesso a dados (Repository ou DAO) referente a Categoria


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Cliente;
import com.example.demo.domain.Pedido;

@Repository 			// Acessa a tabela "Categoria", faz as consultas...
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{ 
	@Transactional(readOnly=true)
	Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);
	
						// JpaRepository é capaz de buscar nas tabela pelo obj e tipo do atributo identificador (id=integer)
						// esse obj (CategoriaRepository) faz as cunsultas de buscar, deletar, salvar, atualizar da tabela (Categoria)

}
