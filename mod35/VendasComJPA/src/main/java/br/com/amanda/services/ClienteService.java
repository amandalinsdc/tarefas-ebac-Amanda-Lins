package br.com.amanda.services;

import br.com.amanda.dao.IClienteDAO;
import br.com.amanda.domain.Cliente;
import br.com.amanda.exceptions.DAOException;
import br.com.amanda.exceptions.MaisDeUmRegistroException;
import br.com.amanda.exceptions.TableException;
import br.com.amanda.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}

}
