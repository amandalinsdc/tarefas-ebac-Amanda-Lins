package br.com.mod13.classes;

public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private String razaoSocial;
    private int qtdDeFuncionarios;

    public PessoaJuridica(String nome, String telefone, String enderecoCompleto, String cnpj, String razaoSocial, int qtdDeFuncionarios) {
        super(nome, telefone, enderecoCompleto);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.qtdDeFuncionarios = qtdDeFuncionarios;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public int getQtdDeFuncionarios() {
        return qtdDeFuncionarios;
    }

    public void setQtdDeFuncionarios(int qtdDeFuncionarios) {
        this.qtdDeFuncionarios = qtdDeFuncionarios;
    }
}
