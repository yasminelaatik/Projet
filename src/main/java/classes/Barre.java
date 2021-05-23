package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Barre extends Composants {
    public int identificateur; 
    public Noeuds N1;
    public Noeuds N2;
    public TypeBarre TB ;
    public int idT;
    
    public Color c;
    
    private static int idB=0;

    public Barre(Noeuds N1, Noeuds N2, TypeBarre TB){
        idB++;
        this.identificateur = idB;
        this.N1 = N1;
        this.N2 = N2;
        this.TB = TB;
        this.idT = Treillis.identificateur;
    }
    
    public Barre(Noeuds N1, Noeuds N2){
        idB++;
        this.identificateur = idB;
        this.N1 = N1;
        this.N2 = N2;
        this.idT = Treillis.identificateur;
    }

    public int getIdentificateur() {
        return identificateur;
    }

    public void setIdentificateur(int identificateur) {
        this.identificateur = identificateur;
    }

    public Noeuds getNoeud1() {
        return N1;
    }

    public void setNoeud1(Noeuds noeud1) {
        this.N1 = noeud1;
    }

    public Noeuds getNoeud2() {
        return N2;
    }

    public void setNoeud2(Noeuds noeud2) {
        this.N2 = noeud2;
    }

    public TypeBarre getTB() {
        return TB;
    }

    public int getidTreillis() {
        return idT;
    }
    
    void setidTreillis(int idTreillis) {
        this.idT = idTreillis;
    }

    public void setTypeBarre(TypeBarre TB) {
        this.TB = TB;
    }

    @Override
    public String toString() {
        return "Barre{" + "identificateur=" + identificateur + ", noeud1=" + N1 + ", noeud2=" + N2 + ", typeBarre=" + TB + '}';
    }
    
    @Override
    public void construire(GraphicsContext context){
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
            Point p4 = new Point(x1 + up * (x2 - x1),
                    y1 + up * (y2 - y1));
            return p4.distance(p);
        }
    }
}
