package br.com.exception;

import java.sql.*;

public class LoginCheck {


    private Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/QFK",
                    "postgres", "2004");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }


    public boolean loginExists(String idlogin) {
        String sql = "SELECT 1 FROM login WHERE idlogin = ?";


        try (Connection conexao = connect();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setString(1, idlogin);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Se o resultado da consulta não estiver vazio, o login existe
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar se o login existe", e);
        }

        // Se o resultado da consulta estiver vazio, o login não existe
        return false;
    }
}