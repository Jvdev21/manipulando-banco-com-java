package br.com.Models;

public class Players extends Classe {
    private  int cod_player;
    private int cod_classe;
    private String login;

    public Players(int codClasse, String dificuldade,String login, int cod_player) {
        super(codClasse, dificuldade);
        this.login =login;
        this.cod_player =cod_player;
    }

    public int getCod_player() {
        return cod_player;
    }

    public void setCod_player(int cod_player) {
        this.cod_player = cod_player;
    }

    public int getCod_classe() {
        return cod_classe;
    }

    public void setCod_classe(int cod_classe) {
        this.cod_classe = cod_classe;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
