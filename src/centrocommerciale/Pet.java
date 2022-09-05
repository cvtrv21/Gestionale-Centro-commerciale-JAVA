
package centrocommerciale;
    
    public abstract class Pet extends Negozio {
    
    
    
    Pet(String nomeNegozio, double valore, String tipoAnimale, int ID){
        super(nomeNegozio, valore, ID);
        
                
    }
    
    public abstract String tipoAnimale();
    public abstract int anni();
    public abstract String toString();
    public abstract String Info();
    
    public String getUbicazione(){
        return "Lotto 5";
    }
    
    public String getDescrizione(){
         return "Pet è un Animal-Center che si occupa della vendita di cani e gatti.";                 
    }
    
    public String presentati() {
        
        return "Tipo Animale: " + tipoAnimale() + "\tAnni: " + anni() + "\tValore: " + getValore();
    }
    
}
    

