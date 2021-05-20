package gui;

import classes.Treillis;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class DessinCanvas extends Pane{
    
    private MainPane main;
    private Canvas realCanvas;
    
    public DessinCanvas(MainPane main){
        
        this.main = main;
        
        this.realCanvas = new Canvas(this.getWidth(), this.getHeight());
        this.getChildren().add(this.realCanvas);
        
        this.realCanvas.heightProperty().bind(this.heightProperty());
        this.realCanvas.heightProperty().addListener((o) -> {
            this.redrawAll();
        });
        this.realCanvas.widthProperty().bind(this.widthProperty());
        this.realCanvas.widthProperty().addListener((o) -> {
            this.redrawAll();
        });
        
        this.realCanvas.setOnMouseClicked((t) -> {
            Controleur control = this.main.getControleur();
            control.clicDansZoneTerrain(t);
            System.out.println("cliqué " + t.getX() + " " + t.getY());
        });
        this.redrawAll();
    }
    
    public void redrawAll(){
        GraphicsContext context = this.realCanvas.getGraphicsContext2D();
        context.setFill(Color.WHITE);
        context.fillRect(0, 0, this.realCanvas.getWidth(), this.realCanvas.getHeight());
        Treillis model = this.main.getModel();
    }
}
