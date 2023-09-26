package mod25.Projeto2.projeto.services;

import mod25.Projeto2.projeto.dao.IProdutoDAO;
import mod25.Projeto2.projeto.domain.Produto;
import mod25.Projeto2.projeto.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
