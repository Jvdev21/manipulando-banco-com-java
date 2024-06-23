package br.com.Models;

import java.util.Date;

public class Login extends Classe {
    private String idlogin;
    private String email;
    private  String senha;
    private  String nome;
    private Date data_nasc;

    public Login(int codClasse, String dificuldade, String idlogin, String email, String senha, String nome, Date data_nasc) {
        super(codClasse, dificuldade);
        this.idlogin = idlogin;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.data_nasc = data_nasc;
    }

    public String getIdlogin() {
        return idlogin;
    }

    public void setIdlogin(String idlogin) {
        this.idlogin = idlogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public java.sql.Date getData_nasc() {
        return (java.sql.Date) data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }
}