/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnes;

import etu002057.annotation.Annotation.MonAnnotation;

/**
 *
 * @author mirlin
 */
public class Personne {
    
    String nom;
    int age;
    double poids;
    
    @MonAnnotation(url="/personne/afficher")
    public void afficherPersonne() {
        System.out.printf("on affiche personne");
    }
    
    @MonAnnotation(url="/personne/supprimer")
    public void supprimerPersonne() {
        System.out.println("Supprimer personne");
    }
}
