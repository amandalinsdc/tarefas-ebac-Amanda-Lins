package mod22.Streams;
import java.util.*;
import java.util.stream.Collectors;

public class mainStreams {
    public static void main(String[] args) {
        List<String> pessoasPorGenero = new ArrayList<>();

        System.out.println("* Insira nome e sexo da pessoa separados por virgula. Siga o exemplo: Maria,F ou Pedro,M.");
        System.out.println("Para encerrar os cadastros e visualizar as coleções de pessoas por genêros, insira qualquer valor diferente de 1 *");
        System.out.println("-----------------");

        int cadastrarPessoas = 1;
        while(cadastrarPessoas == 1) {
            //ler chave do console e montar chave pessoa genero
            String arrayPessoaGenero = montarChavePessoaGenero();

            if(arrayPessoaGenero.contains("fim")) break;

            if(!arrayPessoaGenero.contains("(")) {
                System.out.println("Chave inválida. Siga o exemplo: Maria,F ou Pedro,M");
                arrayPessoaGenero = montarChavePessoaGenero();
            }
            else if(arrayPessoaGenero.contains("F") || arrayPessoaGenero.contains("f")
                    || arrayPessoaGenero.contains("M") || arrayPessoaGenero.contains("m")) {
                pessoasPorGenero.add(arrayPessoaGenero);
            }
            else {
                System.out.println("Gênero inválido. Digite (F) ou (M)");
                continue;
            }
        }
        System.out.println("* Coleções de pessoas *");
        System.out.println(pessoasPorGenero);

        // Criar streams apenas com pessoas do genero feminino
        List<String> generoFemino = pessoasPorGenero.stream().filter(p -> p.contains("f") || p.contains("F")).collect(Collectors.toList());
        System.out.println("* Coleções de pessoas do gênero feminino *");
        System.out.println(generoFemino);
    }

    private static String lerDoConsole() {
        System.out.print("Digite a chave nome e gênero ou 'fim': ");
        Scanner lerDoConsole = new Scanner(System.in);
        //Armazena valor em variável do tipo primitivo
        String chave = lerDoConsole.nextLine();

        return chave;
    }

    private static String montarChavePessoaGenero() {
        String chave = lerDoConsole();
        return chave.replace(",", " (") + ")";
    }
}
