package br.com.amanda.dao.jpa;

import br.com.amanda.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.amanda.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
