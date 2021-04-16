package com.mycompany.projettreillis;

public class NoeudSimple extends Noeud {
    private double abscisse;
    private double ordonnee;
    
public NoeudSimple (double abscisse, double ordonnee, int identificateur){
    super(identificateur);
    this.abscisse = abscisse;
    this.ordonnee = ordonnee;
}
    
}
