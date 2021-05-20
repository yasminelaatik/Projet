package classes;

public class NoeudAppui extends Noeuds {
    
    public NoeudAppui(TriangleTerrain TT, int j, double alpha) {
        int i = j%3 ;
        SegmentTerrain ST = new SegmentTerrain(TT, i) ;
        this.abscisse = alpha*ST.début.px + (1-alpha)*ST.fin.px ;
        this.ordonnee = alpha*ST.début.py + (1-alpha)*ST.fin.py ;
    }   
    
    public NoeudAppui(SegmentTerrain ST, double alpha) {
        this.abscisse = alpha*ST.début.px + (1-alpha)*ST.fin.px ;
        this.ordonnee = alpha*ST.début.py + (1-alpha)*ST.fin.py ;
    }   
    
    public NoeudAppui(double abscisse, double ordonnee){
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }
}
