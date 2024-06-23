package br.com.Bankfuction.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteLogin {

    public DeleteLogin(String idLogin) {
        String sql = "DELETE FROM login WHERE id_login = ?";

        try (Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/QFK", "postgres", "2004");
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setString(1, idLogin);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Registro com id_login " + idLogin + " deletado com sucesso.");
            } else {
                System.out.println("Nenhum registro encontrado com o id_login " + idLogin + ".");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar o registro", e);
        }
    }
}
