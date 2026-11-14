package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PrimaryController {

    private Jogo jogo = new Jogo();

    @FXML private Label pontosMesa;
    @FXML private Label pontosJogador;
    @FXML private Label resultado;
    @FXML private HBox mesaDoComputador;
    @FXML private HBox mesaDoJogador;
    @FXML private ImageView monte;

    @FXML
    public void initialize() {
        novoJogo();
    }

    @FXML
    public void novoJogo() {
        jogo = new Jogo();
        resultado.setText("");
        turno();
    }

    @FXML
    public void pedirCarta() {
        if (jogo.acabou()) return;
        turno();
    }

    @FXML
    public void parar() {
        if (jogo.acabou()) return;
        jogo.getJogador().parar();
        while (!jogo.acabou()) {
            turno();
        }
    }

    private void turno() {
        jogo.distribuiCartaParaJogador(jogo.getJogador());
        jogo.distribuiCartaParaJogador(jogo.getComputador());
        atualizarTela();

        if (jogo.acabou()) {
            resultado.setText(jogo.resultado());
        }
    }

    private void atualizarTela() {
        mesaDoComputador.getChildren().clear();
        mesaDoJogador.getChildren().clear();

        for (Carta c : jogo.getComputador().getCartas()) {
            mesaDoComputador.getChildren().add(criarImagemDaCarta(c));
        }
        for (Carta c : jogo.getJogador().getCartas()) {
            mesaDoJogador.getChildren().add(criarImagemDaCarta(c));
        }

        pontosMesa.setText("Mesa: " + jogo.getComputador().getPontos());
        pontosJogador.setText("Jogador: " + jogo.getJogador().getPontos());
    }

    private ImageView criarImagemDaCarta(Carta carta) {
        Image img = new Image(getClass().getResourceAsStream(carta.imagePath()));
        return new ImageView(img);
    }
}