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
    private int typeBarre;
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
    public void boutonBarre(Event t){
        this.changeEtat(70);}  
    public void boutonTriangleTerrain(Event t){
        this.changeEtat(80);}
    public void boutonSauvegarde(Event t){
        this.changeEtat(90);}
    
    public void changeEtat(int nouvelEtat){
          
        if(nouvelEtat == 10) {
            this.typeBarre = matériau();
            
            this.vue.getRbTerrain().setDisable(false);
            this.vue.getRbAppuiSimple().setDisable(true);
            this.vue.getRbAppuiDouble().setDisable(true);
            this.vue.getRbEncastrement().setDisable(true);
            this.vue.getRbNoeudSimple().setDisable(true);
            this.vue.getRbSelectNoeuds().setDisable(true);
            this.vue.getbBarre().setDisable(true);
            this.vue.getbSauvegarde().setDisable(true); 
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
            this.vue.getbBarre().setDisable(true);
            this.vue.getbSauvegarde().setDisable(true);
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
            
            int taille = getSelectionNoeuds().size();
            Treillis model = this.vue.getModel();
            Barre B = new Barre(getSelectionNoeuds().get(taille-2), getSelectionNoeuds().get(taille-1), typeBarre);
            model.add(B);
            model.addB(B);
            this.vue.redrawAll();
            this.vue.getbSauvegarde().setDisable(false);
            changeEtat(60);
            
        } else if(nouvelEtat == 80) {
            this.etat = 80;

        } else if(nouvelEtat == 90) {
            //sauvegarde
            //this.vue.getModel().sauvegarder(new File("info.txt"));
            this.vue.getbSauvegarde().setDisable(true);
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
            if((SegmentPlusProche == this.ST1)&&(t.getX()>=T.getXmin())&&(t.getX()<=T.getXmax())){
                NAS = new NoeudAppuiSimple(t.getX(), this.P1.py);
            }
            else if((SegmentPlusProche == this.ST2)&&(t.getY()>=T.getYmin())&&(t.getY()<=T.getYmax())){
                NAS = new NoeudAppuiSimple(this.P2.px, t.getY());
            }
            else if((SegmentPlusProche == this.ST3)&&(t.getX()>=T.getXmin())&&(t.getX()<=T.getXmax())){
                NAS = new NoeudAppuiSimple(t.getX(), this.P3.py);
            }
            else if((SegmentPlusProche == this.ST4)&&(t.getY()>=T.getYmin())&&(t.getY()<=T.getYmax())){
                NAS = new NoeudAppuiSimple(this.P4.px, t.getY());
            }
            else{
                throw new Error("pas assez proche du terrain");
            }
            Treillis model = this.vue.getModel();
            model.add(NAS);
            model.addN(NAS);
            listeNoeuds.add(NAS);
            this.vue.redrawAll();
            this.vue.getRbSelectNoeuds().setDisable(false);
            this.vue.getbSauvegarde().setDisable(false);
            
        } else if (this.etat == 30) {
            NoeudAppuiDouble NAD;
            Point clic = new Point(t.getX(), t.getY());
            SegmentTerrain SegmentPlusProche = placementAppui(clic);
            if((SegmentPlusProche == this.ST1)&&(t.getX()>=T.getXmin())&&(t.getX()<=T.getXmax())){
                NAD = new NoeudAppuiDouble(t.getX(), this.P1.py);
            }
            else if((SegmentPlusProche == this.ST2)&&(t.getY()>=T.getYmin())&&(t.getY()<=T.getYmax())){
                NAD = new NoeudAppuiDouble(this.P2.px, t.getY());
            }
            else if((SegmentPlusProche == this.ST3)&&(t.getX()>=T.getXmin())&&(t.getX()<=T.getXmax())){
                NAD = new NoeudAppuiDouble(t.getX(), this.P3.py);
            }
            else if((SegmentPlusProche == this.ST4)&&(t.getY()>=T.getYmin())&&(t.getY()<=T.getYmax())){
                NAD = new NoeudAppuiDouble(this.P4.px, t.getY());
            }
            else{
                throw new Error("pas assez proche du terrain");
            }
            Treillis model = this.vue.getModel();
            model.add(NAD);
            model.addN(NAD);
            listeNoeuds.add(NAD);
            this.vue.redrawAll();
            this.vue.getRbSelectNoeuds().setDisable(false);
            this.vue.getbSauvegarde().setDisable(false);
            
        } else if (this.etat == 40) {
            NoeudAppuiEncastrement NAE;
            Point clic = new Point(t.getX(), t.getY());
            SegmentTerrain SegmentPlusProche = placementAppui(clic);
            if((SegmentPlusProche == this.ST1)&&(t.getX()>=T.getXmin())&&(t.getX()<=T.getXmax())){
                NAE = new NoeudAppuiEncastrement(t.getX(), this.P1.py);
            }
            else if((SegmentPlusProche == this.ST2)&&(t.getY()>=T.getYmin())&&(t.getY()<=T.getYmax())){
                NAE = new NoeudAppuiEncastrement(this.P2.px, t.getY());
            }
            else if((SegmentPlusProche == this.ST3)&&(t.getX()>=T.getXmin())&&(t.getX()<=T.getXmax())){
                NAE = new NoeudAppuiEncastrement(t.getX(), this.P3.py);
            }
            else if((SegmentPlusProche == this.ST4)&&(t.getY()>=T.getYmin())&&(t.getY()<=T.getYmax())){
                NAE = new NoeudAppuiEncastrement(this.P4.px, t.getY());
            }
            else{
                throw new Error("pas assez proche du terrain");
            }
            Treillis model = this.vue.getModel();
            model.add(NAE);
            model.addN(NAE);
            listeNoeuds.add(NAE);
            this.vue.redrawAll();
            this.vue.getRbSelectNoeuds().setDisable(false);
            this.vue.getbSauvegarde().setDisable(false);
            
        } else if (this.etat == 50) { 
            if((t.getX()>T.getXmin()+20)&&(t.getX()<T.getXmax()-20)&&(t.getY()>T.getYmin()+20)&&(t.getY()<T.getYmax()-20)) {
                Treillis model = this.vue.getModel();
                NoeudSimple NS = new NoeudSimple(t.getX(), t.getY());
                model.add(NS);
                model.addN(NS);
                listeNoeuds.add(NS);
                this.vue.redrawAll();
                this.vue.getRbSelectNoeuds().setDisable(false);
                this.vue.getbSauvegarde().setDisable(false);
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
            this.vue.getbBarre().setDisable(false);
            
        } else if (this.etat == 80) {
            if((t.getX()>T.getXmin())&&(t.getX()<T.getXmax())&&(t.getY()>T.getYmin())&&(t.getY()<T.getYmax())) {
                this.P1 = new Point(t.getX(), t.getY());
                if(sélectionnerNoeud(P1) != null){
                    this.P1 = new Point(sélectionnerNoeud(P1).getAbscisse(), sélectionnerNoeud(P1).getOrdonnee());
                }
                else{
                    Treillis model = this.vue.getModel();
                    model.add(this.P1);
                    this.vue.redrawAll();
                }
                this.etat = 81;
            }
            
        } else if (this.etat == 81) {
            if((t.getX()>T.getXmin())&&(t.getX()<T.getXmax())&&(t.getY()>T.getYmin())&&(t.getY()<T.getYmax())) {
                this.P2 = new Point(t.getX(), t.getY());
                if(sélectionnerNoeud(P2) != null){
                    this.P2 = new Point(sélectionnerNoeud(P2).getAbscisse(), sélectionnerNoeud(P2).getOrdonnee());
                }
                else{
                    Treillis model = this.vue.getModel();
                    model.add(this.P2);
                    this.vue.redrawAll();
                }
                this.etat = 82;
            }
            
        } else if (this.etat == 82) {
            if((t.getX()>T.getXmin())&&(t.getX()<T.getXmax())&&(t.getY()>T.getYmin())&&(t.getY()<T.getYmax())) {
                this.P3 = new Point(t.getX(), t.getY());
                Treillis model = this.vue.getModel();
                if(sélectionnerNoeud(P3) != null){
                    this.P3 = new Point(sélectionnerNoeud(P3).getAbscisse(), sélectionnerNoeud(P3).getOrdonnee());
                }
                else{
                    model.add(this.P3);
                }
                model.add(new TriangleTerrain(P1, P2, P3));
                this.vue.redrawAll();
                this.vue.getbSauvegarde().setDisable(false);
                this.etat = 80;
            }
        }
    }
    
    void déplacementSouris(MouseEvent t){
        if(this.etat == 11){
            Point P = new Point(t.getX(), t.getY());
            double xmin = min(this.P1.px, P.px);
            double xmax = max(this.P1.px, P.px);
            double ymin = min(this.P1.py, P.py);
            double ymax = max(this.P1.py, P.py);
            this.T = new Terrain(xmin, xmax, ymin, ymax);
            
            Treillis model = this.vue.getModel();
            model.add(T);
            this.vue.redrawAll();
            model.remove(T);
            
        } else if(this.etat == 20) {
            Treillis model = this.vue.getModel();
            Point emplacement = new Point(t.getX(), t.getY());
            SegmentTerrain SegmentPlusProche = placementAppui(emplacement);
            
            if((SegmentPlusProche == this.ST1)&&(t.getX()>=T.getXmin())&&(t.getX()<=T.getXmax())){
                NoeudAppuiSimple NAS = new NoeudAppuiSimple(t.getX(), this.P1.py);
                model.add(NAS);
                this.vue.redrawAll();
                model.remove(NAS);
            }
            else if((SegmentPlusProche == this.ST2)&&(t.getY()>=T.getYmin())&&(t.getY()<=T.getYmax())){
                NoeudAppuiSimple NAS = new NoeudAppuiSimple(this.P2.px, t.getY());
                model.add(NAS);
                this.vue.redrawAll();
                model.remove(NAS);
            }
            else if((SegmentPlusProche == this.ST3)&&(t.getX()>=T.getXmin())&&(t.getX()<=T.getXmax())){
                NoeudAppuiSimple NAS = new NoeudAppuiSimple(t.getX(), this.P3.py);
                model.add(NAS);
                this.vue.redrawAll();
                model.remove(NAS);
            }
            else if((SegmentPlusProche == this.ST4)&&(t.getY()>=T.getYmin())&&(t.getY()<=T.getYmax())){
                NoeudAppuiSimple NAS = new NoeudAppuiSimple(this.P4.px, t.getY());
                model.add(NAS);
                this.vue.redrawAll();
                model.remove(NAS);
            }
            else{
                this.vue.redrawAll();
            }
            
        } else if(this.etat == 30) {
            Treillis model = this.vue.getModel();
            Point emplacement = new Point(t.getX(), t.getY());
            SegmentTerrain SegmentPlusProche = placementAppui(emplacement);
            
            if((SegmentPlusProche == this.ST1)&&(t.getX()>=T.getXmin())&&(t.getX()<=T.getXmax())){
                NoeudAppuiDouble NAD = new NoeudAppuiDouble(t.getX(), this.P1.py);
                model.add(NAD);
                this.vue.redrawAll();
                model.remove(NAD);
            }
            else if((SegmentPlusProche == this.ST2)&&(t.getY()>=T.getYmin())&&(t.getY()<=T.getYmax())){
                NoeudAppuiDouble NAD = new NoeudAppuiDouble(this.P2.px, t.getY());
                model.add(NAD);
                this.vue.redrawAll();
                model.remove(NAD);
            }
            else if((SegmentPlusProche == this.ST3)&&(t.getX()>=T.getXmin())&&(t.getX()<=T.getXmax())){
                NoeudAppuiDouble NAD = new NoeudAppuiDouble(t.getX(), this.P3.py);
                model.add(NAD);
                this.vue.redrawAll();
                model.remove(NAD);
            }
            else if((SegmentPlusProche == this.ST4)&&(t.getY()>=T.getYmin())&&(t.getY()<=T.getYmax())){
                NoeudAppuiDouble NAD = new NoeudAppuiDouble(this.P4.px, t.getY());
                model.add(NAD);
                this.vue.redrawAll();
                model.remove(NAD);
            }
            else{
                this.vue.redrawAll();
            }
        
        } else if(this.etat == 40) {
            Treillis model = this.vue.getModel();
            Point emplacement = new Point(t.getX(), t.getY());
            SegmentTerrain SegmentPlusProche = placementAppui(emplacement);
            
            if((SegmentPlusProche == this.ST1)&&(t.getX()>=T.getXmin())&&(t.getX()<=T.getXmax())){
                NoeudAppuiEncastrement NAE = new NoeudAppuiEncastrement(t.getX(), this.P1.py);
                model.add(NAE);
                this.vue.redrawAll();
                model.remove(NAE);
            }
            else if((SegmentPlusProche == this.ST2)&&(t.getY()>=T.getYmin())&&(t.getY()<=T.getYmax())){
                NoeudAppuiEncastrement NAE = new NoeudAppuiEncastrement(this.P2.px, t.getY());
                model.add(NAE);
                this.vue.redrawAll();
                model.remove(NAE);
            }
            else if((SegmentPlusProche == this.ST3)&&(t.getX()>=T.getXmin())&&(t.getX()<=T.getXmax())){
                NoeudAppuiEncastrement NAE = new NoeudAppuiEncastrement(t.getX(), this.P3.py);
                model.add(NAE);
                this.vue.redrawAll();
                model.remove(NAE);
            }
            else if((SegmentPlusProche == this.ST4)&&(t.getY()>=T.getYmin())&&(t.getY()<=T.getYmax())){
                NoeudAppuiEncastrement NAE = new NoeudAppuiEncastrement(this.P4.px, t.getY());
                model.add(NAE);
                this.vue.redrawAll();
                model.remove(NAE);
            }
            else{
                this.vue.redrawAll();
            }
            
        } else if(this.etat == 50) {  
            if((t.getX()>T.getXmin()+20)&&(t.getX()<T.getXmax()-20)&&(t.getY()>T.getYmin()+20)&&(t.getY()<T.getYmax()-20)) {
                Treillis model = this.vue.getModel();
                NoeudSimple NS = new NoeudSimple(t.getX(), t.getY());
                model.add(NS);
                this.vue.redrawAll();
                model.remove(NS);
            }
            else{
                this.vue.redrawAll();
            }
            
        } else if(this.etat == 81) { 
            if((t.getX()>T.getXmin())&&(t.getX()<T.getXmax())&&(t.getY()>T.getYmin())&&(t.getY()<T.getYmax())) {
                Treillis model = this.vue.getModel();
                SegmentTerrain ST = new SegmentTerrain(this.P1, new Point(t.getX(), t.getY()));
                model.add(ST);
                this.vue.redrawAll();
                model.remove(ST);
            }
            else{
                this.vue.redrawAll();
            }
            
        } else if(this.etat == 82) { 
            if((t.getX()>T.getXmin())&&(t.getX()<T.getXmax())&&(t.getY()>T.getYmin())&&(t.getY()<T.getYmax())) {
                Treillis model = this.vue.getModel();
                SegmentTerrain SegT1 = new SegmentTerrain(this.P1, this.P2);
                SegmentTerrain SegT2 = new SegmentTerrain(this.P1, new Point(t.getX(), t.getY()));
                SegmentTerrain SegT3 = new SegmentTerrain(this.P2, new Point(t.getX(), t.getY()));
                model.add(SegT1);
                model.add(SegT2);
                model.add(SegT3);
                this.vue.redrawAll();
                model.remove(SegT1);
                model.remove(SegT2);
                model.remove(SegT3);
            }
            else{
                this.vue.redrawAll();
            }
        }
    }
    
    public int matériau(){
        Color c = this.vue.getcDessin().getCouleur();
        if(c == Color.BLUE){
            return 1;
        }
        else if(c == Color.BROWN){
            return 2;
        }
        else if(c == Color.SILVER){
            return 3; 
        }
        else if(c == Color.GREY){
            return 4;
        }
        else if(c == Color.CHOCOLATE){
            return 5;
        }
        else{
            throw new Error("Il faut mettre 1, 2, 3, 4 ou 5");
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
        if(distanceMin < 50){
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
