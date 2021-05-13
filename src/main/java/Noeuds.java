public class Noeuds {
    public int identificateur;
    private static int id = 0;
    
    public Noeuds (){
        id++ ;
        this.identificateur = id;
    }

    public int getIdentificateur() {
        return identificateur;
    }

    public void setIdentificateur(int identificateur) {
        this.identificateur = identificateur;
    }

    @Override
    public String toString() {
        return "Noeuds{identificateur=" + identificateur + '}';
    }
    
    /*public static void main (String args[]) {
        Noeuds N1 = new Noeuds();
        System.out.println(N1.identificateur) ;
        Noeuds N2 = new Noeuds();
        System.out.println(N2.identificateur) ;
        
        NoeudSimple NS3 = new NoeudSimple(3, 8) ;
        System.out.println(NS3.identificateur) ;
        
        NoeudAppui NA4 = new NoeudAppui(13, 75, 12);
        System.out.println(NA4.identificateur) ;
    }
    */
    
}
