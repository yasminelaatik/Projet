package classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import classesRécupérées.Matrice;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Treillis extends Composants {
    
    private List<Barre> listeB;
    private List<Noeuds> listeN;
    private List<Composants> listeC;
    
    private int nbBarres;
    private int nbNoeuds;

    public Treillis(){
        this.listeB = new ArrayList<>();
        this.listeC = new ArrayList<>();
        this.listeN = new ArrayList<>(); 
    }
    
    public int getNbNoeuds(){
       nbNoeuds = listeN.size();
        return nbNoeuds;
    }
    public int getNbBarres (){
        nbBarres = listeB.size();
        return nbBarres;
    }
    public List<Composants> getListeC(){
        return listeC;
    }
    public List<Barre> getListeB(){
        return listeB;
    }
    public List<Noeuds> getListeN(){
        return listeN;
    }
    
    public void add(Composants c){
        listeC.add(c);
        c.setTreillis(this);
    }
    public void addB(Barre b){
        listeB.add(b);
    }
    public void addN(Noeuds n){
        listeN.add(n);
    }
    public void remove(Composants C) {
        listeC.remove(C);
        C.setTreillis(null);
    }
    
    //partie forces
    public double calculAlpha(Point p1, Point p2) {  
    double x;
    double y;
    double ALPHA=0;
    if(p1.getPx()>p2.getPx()){
        x=p1.getPx()-p2.getPx();
        if (p1.getPy()>p2.getPy()){
            y=p1.getPy()-p2.getPy();
            ALPHA= -1*(Math.PI-Math.atan2(y, x));
        }
        else if (p2.getPy()>=p1.getPy()){
            y=p2.getPy()-p1.getPy();
            ALPHA= Math.PI-Math.atan2(y, x);
        }
    }
    else if(p2.getPx()>p1.getPy()){
        x=p2.getPx()-p1.getPx();
        if (p2.getPy()>=p1.getPy()){
            y=p2.getPy()-p1.getPy();
                ALPHA= Math.atan2(y, x);
            }
        else if (p1.getPy()>p2.getPy()){
            y=p1.getPy()-p2.getPy();
            ALPHA= -1*Math.atan2(y, x);
            }
        }
        else if(p1.getPy()==p2.getPy()){
            if(p1.getPy()>p2.getPy()){
                return -Math.PI/2;
            }
            else{
                return Math.PI/2;
            }
        }
        return ALPHA;
    }
    
    public Matrice Forces(){
        int nb = this.listeB.size();
        int ns = this.listeN.size();
        int nAs=0;
        int nAd=0;
        
        for(int i=0; i<this.listeN.size(); i++){
            if(this.listeN.get(i) instanceof NoeudAppuiSimple){
                nAs ++;
            }
        }
        for(int i=0; i<this.listeN.size(); i++){
            if(this.listeN.get(i) instanceof NoeudAppuiDouble){
                nAd ++;
            }
        }
   
        double[][] coeffs = {{}};
        Matrice FORCES = new Matrice(2*ns, (2*ns)+1, coeffs);
        
        while (ns<FORCES.getNbrCol()-2){
        }
        
        return FORCES;   
    }
    
    public String toString(){
        String res="";
        res=res+"FINCATALOGUE"+"\n";
        for(int i=0; i<this.getListeN().size();i++){
            res=res+this.getListeN().get(i).toString()+"\n";
        }
        res=res+"FINNOEUDS"+"\n";
        for (int i=0; i<this.getListeB().size();i++){
            res=res+this.getListeB().get(i).toString()+"\n";
        }
        res=res+"FINBARRES";
        return res;
    }
    
    public void sauvegarder(File fichier) throws FileNotFoundException, IOException{
        //préparation du canal de lecture
        FileReader in = new FileReader(fichier);
        BufferedReader bR = new BufferedReader(in);
        long taille = fichier.length();
        //préparation du canal de sortie
        FileWriter out = new FileWriter(fichier);
        BufferedWriter bW = new BufferedWriter(out);
        //copie
        for(int i=0 ; i<taille ; i++){
            bW.write(bR.read());
        }
        //fermeture du canal
        bR.close();
        bW.close();
    }
    
    @Override
    public void construire(GraphicsContext context) {
        for (Composants C : this.listeC) {
            C.construire(context);
        }
    }
    @Override
    public void changerCouleur(Color c){
        for (Composants C : this.listeC) {
            C.changerCouleur(c);
        }
    }
    @Override
    public double distance(Point p){
        if (this.listeC.isEmpty()) {
            return new Point(0,0).distance(p);
        } else {
            double dist = this.listeC.get(0).distance(p);
            for (int i = 1; i < this.listeC.size(); i++) {
                double cur = this.listeC.get(i).distance(p);
                if (cur < dist) {
                    dist = cur;
                }
            }
            return dist;
        }
    } 
}