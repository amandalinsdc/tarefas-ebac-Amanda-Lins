package br.com.amanda;

import br.com.amanda.dao.IProdutoDAO;
import br.com.amanda.dao.ProdutoDAO;
import br.com.amanda.domain.Produto;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {

	@Test
	public void testCadastrar() throws Exception {
		IProdutoDAO dao = new ProdutoDAO();

		Produto produto = new Produto();
		produto.setCodigo("01");
		produto.setNome("Produto 1");
		produto.setDescricao("Descrição produto 1");
		produto.setValor(new BigDecimal("10.0"));

		Integer qtd = dao.cadastrar(produto);
		assertTrue(qtd == 1);

		Produto produtoBD = dao.consultar(produto.getCodigo());
		assertNotNull(produtoBD);
		assertNotNull(produtoBD.getId());
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getNome(), produtoBD.getNome());
		assertEquals(produto.getDescricao(), produtoBD.getDescricao());
		assertEquals(produto.getValor(), produtoBD.getValor());

		Integer qtdDel = dao.excluir(produtoBD);
		assertNotNull(qtdDel);
	}

	@Test
	public void testBuscar() throws Exception {
		IProdutoDAO dao = new ProdutoDAO();

		Produto produto = new Produto();
		produto.setCodigo("01");
		produto.setNome("Produto 1");
		produto.setDescricao("Descrição produto 1");
		produto.setValor(new BigDecimal("10.0"));

		Integer qtd = dao.cadastrar(produto);
		assertTrue(qtd == 1);

		Produto produtoBD = dao.consultar(produto.getCodigo());
		assertNotNull(produtoBD);
		assertNotNull(produtoBD.getId());
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getNome(), produtoBD.getNome());
		assertEquals(produto.getDescricao(), produtoBD.getDescricao());
		assertEquals(produto.getValor(), produtoBD.getValor());

		Integer qtdDel = dao.excluir(produtoBD);
		assertNotNull(qtdDel);
	}

	@Test
	public void testExcluir() throws Exception {
		IProdutoDAO dao = new ProdutoDAO();

		Produto produto = new Produto();
		produto.setCodigo("01");
		produto.setNome("Produto 1");
		produto.setDescricao("Descrição produto 1");
		produto.setValor(new BigDecimal("10.0"));

		Integer qtd = dao.cadastrar(produto);
		assertTrue(qtd == 1);

		Produto produtoBD = dao.consultar(produto.getCodigo());
		assertNotNull(produtoBD);
		assertNotNull(produtoBD.getId());
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getNome(), produtoBD.getNome());
		assertEquals(produto.getDescricao(), produtoBD.getDescricao());
		assertEquals(produto.getValor(), produtoBD.getValor());

		Integer qtdDel = dao.excluir(produtoBD);
		assertNotNull(qtdDel);
	}

	@Test
	public void testBuscarTodos() throws Exception {
		IProdutoDAO dao = new ProdutoDAO();
		ProdutoDAO produtoDao = new ProdutoDAO();

		Produto produto1 = new Produto();
		produto1.setCodigo("01");
		produto1.setNome("Produto 1");
		produto1.setDescricao("Descrição produto 1");
		produto1.setValor(new BigDecimal("10.0"));

		Integer qtdProd1 = dao.cadastrar(produto1);
		assertTrue(qtdProd1 == 1);

		Produto produto2 = new Produto();
		produto2.setCodigo("02");
		produto2.setNome("Produto 2");
		produto2.setDescricao("Descrição produto 2");
		produto2.setValor(new BigDecimal("12.0"));

		Integer qtdProd2 = dao.cadastrar(produto2);
		assertTrue(qtdProd2 == 1);

		List<Produto> produtos = produtoDao.buscarTodos();
		assertNotNull(produtos);
		assertEquals(2, produtos.size());

		int countDel = 0;
		for(Produto prod : produtos) {
			produtoDao.excluir(prod);
			countDel++;
		}
		assertEquals(produtos.size(), countDel);
	}
}
