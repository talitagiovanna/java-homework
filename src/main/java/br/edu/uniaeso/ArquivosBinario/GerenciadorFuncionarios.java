package br.edu.uniaeso.ArquivosBinario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorFuncionarios {
    public static void main(String[] args) {
        String nomeArquivo = "funcionarios.dat";
        List<Funcionario> funcionarios = new ArrayList<>();

        // Carrega os registros existentes, se houver
        carregarFuncionarios(nomeArquivo, funcionarios);

        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nOpções:");
            System.out.println("1 - Listar Funcionários");
            System.out.println("2 - Adicionar Funcionário");
            System.out.println("3 - Atualizar Funcionário");
            System.out.println("4 - Excluir Funcionário");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    listarFuncionarios(funcionarios);
                    break;
                case 2:
                    adicionarFuncionario(scanner, funcionarios);
                    break;
                case 3:
                    atualizarFuncionario(scanner, funcionarios);
                    break;
                case 4:
                    excluirFuncionario(scanner, funcionarios);
                    break;
                case 5:
                    salvarFuncionarios(nomeArquivo, funcionarios);
                    scanner.close();
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void carregarFuncionarios(String nomeArquivo, List<Funcionario> funcionarios) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            while (true) {
                Funcionario funcionario = (Funcionario) objectInputStream.readObject();
                funcionarios.add(funcionario);
            }
        } catch (EOFException e) {
            // Fim do arquivo
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar funcionários: " + e.getMessage());
        }
    }

    private static void salvarFuncionarios(String nomeArquivo, List<Funcionario> funcionarios) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            for (Funcionario funcionario : funcionarios) {
                objectOutputStream.writeObject(funcionario);
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar funcionários: " + e.getMessage());
        }
    }

    private static void listarFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("\nFuncionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    private static void adicionarFuncionario(Scanner scanner, List<Funcionario> funcionarios) {
        System.out.print("Digite o ID do funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o salário do funcionário: ");
        double salario = scanner.nextDouble();

        Funcionario novoFuncionario = new Funcionario(id, nome, salario);
        funcionarios.add(novoFuncionario);

        System.out.println("Funcionário adicionado com sucesso.");
    }

    private static void atualizarFuncionario(Scanner scanner, List<Funcionario> funcionarios) {
        System.out.print("Digite o ID do funcionário que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa a quebra de linha

        Funcionario funcionarioParaAtualizar = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                funcionarioParaAtualizar = funcionario;
                break;
            }
        }

        if (funcionarioParaAtualizar != null) {
            System.out.print("Digite o novo nome do funcionário: ");
            String novoNome = scanner.nextLine();

            System.out.print("Digite o novo salário do funcionário: ");
            double novoSalario = scanner.nextDouble();

            funcionarioParaAtualizar.setNome(novoNome);
            funcionarioParaAtualizar.setSalario(novoSalario);

            System.out.println("Funcionário atualizado com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void excluirFuncionario(Scanner scanner, List<Funcionario> funcionarios) {
        System.out.print("Digite o ID do funcionário que deseja excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa a quebra de linha

        Funcionario funcionarioParaExcluir = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                funcionarioParaExcluir = funcionario;
                break;
            }
        }

        if (funcionarioParaExcluir != null) {
            funcionarios.remove(funcionarioParaExcluir);
            System.out.println("Funcionário excluído com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }
}

