package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TriangleTerrain extends Composants {
    
    public static int idT = 0;
    
    protected Point PT0;
    protected Point PT1;
    protected Point PT2;
    
    protected SegmentTerrain ST1;
    protected SegmentTerrain ST2;
    protected SegmentTerrain ST3;
    
    public Color c;
    
    public TriangleTerrain (Point PT0, Point PT1, Point PT2) {
        idT++;
        this.idT = idT;
        this.PT0 = PT0;
        this.PT1 = PT1;
        this.PT2 = PT2;
        SegmentTerrain ST1 = new SegmentTerrain(PT0, PT1);
        SegmentTerrain ST2 = new SegmentTerrain(PT1, PT2);
        SegmentTerrain ST3 = new SegmentTerrain(PT2, PT0);
        this.ST1 = ST1;
        this.ST2 = ST2;
        this.ST3 = ST3;
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
        double[] abscisses ={this.PT0.px, this.PT1.px, this.PT2.px};
        double[] ordonnées ={this.PT0.py, this.PT1.py, this.PT2.py};
        context.setStroke(this.c);
        context.strokePolygon(abscisses, ordonnées, 3);
    }
    
    @Override
    public void changerCouleur(Color c){
        this.c = c;
    }
    
    @Override
    public double distance(Point p){
        double d1 = ST1.distance(p);
        double d2 = ST2.distance(p);
        double d3 = ST3.distance(p);
        return min(min(d1, d2), min(d2, d3));
    }
}
