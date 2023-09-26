package br.com.amanda.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carro_seq")
	@SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "CODIGO", length = 10, nullable = false, unique = true)
	private String codigo;
	
	@Column(name = "nome", length = 10, nullable = false)
	private String nome;

	@Column(name = "ano", length = 4, nullable = false)
	private long ano;
	
	@OneToOne(mappedBy = "marca")
	private Marca marca;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "TB_CARRO_ACESSORIO",
        joinColumns = { @JoinColumn(name = "id_carro_fk") },
        inverseJoinColumns = { @JoinColumn(name = "id_acessorio_fk") }
    )
	private List<Acessorio> acessorios;
	
	public Carro() {
		this.acessorios = new ArrayList<Acessorio>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getAno() {
		return ano;
	}

	public void setAno(long ano) {
		this.ano = ano;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	
	public void add(Acessorio aces) {
		this.acessorios.add(aces);
	}
}
