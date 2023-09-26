package mod25.Projeto2.projeto.dao.generic;

import mod25.Projeto2.annotation.TipoChave;
import mod25.Projeto2.projeto.dao.Persistente;
import mod25.Projeto2.projeto.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//Classe genérica que implementa interface genérica com os métodos de CRUD
public abstract class GenericDAO<T extends Persistente, E extends Serializable> implements IGenericDAO<T, E> {

    //Usar Singleton para ter apenas um MAP no sistema
    private SingletonMap singletonMap;

    public GenericDAO() {
        this.singletonMap = SingletonMap.getInstance();
    }

    public abstract Class<T> getTipoClasse();

    public abstract void atualizarDados(T entity, T entityCadastrado);

    public E getChave(T entity) throws TipoChaveNaoEncontradaException {
        Field[] fields = entity.getClass().getDeclaredFields();
        E returnValue = null;
        for (Field field : fields) {
            if (field.isAnnotationPresent(TipoChave.class)) {
                TipoChave tipoChave = field.getAnnotation(TipoChave.class);
                String nomeMetodo = tipoChave.value();
                try {
                    Method method = entity.getClass().getMethod(nomeMetodo);
                    returnValue = (E) method.invoke(entity);
                    return returnValue;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    //Criar exception de negócio TipoChaveNaoEncontradaException
                    //Criar exception de negócio TipoChaveNaoEncontradaException
                    e.printStackTrace();
                    throw new TipoChaveNaoEncontradaException("Chave principal do objeto " + entity.getClass() + " não encontrada", e);
                }
            }
        }
        if (returnValue == null) {
            String msg = "Chave principal do objeto " + entity.getClass() + " não encontrada";
            System.out.println("**** ERRO ****" + msg);
            throw new TipoChaveNaoEncontradaException(msg);
        }
        return null;
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
        //Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        Map<E, T> mapaInterno = getMapa();
        E chave = getChave(entity);
        if (mapaInterno.containsKey(chave)) {
            return false;
        }

        mapaInterno.put(chave, entity);
        return true;
    }

	private Map<E, T> getMapa() {
		Map<E, T> mapaInterno = (Map<E, T>) this.singletonMap.getMap().get(getTipoClasse());
		if (mapaInterno == null) {
			mapaInterno = new HashMap<>();
			this.singletonMap.getMap().put(getTipoClasse(), mapaInterno);
		}
		return mapaInterno;
	}

    @Override
    public void excluir(E valor) {
        //Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        Map<E, T> mapaInterno = getMapa();
        T objetoCadastrado = mapaInterno.get(valor);
        if (objetoCadastrado != null) {
            mapaInterno.remove(valor, objetoCadastrado);
        }
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException {
        Map<E, T> mapaInterno = getMapa();
        E chave = getChave(entity);
        T objetoCadastrado = mapaInterno.get(chave);
        if (objetoCadastrado != null) {
            atualizarDados(entity, objetoCadastrado);
        }
    }

    @Override
    public T consultar(E valor) {
        //Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        Map<E, T> mapaInterno = getMapa();
        return mapaInterno.get(valor);
    }

    @Override
    public Collection<T> buscarTodos() {
        Map<E, T> mapaInterno = getMapa();
        return mapaInterno.values();
    }
}
