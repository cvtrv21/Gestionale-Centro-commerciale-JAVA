
package centrocommerciale;


public class EventieCerimonie extends Negozio {
    private String tipoProdotto;
    private char genere;
    
    public EventieCerimonie(String nomeNegozio, double valore, String tipoProdotto, char genere, int ID){
        super(nomeNegozio, valore, ID);
        this.tipoProdotto = tipoProdotto;
        this.genere = genere;        
    }
    
    public void setTipoProdotto(String tipoProdotto){
        this.tipoProdotto = tipoProdotto;
    }
    
    public void setGenere(char genere){
        this.genere = genere;
    }
    
    public String getTipoProdotto(){
        return tipoProdotto;
    }
    
    public char getGenere(){
        return genere;
    }
    
    public boolean equals(Object other){
        return (other instanceof FootLocker)
                && ((EventieCerimonie)other).tipoProdotto.equals(this.tipoProdotto)
                && ((EventieCerimonie)other).genere ==(this.genere)
                && super.equals(other);
    }
    
    public String getUbicazione(){
        return "Lotto 2";
    }
    
    public String getDescrizione(){
         return "Abiti&Cerimonie è un lussuoso negozio di abiti da cerimonia";
    }
    
    public String toString(){
        return  "\nNegozio : "  + getNomeNegozio() + "\t Prodotto: " + tipoProdotto + "\t ProdottoID: " + getProdottoID() + "\t Valore: " + getValore() + "\n";
    }
    
    public String Info(){
        return   getDescrizione() + "\n Ubicazione: " + getUbicazione() + "\n";
    }
    
}
