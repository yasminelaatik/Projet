package gui;

import javafx.event.Event;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

import classes.Treillis;
import classes.Point;
import classes.Terrain;
import classes.NoeudAppuiSimple;
import classes.NoeudAppuiDouble;
import classes.NoeudAppuiEncastrement;
import classes.NoeudSimple;
import classes.SegmentTerrain;
import classes.Noeuds;
import classes.Composants;
import classes.Barre;
import classes.TriangleTerrain;

public class Controleur {
    
    private MainPane vue;
    private int etat;
    
    //attribut pour le type de matériau et la couleur du treillis
    private String matériau;
    //attributs pour Terrain
    private Point P1;
    private Point P2;
    private Point P3;
    private Point P4;
    private SegmentTerrain ST1;
    private SegmentTerrain ST2;
    private SegmentTerrain ST3;
    private SegmentTerrain ST4;
    private Terrain T;
    //attribust pour sélection
    private List<Noeuds> selectionNoeuds;
    private List<Noeuds> listeNoeuds;
    private List<Noeuds> listeNoeudsPourSegment;
    //attributs pour Barres
    private Noeuds N1;
    private Noeuds N2;
    private Noeuds N3;
    
    public Controleur(MainPane vue){
        this.vue = vue;
        this.selectionNoeuds = new ArrayList<>();
        this.listeNoeuds = new ArrayList<>();
        this.listeNoeudsPourSegment = new ArrayList<>();
    }
   
    public void boutonTerrain(Event t){
        this.changeEtat(10);}
    public void boutonAppuiSimple(Event t){
        this.changeEtat(20);}
    public void boutonAppuiDouble(Event t){
        this.changeEtat(30);}
    public void boutonEncastrement(Event t){
        this.changeEtat(40);}
    public void boutonNoeudSimple(Event t){
        this.changeEtat(50);}
    public void boutonSelectNoeuds(Event t){
        this.changeEtat(60);}
    public void boutonSegmentTerrain(Event t){
        this.changeEtat(70);}  
    public void boutonTriangleTerrain(Event t){
        this.changeEtat(80);}
    public void boutonSimulation(Event t){
        this.changeEtat(90);}
    
    public void changeEtat(int nouvelEtat){
          
        if(nouvelEtat == 10) {
            this.vue.getRbTerrain().setDisable(false);
            this.vue.getRbAppuiSimple().setDisable(true);
            this.vue.getRbAppuiDouble().setDisable(true);
            this.vue.getRbEncastrement().setDisable(true);
            this.vue.getRbNoeudSimple().setDisable(true);
            this.vue.getRbSelectNoeuds().setDisable(true);
            this.vue.getbSegmentTerrain().setDisable(true);
            this.vue.getbSimulation().setDisable(true); 
            this.vue.getRbTriangleTerrain().setDisable(true);
            this.vue.getRbTerrain().setSelected(true);
            
            this.etat = 10;
            
        } else if(nouvelEtat == 11) {
            this.etat = 11;
            
        } else if(nouvelEtat == 20) {
            this.vue.getRbTerrain().setDisable(true);
            this.vue.getRbAppuiSimple().setDisable(false);
            this.vue.getRbAppuiDouble().setDisable(false);
            this.vue.getRbEncastrement().setDisable(false);
            this.vue.getRbNoeudSimple().setDisable(false);
            this.vue.getRbTriangleTerrain().setDisable(false);
            this.vue.getRbSelectNoeuds().setDisable(true);
            this.vue.getbSegmentTerrain().setDisable(true);
            this.vue.getbSimulation().setDisable(true);
            this.vue.getRbAppuiSimple().setSelected(true);
            this.etat = 20;
            
        } else if(nouvelEtat == 30) {
            this.etat = 30;
            
        } else if(nouvelEtat == 40) {
            this.etat = 40;
            
        } else if(nouvelEtat == 50) {
            this.etat = 50;
            
        } else if(nouvelEtat == 60) {
            this.etat = 60;

        } else if(nouvelEtat == 70) {
            
            int taille  = getSelectionNoeuds().size();
            Point P1 = new Point(getSelectionNoeuds().get(taille-2).getAbscisse(), getSelectionNoeuds().get(taille-2).getOrdonnee());
            Point P2 = new Point(getSelectionNoeuds().get(taille-1).getAbscisse(), getSelectionNoeuds().get(taille-1).getOrdonnee());
            Treillis model = this.vue.getModel();
            model.add(new SegmentTerrain(P1, P2));
            model.add(new Barre(getSelectionNoeuds().get(taille-2), getSelectionNoeuds().get(taille-1)));
            this.vue.redrawAll();
            this.vue.getbSimulation().setDisable(false);
            changeEtat(60);
            
        } else if(nouvelEtat == 80) {
            this.etat = 80;

        } else if(nouvelEtat == 90) {
            this.vue.getRbTerrain().setDisable(true);
            this.vue.getRbAppuiSimple().setDisable(true);
            this.vue.getRbAppuiDouble().setDisable(true);
            this.vue.getRbEncastrement().setDisable(true);
            this.vue.getRbNoeudSimple().setDisable(true);
            this.vue.getRbSelectNoeuds().setDisable(true);
            this.vue.getbSegmentTerrain().setDisable(true);
            this.vue.getbSimulation().setDisable(true);
            //forces
            this.etat = 90;
        }
    }

    void clicDansZoneTerrain(MouseEvent t) {
        
        if (this.etat == 10){
            this.P1 = new Point(t.getX(), t.getY());
            Treillis model = this.vue.getModel();
            model.add(P1);
            this.vue.redrawAll();
            this.changeEtat(11);

        } else if (this.etat == 11) {
            this.P2 = new Point(t.getX(), t.getY());
            double xmin = min(this.P1.px, this.P2.px);
            double xmax = max(this.P1.px, this.P2.px);
            double ymin = min(this.P1.py, this.P2.py);
            double ymax = max(this.P1.py, this.P2.py);
            
            this.P1 = new Point(xmin, ymin);
            this.P2 = new Point(xmax, ymin);
            this.P3 = new Point(xmax, ymax);
            this.P4 = new Point(xmin, ymax);
            this.ST1 = new SegmentTerrain(P1, P2); 
            this.ST2 = new SegmentTerrain(P2, P3); 
            this.ST3 = new SegmentTerrain(P3, P4); 
            this.ST4 = new SegmentTerrain(P4, P1); 
            this.T = new Terrain(xmin, xmax, ymin, ymax);
            
            Treillis model = this.vue.getModel();
            model.add(P1);
            model.add(P2);
            model.add(P3);
            model.add(P4);
            model.add(ST1);
            model.add(ST2);
            model.add(ST3);
            model.add(ST4);
            model.add(T);
            this.vue.redrawAll();
            this.changeEtat(20); 
            
        } else if (this.etat == 20) {
            NoeudAppuiSimple NAS;
            Point clic = new Point(t.getX(), t.getY());
            SegmentTerrain SegmentPlusProche = placementAppui(clic);
            if(SegmentPlusProche == this.ST1){
                NAS = new NoeudAppuiSimple(t.getX(), this.P1.py);
            }
            else if(SegmentPlusProche == this.ST2){
                NAS = new NoeudAppuiSimple(this.P2.px, t.getY());
            }
            else if(SegmentPlusProche == this.ST3){
                NAS = new NoeudAppuiSimple(t.getX(), this.P3.py);
            }
            else if(SegmentPlusProche == this.ST4){
                NAS = new NoeudAppuiSimple(this.P4.px, t.getY());
            }
            else{
                throw new Error("pas assez proche du terrain");
            }
            Treillis model = this.vue.getModel();
            model.add(NAS);
            listeNoeuds.add(NAS);
            this.vue.redrawAll();
            this.vue.getRbSelectNoeuds().setDisable(false);
            
        } else if (this.etat == 30) {
            NoeudAppuiDouble NAD;
            Point clic = new Point(t.getX(), t.getY());
            SegmentTerrain SegmentPlusProche = placementAppui(clic);
            if(SegmentPlusProche == this.ST1){
                NAD = new NoeudAppuiDouble(t.getX(), this.P1.py);
            }
            else if(SegmentPlusProche == this.ST2){
                NAD = new NoeudAppuiDouble(this.P2.px, t.getY());
            }
            else if(SegmentPlusProche == this.ST3){
                NAD = new NoeudAppuiDouble(t.getX(), this.P3.py);
            }
            else if(SegmentPlusProche == this.ST4){
                NAD = new NoeudAppuiDouble(this.P4.px, t.getY());
            }
            else{
                throw new Error("pas assez proche du terrain");
            }
            Treillis model = this.vue.getModel();
            model.add(NAD);
            listeNoeuds.add(NAD);
            this.vue.redrawAll();
            this.vue.getRbSelectNoeuds().setDisable(false);
            
        } else if (this.etat == 40) {
            NoeudAppuiEncastrement NAE;
            Point clic = new Point(t.getX(), t.getY());
            SegmentTerrain SegmentPlusProche = placementAppui(clic);
            if(SegmentPlusProche == this.ST1){
                NAE = new NoeudAppuiEncastrement(t.getX(), this.P1.py);
            }
            else if(SegmentPlusProche == this.ST2){
                NAE = new NoeudAppuiEncastrement(this.P2.px, t.getY());
            }
            else if(SegmentPlusProche == this.ST3){
                NAE = new NoeudAppuiEncastrement(t.getX(), this.P3.py);
            }
            else if(SegmentPlusProche == this.ST4){
                NAE = new NoeudAppuiEncastrement(this.P4.px, t.getY());
            }
            else{
                throw new Error("pas assez proche du terrain");
            }
            Treillis model = this.vue.getModel();
            model.add(NAE);
            listeNoeuds.add(NAE);
            this.vue.redrawAll();
            this.vue.getRbSelectNoeuds().setDisable(false);
            
        } else if (this.etat == 50) { 
            if((t.getX()>Terrain.getXmin()+20)&&(t.getX()<Terrain.getXmax()-20)&&(t.getY()>Terrain.getYmin()+20)&&(t.getY()<Terrain.getYmax()-20)) {
                Treillis model = this.vue.getModel();
                NoeudSimple NS = new NoeudSimple(t.getX(), t.getY());
                model.add(NS);
                listeNoeuds.add(NS);
                this.vue.redrawAll();
                this.vue.getRbSelectNoeuds().setDisable(false);
            }

        } else if (this.etat == 60) {
            Point clic = new Point(t.getX(), t.getY());
            Noeuds candidat = sélectionnerNoeud(clic);
            if(candidat != null){
                for (Noeuds N : getSelectionNoeuds()){
                    if (candidat.equals(N)){
                        getSelectionNoeuds().remove(getIndex(N));
                        break;
                    }
                }
                getSelectionNoeuds().add(candidat);
            }
            
            int tailleS = getSelectionNoeuds().size();
            if (tailleS >= 2){
                for (int i = 0 ; i < tailleS ; i++){
                    getSelectionNoeuds().get(i).changerCouleur(Color.BLUE);
                }
                getSelectionNoeuds().get(tailleS-2).changerCouleur(Color.CYAN);
                getSelectionNoeuds().get(tailleS-1).changerCouleur(Color.CYAN);
            }
            this.vue.redrawAll();
            this.vue.getbSegmentTerrain().setDisable(false);
            
        } else if (this.etat == 80) {
            this.P1 = new Point(t.getX(), t.getY());
            Treillis model = this.vue.getModel();
            if(sélectionnerNoeud(P1) != null){
                this.P1 = new Point(sélectionnerNoeud(P1).getAbscisse(), sélectionnerNoeud(P1).getOrdonnee());
                this.N1 = sélectionnerNoeud(P1);
            }
            else{
                NoeudSimple NS = new NoeudSimple(t.getX(), t.getY());
                model.add(NS);
                listeNoeuds.add(NS);
                this.N1 = NS;
            }
            this.vue.redrawAll();
            this.etat = 81;
            
        } else if (this.etat == 81) {
            this.P2 = new Point(t.getX(), t.getY());
            Treillis model = this.vue.getModel();
            if(sélectionnerNoeud(P2) != null){
                this.P2 = new Point(sélectionnerNoeud(P2).getAbscisse(), sélectionnerNoeud(P2).getOrdonnee());
                this.N2 = sélectionnerNoeud(P2);
            }
            else{
                NoeudSimple NS = new NoeudSimple(t.getX(), t.getY());
                model.add(NS);
                listeNoeuds.add(NS);
                this.N2 = NS;
            }
            this.vue.redrawAll();
            this.etat = 82;
            
        } else if (this.etat == 82) {
            this.P3 = new Point(t.getX(), t.getY());
            Treillis model = this.vue.getModel();
            if(sélectionnerNoeud(P3) != null){
                this.P3 = new Point(sélectionnerNoeud(P3).getAbscisse(), sélectionnerNoeud(P3).getOrdonnee());
                this.N3 = sélectionnerNoeud(P3);
            }
            else{
                NoeudSimple NS = new NoeudSimple(t.getX(), t.getY());
                model.add(NS);
                listeNoeuds.add(NS);
                this.N3 = NS;
            }
            model.add(new TriangleTerrain(P1, P2, P3));
            model.add(new Barre(this.N1, this.N2));
            model.add(new Barre(this.N2, this.N3));
            model.add(new Barre(this.N3, this.N1));
            this.vue.redrawAll();
            this.etat = 80;
            
            
        }
    }
  
    public SegmentTerrain placementAppui(Point clic){
        double d1 = this.ST1.distance(clic);
        double d2 = this.ST2.distance(clic);
        double d3 = this.ST3.distance(clic);
        double d4 = this.ST4.distance(clic);
        double dmin = min(min(d1,d2), min(d3,d4));
        if ((d1 == dmin)&&(dmin < 20)) {
            return this.ST1;
        }
        else if ((d2 == dmin)&&(dmin < 20)) {
            return this.ST2;
        }
        else if ((d3 == dmin)&&(dmin < 20)) {
            return this.ST3;
        }
        else if ((d4 == dmin)&&(dmin < 20)) {
            return this.ST4;
        }
        else{
            return null;
        }
    }
    public double min(double a, double b){
        if(a<=b){
            return a;
        }
        else{
            return b;
        }
    }
    public double max(double a, double b){
        if(a<=b){
            return b;
        }
        else{
            return a;
        }
    }
    public Noeuds sélectionnerNoeud(Point clic){
        listeNoeudsPourSegment = conversion(this.vue.getModel().getListeC(), this.listeNoeuds);
        Noeuds choisi = listeNoeudsPourSegment.get(0);
        double distanceMin = choisi.distance(clic);
        for (Noeuds N : listeNoeudsPourSegment){
            if (N.distance(clic) <= distanceMin){
                distanceMin = N.distance(clic);
                choisi = N;
            }
        }
        if(distanceMin < 10){
            return choisi;
        }
        else{
            return null;
        }
    }
    public int getIndex(Composants C) {
        return this.getSelectionNoeuds().indexOf(C);
    }
    public List<Noeuds> conversion(List<Composants> lC, List<Noeuds>lN) {
        List<Noeuds> nouvelleList = new ArrayList<>();

        for (Composants C : lC) {
            for (int i=0 ; i<lN.size() ; i++){
                if(C.equals(lN.get(i))){
                    nouvelleList.add(lN.get(i));
                }
            }
        }
        return nouvelleList;
    }
    public List<Noeuds> getSelectionNoeuds() {
        return selectionNoeuds;
    }
}
