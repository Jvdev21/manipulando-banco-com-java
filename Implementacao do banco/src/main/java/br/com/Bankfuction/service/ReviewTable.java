package br.com.Bankfuction.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewTable {

    public Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/QFK",
                    "postgres", "2004");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }

    public void getReviews() {
        try (Connection conexao = connect()) {
            if (conexao != null) {
                System.out.println("Conexão com o banco de dados estabelecida com sucesso.");

                String sql = "SELECT id, id_login, email, senha, nome, data_nasc FROM login";

                try (PreparedStatement pstmt = conexao.prepareStatement(sql);
                     ResultSet rs = pstmt.executeQuery(sql)) {

                    while (rs.next()) {
                        // Obtém os dados das colunas
                        int id = rs.getInt("id");
                        String idlogin = rs.getString("id_login");
                        String email = rs.getString("email");
                        String senha = rs.getString("senha");
                        String nome = rs.getString("nome");
                        java.sql.Date dataNasc = rs.getDate("data_nasc");

                        // Exibe os dados
                        System.out.println("ID: " + id);
                        System.out.println("ID Login: " + idlogin);
                        System.out.println("Email: " + email);
                        System.out.println("Senha: " + senha);
                        System.out.println("Nome: " + nome);
                        System.out.println("Data de Nascimento: " + dataNasc);
                        System.out.println("---------------------------");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar os registros", e);
        }
    }
}
