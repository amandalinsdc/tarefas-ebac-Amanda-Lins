package br.com.amanda.dao.jpa;

import br.com.amanda.dao.generic.jpa.GenericJpaDB2DAO;
import br.com.amanda.domain.jpa.ClienteJpa;

public class ClienteJpaDB2DAO extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDB2DAO() {
		super(ClienteJpa.class);
	}

}
