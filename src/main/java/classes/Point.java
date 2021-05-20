package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Point{
    public double px;
    public double py;
    
    public Point (double px, double py){
        if ((px<Terrain.xmin)||(px>Terrain.xmax)||(py<Terrain.ymin)||(py>Terrain.ymax)) {
            throw new Error("Vous ne pouvez pas construire de points ici") ;
        }
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
    
    public void construireNoeudSimple(GraphicsContext context){
        context.setFill(Color.BLUE);
        context.fillOval(this.px, this.py, 5, 5);
    }
    
    public void construireNoeudAppui(GraphicsContext context){
        context.setFill(Color.RED);
        context.fillOval(this.px, this.py, 5, 5);
    }
}
    
     
       

