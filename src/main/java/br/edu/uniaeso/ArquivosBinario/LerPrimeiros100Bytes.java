package br.edu.uniaeso.ArquivosBinario;

import java.io.*;

public class LerPrimeiros100Bytes {
    public static void main(String[] args) {
        String nomeArquivo = "arquivo.bin";

        try {
            // Cria um FileInputStream para ler o arquivo binário
            FileInputStream arquivoEntrada = new FileInputStream(nomeArquivo);

            // Cria um buffer de bytes para armazenar os primeiros 100 bytes
            byte[] buffer = new byte[100];

            // Lê os primeiros 100 bytes do arquivo
            int bytesRead = arquivoEntrada.read(buffer, 0, 100);

            // Fecha o FileInputStream
            arquivoEntrada.close();

            if (bytesRead > 0) {
                // Converte os bytes lidos em uma string e exibe no console
                String dados = new String(buffer, 0, bytesRead, "UTF-8");
                System.out.println("Primeiros 100 bytes do arquivo:");
                System.out.println(dados);
            } else {
                System.out.println("O arquivo está vazio ou não contém 100 bytes.");
            }
        } catch (IOException e) {
            // Captura exceções de E/S (IOException) e imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
