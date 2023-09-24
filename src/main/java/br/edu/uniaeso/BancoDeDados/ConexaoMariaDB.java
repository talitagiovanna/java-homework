package br.edu.uniaeso.BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMariaDB {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:192.168.80.125/", "root", "qwerty@123")) {
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("SELECT 'Hello World!'")) {
                    rs.first();
                    System.out.println(rs.getString(0));
                }
            }
        }
    }
}
