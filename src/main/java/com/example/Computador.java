package com.example;

public class Computador extends Jogador {
    private static final int LIMITE = 16;
 
    @Override
    public boolean parou() {
        return getPontos() > LIMITE || super.parou();
    }
}