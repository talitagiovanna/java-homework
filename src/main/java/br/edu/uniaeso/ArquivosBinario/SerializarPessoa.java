package br.edu.uniaeso.ArquivosBinario;

import java.io.*;

public class SerializarPessoa {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 30);

        // Nome do arquivo onde o objeto será serializado
        String nomeArquivo = "pessoa.dat";

        try {
            // Cria um FileOutputStream para escrever no arquivo binário
            FileOutputStream arquivoSaida = new FileOutputStream(nomeArquivo);
            
            // Cria um ObjectOutputStream para serializar o objeto
            ObjectOutputStream objetoSaida = new ObjectOutputStream(arquivoSaida);

            // Serializa o objeto e escreve no arquivo
            objetoSaida.writeObject(pessoa);

            // Fecha o ObjectOutputStream e o FileOutputStream
            objetoSaida.close();
            arquivoSaida.close();

            System.out.println("Objeto Pessoa serializado e salvo em " + nomeArquivo);
        } catch (IOException e) {
            // Captura exceções de E/S (IOException) e imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao serializar o objeto: " + e.getMessage());
        }
    }
}