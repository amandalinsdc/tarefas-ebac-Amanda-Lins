/**
 * 
 */
package br.com.amanda.dao;

import br.com.amanda.domain.Cliente;
import br.com.amanda.domain.Produto;

import java.util.List;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteDAO {

	
	public Integer cadastrar(Cliente cliente) throws Exception;

	public Cliente consultar(String codigo) throws Exception;

	public Integer excluir(Cliente clienteBD) throws Exception;

	List<Cliente> buscarTodos() throws Exception;
}
