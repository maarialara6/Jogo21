package com.example;

public class Carta {
    private int numero;
    private Naipe naipe;
 
    public Carta(int numero, Naipe naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }
 
    public String imagePath() {
        return String.format("classic-cards/%d%s.png", numero, naipe);
    }
 
    public int getNumero() {
        return numero;
    }
 
    public Naipe getNaipe() {
        return naipe;
    }
}
