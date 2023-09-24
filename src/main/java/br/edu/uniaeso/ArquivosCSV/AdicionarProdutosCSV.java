package br.edu.uniaeso.ArquivosCSV;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AdicionarProdutosCSV {
    public static void main(String[] args) {
        String arquivoCSV = "produtos.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV, true))) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o nome do produto: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o preço do produto: ");
            double preco = Double.parseDouble(scanner.nextLine());

            System.out.print("Digite a quantidade em estoque do produto: ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            String[] linha = {nome, Double.toString(preco), Integer.toString(quantidade)};
            writer.writeNext(linha);

            System.out.println("Produto adicionado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
