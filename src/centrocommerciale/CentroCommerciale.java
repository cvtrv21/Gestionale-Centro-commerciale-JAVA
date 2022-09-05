
package centrocommerciale;

import java.util.*;

public class CentroCommerciale implements java.io.Serializable {
    
    private Map ShopList;
    private Map ProdottoID;
    
    public CentroCommerciale(){
        ShopList = new HashMap();
        ProdottoID = new HashMap();
    }
    
    public void addProdotto(Negozio newNegozio){
        String nome = newNegozio.nomeNegozio;
        Integer trackID = new Integer(newNegozio.getProdottoID());
        
        if(ShopList.containsKey(nome)){
            List negozi = (List)ShopList.get(nome);
            negozi.add(newNegozio);
            
        }else{
            List negozi = new LinkedList();
            negozi.add(newNegozio);
            ShopList.put(nome, negozi);
        }
        ProdottoID.put(trackID, newNegozio);
    }
    
    
    public void removeProdotto(int prodID){
        Negozio negozio = getProdottoByID(prodID);        
        
        if(negozio != null){
            ProdottoID.remove(new Integer(prodID));
            List negozi = (List)ShopList.get(negozio.getNomeNegozio());
            negozi.remove(negozio);
        }
        else{
            System.err.println("Nessun prodotto con questo ID");
        }
    }
    
    
    
    public List getProdottiNegozio(String nomeNegozio){
        List retVal = null;
        if(ShopList.containsKey(nomeNegozio)){
            retVal = new ArrayList( (List)ShopList.get(nomeNegozio));
        }
        return retVal;
    }
     
    public Negozio getProdottoByID(int prodID){
        return (Negozio) ProdottoID.get(prodID);
    }
    
    public List getAll(){
        return new ArrayList(ProdottoID.values());
    }
    

   
    
}
