package gui;

import javafx.event.Event;
import javafx.scene.input.MouseEvent;

public class Controleur {
    
    private MainPane vue;
    private int etat;
    
    public Controleur(MainPane vue){
        this.vue = vue;
    }
    
    public void boutonSelect(Event t){
        System.out.println("1");
    }
    public void boutonTerrain(Event t){
        System.out.println("2");
        this.etat = 3;
    }
     public void boutonNoeudAppui(Event t){
        System.out.println("3");
    }
    public void boutonNoeudSimple(Event t){
        System.out.println("4");
    }
    
    public void changeEtat(int nouvelEtat){
        //if(nouvelEtat == 10){
            //this.vue.getModel().setDisable(true);
        //}
        this.etat = nouvelEtat;
    }

    void clicDansZoneTerrain(MouseEvent t) {
        if(this.etat == 10) {
            double px = t.getX();
            double py = t.getY();
            this.vue.redrawAll();
        }
        else if(this.etat == 3) {
            
        }
    }
}
