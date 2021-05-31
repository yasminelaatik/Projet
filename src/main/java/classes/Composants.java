package classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Composants {
    
    private Treillis treillis;
    
    public Treillis getTreillis() {
        return this.treillis;
    }
    public void setTreillis(Treillis treillis) {
        this.treillis = treillis;
    }
    
    public abstract void construire(GraphicsContext context);
    
    public abstract void changerCouleur(Color c);
    
    public abstract double distance(Point p);
}
