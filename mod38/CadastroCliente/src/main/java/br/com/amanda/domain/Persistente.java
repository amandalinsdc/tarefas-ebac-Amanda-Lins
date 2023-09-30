package br.com.amanda.domain;

//Classe que representa todas as entidades ou objetos da aplicação que seram salvas no banco de dados
public interface Persistente {

	Long getId();
	void setId(Long id);
}
