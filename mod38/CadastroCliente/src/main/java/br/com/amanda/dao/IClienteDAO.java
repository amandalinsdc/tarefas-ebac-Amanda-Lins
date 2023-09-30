package br.com.amanda.dao;

import java.util.List;

import br.com.amanda.domain.Cliente;
import br.com.amanda.dao.generic.IGenericDAO;

public interface IClienteDAO extends IGenericDAO<Cliente, Long>{

	List<Cliente> filtrarClientes(String query);

}
