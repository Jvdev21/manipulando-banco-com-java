package br.com.Bankfuction.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewTable extends DeleteLogin {


    public Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/QFK",
                    "postgres", "2004");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }

    /

    public void getReviews() {

        try (Connection conexao = connect()) {

            if (conexao != null) {
                System.out.println("Banco ok");


                String sql = "SELECT * FROM review";


                try (PreparedStatement pstmt = conexao.prepareStatement(sql);
                     ResultSet rs = pstmt.executeQuery()) {


                    while (rs.next()) {
                        // Obtém os dados das colunas
                        int id = rs.getInt("id");
                        String idlogin = rs.getString("idlogin");
                        String email = rs.getString("email");
                        String senha = rs.getString("senha");
                        String nome = rs.getString("nome");
                        java.sql.Date dataNasc = rs.getDate("data_nasc");
                        int userId = rs.getInt("user_id");
                        int productId = rs.getInt("product_id");
                        int rating = rs.getInt("rating");
                        String reviewText = rs.getString("review_text");
                        java.sql.Timestamp createdAt = rs.getTimestamp("created_at");
                        java.sql.Timestamp updatedAt = rs.getTimestamp("updated_at");

                        // Exibe os dados
                        System.out.println("ID: " + id);
                        System.out.println("ID Login: " + idlogin);
                        System.out.println("Email: " + email);
                        System.out.println("Senha: " + senha);
                        System.out.println("Nome: " + nome);
                        System.out.println("Data de Nascimento: " + dataNasc);
                        System.out.println("User ID: " + userId);
                        System.out.println("Product ID: " + productId);
                        System.out.println("Rating: " + rating);
                        System.out.println("Review Text: " + reviewText);
                        System.out.println("Created At: " + createdAt);
                        System.out.println("Updated At: " + updatedAt);
                        System.out.println("---------------------------");
                    }
                }
            }
        } catch (SQLException e) {
            // Lança uma RuntimeException se ocorrer um erro de SQL
            throw new RuntimeException("Erro ao consultar os registros", e);
        }
    }
}
