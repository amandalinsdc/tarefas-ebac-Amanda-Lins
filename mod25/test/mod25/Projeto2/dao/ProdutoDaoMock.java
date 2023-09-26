package mod25.Projeto2.dao;

import mod25.Projeto2.projeto.dao.IProdutoDAO;
import mod25.Projeto2.projeto.dao.generic.IGenericDAO;
import mod25.Projeto2.projeto.domain.Produto;
import mod25.Projeto2.projeto.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;


public class ProdutoDaoMock implements IGenericDAO<Produto, String>, IProdutoDAO {

	@Override
	public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
		return true;
	}

	@Override
	public void excluir(String valor) {
	}

	@Override
	public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {
	}

	@Override
	public Produto consultar(String valor) {
		Produto produto = new Produto();
		produto.setCodigo(valor);
		return produto;
	}

	@Override
	public Collection<Produto> buscarTodos() {
		return null;
	}
}
