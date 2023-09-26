package mod25.Projeto2;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import mod25.Projeto2.projeto.dao.IProdutoDAO;
import mod25.Projeto2.projeto.dao.ProdutoDAO;
import mod25.Projeto2.projeto.domain.Produto;
import mod25.Projeto2.projeto.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProdutoDAOTest {
	
	private IProdutoDAO produtoDao;
	private Produto produto;
	
	public ProdutoDAOTest() {
		produtoDao = new ProdutoDAO();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
		produtoDao.cadastrar(produto);
	}
	
	@Test
	public void testPesquisar() {
		Produto produto = this.produtoDao.consultar(this.produto.getCodigo());

		Assert.assertNotNull(produto);
	}
	
	@Test
	public void testSalvar() throws TipoChaveNaoEncontradaException {
		produto.setCodigo("A2");
		Boolean retorno = produtoDao.cadastrar(produto);

		Assert.assertTrue(retorno);
	}
	
	@Test
	public void testExcluir() {
		produtoDao.excluir(produto.getCodigo());
	}
	
	@Test
	public void testAlterarCliente() throws TipoChaveNaoEncontradaException {
		produto.setNome("Amanda Lins");
		produtoDao.alterar(produto);
		
		Assert.assertEquals("Amanda Lins", produto.getNome());
	}
	
	@Test
	public void testBuscarTodos() {
		Collection<Produto> list = produtoDao.buscarTodos();

		assertTrue(list != null);
		assertTrue(list.size() == 1);
	}
}
