package mod25.Projeto2.projeto.dao;

import mod25.Projeto2.projeto.dao.generic.IGenericDAO;
import mod25.Projeto2.projeto.domain.Venda;
import mod25.Projeto2.projeto.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
