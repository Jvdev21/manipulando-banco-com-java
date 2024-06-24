package br.com.Bankfuction.service;

import java.sql.*;

public class ReviewTable {
    public static void visualizartable() {
        try (Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/QFK",
                "postgres", "2004")) {

            if (conexao != null) {
                System.out.println("Conexão com o banco de dados estabelecida com sucesso.");

                Statement stm = conexao.createStatement();

                String sql = "SELECT id, id_login, email, senha, nome, data_nasc FROM login";
                ResultSet resultSet = stm.executeQuery(sql);

                // Exibir os resultados:
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String idLogin = resultSet.getString("id_login");
                    String email = resultSet.getString("email");
                    String senha = resultSet.getString("senha");
                    String nome = resultSet.getString("nome");
                    java.sql.Date dataNasc = resultSet.getDate("data_nasc");

                    System.out.println("ID: " + id);
                    System.out.println("ID Login: " + idLogin);
                    System.out.println("Email: " + email);
                    System.out.println("Senha: " + senha);
                    System.out.println("Nome: " + nome);
                    System.out.println("Data de Nascimento: " + dataNasc);
                    System.out.println("----------------------------------");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao visualizar tabela Login", e);
        }
    }
}
