
package centrocommerciale;


public class Herbalife extends Negozio {
    
    private String tipoProdotto;
    
    public Herbalife(String nomeNegozio, double valore, String tipoProdotto, int ID){
        super(nomeNegozio, valore, ID);
        this.tipoProdotto = tipoProdotto;               
    }
    
    public void setTipoProdotto(String tipoProdotto){
        this.tipoProdotto = tipoProdotto;
    }
    
    public String getTipoProdotto(){
        return tipoProdotto;
    }
    
    public boolean equals(Object other){
        return (other instanceof FootLocker)
                && ((Herbalife)other).tipoProdotto.equals(this.tipoProdotto)
                && super.equals(other);
    }
    
    public String getUbicazione(){
        return "Lotto 3";
    }
    
    public String getDescrizione(){
         return "Herbalife è un rivenditore che offre prodotti vegetali per Benessere & Salute";
    }
    
    public String toString(){
        return  "\nNegozio : "  + getNomeNegozio() + "\t Prodotto: " + tipoProdotto + "\t ProdottoID: " + getProdottoID() + "\t Valore: " + getValore() + "\n";
    }
    
    public String Info(){
        return   getDescrizione() + "\n Ubicazione: " + getUbicazione() + "\n";
    }
    
    
}
