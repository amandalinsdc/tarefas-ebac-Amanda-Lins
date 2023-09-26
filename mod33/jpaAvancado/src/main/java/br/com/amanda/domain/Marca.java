package br.com.amanda.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MARCA")
public class Marca {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="marca_seq")
	@SequenceGenerator(name="marca_seq", sequenceName="sq_marca", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "SERIE", length = 10, nullable = false, unique = true)
	private String serie;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "pais", nullable = false)
	private String pais;

	@OneToOne
	@JoinColumn(name = "id_carro_fk",
		foreignKey = @ForeignKey(name = "fk_carro_marca"),
		referencedColumnName = "id", nullable = false
	)	
	private Carro carro;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getNome() { return nome; }

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
}
