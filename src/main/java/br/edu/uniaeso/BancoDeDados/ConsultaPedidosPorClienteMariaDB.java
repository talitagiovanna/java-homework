package br.edu.uniaeso.BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConsultaPedidosPorClienteMariaDB {
    public static void main(String[] args) {
        // Configuração da conexão
        String url = "jdbc:mariadb://localhost:3306/mariadb";
        String usuario = "root";
        String senha = "SYSADM";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            if (conexao != null) {
                System.out.println("Conexão com o banco de dados MariaDB bem-sucedida!");

                // Solicitar o ID do cliente para consulta
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o ID do cliente para consultar os pedidos: ");
                int idCliente = Integer.parseInt(scanner.nextLine());

                // Consulta SQL para recuperar os pedidos do cliente
                String consultaPedidos = "SELECT * FROM pedidos WHERE cliente_id = ?";
                PreparedStatement consultaPedidosStatement = conexao.prepareStatement(consultaPedidos);
                consultaPedidosStatement.setInt(1, idCliente);

                // Executar a consulta e exibir os resultados
                ResultSet resultado = consultaPedidosStatement.executeQuery();

                System.out.println("Pedidos do Cliente ID " + idCliente + ":");
                while (resultado.next()) {
                    int idPedido = resultado.getInt("id");
                    String dataPedido = resultado.getString("data_pedido");
                    double valorTotal = resultado.getDouble("valor_total");
                    String statusPedido = resultado.getString("status_pedido");

                    System.out.println("ID Pedido: " + idPedido);
                    System.out.println("Data do Pedido: " + dataPedido);
                    System.out.println("Valor Total: " + valorTotal);
                    System.out.println("Status do Pedido: " + statusPedido);
                    System.out.println("------------------------");
                }

                // Fechar recursos
                consultaPedidosStatement.close();
                scanner.close();
            } else {
                System.out.println("Falha na conexão com o banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
