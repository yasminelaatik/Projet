package classes;

import static java.lang.Math.sqrt;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Point extends Composants {
    
    public double px;
    public double py;
    
    public Point (double px, double py){
        this.px = px;
        this.py = py;
    }

    public double getPx() {
        return px;
    }
    public double getPy() {
        return py;
    }

    @Override
    public String toString() {
        return "(" + px + "," + py + ')';
    } 
    @Override
    public void construire(GraphicsContext context){
        context.setFill(Color.LIMEGREEN);
        context.fillOval(this.px-0.5, this.py-0.5, 1, 1);
    }
    @Override
    public void changerCouleur(Color c){
    }
    @Override
    public double distance(Point p) {
        return sqrt((this.getPx()-p.getPx())*(this.getPx()-p.getPx())+(this.getPy()-p.getPy())*(this.getPy()-p.getPy()));
    }
}
    
     
       

