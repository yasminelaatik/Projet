/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Point {
    private double px;
    private double py;
    
    public Point (double px, double py){
        this.px = px;
        this.py = py;
        
    }
    
    public Point (){
        this(0,0);
    }

    public double getPx() {
        return px;
    }

    public void setPx(double px) {
        this.px = px;
    }

    public double getPy() {
        return py;
    }

    public void setPy(double py) {
        this.py = py;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + px + "," + py + ')';
    }
    
    
        
        
        
   
    }
    
     
       

