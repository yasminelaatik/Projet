package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Terrain extends Composants {

    public double xmin ;
    public double xmax ;
    public double ymin ;
    public double ymax ;
    
    public Terrain(double xmin, double xmax, double ymin, double ymax) {
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
    }
    
    public double getXmin() {
        return xmin;
    }
    public double getXmax() {
        return xmax;
    }
    public double getYmin() {
        return ymin;
    }
    public double getYmax() {
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
        context.setStroke(Color.LIMEGREEN);
        context.strokeRect(this.xmin, this.ymin, (this.xmax-this.xmin), (this.ymax-this.ymin));
    }
    @Override
    public void changerCouleur(Color c){
        //la couleur du terrain est indépendante du type de la barre
    }
    @Override
    public double distance(Point p){
        double d1 = new SegmentTerrain(new Point(xmin, ymin), new Point(xmax, ymin)).distance(p);
        double d2 = new SegmentTerrain(new Point(xmax, ymin), new Point(xmax, ymax)).distance(p);
        double d3 = new SegmentTerrain(new Point(xmax, ymax), new Point(xmin, ymax)).distance(p);
        double d4 = new SegmentTerrain(new Point(xmin, ymax), new Point(xmin, ymin)).distance(p);
        
        return min(min(d1,d2), min(d3,d4));
    }
}
