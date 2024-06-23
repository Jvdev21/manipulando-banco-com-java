package br.com.Models;

public class Perguntas extends Classe {
    private  int cod_perguntas;
    private  String perguntas;
    private String respotas;

    public Perguntas(int codClasse, String dificuldade,int cod_perguntas,String perguntas,String respotas) {
        super(codClasse, dificuldade);
        this.cod_perguntas = cod_perguntas;
        this.perguntas = perguntas;
        this.respotas = respotas;
    }

    public int getCod_perguntas() {
        return cod_perguntas;
    }

    public void setCod_perguntas(int cod_perguntas) {
        this.cod_perguntas = cod_perguntas;
    }

    public String getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(String perguntas) {
        this.perguntas = perguntas;
    }

    public String getRespotas() {
        return respotas;
    }

    public void setRespotas(String respotas) {
        this.respotas = respotas;
    }
}
