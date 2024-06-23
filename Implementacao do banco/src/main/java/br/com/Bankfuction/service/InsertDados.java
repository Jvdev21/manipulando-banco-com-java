package br.com.Bankfuction.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDados {

    public static void main(String[] args) {
        // Exemplo de uso da classe InsertDataExample
        try (Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/QFK",
                "postgres", "2004")) {


        } catch (SQLException e) {
            System.err.println("Erro na conexão com o banco de dados: " + e.getMessage());
        }
    }

    public void inserirDados(Connection conexao, String idLogin, String email, String senha, String nome, java.sql.Date dataNasc) {

        String sql = "INSERT INTO login (id_login, email, senha, nome, data_nasc) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, idLogin);
            pstmt.setString(2, email);
            pstmt.setString(3, senha);
            pstmt.setString(4, nome);
            pstmt.setDate(5, dataNasc);

            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Dados inseridos com sucesso!");
            } else {
                System.out.println("Nenhum dado foi inserido.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados", e);
        }
    }
}