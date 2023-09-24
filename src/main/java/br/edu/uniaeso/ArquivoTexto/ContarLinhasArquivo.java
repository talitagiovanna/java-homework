package br.edu.uniaeso.ArquivoTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContarLinhasArquivo {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";

        try {
            // Abre um FileReader para o arquivo especificado
            FileReader arquivoLeitura = new FileReader(nomeArquivo);
            // Cria um BufferedReader para ler o arquivo
            BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);

            int contadorLinhas = 0;
            String linha;

            // Lê o arquivo linha por linha e incrementa o contador
            while ((linha = lerArquivo.readLine()) != null) {
                contadorLinhas++;
            }

            // Fecha o BufferedReader e o FileReader
            lerArquivo.close();
            arquivoLeitura.close();

            System.out.println("O arquivo " + nomeArquivo + " contém " + contadorLinhas + " linhas.");
        } catch (IOException e) {
            // Captura exceções de E/S (IOException) e imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
