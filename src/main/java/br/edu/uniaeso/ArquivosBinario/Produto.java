package br.edu.uniaeso.ArquivosBinario;

import java.io.*;

public class Produto implements Serializable {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + ", Preço: " + preco;
    }
}