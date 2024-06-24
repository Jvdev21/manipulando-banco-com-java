package br.com.Models;

public class Classe {

    private String cod_classe;
    private  String Dificuldade;

    public Classe(String cod_classe, String dificuldade) {
        this.cod_classe = cod_classe;
        Dificuldade = dificuldade;
    }

    public String getCod_classe() {
        return cod_classe;
    }

    public void setCod_classe(String cod_classe) {
        this.cod_classe = cod_classe;
    }

    public String getDificuldade() {
        return Dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        Dificuldade = dificuldade;
    }
}