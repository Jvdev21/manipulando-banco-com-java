package br.com.Bankfuction.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveLogin {

    private final Connection connection;

    public RemoveLogin(Connection connection) {
        this.connection = connection;
    }

    public void removerLogin(String idLogin) {
        String sql = "DELETE FROM login WHERE id_login = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, idLogin);

            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Login removido com sucesso!");
            } else {
                System.out.println("Nenhum login foi removido.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover login", e);
        }
    }
}