package br.edu.uniaeso.ArquivosCSV;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerProdutosCSV {
    public static void main(String[] args) throws CsvValidationException, NumberFormatException {
        String arquivoCSV = "produtos.csv";
        List<Produto> produtos = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            String[] linha;
            boolean primeiraLinha = true;

            while ((linha = reader.readNext()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                } else {
                    String nome = linha[0];
                    double preco = Double.parseDouble(linha[1]);
                    int quantidade = Integer.parseInt(linha[2]);

                    Produto produto = new Produto(nome, preco, quantidade);
                    produtos.add(produto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Exibir os detalhes dos produtos no console
        System.out.println("Detalhes dos Produtos:");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
