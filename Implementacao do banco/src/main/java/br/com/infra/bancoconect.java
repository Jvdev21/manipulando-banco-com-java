package br.com.infra;

import java.sql.*;

public class bancoconect {
    // Método principal que é o ponto de entrada do programa
    public static void main(String[] args) {
        // Bloco try-with-resources para garantir que a conexão com o banco de dados seja fechada automaticamente
        try (Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/QFK",
                "postgres", "2004")) {
            // Verifica se a conexão foi estabelecida com sucesso
            if (conexao != null) {
                System.out.println("Banco ok");
                // Cria um objeto Statement para executar consultas SQL
                Statement stm = conexao.createStatement();


            }
        } catch (SQLException e) {
            // Lança uma RuntimeException se ocorrer um erro de SQL
            throw new RuntimeException(e);
        }
    }



}
