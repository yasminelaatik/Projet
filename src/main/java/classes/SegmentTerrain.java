package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SegmentTerrain extends Composants { 
    protected Point début ;
    protected Point fin ;
    public Color c;
    
    public int identificateur;
    private static int id = 0;
    int idST;
    
    public SegmentTerrain (TriangleTerrain TT, int j) {
        id++;
        this.identificateur = id;
        int i = j%3 ;
        this.idST = TT.idT ;
        if (i==0) {
            this.début = TT.PT0 ;
            this.fin = TT.PT1 ;
        }
        if (i==1) {
            this.début = TT.PT1 ;
            this.fin = TT.PT2 ;
        }
        if (i==2) {
            this.début = TT.PT2 ;
            this.fin = TT.PT0 ;
        }
    }
    
    public SegmentTerrain(Noeuds N1, Noeuds N2) {
        id++;
        this.idST = id;
        Point P1 = new Point(N1.abscisse, N1.ordonnee); 
        Point P2 = new Point(N2.abscisse, N2.ordonnee); 
        this.début = P1;
        this.fin = P2;
        this.identificateur = id;
    }
    
    public SegmentTerrain(Point début, Point fin){
        id++;
        this.idST = id;
        this.début = début;
        this.fin = fin;
    }
    
    @Override
    public void construire(GraphicsContext context){
        context.setStroke(this.c);
        context.strokeLine(this.début.px, this.début.py, this.fin.px, this.fin.py);
    }
    
    @Override
    public void changerCouleur(Color c){
        this.c = c;
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
            Point p4 = new Point(x1 + up * (x2 - x1),
                    y1 + up * (y2 - y1));
            return p4.distance(p);
        }
    }
}
