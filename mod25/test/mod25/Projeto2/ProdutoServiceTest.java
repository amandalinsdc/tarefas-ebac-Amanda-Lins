package mod25.Projeto2;

import java.math.BigDecimal;

import mod25.Projeto2.dao.ProdutoDaoMock;
import mod25.Projeto2.projeto.dao.IProdutoDAO;
import mod25.Projeto2.projeto.domain.Produto;
import mod25.Projeto2.projeto.exceptions.TipoChaveNaoEncontradaException;
import mod25.Projeto2.projeto.services.IProdutoService;
import mod25.Projeto2.projeto.services.ProdutoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProdutoServiceTest {

	private IProdutoService produtoService;
	private Produto produto;
	
	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}
	
	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
	}
	
	@Test
	public void testPesquisar() {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());

		Assert.assertNotNull(produtor);
	}
	
	@Test
	public void testSalvar() throws TipoChaveNaoEncontradaException {
		Boolean retorno = produtoService.cadastrar(produto);

		Assert.assertTrue(retorno);
	}
	
	@Test
	public void testExcluir() {
		produtoService.excluir(produto.getCodigo());
	}
	
	@Test
	public void testAlterarCliente() throws TipoChaveNaoEncontradaException {
		produto.setNome("Amanda Lins");
		produtoService.alterar(produto);
		
		Assert.assertEquals("Amanda Lins", produto.getNome());
	}
}
