package br.edu.uniaeso.ArquivoTexto;

import java.io.*;

public class ConcatenarArquivosTexto {
    public static void main(String[] args) {
        String nomeArquivo1 = "arquivo1.txt";
        String nomeArquivo2 = "arquivo2.txt";
        String nomeArquivoConcatenado = "arquivo_concatenado.txt";

        try {
            // Cria o primeiro arquivo ("arquivo1.txt") e escreve algum conteúdo
            FileWriter arquivoEscrita1 = new FileWriter(nomeArquivo1);
            BufferedWriter gravarArquivo1 = new BufferedWriter(arquivoEscrita1);
            gravarArquivo1.write("Aulinha de Java é bom,");
            gravarArquivo1.close();

            // Cria o segundo arquivo ("arquivo2.txt") e escreve algum conteúdo
            FileWriter arquivoEscrita2 = new FileWriter(nomeArquivo2);
            BufferedWriter gravarArquivo2 = new BufferedWriter(arquivoEscrita2);
            gravarArquivo2.write("só falta aprender direito.");
            gravarArquivo2.close();

            // Abre os arquivos de leitura
            BufferedReader leituraArquivo1 = new BufferedReader(new FileReader(nomeArquivo1));
            BufferedReader leituraArquivo2 = new BufferedReader(new FileReader(nomeArquivo2));

            // Cria o arquivo de saída ("arquivo_concatenado.txt")
            FileWriter arquivoConcatenado = new FileWriter(nomeArquivoConcatenado);
            BufferedWriter gravarArquivoConcatenado = new BufferedWriter(arquivoConcatenado);

            String linha;

            // Lê e escreve o conteúdo do primeiro arquivo no arquivo concatenado
            while ((linha = leituraArquivo1.readLine()) != null) {
                gravarArquivoConcatenado.write(linha);
                gravarArquivoConcatenado.newLine(); // Adiciona uma nova linha
            }

            // Lê e escreve o conteúdo do segundo arquivo no arquivo concatenado
            while ((linha = leituraArquivo2.readLine()) != null) {
                gravarArquivoConcatenado.write(linha);
                gravarArquivoConcatenado.newLine(); // Adiciona uma nova linha
            }

            // Fecha os arquivos
            leituraArquivo1.close();
            leituraArquivo2.close();
            gravarArquivoConcatenado.close();

            System.out.println("Arquivos concatenados com sucesso. Resultado salvo em " + nomeArquivoConcatenado);
        } catch (IOException e) {
            // Captura exceções de E/S (IOException) e imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao criar ou concatenar os arquivos: " + e.getMessage());
        }
    }
}
