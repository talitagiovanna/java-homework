package br.edu.uniaeso.ArquivosBinario;

import java.io.*;

public class AtualizarContaBancaria {
    public static void main(String[] args) {
        // Nome do arquivo de onde o objeto será desserializado
        String nomeArquivo = "conta.dat";

        try {
            // Cria um FileInputStream para ler o arquivo binário
            FileInputStream arquivoEntrada = new FileInputStream(nomeArquivo);

            // Cria um ObjectInputStream para desserializar o objeto
            ObjectInputStream objetoEntrada = new ObjectInputStream(arquivoEntrada);

            // Desserializa o objeto
            ContaBancaria conta = (ContaBancaria) objetoEntrada.readObject();

            // Fecha o ObjectInputStream e o FileInputStream
            objetoEntrada.close();
            arquivoEntrada.close();

            System.out.println("Conta Bancária carregada:");
            System.out.println(conta);

            // Atualiza o saldo da conta (exemplo: deposita R$ 100)
            conta.depositar(100);

            // Cria um FileOutputStream para escrever no arquivo binário
            FileOutputStream arquivoSaida = new FileOutputStream(nomeArquivo);

            // Cria um ObjectOutputStream para serializar o objeto atualizado
            ObjectOutputStream objetoSaida = new ObjectOutputStream(arquivoSaida);

            // Serializa o objeto atualizado e escreve no arquivo
            objetoSaida.writeObject(conta);

            // Fecha o ObjectOutputStream e o FileOutputStream
            objetoSaida.close();
            arquivoSaida.close();

            System.out.println("Conta Bancária atualizada e salva em " + nomeArquivo);
        } catch (IOException | ClassNotFoundException e) {
            // Captura exceções de E/S (IOException), exceções de classe não encontrada (ClassNotFoundException)
            // e imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao carregar/atualizar a conta bancária: " + e.getMessage());
        }
    }
}