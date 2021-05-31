package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SegmentTerrain extends Composants {
    
    private Point début ;
    private Point fin ;
    
    public int identificateur;
    private static int id = 0;
    
    public SegmentTerrain(Point début, Point fin){
        id++;
        this.identificateur = id;
        
        this.début = début;
        this.fin = fin;
    }
    
    @Override
    public void construire(GraphicsContext context){
        context.setStroke(Color.LIMEGREEN);
        context.strokeLine(this.début.px, this.début.py, this.fin.px, this.fin.py);
    }
    @Override
    public void changerCouleur(Color c){
        //la couleur du segmentTerrain est indépendante du type de la barre
    } 
    @Override 
    public double distance(Point p){
        double x1 = this.début.getPx();
        double y1 = this.début.getPy();
        double x2 = this.fin.getPx();
        double y2 = this.fin.getPy();
        double x3 = p.getPx();
        double y3 = p.getPy();
        double up = ((x3 - x1) * (x2 - x1) + (y3 - y1) * (y2 - y1)) / (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (up < 0) {
            return this.début.distance(p);
        } else if (up > 1) {
            return this.fin.distance(p);
        } else {
            Point p4 = new Point(x1 + up * (x2 - x1), y1 + up * (y2 - y1));
            return p4.distance(p);
        }
    }
}
