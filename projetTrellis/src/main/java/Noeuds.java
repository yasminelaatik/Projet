package com.mycompany.projettreillis;

public class Noeud {
    int identificateur;
    
    public Noeud (int identificateur){
        this.identificateur = identificateur;
        
        
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
    
    
}
