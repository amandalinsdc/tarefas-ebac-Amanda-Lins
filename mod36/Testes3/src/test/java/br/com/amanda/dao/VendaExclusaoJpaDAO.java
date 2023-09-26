package br.com.amanda.dao;

import br.com.amanda.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.amanda.dao.jpa.IVendaJpaDAO;
import br.com.amanda.domain.jpa.VendaJpa;
import br.com.amanda.exceptions.DAOException;
import br.com.amanda.exceptions.TipoChaveNaoEncontradaException;

// Classe utilizada somente no teste para fazer a exclusão das vendas
public class VendaExclusaoJpaDAO extends GenericJpaDB1DAO<VendaJpa, Long> implements IVendaJpaDAO {

	public VendaExclusaoJpaDAO() {
		super(VendaJpa.class);
	}

	@Override
	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("Operação não permitida");
	}

	@Override
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("Operação não permitida");
	}

	@Override
	public VendaJpa consultarComCollection(Long id) {
		throw new UnsupportedOperationException("Operação não permitida");
	}

}
