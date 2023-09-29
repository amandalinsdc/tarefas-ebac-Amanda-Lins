package br.com.amanda.dao;

import br.com.amanda.dao.generic.GenericDAO;
import br.com.amanda.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto, Long> implements IProdutoDAO {

	public ProdutoDAO() {
		super(Produto.class);
	}

}
