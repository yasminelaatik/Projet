public class SegmentTerrain { 
    protected Point début ;
    protected Point fin ;
    int identificateur;
    
    public SegmentTerrain (TriangleTerrain TT, int j) {
        int i = j%3 ;
        this.identificateur = TT.idT ;
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
}
