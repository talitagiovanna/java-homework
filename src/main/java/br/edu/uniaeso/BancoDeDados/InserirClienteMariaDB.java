package br.edu.uniaeso.BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirClienteMariaDB {
    public static void main(String[] args) {
        // Configuração da conexão
        String url = "jdbc:mariadb://localhost:3306/mariadb"; 
        String usuario = "root"; 
        String senha = "SYSADM"; 

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            if (conexao != null) {
                System.out.println("Conexão com o banco de dados MariaDB bem-sucedida!");

                // Solicitar informações do novo cliente ao usuário
                Scanner scanner = new Scanner(System.in);

                System.out.print("Digite o nome do cliente: ");
                String nome = scanner.nextLine();

                System.out.print("Digite a idade do cliente: ");
                int idade = Integer.parseInt(scanner.nextLine());

                System.out.print("Digite o endereço do cliente: ");
                String endereco = scanner.nextLine();

                // Inserir os dados na tabela "clientes"
                String sql = "INSERT INTO clientes (nome, idade, endereco) VALUES (?, ?, ?)";
                PreparedStatement statement = conexao.prepareStatement(sql);
                statement.setString(1, nome);
                statement.setInt(2, idade);
                statement.setString(3, endereco);

                int linhasAfetadas = statement.executeUpdate();

                if (linhasAfetadas > 0) {
                    System.out.println("Cliente inserido com sucesso!");
                } else {
                    System.out.println("Falha ao inserir o cliente.");
                }

                // Fechar recursos
                statement.close();
                scanner.close();
            } else {
                System.out.println("Falha na conexão com o banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
