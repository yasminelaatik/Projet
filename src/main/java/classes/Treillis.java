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

 

public class Treillis extends Composants {
    
    
    private List<Barre> listeB;
    private List<Noeuds> listeN;
    
    public static int identificateur;
    public static int nbBarres;
    public static int nbNoeuds;
    
    private static int idT = 0;

 

    public Treillis(){
        idT++;
        this.identificateur = idT;
        this.listeB = new ArrayList<Barre>();
        this.nbNoeuds = nbNoeuds;
        this.listeC = new ArrayList<>();
        this.listeN = new ArrayList<>();
       
    }
    
    
    public int getNbNoeuds(){
       this.nbNoeuds = this.listeN.size();
        return nbNoeuds;
    }

 

    public int getNbBarres (){
        this.nbBarres = this.listeB.size();
        return nbBarres;
    }
    
    public void addB(Barre b){
        if(b.getidTreillis() != this.identificateur){
            throw new Error("la barre est déjà dans un autre treillis");
        }
        this.listeB.add(b);
        b.setidTreillis(this.identificateur);
    }

 

    
    public List<Composants> listeC;
   
    private List<Noeuds> liste;
    
   
    public void add(Composants C){
         if (C.getTreillis() != this) {
            if (C.getTreillis() != null) {
                throw new Error("figure déja dans un autre groupe");
            }
            this.listeC.add(C);
            C.setTreillis(this);
        }
    }
    
    public void remove(Composants C) {
        if (C.getTreillis() != this) {
            throw new Error("la figure n'est pas dans le groupe");
        }
        this.listeC.remove(C);
        C.setTreillis(null);
    }
    
    public List<Composants> getListeC(){
        return this.listeC;
    }
    
    public List<Noeuds> getListeN(){
        return this.listeN;
    }
    
    public List<Barre> getListeB(){
        return this.listeB;
    }
    
     /**
     * @return the idT
     */
    public static int getIdT() {
        return idT;
    }

 

    /**
     * @param aIdT the idT to set
     */
    public static void setIdT(int aIdT) {
        idT = aIdT;
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
    
    
    
    public void sauvegarder(File fichier ){
         try{
             BufferedWriter o = new BufferedWriter(new FileWriter(fichier));
             o.write(this.toString());
             o.close();
         }
         catch(IOException erreur){
             System.out.println("Erreur dans l'écriture du fichier");
         }
     }
    
    
   
    public void addN(Noeuds n){
        if(n.getIdT() != this.identificateur){
            throw new Error("les noeud est déjà dans un autre treillis");
        }
        this.listeN.add(n);
        n.setIdT(this.identificateur);
    }
    
    
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
    
    
    @Override
    public double distance(Point p){
        if (this.listeC.isEmpty()) {
            return new Point().distance(p);
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