package br.edu.uniaeso.ArquivoTexto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscreverArquivoTexto {
    public static void main(String[] args) {
        // Define o nome do arquivo que será criado
        String nomeArquivo = "meuarquivo.txt";
        // Define a mensagem que será escrita no arquivo
        String mensagem = "Olá, estou aprendendo java!";

        try {
            // Abre um FileWriter para o arquivo especificado
            FileWriter arquivoEscrita = new FileWriter(nomeArquivo);
            // Cria um PrintWriter para escrever no arquivo
            PrintWriter gravarArquivo = new PrintWriter(arquivoEscrita);

            // Escreve a mensagem no arquivo
            gravarArquivo.println(mensagem);

            // Fecha o PrintWriter e o FileWriter para liberar recursos
            gravarArquivo.close();
            arquivoEscrita.close();

            // Imprime uma mensagem de sucesso no console
            System.out.println("Mensagem gravada com sucesso no arquivo " + nomeArquivo);
        } catch (IOException e) {
            // Captura exceções de E/S (IOException) e imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao gravar o arquivo: " + e.getMessage());
        }
    }
}
