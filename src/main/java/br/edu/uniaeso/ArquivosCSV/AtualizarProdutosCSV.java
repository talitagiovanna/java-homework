package br.edu.uniaeso.ArquivosCSV;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class AtualizarProdutosCSV {
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

        System.out.print("Digite o nome do produto que deseja atualizar: ");
        String nomeProdutoParaAtualizar = scanner.nextLine();

        boolean encontrado = false;

        for (String[] linha : linhas) {
            if (linha[0].equalsIgnoreCase(nomeProdutoParaAtualizar)) {
                encontrado = true;
                System.out.print("Digite o novo preço do produto: ");
                double novoPreco = Double.parseDouble(scanner.nextLine());

                System.out.print("Digite a nova quantidade em estoque do produto: ");
                int novaQuantidadeEstoque = Integer.parseInt(scanner.nextLine());

                linha[1] = String.valueOf(novoPreco);
                linha[2] = String.valueOf(novaQuantidadeEstoque);
                System.out.println("Produto atualizado com sucesso.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Produto não encontrado.");
        }

        // Salvar as alterações no arquivo CSV
        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
            // Escreva todas as linhas, incluindo a primeira linha (cabeçalhos)
            writer.writeNext(new String[]{"Nome", "Preço", "Quantidade"});
            writer.writeAll(linhas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
