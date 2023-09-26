package br.com.amanda;

import br.com.amanda.dao.IProdutoDAO;
import br.com.amanda.dao.ProdutoDAO;
import br.com.amanda.domain.Produto;

import java.util.List;

public class ProdutoTest {

    private IProdutoDAO produtoDao;

    public ProdutoTest() {
        produtoDao = new ProdutoDAO();
    }

    @After
    public void end() {
        List<Produto> list = produtoDao.buscarTodos();
        list.forEach(prod -> produtoDao.excluir(prod));
    }

    @Test
    public void cadastrar() {
        Produto prod = new Produto();
        prod.setCodigo("A1");
        prod.setNome("Produto 1");
        prod.setValor(500d);
        prod = produtoDao.cadastrar(prod);

        assertNotNull(prod);
        assertNotNull(prod.getId());
    }
}
