package mod25.Projeto2;

import mod25.Projeto2.projeto.dao.*;
import mod25.Projeto2.projeto.domain.Cliente;
import mod25.Projeto2.projeto.domain.Produto;
import mod25.Projeto2.projeto.domain.Venda;
import mod25.Projeto2.projeto.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;

public class VendaDAOTest {
	
	private IVendaDAO vendaDao;
	private IClienteDAO clienteDao;
	private IProdutoDAO produtoDao;
	private Cliente cliente;
	private Produto produto;
	
	public VendaDAOTest() {
		vendaDao = new VendaDAO();
		clienteDao = new ClienteDAO();
		produtoDao = new ProdutoDAO();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		this.cliente = cadastrarCliente();
		this.produto = cadastrarProduto("A1", BigDecimal.TEN);
	}

	
	@Test
	public void testPesquisar() throws TipoChaveNaoEncontradaException {
		Venda venda = criarVenda("A1");
		Boolean retorno = vendaDao.cadastrar(venda);

		Assert.assertTrue(retorno);

		Venda vendaConsultada = vendaDao.consultar(venda.getCodigo());

		Assert.assertNotNull(vendaConsultada);
		Assert.assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
	}
	
	@Test
	public void testSalvar() throws TipoChaveNaoEncontradaException {
		Venda venda = criarVenda("A2");
		Boolean retorno = vendaDao.cadastrar(venda);

		Assert.assertTrue(retorno);
		Assert.assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
		Assert.assertTrue(venda.getStatus().equals(Venda.Status.INICIADA));
	} 
	
	
	@Test
	public void testCancelarVenda() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A3";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);

		Assert.assertTrue(retorno);
		Assert.assertNotNull(venda);
		Assert.assertEquals(codigoVenda, venda.getCodigo());
		
		venda.setStatus(Venda.Status.CANCELADA);
		vendaDao.alterar(venda);
		
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);

		Assert.assertEquals(codigoVenda, vendaConsultada.getCodigo());
		Assert.assertEquals(Venda.Status.CANCELADA, vendaConsultada.getStatus());
	}
	
	@Test
	public void testAdicionarMaisProdutosDoMesmo() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A4";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);

		Assert.assertTrue(retorno);
		Assert.assertNotNull(venda);
		Assert.assertEquals(codigoVenda, venda.getCodigo());
		
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		vendaConsultada.adicionarProduto(produto, 1);
		
		Assert.assertTrue(venda.getQuantidadeTotalProdutos() == 3);
		Assert.assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(30)));
		Assert.assertTrue(venda.getStatus().equals(Venda.Status.INICIADA));
	} 
	
	@Test
	public void testAdicionarMaisProdutosDiferentes() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A5";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);

		Assert.assertTrue(retorno);
		Assert.assertNotNull(venda);
		Assert.assertEquals(codigoVenda, venda.getCodigo());
		
		Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));

		Assert.assertNotNull(prod);
		Assert.assertEquals(codigoVenda, prod.getCodigo());
		
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		vendaConsultada.adicionarProduto(prod, 1);
		
		Assert.assertTrue(venda.getQuantidadeTotalProdutos() == 3);
		Assert.assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));
		Assert.assertTrue(venda.getStatus().equals(Venda.Status.INICIADA));
	} 
	
	@Test
	public void testSalvarProdutoExistente() throws TipoChaveNaoEncontradaException {
		Venda venda = criarVenda("A6");
		Boolean retorno1 = vendaDao.cadastrar(venda);

		Assert.assertTrue(retorno1);
	
		Boolean retorno2 = vendaDao.cadastrar(venda);

		Assert.assertFalse(retorno2);
		Assert.assertTrue(venda.getStatus().equals(Venda.Status.INICIADA));
	} 
	
	@Test
	public void testRemoverProduto() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A7";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);

		Assert.assertTrue(retorno);
		Assert.assertNotNull(venda);
		Assert.assertEquals(codigoVenda, venda.getCodigo());
		
		Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));

		Assert.assertNotNull(prod);
		Assert.assertEquals(codigoVenda, prod.getCodigo());
		
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		vendaConsultada.adicionarProduto(prod, 1);

		Assert.assertTrue(venda.getQuantidadeTotalProdutos() == 3);
		Assert.assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));
		
		
		vendaConsultada.removerProduto(prod, 1);

		Assert.assertTrue(venda.getQuantidadeTotalProdutos() == 2);
		Assert.assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
		Assert.assertTrue(venda.getStatus().equals(Venda.Status.INICIADA));
	} 
	
	@Test
	public void testRemoverApenasUmProduto() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A8";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);

		Assert.assertTrue(retorno);
		Assert.assertNotNull(venda);
		Assert.assertEquals(codigoVenda, venda.getCodigo());
		
		Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));

		Assert.assertNotNull(prod);
		Assert.assertEquals(codigoVenda, prod.getCodigo());
		
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		vendaConsultada.adicionarProduto(prod, 1);

		Assert.assertTrue(venda.getQuantidadeTotalProdutos() == 3);
		Assert.assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));

		vendaConsultada.removerProduto(prod, 1);

		Assert.assertTrue(venda.getQuantidadeTotalProdutos() == 2);
		Assert.assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
		Assert.assertTrue(venda.getStatus().equals(Venda.Status.INICIADA));
	} 
	
	@Test
	public void testRemoverTodosProdutos() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A9";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);

		Assert.assertTrue(retorno);
		Assert.assertNotNull(venda);
		Assert.assertEquals(codigoVenda, venda.getCodigo());
		
		Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));

		Assert.assertNotNull(prod);
		Assert.assertEquals(codigoVenda, prod.getCodigo());
		
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);
		vendaConsultada.adicionarProduto(prod, 1);

		Assert.assertTrue(venda.getQuantidadeTotalProdutos() == 3);
		Assert.assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));
		
		vendaConsultada.removerTodosProdutos();

		Assert.assertTrue(venda.getQuantidadeTotalProdutos() == 0);
		Assert.assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(0)));
		Assert.assertTrue(venda.getStatus().equals(Venda.Status.INICIADA));
	} 
	
	@Test
	public void testFinalizarVenda() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A10";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);

		Assert.assertTrue(retorno);
		Assert.assertNotNull(venda);
		Assert.assertEquals(codigoVenda, venda.getCodigo());
		
		vendaDao.finalizarVenda(venda);
		
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);

		Assert.assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		Assert.assertEquals(venda.getStatus(), vendaConsultada.getStatus());
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testTentarAdicionarProdutosVendaFinalizada() throws TipoChaveNaoEncontradaException {
		String codigoVenda = "A11";
		Venda venda = criarVenda(codigoVenda);
		Boolean retorno = vendaDao.cadastrar(venda);

		Assert.assertTrue(retorno);
		Assert.assertNotNull(venda);
		Assert.assertEquals(codigoVenda, venda.getCodigo());
		
		vendaDao.finalizarVenda(venda);
		Venda vendaConsultada = vendaDao.consultar(codigoVenda);

		Assert.assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		Assert.assertEquals(venda.getStatus(), vendaConsultada.getStatus());
		
		vendaConsultada.adicionarProduto(this.produto, 1);
	}

	private Produto cadastrarProduto(String codigo, BigDecimal valor) throws TipoChaveNaoEncontradaException {
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(valor);
		produtoDao.cadastrar(produto);
		return produto;
	}

	private Cliente cadastrarCliente() throws TipoChaveNaoEncontradaException {
		Cliente cliente = new Cliente();
		cliente.setCpf(69845634421L);
		cliente.setNome("Amanda");
		cliente.setCidade("Fortaleza");
		cliente.setEnd("Rua do Sol");
		cliente.setEstado("CE");
		cliente.setNumero(102);
		cliente.setTel(85987651234L);
		clienteDao.cadastrar(cliente);
		return cliente;
	}
	
	private Venda criarVenda(String codigo) {
		Venda venda = new Venda();
		venda.setCodigo(codigo);
		venda.setDataVenda(Instant.now());
		venda.setCliente(this.cliente);
		venda.setStatus(Venda.Status.INICIADA);
		venda.adicionarProduto(this.produto, 2);
		return venda;
	}
}
