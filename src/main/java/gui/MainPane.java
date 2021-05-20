package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MainPane extends BorderPane {

    public Button getbGrouper() {
        return bGrouper;
    }
    
    private Controleur controleur;
    
    private RadioButton rbSelect;
    private RadioButton rbPoints;
    private RadioButton rbSegments;
    
    private Button bGrouper;
    private Button bCouleur;
    
    private DessinCanvas cDessin;
    

    public MainPane(){
        this.controleur = new Controleur(this);
        this.rbSelect = new RadioButton("Select");
        //this.rbSelect.setOnAction((t) -> {
            //this.controleur.boutonSelect(t); (action lorsque le bouton est appuyé)
        //});
        this.rbPoints = new RadioButton("Points");
        this.rbSegments = new RadioButton("Segments");
        
        ToggleGroup bgEtat = new ToggleGroup();
        this.rbSelect.setToggleGroup(bgEtat);
        this.rbPoints.setToggleGroup(bgEtat);
        this.rbSegments.setToggleGroup(bgEtat);
        
        VBox vbGauche = new VBox(this.rbSelect, this.rbPoints, this.rbSegments);
        this.setLeft(vbGauche);
        
        this.bGrouper = new Button("Grouper");
        this.bGrouper.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                System.out.println("bouton Grouper cliqué");
            }
        });
        
        this.bCouleur = new Button("Couleur");
        this.bCouleur.setOnAction((t) -> {
            System.out.println("bouton Couleur cliqué");
        });
        this.bCouleur.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent t){
                System.out.println("la souris est passé sur Couleur en " + t.getX() + ", " + t.getY());
            }
        });
        
        
        VBox vbDroite = new VBox(this.getbGrouper(), this.bCouleur);
        this.setRight(vbDroite);
        
        this.cDessin = new DessinCanvas(this);
        this.setCenter(this.cDessin);
        
        //this.controleur.changeEtat(30);
    }  
    
    public void redrawAll(){
        this.cDessin.redrawAll();
    }

    public Controleur getControleur() {
        return controleur;
    }
}


