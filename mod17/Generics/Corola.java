package mod17.Generics;

public class Corola extends Carro{

    @Override
    public String montadora() {
        return "Toyota";
    }

    @Override
    public boolean isSedan() {
        return true;
    }

    @Override
    public String motor() {
        return "2.0";
    }
}
