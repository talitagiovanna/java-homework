package br.edu.uniaeso.ArquivosBinario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializarDeserializarProdutos {
    public static void main(String[] args) {
        // Nome do arquivo onde a lista de produtos será serializada
        String nomeArquivo = "produtos.dat";

        try {
            // Cria uma lista de produtos e adiciona produtos a ela
            List<Produto> listaProdutos = new ArrayList<>();
            listaProdutos.add(new Produto("Produto1", 10.99));
            listaProdutos.add(new Produto("Produto2", 19.99));
            listaProdutos.add(new Produto("Produto3", 7.49));

            // Cria um FileOutputStream para escrever no arquivo binário
            FileOutputStream arquivoSaida = new FileOutputStream(nomeArquivo);
            
            // Cria um ObjectOutputStream para serializar a lista de produtos
            ObjectOutputStream objetoSaida = new ObjectOutputStream(arquivoSaida);

            // Serializa a lista e escreve no arquivo
            objetoSaida.writeObject(listaProdutos);

            // Fecha o ObjectOutputStream e o FileOutputStream
            objetoSaida.close();
            arquivoSaida.close();

            System.out.println("Lista de produtos serializada e salva em " + nomeArquivo);

            // Cria um FileInputStream para ler o arquivo binário
            FileInputStream arquivoEntrada = new FileInputStream(nomeArquivo);
            
            // Cria um ObjectInputStream para desserializar a lista de produtos
            ObjectInputStream objetoEntrada = new ObjectInputStream(arquivoEntrada);

            // Desserializa a lista de produtos
            List<Produto> produtosDesserializados = (List<Produto>) objetoEntrada.readObject();

            // Fecha o ObjectInputStream e o FileInputStream
            objetoEntrada.close();
            arquivoEntrada.close();

            System.out.println("Produtos Desserializados:");
            for (Produto produto : produtosDesserializados) {
                System.out.println(produto);
            }
        } catch (IOException | ClassNotFoundException e) {
            // Captura exceções de E/S (IOException), exceções de classe não encontrada (ClassNotFoundException)
            // e imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao serializar/desserializar a lista de produtos: " + e.getMessage());
        }
    }
}
