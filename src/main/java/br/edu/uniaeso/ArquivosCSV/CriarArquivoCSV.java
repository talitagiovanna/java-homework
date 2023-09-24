package br.edu.uniaeso.ArquivosCSV;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CriarArquivoCSV {
    public static void main(String[] args) {
        String arquivoCSV = "funcionarios.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV, true))) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Digite o nome do funcionário (ou 'sair' para encerrar): ");
                String nome = scanner.nextLine();

                if (nome.equalsIgnoreCase("sair")) {
                    break;
                }

                System.out.print("Digite o cargo do funcionário: ");
                String cargo = scanner.nextLine();

                System.out.print("Digite o salário do funcionário: ");
                double salario = Double.parseDouble(scanner.nextLine());

                String[] linha = {nome, cargo, Double.toString(salario)};
                writer.writeNext(linha);

                System.out.println("Funcionário adicionado com sucesso.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
