
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */

    import java.util.ArrayList;
import java.util.List;

public class Treillis extends Barre{
    private List<Barre> liste;
          
public Treillis(){
    this.liste = new ArrayList<Barre>();
    
}
public void add(Barre b){
    if(b.getTreillis() != this){
        if(b.getTreillis()!= null){
            throw new Error("la barre est déjà dans un autre treillis");
        }
        this.liste.add(b);
        b.setTreillis(this);
}
    
}
}

