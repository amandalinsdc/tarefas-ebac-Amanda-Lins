package br.com.amanda.dao;

import br.com.amanda.domain.Produto;
import java.util.List;

public interface IProdutoDAO {

    Produto cadastrar(Produto produto);

    void excluir(Produto produto);

    List<Produto> buscarTodos();
}
