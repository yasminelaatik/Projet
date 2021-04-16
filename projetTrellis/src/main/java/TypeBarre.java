package com.mycompany.projettreillis;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class TypeBarre extends Catalogue{
    private int identificateur;
    private double cout;
    private double lMin;
    private double lMax;
    private double rMaxT;
    private double rMaxC;
    
    public TypeBarre(int identificateur) {
        HashMap <Integer, String> type = type() ;
        String typeBarre = type.get(identificateur) ;
        HashMap <String, List<Double>> attributs = attributs() ;
        List<Double> matériau = attributs.get(typeBarre) ;
        
        this.cout = matériau.get(0);
        this.lMin = matériau.get(1);
        this.lMax = matériau.get(2);
        this.rMaxT = matériau.get(3);
        this.rMaxC = matériau.get(4) ;
    }
}
