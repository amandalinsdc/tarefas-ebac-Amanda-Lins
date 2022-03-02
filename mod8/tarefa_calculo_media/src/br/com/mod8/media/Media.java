package br.com.mod8.media;

public class Media {
    public static void main(String[] args) {
        calcularMedia();
    }

    public static void calcularMedia() {
        float nota1 = 7.0f;
        float nota2 = 10f;
        float nota3 = 5.7f;
        float nota4 = 4.8f;

        float resultadoCalculoDaMedia = (nota1+nota2+nota3+nota4)/4;

        System.out.println("*** Média ***");
        System.out.println("Nota 1: "+nota1);
        System.out.println("Nota 2: "+nota2);
        System.out.println("Nota 3: "+nota3);
        System.out.println("Nota 4: "+nota4);
        System.out.println("Média das notas: "+ resultadoCalculoDaMedia);
    }
}
