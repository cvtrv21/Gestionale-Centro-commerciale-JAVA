
package centrocommerciale;

import java.io.*;


public abstract class Negozio implements Comparable, Serializable {
    
    private static int nextID;
    
    protected String nomeNegozio;   
    protected int prodottoID;
    protected double valore;
    
    static{
        nextID = 1;               
    }
    
    public Negozio(String nomeNegozio, double mioValore, int nextID){
        this.nomeNegozio = nomeNegozio;
        valore = mioValore;
        prodottoID = nextID;
        nextID++;
    }
    
    public void setNome(String mioNome){
        nomeNegozio = mioNome;
    }
    
    public void setValore(double mioValore){
        valore = mioValore;
    }
    
    public String getNomeNegozio(){
        return nomeNegozio;
    }
    
    public double getValore(){
        return valore;
    }
    
    public int getProdottoID(){
        return prodottoID;
    }
    
    public int compareTo(Object other){
        Negozio newNegozio = (Negozio)other;
        return prodottoID - newNegozio.prodottoID;
    }
    
    public boolean equals(Object other){
        boolean retVal = other instanceof Negozio;
        
        if(retVal){
            Negozio newNegozio = (Negozio)other;
            retVal =
                    this.prodottoID == newNegozio.prodottoID
                    && this.nomeNegozio.equals(newNegozio.nomeNegozio)
                    && this.valore == newNegozio.valore;
        }
        return retVal;
    }
    
    public abstract String toString();
    public abstract String Info();
    
}
