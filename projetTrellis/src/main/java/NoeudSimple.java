/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class NoeudSimple extends Noeuds {
    private double abscisse;
    private double ordonnee;
    
public NoeudSimple (double abscisse, double ordonnee, int identificateur){
    super(identificateur);
    this.abscisse = abscisse;
    this.ordonnee = ordonnee;
}
    
}
