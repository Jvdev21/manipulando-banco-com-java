package br.com.Bankfuction.service;

import br.com.Bankfuction.bancoconect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteLogin extends bancoconect {


    Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/QFK",
                    "postgres", "2004");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }

    public void deleteByIdLogin(String idlogin) {

        try (Connection conexao = connect()) {

            if (conexao != null) {
                System.out.println("Banco ok");

                String sql = "DELETE FROM review WHERE idlogin = ?";


                try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {

                    pstmt.setString(1, idlogin);

                    int rowsAffected = pstmt.executeUpdate();

                    // Verifica seta tudo funcionando
                    if (rowsAffected > 0) {
                        System.out.println("Registro deletado com sucesso.");
                    } else {
                        System.out.println("Nenhum registro encontrado com o idlogin fornecido.");
                    }
                }
            }
        } catch (SQLException e) {

            throw new RuntimeException("Erro ao deletar o registro", e);
        }
    }
}
