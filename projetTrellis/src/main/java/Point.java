package com.mycompany.projettreillis;

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
