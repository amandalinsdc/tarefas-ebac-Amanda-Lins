package mod15.PadraoDeProjetos;

public class KwidCarroFactory implements CarroFactory {

    @Override
    public Carro criarCarro(Float motor, String cor) {
        return new KwidCarro(motor, cor);
    }

    @Override
    public Carro servicoCompleto(Carro carro) {
        return null;
    }
}