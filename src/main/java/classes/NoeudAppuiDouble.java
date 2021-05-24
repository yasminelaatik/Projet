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
        context.fillOval(this.abscisse-3.5, this.ordonnee-3.5, 7, 7);
        
        //pour que ça soit joli
        double[] doubles = {this.abscisse, this.abscisse-10, this.abscisse+10};
        double[] doubles1 = {this.ordonnee, this.ordonnee+15, this.ordonnee+15};
        context.setStroke(Color.BLACK);
        context.strokePolygon(doubles, doubles1, 3);
        
        context.setStroke(Color.BLUE);
        context.strokeLine(this.abscisse-12.5, this.ordonnee+15, this.abscisse+12.5, this.ordonnee+15);
        
        context.strokeLine(this.abscisse+12.5, this.ordonnee+15, this.abscisse+7.5, this.ordonnee+18);
        context.strokeLine(this.abscisse+7.5, this.ordonnee+15, this.abscisse+2.5, this.ordonnee+18);
        context.strokeLine(this.abscisse+2.5, this.ordonnee+15, this.abscisse-2.5, this.ordonnee+18);
        context.strokeLine(this.abscisse-2.5, this.ordonnee+15, this.abscisse-7.5, this.ordonnee+18);
        context.strokeLine(this.abscisse-7.5, this.ordonnee+15, this.abscisse-12.5, this.ordonnee+18);
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
