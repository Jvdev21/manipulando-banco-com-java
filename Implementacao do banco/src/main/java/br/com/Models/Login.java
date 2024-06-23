package br.com.Models;

import java.sql.Date;

public class Login extends Classe {
    private String idlogin;
    private String email;
    private  String senha;
    private  String nome;
    private Date data_nasc;

    public Login(String codClasse, String dificuldade, String idlogin, String email, String senha, String nome, Date data_nasc) {
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

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = Date.valueOf(data_nasc);
    }
}