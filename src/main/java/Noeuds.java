public class Noeuds {
    int identificateur;
    
    public Noeuds (int identificateur){
        this.identificateur = identificateur; 
    }

    public int getIdentificateur() {
        return identificateur;
    }

    public void setIdentificateur(int identificateur) {
        this.identificateur = identificateur;
    }

    @Override
    public String toString() {
        return "Noeuds{identificateur=" + identificateur + '}';
    }
    
    
}
