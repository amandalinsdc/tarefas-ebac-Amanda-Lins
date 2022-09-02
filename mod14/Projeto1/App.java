package br.com.mod14.Projeto1;

import br.com.mod14.Projeto1.dao.ClienteMapDAO;
import br.com.mod14.Projeto1.dao.IClienteDAO;
import br.com.mod14.Projeto1.domain.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String args[]) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = chamadaInicial();

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida! Escolha uma opção:\n" +
                            "- 1 para cadastrar \n" +
                            "- 2 para consultar \n" +
                            "- 3 para excluir \n" +
                            "- 4 para alterar \n" +
                            "- 5 para sair",
                    "Opção inválida", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {
            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula, conforme exemplo: " +
                                "Nome (obrigatório), CPF (obrigatório), Telefone, Endereço, Número, Cidade e Estado.\n" +
                                "Se desejar deixar campos vazios, siga o exemplo: Nome, CPF, Telefone, , Endereco, , , ",
                        "Cadastrar cliente", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if(isConsultar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o cpf:",
                        "Consultar cliente", JOptionPane.INFORMATION_MESSAGE);

               consultar(dados);
            } else if (isExclusao(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente:",
                        "Excluir cliente", JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            } else {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula, conforme exemplo: " +
                                "Nome (obrigatório), CPF (obrigatório), Telefone, Endereço, Número, Cidade e Estado.\n" +
                                "Se desejar deixar campos vazios, siga o exemplo: Nome, CPF, Telefone, , Endereco, , , ",
                        "Atualizar cliente", JOptionPane.INFORMATION_MESSAGE);
                atualizar(dados);
            }

            opcao = chamadaInicial();
        }
    }

    private static void consultar(String dados) {
        //Validar se foi passado somente o cpf
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente.toString(), "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static boolean isConsultar(String opcao) {
        if ("2".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");

        //Verifica se todos os campos foram declarados
        if(dadosSeparados.length < 7) {
            JOptionPane.showMessageDialog(null, "Você não declarou todos os campos. " +
                    "Tente novamente", "Erro :(",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        // Verifica se os campos obrigatórios forem preenchidos
        else if(dadosSeparados[0].length() < 3 || dadosSeparados[1].length() < 11) {
            JOptionPane.showMessageDialog(null, "Você não preencheu campos obrigatórios corretamente (nome ou cpf). " +
                    "Tente novamente", "Erro :(",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        for(int i=0;i<dadosSeparados.length;i++) {
            if(dadosSeparados[i].length() == 0 || dadosSeparados[i] == " " || dadosSeparados[i] == "") {
                dadosSeparados[i] = null;
            }
        }
        Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado", "Erro",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isCadastro(String opcao) {
        if ("1".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void excluir(String dados) {
        iClienteDAO.excluir(Long.parseLong(dados));
        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso. ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }

    private static boolean isExclusao(String opcao) {
        if ("3".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void atualizar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
        iClienteDAO.alterar(cliente);
    }

    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo :) ", "Sair",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao)
                || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isOpcaoCadastro(String opcao) {
        if ("1".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static String chamadaInicial() {
        return JOptionPane.showInputDialog(null,
                "Olá! Escolha uma opção:\n" +
                        "- 1 para cadastrar \n" +
                        "- 2 para consultar \n" +
                        "- 3 para excluir \n" +
                        "- 4 para alterar \n" +
                        "- 5 para sair",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);
    }
}
