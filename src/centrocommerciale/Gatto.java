/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrocommerciale;


public class Gatto extends Pet {
    
    public Gatto(String nomeNegozio, double valore, int ID, String tipoAnimale){
        super(nomeNegozio, valore, tipoAnimale, ID);        
    }       
    
    public String tipoAnimale(){
        return "Gatto";
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
