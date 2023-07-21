package mod17.Generics;

public class Kwid extends Carro {

    @Override
    public String montadora() {
        return "Renault";
    }

    @Override
    public boolean isSedan() {
        return false;
    }

    @Override
    public String motor() {
        return "1.0";
    }
}
