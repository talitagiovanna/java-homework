package br.edu.uniaeso.ArquivosBinario;

import java.io.*;

public class CopiarArquivoBinario {
    public static void main(String[] args) {
        String arquivoOriginal = "arquivo_grande.bin";
        String arquivoCopia = "copia_arquivo_grande.bin";

        try {
            // Cria um FileInputStream para ler o arquivo original
            FileInputStream arquivoEntrada = new FileInputStream(arquivoOriginal);

            // Cria um FileOutputStream para escrever no arquivo de cópia
            FileOutputStream arquivoSaida = new FileOutputStream(arquivoCopia);

            // Cria um buffer de bytes para armazenar os dados lidos do arquivo original
            byte[] buffer = new byte[1024]; // Você pode ajustar o tamanho do buffer conforme necessário

            int bytesRead;
            // Enquanto houver dados para ler no arquivo original
            while ((bytesRead = arquivoEntrada.read(buffer)) != -1) {
                // Escreve os dados lidos no arquivo de cópia
                arquivoSaida.write(buffer, 0, bytesRead);
            }

            // Fecha os fluxos de entrada e saída
            arquivoEntrada.close();
            arquivoSaida.close();

            System.out.println("Arquivo copiado com sucesso.");
        } catch (IOException e) {
            // Captura exceções de E/S (IOException) e imprime uma mensagem de erro
            System.out.println("Ocorreu um erro durante a cópia do arquivo: " + e.getMessage());
        }
    }
}
