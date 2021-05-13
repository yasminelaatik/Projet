public class NoeudSimple extends Noeuds {
    public double abscisse;
    public double ordonnee;
    
    public NoeudSimple (double abscisse, double ordonnee){
        if ((abscisse<Terrain.xmin)||(abscisse>Terrain.xmax)||(ordonnee<Terrain.ymin)||(ordonnee>Terrain.ymax)) {
            throw new Error("Vous ne pouvez pas construire de points ici") ;
        }
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }
    
    /*public static void main (String args[]) {
        NoeudSimple NS1 = new NoeudSimple(3, 8) ;
        System.out.println(NS1.identificateur) ;
        System.out.println(NS1.abscisse) ;
        System.out.println(NS1.ordonnee) ;
        NoeudSimple NS2 = new NoeudSimple(-9, 4) ;
        System.out.println(NS2.identificateur) ;
        System.out.println(NS2.abscisse) ;
        System.out.println(NS2.ordonnee) ;
    }
    */
}
