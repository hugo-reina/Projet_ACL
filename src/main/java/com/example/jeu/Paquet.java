package com.example.jeu;

import java.util.ArrayList;
import java.util.Random;

public class Paquet {

    private ArrayList<Carte> paquet;

    public Paquet() {
        this.paquet = new ArrayList<>();
        String[] couleurs = {"pique", "coeur", "trefle", "carreau"};
        String[] numero = {"7", "8", "9", "10", "V", "D", "K", "A"};

        for (String couleur : couleurs) {
            for (String valeur : numero) {
                paquet.add(new Carte(valeur,couleur));
            }
        }
    }
    public ArrayList<Carte> getCartes() {
        return paquet;
    }

    // Méthode pour mélanger le jeu de cartes

    public ArrayList<Carte> melanger(){
        Random random = new Random();

        // commence à la fin de la liste
        for (int i = paquet.size() - 1; i >= 1; i--)
        {
            // obtient un index aléatoire `j` tel que `0 <= j <= i`
            int j = random.nextInt(i + 1);

            // échange l'élément à la ième position dans la liste avec l'élément à
            // index `j` généré aléatoirement
            Carte carte = paquet.get(i);
            paquet.set(i, paquet.get(j));
            paquet.set(j, carte);
        }
        return paquet;
    }

    public int getNumber(Carte carte){
        int number = 0;
        switch (carte.getNumber()){
            case "A":
                number = 11;
                break;
            case "V":
                number = 2;
                break;
            case "D":
                number = 3;
                break;
            case "K":
                number = 4;
                break;
            case "10":
                number = 10;
                break;
        }
        return number;
    }


    // Méthode pour piocher une carte du dessus du paquet
    public Carte piocherCarte(){
        if (paquet.isEmpty()) {
            System.out.println("Le paquet est vide. Impossible de piocher une carte.");
            return null; // Ou générer une exception si nécessaire
        }
        Random rand = new Random();
        int indexCartePiochee = rand.nextInt(paquet.size());
        Carte cartePiochee = paquet.remove(indexCartePiochee);
        return cartePiochee;
    }



}
