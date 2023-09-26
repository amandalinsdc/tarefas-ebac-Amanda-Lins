package br.com.amanda.dao.jpa;

import br.com.amanda.dao.generic.jpa.IGenericJapDAO;
import br.com.amanda.domain.jpa.VendaJpa;
import br.com.amanda.exceptions.DAOException;
import br.com.amanda.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaJpaDAO extends IGenericJapDAO<VendaJpa, Long>{

	void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;

	void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	VendaJpa consultarComCollection(Long id);
}
