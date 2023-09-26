package mod25.Projeto2.projeto.services;

import mod25.Projeto2.projeto.dao.IClienteDAO;
import mod25.Projeto2.projeto.services.generic.GenericService;
import mod25.Projeto2.projeto.domain.Cliente;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) {
		return this.dao.consultar(cpf);
	}

}
