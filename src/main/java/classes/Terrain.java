package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Terrain extends Composants {

    public static double xmin ;
    public static double xmax ;
    public static double ymin ;
    public static double ymax ;
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
        context.strokeRect(Terrain.xmin, Terrain.ymin, (Terrain.xmax-Terrain.xmin), (Terrain.ymax-Terrain.ymin));
    }
    
    @Override
    public void changerCouleur(Color c){
    }
    
    @Override
    public double distance(Point p){
        double d1 = new SegmentTerrain(new Point(Terrain.xmin, Terrain.ymin), new Point(Terrain.xmax, Terrain.ymin)).distance(p);
        double d2 = new SegmentTerrain(new Point(Terrain.xmax, Terrain.ymin), new Point(Terrain.xmax, Terrain.ymax)).distance(p);
        double d3 = new SegmentTerrain(new Point(Terrain.xmax, Terrain.ymax), new Point(Terrain.xmin, Terrain.ymax)).distance(p);
        double d4 = new SegmentTerrain(new Point(Terrain.xmin, Terrain.ymax), new Point(Terrain.xmin, Terrain.ymin)).distance(p);
        
        return min(min(d1,d2), min(d3, d4));
    }
}
