package br.com.amanda.services;

import br.com.amanda.domain.Cliente;
import br.com.amanda.exceptions.DAOException;
import br.com.amanda.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;
}
