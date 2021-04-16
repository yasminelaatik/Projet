package com.mycompany.projettreillis;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Catalogue { 
    
    public static HashMap<Integer, String> type() {
        HashMap<Integer, String> type = new HashMap<>() ; 
        type.put(1, "acier") ;
        type.put(2, "bois") ;
        type.put(3, "aluminium") ;
        type.put(4, "béton") ;
        type.put(5, "bronze") ;
        return type;
    }
        
    public static HashMap<String, List<Double>> attributs() {
        HashMap<String, List<Double>> attributs = new HashMap<>() ; 
        List<Double> acier = Arrays.asList(35.0, 2.42, 82.3, 89.75, 75.36);
        List<Double> bois = Arrays.asList(35.0, 2.42, 82.3, 89.75, 75.36);
        List<Double> aluminium = Arrays.asList(35.0, 2.42, 82.3, 89.75, 75.36);
        List<Double> béton = Arrays.asList(35.0, 2.42, 82.3, 89.75, 75.36);
        List<Double> bronze = Arrays.asList(35.0, 2.42, 82.3, 89.75, 75.36);
        attributs.put("acier", acier) ;
        attributs.put("bois", bois) ;
        attributs.put("aluminium", aluminium) ;
        attributs.put("béton", béton) ;
        attributs.put("bronze", bronze) ;
        return attributs;
    }
}

