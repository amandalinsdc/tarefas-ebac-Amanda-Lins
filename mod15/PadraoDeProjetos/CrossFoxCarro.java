package mod15.PadraoDeProjetos;

public class CrossFoxCarro implements Carro {
    private Float motor;
    private String cor;

    public CrossFoxCarro(Float motor, String cor){
        this.motor = motor;
        this.cor = cor;
    }

    @Override
    public void ligarCarro() {
        System.out.println("Ligando um CrossFox. Seu motor é "+motor+". Aceleraa!");
    }

    @Override
    public void limparCarro() {
        System.out.println("Limpando um CrossFox. Sua cor " + cor + " está mais brilhante do que nunca");
    }

    @Override
    public void abastecerCarro() {
        System.out.println("Abastecendo um CrossFox");
    }
}
