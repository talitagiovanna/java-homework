package br.edu.uniaeso.ArquivosCSV;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ExcluirProdutosCSV {
    public static void main(String[] args) throws CsvValidationException {
        String arquivoCSV = "produtos.csv";
        List<String[]> linhas = new ArrayList<>();

        // Carregar dados existentes do arquivo CSV
        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            String[] linha;
            boolean primeiraLinha = true;

            while ((linha = reader.readNext()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                } else {
                    linhas.add(linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do produto que deseja excluir: ");
        String nomeProdutoParaExcluir = scanner.nextLine();

        boolean encontrado = false;
        List<String[]> novasLinhas = new ArrayList<>();

        for (String[] linha : linhas) {
            if (linha[0].equalsIgnoreCase(nomeProdutoParaExcluir)) {
                encontrado = true;
                System.out.println("Produto excluído com sucesso.");
            } else {
                novasLinhas.add(linha);
            }
        }

        if (!encontrado) {
            System.out.println("Produto não encontrado.");
        }

        // Salvar as alterações no arquivo CSV
        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
            // Escreva todas as linhas, incluindo a primeira linha (cabeçalhos)
            writer.writeNext(new String[]{"Nome", "Preço", "Quantidade"});
            writer.writeAll(novasLinhas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
