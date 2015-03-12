package com.algaworks.os.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.os.model.Cliente;

public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Cliente porId(Long id) {
		return manager.find(Cliente.class, id);
	}

	public List<Cliente> porNomeSemelhante(String nome) {
		return manager.createQuery("from Cliente where nome like :nome", Cliente.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}

}