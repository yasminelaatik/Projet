package classes;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Treillis extends Composants {
    
    public List<Composants> listeC;
    public List<Noeuds> listeN;
    public static int identificateur;
    
    public static int idT = 0;

    public Treillis(){
        idT++;
        this.identificateur = idT;
        this.listeC = new ArrayList<>();
        this.listeN = new ArrayList<>();
    }
    
    public void add(Composants C){
         if (C.getTreillis() != this) {
            if (C.getTreillis() != null) {
                throw new Error("figure déja dans un autre groupe");
            }
            this.listeC.add(C);
            C.setTreillis(this);
        }
    }
    
    public void remove(Composants C) {
        if (C.getTreillis() != this) {
            throw new Error("la figure n'est pas dans le groupe");
        }
        this.listeC.remove(C);
        C.setTreillis(null);
    }
    
    public List<Composants> getListeC(){
        return this.listeC;
    }
    
    public List<Noeuds> getListeN(){
        return this.listeN;
    }
    
    @Override
    public void construire(GraphicsContext context) {
        for (Composants C : this.listeC) {
            C.construire(context);
        }
    }
    
    @Override
    public void changerCouleur(Color c){
        for (Composants C : this.listeC) {
            C.changerCouleur(c);
        }
    }
    
    @Override
    public double distance(Point p){
        if (this.listeC.isEmpty()) {
            return new Point().distance(p);
        } else {
            double dist = this.listeC.get(0).distance(p);
            for (int i = 1; i < this.listeC.size(); i++) {
                double cur = this.listeC.get(i).distance(p);
                if (cur < dist) {
                    dist = cur;
                }
            }
            return dist;
        }
    }
}