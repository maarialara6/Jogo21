package com.example;

public class Jogo {
    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();

    public Jogo() {
        monte.embaralhar();
    }

    public Carta distribuiCartaParaJogador(Jogador j) {
        if (j.parou()) return null;
        Carta carta = monte.virar();
        j.receberCarta(carta);
        return carta;
    }

    public boolean acabou() {
        if (jogador.getPontos() > 21 || computador.getPontos() > 21) return true;
        return jogador.parou() && computador.parou();
    }

    public String resultado() {
        int jp = jogador.getPontos();
        int cp = computador.getPontos();

        if (jp > 21 && cp > 21) return "Empate";
        if (jp > 21) return "Você perdeu";
        if (cp > 21) return "Você ganhou!";
        if (jp > cp) return "Você ganhou!";
        if (jp < cp) return "Você perdeu";
        return "Empate";
    }

    public Computador getComputador() {
        return computador;
    }

    public Jogador getJogador() {
        return jogador;
    }
}
