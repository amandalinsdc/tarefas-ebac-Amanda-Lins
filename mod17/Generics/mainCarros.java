package mod17.Generics;

import java.util.Arrays;

public class mainCarros {
    public static void main(String[] args) {
        GenericCarros<Carro> listaDeCarros = new GenericCarros<>();

        listaDeCarros.adicionarCarros(Arrays.asList(new Kwid(), new Corola(), new Argo()));
        listaDeCarros.listarCarros();
    }
}
