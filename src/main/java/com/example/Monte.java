package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
 
public class Monte {
    private List<Carta> cartas = new ArrayList<>();
 
    public Monte() {
        for (Naipe naipe : Naipe.values()) {
            IntStream.rangeClosed(1, 13)
                     .forEach(numero -> cartas.add(new Carta(numero, naipe)));
        }
    }
 
    public void embaralhar() {
        Random sorteio = new Random();
        for (int i = cartas.size() - 1; i > 0; i--) {
            int j = sorteio.nextInt(i + 1);
            Carta temporaria = cartas.get(i);
            cartas.set(i, cartas.get(j));
            cartas.set(j, temporaria);
        }
    }
 
    public Carta virar() {
        return cartas.remove(0);
    }
}
