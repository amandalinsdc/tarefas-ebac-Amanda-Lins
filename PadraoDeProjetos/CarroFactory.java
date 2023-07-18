package mod15.PadraoDeProjetos;

public interface CarroFactory {
    Carro criarCarro(Float motor, String cor);
    Carro servicoCompleto(Carro carro);
}
