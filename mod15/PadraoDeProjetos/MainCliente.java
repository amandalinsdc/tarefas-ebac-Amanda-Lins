package mod15.PadraoDeProjetos;

public class MainCliente {
    public static void main(String[] args) {
        // Criando factory kwid
        CarroFactory kwidFactory = new KwidCarroFactory();
        Carro kwid = kwidFactory.criarCarro(1.0f, "Laranja");
        kwid.limparCarro();
        kwid.abastecerCarro();
        kwid.ligarCarro();

        //Criando factory crossfox (serviço completo para carros 1.6)
        CarroFactory crossFoxFactory = new CrossFoxCarroFactory();
        Carro crossfox = crossFoxFactory.criarCarro(1.6f, "cinza");
        crossFoxFactory.servicoCompleto(crossfox);
    }
}