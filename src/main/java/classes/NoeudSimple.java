package classes;

import static java.lang.Math.sqrt;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class NoeudSimple extends Noeuds {
    
    public NoeudSimple(double abscisse, double ordonnee){
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
        this.c = Color.BLUE;
    }
    
    @Override
    public void construire(GraphicsContext context){
        context.setFill(this.c);
        context.fillOval(this.getAbscisse()-3.5, this.getOrdonnee()-3.5, 7, 7);
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
