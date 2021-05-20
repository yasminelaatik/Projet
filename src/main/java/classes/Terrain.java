package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Terrain {
    public static double xmin ;
    public static double xmax ;
    public static double ymin ;
    public static double ymax ;
    
    public Terrain (double xmin, double xmax, double ymin, double ymax) {
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
    }
    
    public void construire(GraphicsContext context){
        context.setStroke(Color.GREEN);
        context.strokeRect(this.xmin, this.xmax, this.ymin, this.ymax);
    }
}
