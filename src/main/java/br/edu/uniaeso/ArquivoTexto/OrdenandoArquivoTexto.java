package br.edu.uniaeso.ArquivoTexto;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenandoArquivoTexto {
    public static void main(String[] args) {
        String nomeArquivoEntrada = "meuarquivo.txt";
        String nomeArquivoSaida = "meuarquivo_ordenado.txt";

        try {
            // Leitura do arquivo de entrada
            BufferedReader leituraArquivo = new BufferedReader(new FileReader(nomeArquivoEntrada));

            // Lista para armazenar as linhas do arquivo
            List<String> linhas = new ArrayList<>();

            String linha;

            while ((linha = leituraArquivo.readLine()) != null) {
                linhas.add(linha);
            }

            // Fecha o arquivo de leitura
            leituraArquivo.close();

            // Ordena as linhas em ordem alfabética
            Collections.sort(linhas);

            // Escrita das linhas ordenadas no arquivo de saída
            BufferedWriter escritaArquivo = new BufferedWriter(new FileWriter(nomeArquivoSaida));
            for (String linhaOrdenada : linhas) {
                escritaArquivo.write(linhaOrdenada);
                escritaArquivo.newLine(); // Adiciona uma nova linha após cada linha do arquivo
            }

            // Fecha o arquivo de escrita
            escritaArquivo.close();

            System.out.println("Arquivo ordenado com sucesso. Resultado salvo em " + nomeArquivoSaida);
        } catch (IOException e) {
            // Captura exceções de E/S (IOException) e imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao processar o arquivo: " + e.getMessage());
        }
    }
}

