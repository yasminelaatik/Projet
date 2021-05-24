package gui;

import classes.Treillis;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class MainPane extends BorderPane {
    
    private Treillis model;
    private Controleur controleur;
    
    private RadioButton rbTerrain;
    private RadioButton rbAppuiSimple;
    private RadioButton rbAppuiDouble;
    private RadioButton rbEncastrement;
    private RadioButton rbNoeudSimple;
    private RadioButton rbSelectNoeuds;
    private RadioButton rbTriangleTerrain;
    private Button bSegmentTerrain;
    private Button bSimulation;
    
    private DessinCanvas cDessin;
    
    public MainPane(Treillis model){
        
        this.model = model; 
        this.controleur = new Controleur(this);
        
        this.rbTerrain = new RadioButton("Placer Terrain");
        this.rbTerrain.setOnAction((t) -> {
            this.controleur.boutonTerrain(t); 
        });
        this.rbAppuiSimple = new RadioButton("Placer Appui Simple");
        this.rbAppuiSimple.setOnAction((t) -> {
            this.controleur.boutonAppuiSimple(t); 
        });
        this.rbAppuiDouble = new RadioButton("Placer Appui Double");
        this.rbAppuiDouble.setOnAction((t) -> {
            this.controleur.boutonAppuiDouble(t); 
        });
        this.rbEncastrement = new RadioButton("Placer Encastrement");
        this.rbEncastrement.setOnAction((t) -> {
            this.controleur.boutonEncastrement(t); 
        });
        this.rbNoeudSimple = new RadioButton("Créer Noeud Simple");
        this.rbNoeudSimple.setOnAction((t) -> {
            this.controleur.boutonNoeudSimple(t); 
        });
        this.rbSelectNoeuds = new RadioButton("Selectionner Noeuds");
        this.rbSelectNoeuds.setOnAction((t) -> {
            this.controleur.boutonSelectNoeuds(t); 
        });
        this.rbTriangleTerrain = new RadioButton("Créer TriangleTerrain");
        this.rbTriangleTerrain.setOnAction((t) -> {
            this.controleur.boutonTriangleTerrain(t); 
        });
        this.bSegmentTerrain = new Button("Créer un Segment Terrain");
        this.bSegmentTerrain.setOnAction((t) -> {
            this.controleur.boutonSegmentTerrain(t); 
        });
        this.bSimulation = new Button("Lancer la Simulation");
        this.bSimulation.setOnAction((t) -> {
            this.controleur.boutonSimulation(t); 
        });
        
        ToggleGroup bgEtat = new ToggleGroup();
        this.rbTerrain.setToggleGroup(bgEtat);
        this.rbAppuiSimple.setToggleGroup(bgEtat);
        this.rbAppuiDouble.setToggleGroup(bgEtat);
        this.rbEncastrement.setToggleGroup(bgEtat);
        this.rbNoeudSimple.setToggleGroup(bgEtat);
        this.rbSelectNoeuds.setToggleGroup(bgEtat);
        this.rbTriangleTerrain.setToggleGroup(bgEtat);
        
        VBox vbGauche = new VBox(this.rbTerrain, this.rbAppuiSimple, this.rbAppuiDouble, this.rbEncastrement, this.rbNoeudSimple, this.rbSelectNoeuds, this.rbTriangleTerrain, this.bSegmentTerrain, this.bSimulation);
        this.setLeft(vbGauche);
        
        this.cDessin = new DessinCanvas(this);
        this.setCenter(this.cDessin);
        this.controleur.changeEtat(10);
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
    
    public RadioButton getRbTerrain() {
        return rbTerrain;
    }
    public RadioButton getRbAppuiSimple() {
        return rbAppuiSimple;
    }
    public RadioButton getRbAppuiDouble() {
        return rbAppuiDouble;
    }
    public RadioButton getRbEncastrement() {
        return rbEncastrement;
    }
    public RadioButton getRbNoeudSimple() {
        return rbNoeudSimple;
    }
    public RadioButton getRbSelectNoeuds() {
        return rbSelectNoeuds;
    }
    public Button getbSegmentTerrain() {
        return bSegmentTerrain;
    }
    public RadioButton getRbTriangleTerrain() {
        return rbTriangleTerrain;
    }
    public Button getbSimulation() {
        return bSimulation;
    }
}


