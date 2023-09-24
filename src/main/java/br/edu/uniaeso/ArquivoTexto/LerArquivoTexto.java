package br.edu.uniaeso.ArquivoTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivoTexto {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";

        try {
            // Abre um FileReader para o arquivo especificado
            FileReader arquivoLeitura = new FileReader(nomeArquivo);
            // Cria um BufferedReader para ler o arquivo
            BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);

            String linha;

            // Lê e exibe cada linha do arquivo até o final
            while ((linha = lerArquivo.readLine()) != null) {
                System.out.println(linha);
            }

            // Fecha o BufferedReader e o FileReader
            lerArquivo.close();
            arquivoLeitura.close();
        } catch (IOException e) {
            // Captura exceções de E/S (IOException) e imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
