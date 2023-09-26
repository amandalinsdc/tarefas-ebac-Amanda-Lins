package br.com.amanda.dao.jpa;

import br.com.amanda.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.amanda.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
