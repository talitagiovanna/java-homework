package br.edu.uniaeso.ArquivoTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContarPalavraJava {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";
        String palavraAlvo = "Java";
        int contador = 0;

        try {
            // Abre um FileReader para o arquivo especificado
            FileReader arquivoLeitura = new FileReader(nomeArquivo);
            // Cria um BufferedReader para ler o arquivo
            BufferedReader lerArquivo = new BufferedReader(arquivoLeitura);

            String linha;

            // Lê o arquivo linha por linha
            while ((linha = lerArquivo.readLine()) != null) {
                // Divide a linha em palavras usando espaços como delimitadores
                String[] palavras = linha.split(" ");

                // Itera sobre as palavras e verifica se alguma delas é "Java"
                for (String palavra : palavras) {
                    if (palavra.equals(palavraAlvo)) {
                        contador++;
                    }
                }
            }

            // Fecha o BufferedReader e o FileReader
            lerArquivo.close();
            arquivoLeitura.close();

            System.out.println("A palavra '" + palavraAlvo + "' aparece " + contador + " vezes no arquivo.");
        } catch (IOException e) {
            // Captura exceções de E/S (IOException) e imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
