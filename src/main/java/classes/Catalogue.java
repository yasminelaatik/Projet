package classes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Catalogue { 
    
    public static HashMap<String, List<Double>> acier = new HashMap<>() ;
    public static HashMap<String, List<Double>> bois = new HashMap<>() ;
    public static HashMap<String, List<Double>> aluminium = new HashMap<>() ;
    public static HashMap<String, List<Double>> béton = new HashMap<>() ;
    public static HashMap<String, List<Double>> bronze = new HashMap<>() ;
            
    public void Catalogue(){
        HashMap<Integer, String> catalogue = new HashMap<>() ; 
        catalogue.put(1, "acier") ;
        catalogue.put(2, "bois") ;
        catalogue.put(3, "aluminium") ;
        catalogue.put(4, "béton") ;
        catalogue.put(5, "bronze") ;
        for(int i=1 ; i<=5 ; i++){
            System.out.print(catalogue.get(i));
        }

        List<Double> caracacier = Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0);
        acier.put("acier", caracacier) ;
        
        List<Double> caracbois = Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0);
        bois.put("bois", caracbois) ;
       
        List<Double> caracaluminium = Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0);
        aluminium.put("aluminium", caracaluminium) ;
        
        List<Double> caracbéton = Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0);
        béton.put("béton", caracbéton) ;
        
        List<Double> caracbronze = Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0);
        bronze.put("béton", caracbronze) ;
        
    }
}