package classes;

import static java.lang.Math.sqrt;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Point extends Composants {
    public double px;
    public double py;
    public Color c;
    
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

    @Override
    public String toString() {
        return "(" + px + "," + py + ')';
    } 
    
    @Override
    public void construire(GraphicsContext context){
        context.setFill(Color.GREEN);
        context.fillOval(this.px-0.5, this.py-0.5, 1, 1);
    }
    
    @Override
    public void changerCouleur(Color c){
    this.c = c;
    }
    
    @Override
    public double distance(Point p) {
        return sqrt((this.getPx()-p.getPx())*(this.getPx()-p.getPx())+(this.getPy()-p.getPy())*(this.getPy()-p.getPy()));
    }
}
    
     
       

