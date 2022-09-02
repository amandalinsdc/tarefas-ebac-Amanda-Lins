package br.com.mod12.tarefa_colecoes;

import java.util.*;

public class SepararPorGeneroEOrdernar {
    public static void main(String[] args) {

        System.out.println("*** Escolha que parte da atividade deseja executar. ***");
        System.out.print("Escolha 1 para parte 1 e 2 para parte 2: ");

        Scanner lerEscolhaDoConsole = new Scanner(System.in);
        //Armazena valor em variável do tipo primitivo
        int escolha = lerEscolhaDoConsole.nextInt();

        if(escolha == 1) {
            parte1();
        }
        else if(escolha == 2) {
            parte2();
        }
    }

    /*
     *  ---- PARTE 1 ----
     * Ler do console lista de pessoas separadas por vírgula e ordená-las.
     *
     * */
    private static void parte1() {
        String chave = lerDoConsole();

        TreeSet<String> listaDePessoasOrdenada = new TreeSet<String>(Arrays.asList(chave.split(",")));
        System.out.println("*** Parte 1 ***");
        System.out.println("Lista ordenada de pessoas");
        System.out.println(listaDePessoasOrdenada);
    }

    /*
     *  ---- PARTE 2 ----
     * Ler do console lista de pessoas com chave (pessoa - genero) separadas por vírgula e separar por genero.
     *
     * */
    private static void parte2() {
        String dados = lerDoConsole();

        TreeSet<String> listaDeChavePessoaGeneroOrdenada = new TreeSet<String>(Arrays.asList(dados.split(",")));
        TreeSet<String> masculino = new TreeSet<>();
        TreeSet<String> feminino = new TreeSet<>();
        for (String dadoChave : listaDeChavePessoaGeneroOrdenada) {
            String chave[] = dadoChave.split("-");
            if(chave[1].equalsIgnoreCase("F")) {
                feminino.add(chave[0]);
            }
            else if(chave[1].equalsIgnoreCase("M")) {
                masculino.add(chave[0]);
            }
        }

        System.out.println("*** Coleções de pessoas do gênero feminino ***");
        System.out.println(feminino);
        System.out.println("*** Coleções de pessoas do gênero masculino ***");
        System.out.println(masculino);

    }



    private static String lerDoConsole() {
        System.out.print("Digite a lista de pessoas separadas por virgula: ");
        Scanner lerDoConsole = new Scanner(System.in);
        //Armazena valor em variável do tipo primitivo
        String chave = lerDoConsole.nextLine();

        return chave;
    }
}
