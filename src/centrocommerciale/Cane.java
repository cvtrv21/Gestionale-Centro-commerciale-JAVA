
package centrocommerciale;


public class Cane extends Pet{
    
    public Cane(String nomeNegozio, double valore, int ID, String tipoAnimale){
        super(nomeNegozio, valore, tipoAnimale, ID);        
    }       
    
    public String tipoAnimale(){
        return "Cane";
    }
    
    public int anni(){
        return (int) (Math.floor(Math.random() * 4) + 1);
    }
    
    public String toString(){
        return  "\nNegozio : "  + getNomeNegozio() + "\t ProdottoID: " + getProdottoID() + presentati();
    }
    public String Info(){
        return   getDescrizione() + "\n Ubicazione: " + getUbicazione() + "\n";
    }
    
    
}
