/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class NoeudAppui extends Noeuds {
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
