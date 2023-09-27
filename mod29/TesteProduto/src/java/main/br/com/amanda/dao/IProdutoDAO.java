package br.com.amanda.dao;

import br.com.amanda.domain.Produto;

import java.util.List;

public interface IProdutoDAO {

	Integer cadastrar(Produto produto) throws Exception;

	Produto consultar(String codigo) throws Exception;

	Integer excluir(Produto produtoBD) throws Exception;

	List<Produto> buscarTodos() throws Exception;
}
