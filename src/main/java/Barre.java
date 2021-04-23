/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yasmine
 */
public class Barre {
    private int identificateur;
    private int noeud1;
    private int noeud2;
    private int typeBarre;
    
    private Treillis treillis;
    private Noeuds noeudUn;
    private Noeuds noeudDeux;
    
    public Barre(int identificateur,int noeud1, int noeud2, int typeBarre ){
        this.identificateur = identificateur;
        this.noeud1 = noeud1;
        this.noeud2 = noeud2;
        this.typeBarre = typeBarre;
    }

    
    public int getIdentificateur() {
        return identificateur;
    }

    public void setIdentificateur(int identificateur) {
        this.identificateur = identificateur;
    }

    public int getNoeud1() {
        return noeud1;
    }

    public void setNoeud1(int noeud1) {
        this.noeud1 = noeud1;
    }

    public int getNoeud2() {
        return noeud2;
    }

    public void setNoeud2(int noeud2) {
        this.noeud2 = noeud2;
    }

    public int getTypeBarre() {
        return typeBarre;
    }

    public Treillis getTreillis() {
        return treillis;
    }

    void setTreillis(Treillis treillis) {
        this.treillis = treillis;
    }

    public void setTypeBarre(int typeBarre) {
        this.typeBarre = typeBarre;
    }

    @Override
    public String toString() {
        return "Barre{" + "identificateur=" + identificateur + ", noeud1=" + noeud1 + ", noeud2=" + noeud2 + ", typeBarre=" + typeBarre + '}';
    }

   
    
    
}
