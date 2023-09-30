package br.com.amanda.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.amanda.dao.IClienteDAO;
import br.com.amanda.domain.Cliente;
import br.com.amanda.exceptions.DAOException;
import br.com.amanda.exceptions.MaisDeUmRegistroException;
import br.com.amanda.exceptions.TableException;
import br.com.amanda.services.generic.GenericService;

@Stateless
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	private IClienteDAO clienteDAO;
	
	@Inject
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		this.clienteDAO = clienteDAO;
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			System.out.println("Erro na consulta " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Cliente> filtrarClientes(String query) {
		return clienteDAO.filtrarClientes(query);
	}

}
