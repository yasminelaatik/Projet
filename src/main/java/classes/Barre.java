package classes;

public class Barre {
    public int identificateur; 
    public Noeuds noeud1;
    public Noeuds noeud2;
    public TypeBarre TB ;
    public int idT;
    
    private static int idB=0;

    public Barre(Noeuds noeud1, Noeuds noeud2, TypeBarre TB){
        idB++;
        this.identificateur = idB;
        this.noeud1 = noeud1;
        this.noeud2 = noeud2;
        this.TB = TB;
        this.idT = Treillis.identificateur;
    }

    public int getIdentificateur() {
        return identificateur;
    }

    public void setIdentificateur(int identificateur) {
        this.identificateur = identificateur;
    }

    public Noeuds getNoeud1() {
        return noeud1;
    }

    public void setNoeud1(Noeuds noeud1) {
        this.noeud1 = noeud1;
    }

    public Noeuds getNoeud2() {
        return noeud2;
    }

    public void setNoeud2(Noeuds noeud2) {
        this.noeud2 = noeud2;
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
        return "Barre{" + "identificateur=" + identificateur + ", noeud1=" + noeud1 + ", noeud2=" + noeud2 + ", typeBarre=" + TB + '}';
    }

}
