package com.example;

import java.util.List;
 
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
        if (!jogo.acabou()) {
            turno();
        }
    }
 
    @FXML
    public void parar() {
        if (jogo.acabou()) {
            return;
        }
        jogo.getJogador().parar();
        do {
            turno();
        } while (!jogo.acabou());
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
        preencherMesa(mesaDoComputador, jogo.getComputador().getCartas());
        preencherMesa(mesaDoJogador, jogo.getJogador().getCartas());
 
        pontosMesa.setText("Mesa: " + jogo.getComputador().getPontos());
        pontosJogador.setText("Jogador: " + jogo.getJogador().getPontos());
    }
 
    private void preencherMesa(HBox mesa, List<Carta> cartas) {
        mesa.getChildren().clear();
        for (Carta carta : cartas) {
            mesa.getChildren().add(criarImagemDaCarta(carta));
        }
    }
 
    private ImageView criarImagemDaCarta(Carta carta) {
        Image imagem = new Image(getClass().getResourceAsStream(carta.imagePath()));
        return new ImageView(imagem);
    }
}