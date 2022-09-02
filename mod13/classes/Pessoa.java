package br.com.mod13.classes;

public abstract class Pessoa {

    private String nome;
    private String telefone;
    private String enderecoCompleto;

    public Pessoa(){}

    public Pessoa(String nome, String telefone, String enderecoCompleto) {
        this.nome = nome;
        this.telefone = telefone;
        this.enderecoCompleto = enderecoCompleto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }
}
