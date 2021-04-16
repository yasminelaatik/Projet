/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
import java.util.HashMap;
import java.util.List;

public class Catalogue { 
    
    public static void main(String[] args) {
        HashMap<Integer, String> type = new HashMap<>() ; 
        type.put(1, "acier") ;
        type.put(2, "bois") ;
        type.put(3, "aluminium") ;
        type.put(4, "béton") ;
        type.put(5, "bronze") ;
        for(int i=1 ; i<=5 ; i++){
            System.out.println(type.get(i));
        }        
    }
}

