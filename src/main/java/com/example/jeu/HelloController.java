package com.example.jeu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController{
    @FXML
    private Label welcomeText;
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private ImageView imageView; // Récupère l'ImageView depuis le fichier FXML

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

    public void pioche(ActionEvent actionEvent) {
        //création du paquet de carte
        Paquet paquet = new Paquet();
        //melange
        paquet.melanger();

        //Carte
        Carte c1;
        Carte c2;
        c1 = paquet.piocherCarte();
        Image image = new Image("file:src/main/cartes/"+c1.number+"_"+c1.couleur+".png");
        System.out.println(image.getUrl());
        imageView.setImage(image);


        // Agrandir l'ImageView (par exemple, largeur = 400, hauteur = 300)


    }
}