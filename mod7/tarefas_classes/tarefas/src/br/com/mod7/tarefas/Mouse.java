package br.com.mod7.tarefas;

/**
 * @author Amanda
 */
public class Mouse {
    private String nome;
    private String marca;
    private String referencia;
    private String cor;
    private double preco;
    private boolean isSemFio;

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isSemFio() {
        return isSemFio;
    }

    public void setBluetooth(boolean isSemFio) {
        this.isSemFio = isSemFio;
    }

    /**
     *
     * @return retorna o valor do nome e da referencia do objeto concatenados separados por hífen
     */
    public String tituloDoMouse() {
        return this.nome + " - " + this.referencia;
    }
}
