package br.edu.uniaeso.BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultarProdutosMariaDB {
    public static void main(String[] args) {
        // Configuração da conexão
        String url = "jdbc:mariadb://localhost:3306/mariadb";
        String usuario = "root";
        String senha = "SYSADM";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            if (conexao != null) {
                System.out.println("Conexão com o banco de dados MariaDB bem-sucedida!");

                // Criar uma instrução SQL para consultar todos os registros da tabela "produtos"
                String sql = "SELECT * FROM produtos";
                Statement statement = conexao.createStatement();

                // Executar a consulta
                ResultSet resultSet = statement.executeQuery(sql);

                // Exibir os resultados no console
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    double preco = resultSet.getDouble("preco");
                    int quantidade = resultSet.getInt("quantidade");

                    System.out.println("ID: " + id);
                    System.out.println("Nome: " + nome);
                    System.out.println("Preço: " + preco);
                    System.out.println("Quantidade: " + quantidade);
                    System.out.println("---------------------------");
                }

                // Fechar recursos
                resultSet.close();
                statement.close();
            } else {
                System.out.println("Falha na conexão com o banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
