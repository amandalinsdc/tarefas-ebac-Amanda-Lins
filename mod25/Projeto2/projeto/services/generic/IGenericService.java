package mod25.Projeto2.projeto.services.generic;

import mod25.Projeto2.projeto.dao.Persistente;
import mod25.Projeto2.projeto.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericService <T extends Persistente, E extends Serializable> {

    Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    void excluir(E valor);

    void alterar(T entity) throws TipoChaveNaoEncontradaException;

    T consultar(E valor);

    Collection<T> buscarTodos();

}
