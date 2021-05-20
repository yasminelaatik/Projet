package gui;

import javafx.scene.input.MouseEvent;

public class Controleur {
    
    private MainPane vue;
    private int etat;
    
    public Controleur(MainPane vue){
        this.vue = vue;
    }
    
    public void changeEtat(int nouvelEtat){
        if(nouvelEtat == 10){
            this.vue.getbGrouper().setDisable(true);
            //etc etc
        }
        this.etat = nouvelEtat;
    }

    void clicDansZoneTerrain(MouseEvent t) {
        //if(this.etat == 10) {
            double px = t.getX();
            double py = t.getY();
            //truc avec Groupe model, sauf que Groupe on a pas
            this.vue.redrawAll();
        //} //faire un else if pour chaque état, faire des this.vue.redrawAll() à chaque fois
    }
}
