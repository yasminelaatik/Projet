package classes;

import static java.lang.Math.sqrt;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class NoeudAppuiDouble extends NoeudAppui {
    
    public NoeudAppuiDouble(double abscisse, double ordonnee) {
        super(abscisse, ordonnee);
        this.c = Color.BLUE;
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
