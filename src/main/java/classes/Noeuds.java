package classes;

import static java.lang.Math.sqrt;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Noeuds extends Composants {
   
    public double abscisse;
    public double ordonnee;
    
    public int identificateur;
    private static int id = 0;
    
    public Color c;
    
    public Noeuds(){
        id++;
        this.identificateur = id;
    }
    
    public Noeuds(double abscisse, double ordonnee){
        id++ ;
        this.identificateur = id;
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }
    
    public double getAbscisse() {
        return abscisse;
    }
    public double getOrdonnee() {
        return ordonnee;
    }

    
    @Override
    public String toString() {
        return ("Noeud numéro " + identificateur);
    } 
    @Override
    public void construire(GraphicsContext context){
        //on ne créé jamais de Noeuds("tout court"), donc inutile de les construire
    }
    @Override
    public void changerCouleur(Color c){
        this.c = c;
    }
    @Override
    public double distance(Point p){
        return sqrt((this.getAbscisse()-p.getPx())*(this.getAbscisse()-p.getPx())+(this.getOrdonnee()-p.getPy())*(this.getOrdonnee()-p.getPy()));
    }
}

