package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TriangleTerrain extends Composants {
    
    protected Point PT0;
    protected Point PT1;
    protected Point PT2;
    
    protected SegmentTerrain ST1;
    protected SegmentTerrain ST2;
    protected SegmentTerrain ST3;
    
    public int identificateur;
    private static int id = 0;
    
    public TriangleTerrain (Point PT0, Point PT1, Point PT2) {
        id++;
        this.identificateur = id;
        
        this.PT0 = PT0;
        this.PT1 = PT1;
        this.PT2 = PT2;
        this.ST1 = new SegmentTerrain(PT0, PT1);
        this.ST2 = new SegmentTerrain(PT1, PT2);
        this.ST3 = new SegmentTerrain(PT2, PT0);
    }
    
    public double min(double a, double b){
        if(a<=b){
            return a;
        }
        else{
            return b;
        }
    }
   
    @Override
    public void construire(GraphicsContext context){
        double[] abscisses = {this.PT0.px, this.PT1.px, this.PT2.px};
        double[] ordonnées = {this.PT0.py, this.PT1.py, this.PT2.py};
        context.setStroke(Color.LIMEGREEN);
        context.strokePolygon(abscisses, ordonnées, 3);
    }
    @Override
    public void changerCouleur(Color c){
        //la couleur du riangle terrain ne dépend du type de barre
    }
    @Override
    public double distance(Point p){
        double d1 = ST1.distance(p);
        double d2 = ST2.distance(p);
        double d3 = ST3.distance(p);
        return min(min(d1, d2), min(d2, d3));
    }
}
