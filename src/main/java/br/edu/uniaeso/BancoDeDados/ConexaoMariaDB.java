package br.edu.uniaeso.BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMariaDB {
    public static void main(String[] args) {
        // Configuração da conexão
        String url = "jdbc:mariadb://localhost:3306/mariadb";
        String usuario = "root";
        String senha = "SYSADM";

        try {
            // Estabelece a conexão com o banco de dados
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            // Se a conexão for bem-sucedida, exibe uma mensagem de confirmação
            if (conexao != null) {
                System.out.println("Conexão com o banco de dados MariaDB bem-sucedida!");
                conexao.close(); // Fecha a conexão após o uso
            } else {
                System.out.println("Falha na conexão com o banco de dados.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
