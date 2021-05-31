package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Barre extends Composants {
    
    private Noeuds N1;
    private Noeuds N2;
    private int TB ;
    
    private int identificateur; 
    private static int id=0;
    
    private Color c;

    public Barre(Noeuds N1, Noeuds N2, int TB){
        id++;
        this.identificateur = id;
        this.N1 = N1;
        this.N2 = N2;
        this.TB = TB;
    }
    public Barre(Noeuds N1, Noeuds N2){
        id++;
        this.identificateur = id;
        this.N1 = N1;
        this.N2 = N2;
    }

    public void setIdentificateur(int identificateur) {
        this.identificateur = identificateur;
    }
    public void setTypeBarre(int TB) {
        this.TB = TB;
    }
    
    @Override
    public String toString() {
        return "Barre{" + "identificateur=" + identificateur + ", noeud1=" + N1 + ", noeud2=" + N2 + ", typeBarre=" + TB + '}';
    }
    @Override
    public void construire(GraphicsContext context){
        context.setStroke(this.c);
        context.strokeLine(this.N1.getAbscisse(), this.N1.getOrdonnee(), this.N2.getAbscisse(), this.N2.getOrdonnee());
    }
    @Override
    public void changerCouleur(Color c){
        this.c = c;
    }
    @Override 
    public double distance(Point p){
        double x1 = this.N1.getAbscisse();
        double y1 = this.N1.getOrdonnee();
        double x2 = this.N2.getAbscisse();
        double y2 = this.N2.getOrdonnee();
        double x3 = p.getPx();
        double y3 = p.getPy();
        double up = ((x3 - x1) * (x2 - x1) + (y3 - y1) * (y2 - y1)) / (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (up < 0) {
            return this.N1.distance(p);
        } else if (up > 1) {
            return this.N2.distance(p);
        } else {
            Point p4 = new Point(x1 + up * (x2 - x1), y1 + up * (y2 - y1));
            return p4.distance(p);
        }
    }
}
