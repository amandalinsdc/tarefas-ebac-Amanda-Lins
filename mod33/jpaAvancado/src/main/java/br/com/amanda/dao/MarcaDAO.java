package br.com.amanda.dao;

import br.com.amanda.domain.Carro;
import br.com.amanda.domain.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

public class MarcaDAO implements IMarcaDAO {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");

	@Override
	public Marca cadastrar(Marca marca) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(marca);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		return marca;
	}

	@Override
	public Marca buscarPorCarro(Carro carro) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT m FROM Marca m ");
		sb.append("INNER JOIN Carro c on c = m.carro ");
		sb.append("WHERE c = :carro");
		
		entityManager.getTransaction().begin();
		TypedQuery<Marca> query = entityManager.createQuery(sb.toString(), Marca.class);
		query.setParameter("carro", carro);
		Marca marca = query.getSingleResult();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return marca;
	}
}
