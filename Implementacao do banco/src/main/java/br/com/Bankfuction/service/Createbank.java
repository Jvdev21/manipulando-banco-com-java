package br.com.Bankfuction.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Createbank {
    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/QFK",
                "postgres", "2004")) {

            if (conexao != null) {
                System.out.println("Conexão com o banco de dados estabelecida com sucesso.");

                Statement stm = conexao.createStatement();

                // Criação da tabela Login no esquema QFK
                String sql = "CREATE TABLE IF NOT EXISTS login (" +
                        "id SERIAL PRIMARY KEY," +
                        "id_login VARCHAR(100) NOT NULL," +
                        "email VARCHAR(100) NOT NULL," +
                        "senha VARCHAR(100) NOT NULL," +
                        "nome VARCHAR(100) NOT NULL," +
                        "data_nasc DATE NOT NULL" +
                        ")";
                stm.executeUpdate(sql);
                System.out.println("Tabela Login criada com sucesso.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar tabela Login", e);
        }
    }
}
