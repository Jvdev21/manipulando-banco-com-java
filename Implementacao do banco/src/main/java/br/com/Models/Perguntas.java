package br.com.Models;

public class Perguntas extends Classe {
    private int cod_perguntas;
    private String pergunta;
    private String resposta;

    public Perguntas(int codClasse, String dificuldade, int cod_perguntas, String pergunta, String resposta) {
        super(codClasse, dificuldade);
        this.cod_perguntas = cod_perguntas;
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public int getCod_perguntas() {
        return cod_perguntas;
    }

    public void setCod_perguntas(int cod_perguntas) {
        this.cod_perguntas = cod_perguntas;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
