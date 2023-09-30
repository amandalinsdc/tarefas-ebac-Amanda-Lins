package br.com.amanda.service;

import java.util.List;

import br.com.amanda.domain.Cliente;
import br.com.amanda.exceptions.DAOException;
import br.com.amanda.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}
