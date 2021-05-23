package classes;

import static java.lang.Math.sqrt;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Noeuds extends Composants {
    public int identificateur;
    private static int id = 0;
    public double abscisse;
    public double ordonnee;
    
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

    public int getIdentificateur() {
        return identificateur;
    }
    
    public double getAbscisse() {
        return abscisse;
    }
    
    public double getOrdonnee() {
        return ordonnee;
    }

    public void setIdentificateur(int identificateur) {
        this.identificateur = identificateur;
    }

    @Override
    public String toString() {
        return ("Noeud numéro " + identificateur);
    } 
    
    @Override
    public void construire(GraphicsContext context){
        context.setFill(this.c);
        context.fillOval(this.abscisse-2.5, this.ordonnee-2.5, 5, 5);
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

