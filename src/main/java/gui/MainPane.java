package gui;

import classes.Treillis;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MainPane extends BorderPane {
    
    private Treillis model;
    private Controleur controleur;
    
    private RadioButton rbSelect;
    private Button bTerrain;
    private Button bNoeudAppui;
    private Button bNoeudSimple;
    
    private DessinCanvas cDessin;
    
    public MainPane(Treillis model){
        
        this.model = model; 
        this.controleur = new Controleur(this);
        
        this.rbSelect = new RadioButton("Select");
        this.rbSelect.setOnAction((t) -> {
            this.controleur.boutonSelect(t); 
        });
        
        this.bTerrain = new Button("Terrain");
        this.bTerrain.setOnAction((t) -> {
            this.controleur.boutonTerrain(t); 
        });
        
        this.bNoeudAppui = new Button("NoeudAppui");
        this.bNoeudAppui.setOnAction((t) -> {
            this.controleur.boutonNoeudAppui(t); 
        });
        
        this.bNoeudSimple = new Button("NoeudSimple");
        this.bNoeudSimple.setOnAction((t) -> {
            this.controleur.boutonNoeudSimple(t); 
        });
        
        //ToggleGroup bgEtat2 = new ToggleGroup();
        //this.bTerrain.setToggleGroup(bgEtat2);
        //this.bNoeudAppui.setToggleGroup(bgEtat2);
        //this.bNoeudSimple.setToggleGroup(bgEtat2);
        
        VBox vbGauche = new VBox(this.rbSelect, this.bTerrain, this.bNoeudAppui, this.bNoeudSimple);
        this.setLeft(vbGauche);
        
        this.cDessin = new DessinCanvas(this);
        this.setCenter(this.cDessin);
        
        this.controleur.changeEtat(30);
    }  
    
    public void redrawAll(){
        this.cDessin.redrawAll();
    }

    public Controleur getControleur() {
        return controleur;
    }


    public Treillis getModel() {
        return model;
    }

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

}


