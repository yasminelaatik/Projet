package classes;


import classes.Catalogue;

public class TypeBarre {
    private int identificateur;
    private Double cout;
    private Double lMin;
    private Double lMax;
    private Double rMaxT;
    private Double rMaxC;
            
    public TypeBarre(int identificateur){
        if ((identificateur < 1) | (identificateur > 5)) {
            throw new Error("bah non en faite") ;
        }
        this.identificateur = identificateur;
        if (identificateur == 1) {
            this.cout = Catalogue.acier.get("acier").get(0) ;
            this.lMin = Catalogue.acier.get("acier").get(1) ;
            this.lMax = Catalogue.acier.get("acier").get(2) ;
            this.rMaxC = Catalogue.acier.get("acier").get(3) ;
            this.rMaxT= Catalogue.acier.get("acier").get(4) ;
        }
        if (identificateur == 2) {
            this.cout = Catalogue.bois.get("acier").get(0) ;
            this.lMin = Catalogue.bois.get("acier").get(1) ;
            this.lMax = Catalogue.bois.get("acier").get(2) ;
            this.rMaxC = Catalogue.bois.get("acier").get(3) ;
            this.rMaxT= Catalogue.bois.get("acier").get(4) ;
        }
        if (identificateur == 3) {
            this.cout = Catalogue.aluminium.get("acier").get(0) ;
            this.lMin = Catalogue.aluminium.get("acier").get(1) ;
            this.lMax = Catalogue.aluminium.get("acier").get(2) ;
            this.rMaxC = Catalogue.aluminium.get("acier").get(3) ;
            this.rMaxT= Catalogue.aluminium.get("acier").get(4) ;
        }
        if (identificateur == 4) {
            this.cout = Catalogue.béton.get("acier").get(0) ;
            this.lMin = Catalogue.béton.get("acier").get(1) ;
            this.lMax = Catalogue.béton.get("acier").get(2) ;
            this.rMaxC = Catalogue.béton.get("acier").get(3) ;
            this.rMaxT= Catalogue.béton.get("acier").get(4) ;
        }
        if (identificateur == 5) {
            this.cout = Catalogue.bronze.get("acier").get(0) ;
            this.lMin = Catalogue.bronze.get("acier").get(1) ;
            this.lMax = Catalogue.bronze.get("acier").get(2) ;
            this.rMaxC = Catalogue.bronze.get("acier").get(3) ;
            this.rMaxT= Catalogue.bronze.get("acier").get(4) ;
        }
    }
    
}
