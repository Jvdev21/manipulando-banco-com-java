package br.com.Bankfuction.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsertDados {

    public void inserirDados(Connection conexao, String idLogin, String email, String senha, String nome, String dataNasc) {
        String sql = "INSERT INTO login (id_login, email, senha, nome, data_nasc) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, idLogin);
            pstmt.setString(2, email);
            pstmt.setString(3, senha);
            pstmt.setString(4, nome);
            java.sql.Date dataSql = converterStringParaSqlDate(dataNasc);
            pstmt.setDate(5, dataSql);

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

    // Método para converter String (no formato "yyyy-MM-dd") para java.sql.Date
    private java.sql.Date converterStringParaSqlDate(String dataStr) {
        try {
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dataUtil = formatador.parse(dataStr);
            return new java.sql.Date(dataUtil.getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de data inválido. Use o formato 'yyyy-MM-dd'.", e);
        }
    }
}
