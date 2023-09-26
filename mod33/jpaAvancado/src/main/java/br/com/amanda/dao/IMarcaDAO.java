package br.com.amanda.dao;

import br.com.amanda.domain.Carro;
import br.com.amanda.domain.Marca;

public interface IMarcaDAO {

	Marca cadastrar(Marca marca);
	
	Marca buscarPorCarro(Carro carro);
	
}
