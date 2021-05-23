package classes;

import static java.lang.Math.sqrt;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class NoeudAppui extends Noeuds {
    
    public NoeudAppui(TriangleTerrain TT, int j, double alpha) {
        int i = j%3 ;
        SegmentTerrain ST = new SegmentTerrain(TT, i) ;
        this.abscisse = alpha*ST.début.px + (1-alpha)*ST.fin.px ;
        this.ordonnee = alpha*ST.début.py + (1-alpha)*ST.fin.py ;
        this.c = Color.BLUE;
    }   
    
    public NoeudAppui(SegmentTerrain ST, double alpha) {
        this.abscisse = alpha*ST.début.px + (1-alpha)*ST.fin.px ;
        this.ordonnee = alpha*ST.début.py + (1-alpha)*ST.fin.py ;
        this.c = Color.BLUE;
    }   
    
    public NoeudAppui(double abscisse, double ordonnee){
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
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
