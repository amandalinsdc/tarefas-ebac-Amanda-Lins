package br.com.mod14.Projeto1.domain;

import java.util.Objects;

public class Cliente {
    private String nome;
    private Long cpf;
    private Long telefone;
    private String endereco;
    private String numero;
    private String cidade;
    private String estado;

    public Cliente(String nome, String cpf, String telefone,
                   String endereco, String numero, String cidade, String estado) {
        this.nome = nome.trim();
        this.cpf = Long.valueOf(cpf);
        this.telefone = Long.valueOf(telefone);
        this.endereco = endereco.trim();
        this.numero = numero.trim();
        this.cidade = cidade.trim();
        this.estado = estado.trim();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Cliente -> " + "Nome: " + nome + " | CPF: " + cpf;
    }
}
