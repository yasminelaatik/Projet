package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

public class MainPane extends BorderPane {
    
    private RadioButton rbSelect;
    private RadioButton rbPoints;
    private RadioButton rbSegments;
    
    private Button bGrouper;
    private Button bCouleur;
    
    private Canvas cDessin;
    
    public MainPane(){
        this.rbSelect = new RadioButton("Select");
        this.rbPoints = new RadioButton("Points");
        this.rbSegments = new RadioButton("Segments");
        VBox vbGauche = new VBox(this.rbSelect, this.rbPoints, this.rbSegments);
        this.setLeft(vbGauche);
        
        this.bGrouper = new Button("Grouper");
        this.bCouleur = new Button("Couleur");
        VBox vbDroite = new VBox(this.bGrouper, this.bCouleur);
        this.setRight(vbDroite);
        
        this.cDessin = new DessinCanvas1(200, 200);
        this.setCenter(this.cDessin);
    }  
}
