package mod17.Generics;

public class Argo extends Carro {

    @Override
    public String montadora() {
        return "Fiat";
    }

    @Override
    public boolean isSedan() {
        return false;
    }

    @Override
    public String motor() {
        return "1.3";
    }
}
