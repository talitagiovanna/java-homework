package br.edu.uniaeso.ArquivoTexto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RemoverLinhasArquivo {
    public static void main(String[] args) {
        String nomeArquivoEntrada = "meuarquivo.txt";
        String nomeArquivoSaida = "meuarquivo_sem_excluir.txt";

        try {
            // Leitura do arquivo de entrada
            BufferedReader leituraArquivo = new BufferedReader(new FileReader(nomeArquivoEntrada));

            // Lista para armazenar as linhas que não contêm a palavra "excluir"
            List<String> linhasFiltradas = new ArrayList<>();

            String linha;

            // Lê cada linha do arquivo e verifica se contém a palavra "excluir"
            while ((linha = leituraArquivo.readLine()) != null) {
                if (!linha.contains("excluir")) {
                    linhasFiltradas.add(linha);
                }
            }

            // Fecha o arquivo de leitura
            leituraArquivo.close();

            // Escrita das linhas filtradas no arquivo de saída
            BufferedWriter escritaArquivo = new BufferedWriter(new FileWriter(nomeArquivoSaida));
            for (String linhaFiltrada : linhasFiltradas) {
                escritaArquivo.write(linhaFiltrada);
                escritaArquivo.newLine(); // Adiciona uma nova linha após cada linha do arquivo
            }

            // Fecha o arquivo de escrita
            escritaArquivo.close();

            System.out.println("Linhas com a palavra 'excluir' removidas com sucesso. Resultado salvo em " + nomeArquivoSaida);
        } catch (IOException e) {
            // Captura exceções de E/S (IOException) e imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao processar o arquivo: " + e.getMessage());
        }
    }   
}
