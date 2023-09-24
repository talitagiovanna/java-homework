package br.edu.uniaeso.ArquivosCSV;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class FiltrarFuncionariosCSV {
    public static void main(String[] args) throws CsvValidationException {
        String arquivoCSV = "funcionarios.csv";
        List<String[]> funcionarios = new ArrayList<>();

        // Carregar dados existentes do arquivo CSV
        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            String[] linha;
            boolean primeiraLinha = true;

            while ((linha = reader.readNext()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                } else {
                    funcionarios.add(linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Opções de filtro:");
        System.out.println("1 - Filtrar por cargo");
        System.out.println("2 - Filtrar por salário mínimo");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();  // Limpar a quebra de linha deixada pelo nextInt()

        if (opcao == 1) {
            // Filtro por cargo
            System.out.print("Digite o cargo para filtrar: ");
            String cargoFiltro = scanner.nextLine();
            System.out.println("Funcionários com o cargo de " + cargoFiltro + ":");

            for (String[] funcionario : funcionarios) {
                if (funcionario[1].equalsIgnoreCase(cargoFiltro)) {
                    System.out.println("Nome: " + funcionario[0] + ", Cargo: " + funcionario[1] + ", Salário: " + funcionario[2]);
                }
            }
        } else if (opcao == 2) {
            // Filtro por salário mínimo
            System.out.print("Digite o salário mínimo para filtrar: ");
            double salarioMinimo = scanner.nextDouble();
            scanner.nextLine();  // Limpar a quebra de linha deixada pelo nextDouble()
            System.out.println("Funcionários com salário igual ou superior a " + salarioMinimo + ":");

            for (String[] funcionario : funcionarios) {
                double salario = Double.parseDouble(funcionario[2]);
                if (salario >= salarioMinimo) {
                    System.out.println("Nome: " + funcionario[0] + ", Cargo: " + funcionario[1] + ", Salário: " + salario);
                }
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }
}
