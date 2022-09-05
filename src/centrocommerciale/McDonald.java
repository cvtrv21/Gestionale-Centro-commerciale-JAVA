
package centrocommerciale;


public class McDonald extends Negozio {
    private String tipoProdotto;
    private int tavoliDisponibili = 10;
    
    public McDonald(String nomeNegozio, double valore, String tipoProdotto, int ID){
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
                && ((McDonald)other).tipoProdotto.equals(this.tipoProdotto)
                && super.equals(other);
    }
    
    public String getUbicazione(){
        return "Lotto 4";
    }
    
    public String getDescrizione(){
         return "McDonald è il FastFood più adatto per te. Vieni ad assaggiare i nostri menù..";
                 
    }
    
    public String toString(){
        return  "\nNegozio : "  + getNomeNegozio() + "\t Prodotto: " + tipoProdotto + "\t ProdottoID: " + getProdottoID() + "\t Valore: " + getValore() + "\n";
    }
    
    public String Info(){
        return   getDescrizione() + "\n Ubicazione: " + getUbicazione() + "\n";
    }
    
    
    
}
