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
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private ImageView imageView; // Récupère l'ImageView depuis le fichier FXML
    @FXML
    private ImageView imageView2; // Récupère l'ImageView depuis le fichier FXML

    private static Paquet paquet;


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
        if (paquet == null) {
            // Créez le paquet si c'est la première utilisation ou s'il est vide
            paquet = new Paquet();
            paquet.melanger();
        }
        System.out.println(paquet.getCartes().size());
        //Carte
        try {
            Carte c1;
            Carte c2;
            c1 = paquet.piocherCarte();
            c2 = paquet.piocherCarte();
            Image image = new Image("file:src/main/cartes/" + c1.number + "_" + c1.couleur + ".png");
            Image image2 = new Image("file:src/main/cartes/" + c2.number + "_" + c2.couleur + ".png");
            imageView.setImage(image);
            imageView2.setImage(image2);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}