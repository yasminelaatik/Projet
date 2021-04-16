/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Noeuds {
    int identificateur;
    
    public Noeuds (int identificateur){
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
