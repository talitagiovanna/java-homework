package br.edu.uniaeso.ArquivosBinario;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializarPessoa {
    public static void main(String[] args) {
        // Nome do arquivo de onde o objeto será desserializado
        String nomeArquivo = "pessoa.dat";

        try {
            // Cria um FileInputStream para ler o arquivo binário
            FileInputStream arquivoEntrada = new FileInputStream(nomeArquivo);
            
            // Cria um ObjectInputStream para desserializar o objeto
            ObjectInputStream objetoEntrada = new ObjectInputStream(arquivoEntrada);

            // Desserializa o objeto
            Pessoa pessoa = (Pessoa) objetoEntrada.readObject();

            // Fecha o ObjectInputStream e o FileInputStream
            objetoEntrada.close();
            arquivoEntrada.close();

            // Exibe os detalhes da pessoa no console
            System.out.println("Detalhes da Pessoa:");
            System.out.println(pessoa);
        } catch (IOException | ClassNotFoundException e) {
            // Captura exceções de E/S (IOException) e exceções de classe não encontrada (ClassNotFoundException)
            // e imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao desserializar o objeto: " + e.getMessage());
        }
    }
}
