package br.com.mod10.controle_de_fluxo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Entre com 4 notas pelo console e faça a média.
*  Se média >=7 mostrar mensagem "Aluno aprovado"
*  Se média >=5 e <7 mostrar mensagem "Aluno em recuperação"
*  Se média <5 mostrar mensagem "Aluno reprovado"
*/
public class MediaDeNotasComControleDeFluxo {
    public static void main(String[] args) {

        List<Float> notas = new ArrayList<>();
        System.out.println("*** Insira suas 4 notas ***");
        for(int i = 0; i < 4; i++) {
            System.out.print("Digite nota "+(i+1)+": ");
            //Ler do console
            Scanner lerDoConsole = new Scanner(System.in);
            //Armazena valor em variável do tipo primitivo
            float nota = lerDoConsole.nextFloat();
            notas.add(nota);
        }
        System.out.println("-----------------");
        System.out.println("*** Média ***");
        float resultadoCalculoDaMedia = calcularMedia(notas);
        System.out.print(resultadoCalculoDaMedia+" - ");

        if(resultadoCalculoDaMedia >= 7f) {
            System.out.println("Aluno aprovado");
        }
        else if(resultadoCalculoDaMedia >= 5f && resultadoCalculoDaMedia < 7f) {
            System.out.println("Aluno de recuperação");
        }
        else {
            System.out.println("Aluno reprovado");
        }
    }

    private static float calcularMedia(List<Float> notas) {
        float somaDasNotas = 0f;
        for(float nota : notas) {
            somaDasNotas = somaDasNotas + nota;
        }

        return somaDasNotas/4;
    }
}
