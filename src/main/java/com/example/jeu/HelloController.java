package com.example.jeu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController{
    public Label pts;
    public Label parties;
    public Button btn_pioche;
    public Button btn_suivant;
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private ImageView imageView; // Récupère l'ImageView depuis le fichier FXML
    @FXML
    private ImageView imageView2; // Récupère l'ImageView depuis le fichier FXML

    @FXML
    private TextField Saisie;

    private String Valide;
    public Label Nom;

    @FXML
    private Button ValidPseudo;

    int points;
    int total = 0;
    int nbPartie =0;


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

    private int CompterPoints(Carte c1, Carte c2){
        int number = 0;
            //number = paquet.getNumber(c1) + paquet.getNumber(c2);
            if(c1.getNumber().equals(c2.getNumber()) && (c1.getCouleur().equals(c2.getCouleur()))){
                number += 2*(paquet.getNumber(c1) + paquet.getNumber(c2));
            }else if (c1.getNumber().equals(c2.getNumber()) && (!c1.getCouleur().equals(c2.getCouleur()))){
                number -= paquet.getNumber(c1) + paquet.getNumber(c2);
            }else{
                number += paquet.getNumber(c1) + paquet.getNumber(c2);
            }
        return number;
    }
    public void pioche(ActionEvent actionEvent) {
        if (nbPartie == 5){
            btn_pioche.setVisible(false);
            btn_suivant.setVisible(true);
        }else {
            if (paquet == null) {
                // Créez le paquet si c'est la première utilisation ou s'il est vide
                paquet = new Paquet();
                paquet.melanger();
            }
            System.out.println(paquet.getCartes().size());
            //Carte
            try {
                nbPartie = nbPartie + 1;
                Carte c1;
                Carte c2;
                c1 = paquet.piocherCarte();
                c2 = paquet.piocherCarte();
                Image image = new Image("file:src/main/cartes/" + c1.number + "_" + c1.couleur + ".png");
                Image image2 = new Image("file:src/main/cartes/" + c2.number + "_" + c2.couleur + ".png");
                imageView.setImage(image);
                imageView2.setImage(image2);
                points = CompterPoints(c1, c2);
                total = total + points;
                pts.setText("Mon score " + total + " (+" + points + ")");
                parties.setText("Partie numéro " + nbPartie);
                //Nom.setText(Saisie.getText());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public void pageScore(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/jeu/page-classement.fxml"));
        root = fxmlLoader.load();
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void ConfigPseudo(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/jeu/ConfigPseudo.fxml"));
        root = fxmlLoader.load();
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void configPseudoAction(ActionEvent event) {
    }
}