package br.com.amanda.dao.jpa;

import br.com.amanda.dao.generic.jpa.IGenericJapDAO;
import br.com.amanda.domain.jpa.Persistente;

public interface IClienteJpaDAO<T extends Persistente> extends IGenericJapDAO<T, Long>{

}
