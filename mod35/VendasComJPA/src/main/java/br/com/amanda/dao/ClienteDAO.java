package br.com.amanda.dao;

import br.com.amanda.dao.generic.GenericDAO;
import br.com.amanda.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

	public ClienteDAO() {
		super(Cliente.class);
	}

}
