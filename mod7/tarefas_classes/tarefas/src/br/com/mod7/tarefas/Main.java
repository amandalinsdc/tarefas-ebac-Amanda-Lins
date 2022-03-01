package br.com.mod7.tarefas;

public class Main {

    public static void main(String[] args) {

        // Mouse 1
        Mouse mouseUm = new Mouse();
        mouseUm.setNome("Mouse sem Fio Movitec Óptico 1200DPI 3 Botões");
        mouseUm.setMarca("Movitec");
        mouseUm.setReferencia("OMW-02");
        mouseUm.setCor("Preto");
        mouseUm.setBluetooth(true);
        mouseUm.setPreco(84.99);

        System.out.println("Mouse 1 ");
        System.out.println("Título: " + mouseUm.tituloDoMouse());
        System.out.println("Marca: " + mouseUm.getMarca());
        System.out.println("Cor: " + mouseUm.getCor());
        System.out.println("Preço: R$ " + mouseUm.getPreco());
        System.out.println("Sem fio: " + mouseUm.isSemFio());

        // Mouse 2
        Mouse mouseDois = new Mouse();
        mouseDois.setNome("Mouse Logitech Óptico 1000DPI 3 Botões");
        mouseDois.setMarca("Logitech");
        mouseDois.setReferencia("M185");
        mouseDois.setCor("Vermelho");
        mouseDois.setBluetooth(false);
        mouseDois.setPreco(42.00);

        System.out.println("Mouse 2 ");
        System.out.println("Título: " + mouseDois.tituloDoMouse());
        System.out.println("Marca: " + mouseDois.getMarca());
        System.out.println("Cor: " + mouseDois.getCor());
        System.out.println("Preço: R$ " + mouseDois.getPreco());
        System.out.println("Sem fio: " + mouseDois.isSemFio());
    }
}
