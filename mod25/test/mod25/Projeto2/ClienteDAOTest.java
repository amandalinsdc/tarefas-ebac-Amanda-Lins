package mod25.Projeto2;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import mod25.Projeto2.projeto.dao.ClienteDAO;
import mod25.Projeto2.projeto.dao.IClienteDAO;
import mod25.Projeto2.projeto.domain.Cliente;
import mod25.Projeto2.projeto.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {
	
	private IClienteDAO clienteDao;
	private Cliente cliente;
	
	public ClienteDAOTest() {
		clienteDao = new ClienteDAO();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		cliente = new Cliente();
		cliente.setCpf(69845634421L);
		cliente.setNome("Amanda");
		cliente.setCidade("Fortaleza");
		cliente.setEnd("Rua do Sol");
		cliente.setEstado("CE");
		cliente.setNumero(102);
		cliente.setTel(85987651234L);
		clienteDao.cadastrar(cliente);
	}
	
	@Test
	public void testPesquisarCliente() {
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());

		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void testSalvarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setCpf(56565656565L);
		Boolean retorno = clienteDao.cadastrar(cliente);

		Assert.assertTrue(retorno);
	}

	@Test
	public void testExcluirCliente() {
		clienteDao.excluir(cliente.getCpf());
	}
	
	@Test
	public void testAlterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Amanda Lins");
		clienteDao.alterar(cliente);

		Assert.assertEquals("Amanda Lins", cliente.getNome());
	}
	
	@Test
	public void testBuscarTodos() {
		Collection<Cliente> list = clienteDao.buscarTodos();

		assertTrue(list != null);
		assertTrue(list.size() == 2);
	}
}
