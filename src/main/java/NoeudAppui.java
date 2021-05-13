public class NoeudAppui extends Noeuds {
    public double abscisse;
    public double ordonnee;
    
    public NoeudAppui(TriangleTerrain TT, int j, double alpha) {
        int i = j%3 ;
        SegmentTerrain ST = new SegmentTerrain(TT, i) ;
        this.abscisse = alpha*ST.début.px + (1-alpha)*ST.fin.px ;
        this.ordonnee = alpha*ST.début.py + (1-alpha)*ST.fin.py ;
    }     
}
