package br.edu.uniaeso.BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirClienteMariaDB {
    public static void main(String[] args) {
        // Configuração da conexão
        String url = "jdbc:mariadb://localhost:3306/mariadb";
        String usuario = "root";
        String senha = "SYSADM";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            if (conexao != null) {
                System.out.println("Conexão com o banco de dados MariaDB bem-sucedida!");

                // Solicitar o ID do cliente a ser excluído
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o ID do cliente a ser excluído: ");
                int idCliente = Integer.parseInt(scanner.nextLine());

                // Excluir o cliente da tabela "clientes"
                String excluirCliente = "DELETE FROM clientes WHERE id = ?";
                PreparedStatement excluirClienteStatement = conexao.prepareStatement(excluirCliente);
                excluirClienteStatement.setInt(1, idCliente);

                int linhasAfetadas = excluirClienteStatement.executeUpdate();

                if (linhasAfetadas > 0) {
                    System.out.println("Cliente excluído com sucesso!");
                } else {
                    System.out.println("Falha ao excluir o cliente. Verifique o ID do cliente.");
                }

                // Fechar recursos
                excluirClienteStatement.close();
                scanner.close();
            } else {
                System.out.println("Falha na conexão com o banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
