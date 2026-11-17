package com.example;

public class Jogo {
    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();
 
    public Jogo() {
        monte.embaralhar();
    }
 
    public Carta distribuiCartaParaJogador(Jogador j) {
        if (j.parou()) {
            return null;
        }
        Carta carta = monte.virar();
        j.receberCarta(carta);
        return carta;
    }
 
    private boolean estourou(Jogador j) {
        return j.getPontos() > 21;
    }
 
    public boolean acabou() {
        return estourou(jogador)
            || estourou(computador)
            || (jogador.parou() && computador.parou());
    }
 
    public String resultado() {
        if (estourou(jogador) && estourou(computador)) return "Empate";
        if (estourou(jogador)) return "Você perdeu";
        if (estourou(computador)) return "Você ganhou!";
 
        int comparacao = Integer.compare(jogador.getPontos(), computador.getPontos());
        if (comparacao > 0) return "Você ganhou!";
        if (comparacao < 0) return "Você perdeu";
        return "Empate";
    }
 
    public Computador getComputador() {
        return computador;
    }
 
    public Jogador getJogador() {
        return jogador;
    }
}
