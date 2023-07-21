package mod17.Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericCarros<T extends Carro> {

    private List<T> carros = new ArrayList<>();

    public void adicionarCarros(List<T> carrosNovos) {
        for (T carro : carrosNovos) {
            carros.add(carro);
        }
    }

    public void listarCarros() {
        for (T carro : carros) {
            System.out.println("Nome: "+carro.getClass().getSimpleName());
            System.out.println("Montadora: "+carro.montadora());
            System.out.println("É Sedan? "+ (carro.isSedan()==true?"Sim":"Não"));
            System.out.println("Motor: "+carro.motor());
            System.out.println("---------------------");
        }
    }
}
