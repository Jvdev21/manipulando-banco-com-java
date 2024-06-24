package br.com.Models;

import java.sql.Date;

public class Login {
    private final String idLogin;
    private final String email;
    private final String senha;
    private final String nome;
    private final Date dataNasc;

    public Login(String idLogin, String email, String senha, String nome, Date dataNasc) {
        this.idLogin = idLogin;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    // Getters
    public String getIdLogin() {
        return idLogin;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }
}
