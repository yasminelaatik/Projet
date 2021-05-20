package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class TriangleTerrain extends Treillis{
    
    public int idT ;
    
    protected Point PT0;
    protected Point PT1;
    protected Point PT2;
    
    protected SegmentTerrain ST1;
    protected SegmentTerrain ST2;
    protected SegmentTerrain ST3;
    
    public TriangleTerrain (int idT, Point PT0, Point PT1, Point PT2) {
        this.idT = idT;
        this.PT0 = PT0;
        this.PT1 = PT1;
        this.PT2 = PT2;
        SegmentTerrain ST1 = new SegmentTerrain(PT0, PT1);
        SegmentTerrain ST2 = new SegmentTerrain(PT1, PT2);
        SegmentTerrain ST3 = new SegmentTerrain(PT2, PT0);
        this.ST1 = ST1;
        this.ST2 = ST2;
        this.ST3 = ST3;
    }
   
    public void construire(GraphicsContext context){
        double[] x ={this.PT0.px, this.PT1.px, this.PT2.px};
        double[] y ={this.PT0.py, this.PT1.py, this.PT2.py};
        context.setStroke(Color.BLUE);
        context.strokePolygon(x,y,3);
    }
}
