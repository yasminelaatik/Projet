package gui;

import classes.Treillis;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import java.util.Scanner;
import javafx.scene.paint.Color;

public class DessinCanvas extends Pane{
    
    private MainPane main;
    private Canvas realCanvas;
    
    private Color couleur;
    
    public DessinCanvas(MainPane main){
        
        this.couleur = choixTypeBarre();
        
        this.main = main;
        
        this.realCanvas = new Canvas(this.getWidth(), this.getHeight());
        this.getChildren().add(this.realCanvas);
        
        this.realCanvas.widthProperty().bind(this.widthProperty());
        this.realCanvas.widthProperty().addListener((o) -> {
            this.redrawAll();
        });
        this.realCanvas.heightProperty().bind(this.heightProperty());
        this.realCanvas.heightProperty().addListener((o) -> {
            this.redrawAll();
        });
        
        this.realCanvas.setOnMouseClicked((t) -> {
            Controleur control = this.main.getControleur();
            control.clicDansZoneTerrain(t);
        });
        /*
        this.realCanvas.setOnMouseEntered((t) -> {
            Controleur control = this.main.getControleur();
            control.déplacementSouris(t);
        });
        */
        this.realCanvas.setOnMouseMoved((t) -> {
            Controleur control = this.main.getControleur();
            control.déplacementSouris(t);
        });
        
    }
    
    public Color choixTypeBarre(){
        System.out.println("Choisissez le matériau que vous voulez");
        System.out.println("1 : acier");
        System.out.println("2 : bois");
        System.out.println("3 : aluminium");
        System.out.println("4 : béton");
        System.out.println("5 : bronze");
        Scanner sc = new Scanner(System.in);
        
        if(sc.nextLine().equals("acier")){
            return Color.BLUE;
        }
        else if(sc.nextLine().equals("bois")){
            return Color.BROWN;
        }
        else if(sc.nextLine().equals("aluminium")){
            return Color.SILVER;
        }
        else if(sc.nextLine().equals("béton")){
            return Color.BEIGE;
        }
        else if(sc.nextLine().equals("bronze")){
            return Color.CHOCOLATE;
        }
        else{
            throw new Error("Il faut mettre acier, bois, aluminium, béton ou bronze");
        }
    }
    /*
    public void redrawAll(){
        GraphicsContext context = this.realCanvas.getGraphicsContext2D();
        Treillis model = this.main.getModel();
        model.changerCouleur(this.couleur);
        Controleur control = this.main.getControleur();
        if((control.getSelectionNoeuds().get(0) != null)&&(control.getSelectionNoeuds().size() >= 2)){
            control.getSelectionNoeuds().get(control.getSelectionNoeuds().size()-2).changerCouleur(Color.CYAN);
            control.getSelectionNoeuds().get(control.getSelectionNoeuds().size()-1).changerCouleur(Color.CYAN);
        }
        model.construire(context);
    }
*/
    public void redrawAll(){
        GraphicsContext context = this.realCanvas.getGraphicsContext2D();
        Treillis model = this.main.getModel();
        context.setFill(Color.WHITE);
        context.fillRect(0, 0, this.getWidth(), this.getHeight());
        model.changerCouleur(this.couleur);
        Controleur control = this.main.getControleur();
        if(control.getSelectionNoeuds().size() >= 2){
            control.getSelectionNoeuds().get(control.getSelectionNoeuds().size()-2).changerCouleur(Color.CYAN);
            control.getSelectionNoeuds().get(control.getSelectionNoeuds().size()-1).changerCouleur(Color.CYAN);
        }
        model.construire(context);
    }
}
