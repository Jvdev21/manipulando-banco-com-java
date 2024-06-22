package br.com.service;
import br.com.Models.Players;

public interface Playerexistente {
    Players salvar(Players players);
    void deletar(String id);
    Players buscar(String id);
    Players atualizar(String id, Players players);
    boolean existe(String id);
}