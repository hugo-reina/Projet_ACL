package com.example.jeu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController{
    @FXML
    private Label welcomeText;
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    public void onHelloButtonClick() {
        //création du paquet de carte
        Paquet paquet = new Paquet();
        //melange
        paquet.melanger();
        //Carte
        Carte c1;
        c1 = paquet.piocherCarte();
        welcomeText.setText(c1.couleur + " " + c1.number);
    }

    public void QuitterPartie(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void ScenePseudo(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/jeu/choix-pseudo.fxml"));
        root = fxmlLoader.load();
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}