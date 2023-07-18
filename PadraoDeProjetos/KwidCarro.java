package mod15.PadraoDeProjetos;

public class KwidCarro implements Carro {
    private Float motor;
    private String cor;

    public KwidCarro(Float motor, String cor){
        this.motor = motor;
        this.cor = cor;
    }

    @Override
    public void ligarCarro() {
        System.out.println("Ligando um Kwid. Lembre-se seu motor é "+motor+". Pegue leve!");
    }

    @Override
    public void limparCarro() {
        System.out.println("Limpando um Kwid. Sua cor "+cor+" está mais brilhante do que nunca");
    }

    @Override
    public void abastecerCarro() {
        System.out.println("Abastecendo um Kwid");
    }
}
