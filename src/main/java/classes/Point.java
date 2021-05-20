package classes;

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
}
    
     
       

