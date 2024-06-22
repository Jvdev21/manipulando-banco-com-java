package br.com.Models;

public class Classe {

   private  int cod_classe;
   private  String Dificuldade;

    public Classe(int codClasse, String dificuldade) {
    }

    public int getCod_classe() {
        return cod_classe;
    }

    public void setCod_classe(int cod_classe) {
        this.cod_classe = cod_classe;
    }

    public String getDificuldade() {
        return Dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        Dificuldade = dificuldade;
    }
}
