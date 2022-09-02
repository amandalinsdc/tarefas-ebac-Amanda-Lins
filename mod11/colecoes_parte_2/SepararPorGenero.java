package br.com.mod11.colecoes_parte_2;

import java.util.*;

/* Criar coleção por gênero.
*/
public class SepararPorGenero {
    public static void main(String[] args) {
        Set<String> masculino = new HashSet<>();
        Set<String> feminino = new HashSet<>();

        System.out.println("*** Insira nome e sexo da pessoa separados por virgula. Siga o exemplo: Maria,F ou Pedro,M.");
        System.out.println("Para encerrar os cadastros e visualizar as coleções de pessoas por genêros, insira qualquer valor diferente de 1 ***");
        System.out.println("-----------------");
        int cadastrarPessoas = 1;
        while(cadastrarPessoas == 1) {
            //ler chave do console e montar chave pessoa genero
            String arrayPessoaGenero[] = montarChavePessoaGenero();

            if(arrayPessoaGenero[0].equalsIgnoreCase("fim")) break;

            if(arrayPessoaGenero.length < 2) {
                System.out.println("Chave inválida. Siga o exemplo: Maria,F ou Pedro,M");
                arrayPessoaGenero = montarChavePessoaGenero();
            }
            else if(arrayPessoaGenero[1].equalsIgnoreCase("F")) {
                feminino.add(arrayPessoaGenero[0]);
            }
            else if(arrayPessoaGenero[1].equalsIgnoreCase("M")) {
                masculino.add(arrayPessoaGenero[0]);
            }
            else {
                System.out.println("Gênero inválido. Digite (F) ou (M)");
                continue;
            }
        }
        System.out.println("*** Coleções de pessoas do gênero feminino ***");
        System.out.println(feminino);
        System.out.println("*** Coleções de pessoas do gênero masculino ***");
        System.out.println(masculino);
    }

    private static String lerDoConsole() {
        System.out.print("Digite a chave nome e gênero ou 'fim': ");
        Scanner lerDoConsole = new Scanner(System.in);
        //Armazena valor em variável do tipo primitivo
        String chave = lerDoConsole.nextLine();

        return chave;
    }

    private static String[] montarChavePessoaGenero() {
        String chave = lerDoConsole();
        return chave.split(",");
    }
}
