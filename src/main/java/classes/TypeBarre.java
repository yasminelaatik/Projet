package classes;

public class TypeBarre {
    private int identificateur;
    private Double cout;
    private Double lMin;
    private Double lMax;
    private Double rMaxT;
    private Double rMaxC;
            
    public TypeBarre(int identificateur){
        if ((identificateur < 1) | (identificateur > 5)) {
            throw new Error("l'identificateur doit valoir 1, 2, 3, 4 ou 5"); 
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
            this.cout = Catalogue.bois.get("bois").get(0) ;
            this.lMin = Catalogue.bois.get("bois").get(1) ;
            this.lMax = Catalogue.bois.get("bois").get(2) ;
            this.rMaxC = Catalogue.bois.get("bois").get(3) ;
            this.rMaxT= Catalogue.bois.get("bois").get(4) ;
        }
        if (identificateur == 3) {
            this.cout = Catalogue.aluminium.get("aluminium").get(0) ;
            this.lMin = Catalogue.aluminium.get("aluminium").get(1) ;
            this.lMax = Catalogue.aluminium.get("aluminium").get(2) ;
            this.rMaxC = Catalogue.aluminium.get("aluminium").get(3) ;
            this.rMaxT= Catalogue.aluminium.get("aluminium").get(4) ;
        }
        if (identificateur == 4) {
            this.cout = Catalogue.béton.get("béton").get(0) ;
            this.lMin = Catalogue.béton.get("béton").get(1) ;
            this.lMax = Catalogue.béton.get("béton").get(2) ;
            this.rMaxC = Catalogue.béton.get("béton").get(3) ;
            this.rMaxT= Catalogue.béton.get("béton").get(4) ;
        }
        if (identificateur == 5) {
            this.cout = Catalogue.bronze.get("bronze").get(0) ;
            this.lMin = Catalogue.bronze.get("bronze").get(1) ;
            this.lMax = Catalogue.bronze.get("bronze").get(2) ;
            this.rMaxC = Catalogue.bronze.get("bronze").get(3) ;
            this.rMaxT= Catalogue.bronze.get("bronze").get(4) ;
        }
    }
    
}
