package com.mycompany.projettreillis;

public class NoeudAppui extends Noeud {
    private double point1;
    private double point2;
    private double position;
    
    public NoeudAppui (double point1,double point2, double position, int identificateur){
        super(identificateur);
        this.point1= point1;
        this.point2 = point2;
        this.position= position;
        
    }
}
