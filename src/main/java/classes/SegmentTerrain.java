package classes;

import classes.Point;

public class SegmentTerrain { 
    protected Point début ;
    protected Point fin ;
    
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
    
    public SegmentTerrain (Noeuds N1, Noeuds N2) {
        Point P1 = new Point(N1.abscisse, N1.ordonnee); 
        Point P2 = new Point(N2.abscisse, N2.ordonnee); 
        this.début = P1;
        this.fin = P2;
        this.identificateur = id;
    }
}
