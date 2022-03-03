package br.com.mod9.wrappers;

import java.util.Scanner;

public class Wrappers {

    public static void main(String[] args) {
        //Ler do console
        Scanner lerDoConsole = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");

        //Armazena valor em variável do tipo primitivo
        int numero = lerDoConsole.nextInt();

        //Converte para wrappers
        Integer numeroWrapper = numero;
        System.out.println("Número convertido: "+numeroWrapper);
    }
}
