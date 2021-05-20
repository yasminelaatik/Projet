package classes;

import java.util.ArrayList;
import java.util.List;

public class Treillis {
    private List<Barre> liste;
    public static int identificateur;
    
    public static int idT = 0;

    public Treillis(){
        idT++;
        this.identificateur = idT;
        this.liste = new ArrayList<Barre>();
    }

    public void add(Barre b){
        if(b.getidTreillis() != this.identificateur){
            throw new Error("la barre est déjà dans un autre treillis");
        }
        this.liste.add(b);
        b.setidTreillis(this.identificateur);
    }
}