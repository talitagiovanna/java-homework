package br.edu.uniaeso.ArquivoTexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SubstituirPalavraArquivo {
    public static void main(String[] args) {
        String nomeArquivoEntrada = "meuarquivo.txt";
        String nomeArquivoSaida = "meuarquivo_python.txt";

        try {
            // Abre um FileReader para o arquivo de entrada
            FileReader arquivoLeitura = new FileReader(nomeArquivoEntrada);

            // Cria um BufferedReader para ler o arquivo de entrada
            BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);

            // Abre um FileWriter para o arquivo de saída
            FileWriter arquivoEscrita = new FileWriter(nomeArquivoSaida);
            // Cria um BufferedWriter para escrever no arquivo de saída
            BufferedWriter escreverArquivo = new BufferedWriter(arquivoEscrita);

            String linha;

            // Lê o arquivo de entrada linha por linha
            while ((linha = lerArquivo.readLine()) != null) {
                // Substitui todas as ocorrências de "Java" por "Python" na linha
                linha = linha.replaceAll("Java", "Python");
                // Escreve a linha modificada no arquivo de saída
                escreverArquivo.write(linha);
                escreverArquivo.newLine(); // Adiciona uma nova linha após a linha modificada
            }

            // Fecha os leitores e escritores
            lerArquivo.close();
            arquivoLeitura.close();
            escreverArquivo.close();
            arquivoEscrita.close();

            System.out.println("Arquivo processado com sucesso. Resultado salvo em " + nomeArquivoSaida);
        } catch (IOException e) {
            // Captura exceções de E/S (IOException) e imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
