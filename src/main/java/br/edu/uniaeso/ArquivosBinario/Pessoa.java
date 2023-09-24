package br.edu.uniaeso.ArquivosBinario;

import java.io.*;

// Classe Pessoa deve implementar a interface Serializable
class Pessoa implements Serializable {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade;
    }
}