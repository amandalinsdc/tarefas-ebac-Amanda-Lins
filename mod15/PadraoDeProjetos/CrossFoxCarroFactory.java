package mod15.PadraoDeProjetos;

public class CrossFoxCarroFactory implements CarroFactory {

    @Override
    public Carro criarCarro(Float motor, String cor) {
        return new CrossFoxCarro(motor, cor);
    }


    @Override
    public Carro servicoCompleto(Carro carro) {
        carro.abastecerCarro();
        carro.limparCarro();
        carro.ligarCarro();
        return carro;
    }
}