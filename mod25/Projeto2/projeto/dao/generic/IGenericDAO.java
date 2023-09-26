package mod25.Projeto2.projeto.dao.generic;

import mod25.Projeto2.projeto.dao.Persistente;
import mod25.Projeto2.projeto.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

//Interface genérica para métodos de CRUD(Create, Read, Update and Delete)
public interface IGenericDAO <T extends Persistente, E extends Serializable> {

    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    public void excluir(E valor);

    public void alterar(T entity) throws TipoChaveNaoEncontradaException;

    public T consultar(E valor);

    public Collection<T> buscarTodos();
}
