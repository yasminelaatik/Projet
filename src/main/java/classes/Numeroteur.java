package classes;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Numeroteur<TO> {
    private TreeMap<Integer, TO> idVersObjet;
    private Map<TO, Integer> objetVersId;
    
    private int prochainID;
    
    private Numeroteur(int prochainID){
        this.idVersObjet = new TreeMap<>();
        this.objetVersId = new HashMap<>();
        this.prochainID = prochainID;
    }
    
    private Numeroteur(){
        this(0);
    }
    
    public int creerID(TO obj){
        if(this.objetVersId.containsKey(obj)){
            throw new Error("objet " + obj + " déjà dans le numéroteur");
        }
        this.idVersObjet.put(this.prochainID, obj);
        this.objetVersId.put(obj, this.prochainID);
        this.prochainID++ ;
        return this.prochainID - 1;
    }
    
    public boolean objExist(TO Obj){
        return this.objetVersId.containsKey(Obj);
    }
    
    public int getOuCreeID(TO obj){
        if (this.objExist(obj)){
            return this.objetVersId.get(obj);
        }
        else{
            return this.creerID(obj);
        }
    }
}
