package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Terrain extends Composants {

    private static double xmin ;
    private static double xmax ;
    private static double ymin ;
    private static double ymax ;
    public Color c;
    
    public Terrain(double xmin, double xmax, double ymin, double ymax) {
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
        this.c = Color.LIMEGREEN;
    }
    
    public static double getXmin() {
        return xmin;
    }
    public static double getXmax() {
        return xmax;
    }
    public static double getYmin() {
        return ymin;
    }
    public static double getYmax() {
        return ymax;
    }
    public double min(double a, double b){
        if(a<=b){
            return a;
        }
        else{
            return b;
        }
    }
    
    @Override
    public void construire(GraphicsContext context){
        context.setStroke(this.c);
        context.strokeRect(this.xmin, this.ymin, (this.xmax-this.xmin), (this.ymax-this.ymin));
    }
    
    @Override
    public void changerCouleur(Color c){
    }
    
    @Override
    public double distance(Point p){
        double d1 = new SegmentTerrain(new Point(this.xmin, this.ymin), new Point(this.xmax, this.ymin)).distance(p);
        double d2 = new SegmentTerrain(new Point(this.xmax, this.ymin), new Point(this.xmax, this.ymax)).distance(p);
        double d3 = new SegmentTerrain(new Point(this.xmax, this.ymax), new Point(this.xmin, this.ymax)).distance(p);
        double d4 = new SegmentTerrain(new Point(this.xmin, this.ymax), new Point(this.xmin, this.ymin)).distance(p);
        
        return min(min(d1,d2), min(d3, d4));
    }
}
