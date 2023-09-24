package br.edu.uniaeso.ArquivoTexto;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class AdicionarAoArquivoTexto {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";
        String mensagemAdicional = "Isso é uma adição!";

        try {
            // Abre um FileWriter no modo de anexação (append) para adicionar conteúdo ao arquivo
            FileWriter arquivoEscrita = new FileWriter(nomeArquivo, true);
            // Cria um BufferedWriter para escrever no arquivo
            BufferedWriter gravarArquivo = new BufferedWriter(arquivoEscrita);

            // Escreve a mensagem adicional no arquivo
            gravarArquivo.write(mensagemAdicional);
            gravarArquivo.newLine(); // Adiciona uma nova linha após a mensagem

            // Fecha o BufferedWriter e o FileWriter
            gravarArquivo.close();
            arquivoEscrita.close();

            System.out.println("Mensagem adicionada ao arquivo " + nomeArquivo + " com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao adicionar ao arquivo: " + e.getMessage());
        }
    }
}
