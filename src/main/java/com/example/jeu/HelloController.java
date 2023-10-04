package com.example.jeu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        //création du paquet de carte
        Paquet paquet = new Paquet();
        //melange
        paquet.melanger();
        //Carte
        Carte c1;
        c1 = paquet.piocherCarte();
        welcomeText.setText(c1.couleur + " " + c1.number);
    }
}