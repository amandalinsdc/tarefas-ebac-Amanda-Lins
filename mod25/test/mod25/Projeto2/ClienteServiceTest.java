package mod25.Projeto2;

import mod25.Projeto2.dao.ClienteDaoMock;
import mod25.Projeto2.projeto.dao.IClienteDAO;
import mod25.Projeto2.projeto.domain.Cliente;
import mod25.Projeto2.projeto.exceptions.TipoChaveNaoEncontradaException;
import mod25.Projeto2.projeto.services.ClienteService;
import mod25.Projeto2.projeto.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	private Cliente cliente;

	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(69845634421L);
		cliente.setNome("Amanda");
		cliente.setCidade("Fortaleza");
		cliente.setEnd("Rua do Sol");
		cliente.setEstado("CE");
		cliente.setNumero(102);
		cliente.setTel(85987651234L);
	}
	
	@Test
	public void testPesquisarCliente() {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());

		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void testSalvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void testExcluirCliente() {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void testAlterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Amanda Lins");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Amanda Lins", cliente.getNome());
	}
}