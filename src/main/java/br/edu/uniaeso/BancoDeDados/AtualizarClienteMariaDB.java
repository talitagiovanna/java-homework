package br.edu.uniaeso.BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarClienteMariaDB {
    public static void main(String[] args) {
        // Configuração da conexão
        String url = "jdbc:mariadb://localhost:3306/mariadb";
        String usuario = "root";
        String senha = "SYSADM";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            if (conexao != null) {
                System.out.println("Conexão com o banco de dados MariaDB bem-sucedida!");

                // Solicitar o ID do cliente a ser atualizado
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o ID do cliente a ser atualizado: ");
                int idCliente = Integer.parseInt(scanner.nextLine());

                // Verificar se o cliente com o ID especificado existe
                String verificarExistencia = "SELECT * FROM clientes WHERE id = ?";
                PreparedStatement verificarExistenciaStatement = conexao.prepareStatement(verificarExistencia);
                verificarExistenciaStatement.setInt(1, idCliente);
                ResultSet resultado = verificarExistenciaStatement.executeQuery();

                if (resultado.next()) {
                    // Cliente encontrado, permitir atualização
                    System.out.println("Cliente encontrado. Você pode atualizar as informações.");

                    System.out.print("Digite o novo nome do cliente: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Digite a nova idade do cliente: ");
                    int novaIdade = Integer.parseInt(scanner.nextLine());

                    System.out.print("Digite o novo endereço do cliente: ");
                    String novoEndereco = scanner.nextLine();

                    // Atualizar os campos nome, idade e endereço do cliente
                    String atualizarCampos = "UPDATE clientes SET nome = ?, idade = ?, endereco = ? WHERE id = ?";
                    PreparedStatement atualizarCamposStatement = conexao.prepareStatement(atualizarCampos);
                    atualizarCamposStatement.setString(1, novoNome);
                    atualizarCamposStatement.setInt(2, novaIdade);
                    atualizarCamposStatement.setString(3, novoEndereco);
                    atualizarCamposStatement.setInt(4, idCliente);

                    int linhasAfetadas = atualizarCamposStatement.executeUpdate();

                    if (linhasAfetadas > 0) {
                        System.out.println("Informações do cliente atualizadas com sucesso!");
                    } else {
                        System.out.println("Falha ao atualizar as informações do cliente.");
                    }

                    // Fechar recursos
                    atualizarCamposStatement.close();
                } else {
                    System.out.println("Cliente com o ID especificado não encontrado.");
                }

                // Fechar recursos
                verificarExistenciaStatement.close();
                resultado.close();
                scanner.close();
            } else {
                System.out.println("Falha na conexão com o banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
