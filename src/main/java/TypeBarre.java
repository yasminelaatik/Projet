public class TypeBarre {
    private int identificateur;
    private double cout;
    private double lMin;
    private double lMax;
    private double rMaxT;
    private double rMaxC;
    
    public TypeBarre(int identificateur, double cout, double lMin, double lMax, double rMaxT, double rMaxC ){
        this.identificateur= identificateur;
        this.cout = cout;
        this.lMin= lMin;
        this.lMax = lMax;
        this.rMaxC = rMaxC;
        this.rMaxT= rMaxT;
    }
    
}
