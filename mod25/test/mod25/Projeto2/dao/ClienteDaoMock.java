package mod25.Projeto2.dao;

import mod25.Projeto2.projeto.dao.IClienteDAO;
import mod25.Projeto2.projeto.dao.generic.IGenericDAO;
import mod25.Projeto2.projeto.domain.Cliente;
import mod25.Projeto2.projeto.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

public class ClienteDaoMock implements IGenericDAO<Cliente, Long>, IClienteDAO {

	@Override
	public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
		return true;
	}

	@Override
	public void excluir(Long valor) {
	}

	@Override
	public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {
	}

	@Override
	public Cliente consultar(Long valor) {
		Cliente cliente = new Cliente();
		cliente.setCpf(valor);
		return cliente;
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		return null;
	}
}
