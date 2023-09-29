package br.com.amanda.services;

import br.com.amanda.dao.IProdutoDAO;
import br.com.amanda.domain.Produto;
import br.com.amanda.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
