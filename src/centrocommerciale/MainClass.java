
package centrocommerciale;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


public class MainClass {
    
    private static CentroCommerciale database;
    private static Scanner in = null;
    
    public static void main(String[] args) throws IOException{
        
        boolean quit = false;
        in = new Scanner(System.in);
        database = new CentroCommerciale();
        
        while(!quit){
            System.out.println("\n** BENVENUTI AL CENTRO COMMERCIALE 'MOLL' **\n");
            
            System.out.println("Scegliere \n1. Cliente \n2.Amministratore \n>> ");
            int scelta = in.nextInt();
            if (scelta == 1){
                String menu2 = 
                       "\n***** MENU CLIENTE*******\n" 
                    + "1. Visualizza Prodotti Di Un Negozio: \n"
                    + "2. Cerca Prodotti tramite ID: \n"
                    + "3. Visualizza tutti i prodotti: \n"
                    + "4. Panoramica del Centro-Commerciale: \n"                    
                    + "5. Indietro. \n"
                    + "6. Esci.\n" 
                    + ">>"
                    + "";
                
                System.out.print(menu2);
                boolean goodInput = false;
                int choice = getIntChoice(1,6);
                switch(choice){
                    case 1:
                        viewByShop();
                        break;
                    case 2:
                        viewByProdID();
                        break;
                    case 3:
                        viewAll();
                        break;
                    case 4: Info();
                        break;
                    case 5:                        
                        break;
                    case 6:
                        quit = true;
                        break;
                    default:
                    System.err.println("Errore: "
                                    + " Scelta non valida.");
                }
            }else if(scelta == 2){
                System.out.println("Inserisci password: ");
                int passwd = in.nextInt();
                
                if(passwd == 1234){
                    System.out.println("Password Accettata...\n Accesso in corso...");
                    
                    String menu3 = 
                            "\n***** MENU AMMINISTARTORE*****\n"
                            + "1. Aggiungi Prodotto: \n"
                            + "2. Rimuovi Prodotto: \n"
                            + "3. Carica dati dal Database: \n"
                            + "4. Esci\n"
                            + ">>";
                    
                    System.out.print(menu3);
                    int choice = getIntChoice(1,4);
                    switch(choice){
                        case 1:
                            aggiungiProdotto();
                            saveToFile();
                            break;
                        case 2:
                            rimuoviProdotto();
                            break;
                        case 3:
                            loadFromFile();
                            
                            break;
                        case 4:                            
                            break;
                         default:
                         System.err.println("Errore: "
                                        + " Scelta non valida.");                        
                    }                            
                }else
                    System.err.print("Password Errata...Ritenta \n");
            }          
        }
    }
    
    private static int getIntChoice(int low, int high){
        boolean Input = false;
        int choice = low - 1;
        while(!Input){
            choice = in.nextInt();
            in.nextLine();
            Input = choice >= low && choice <= high;
            if(!Input){
                System.err.println("Scegliere un numero compreso da " +
                        " " + low + " a " + high + ".");
                System.out.print("> ");
            }
        }
        return choice;
    }
    
    private static void aggiungiProdotto(){
        String menu = 
                "Seleziona in quale negozio si vuole aggungere un prodotto: \n" +
                "1. FootLocker \n" +
                "2. Eventi & Cerimonie \n" +
                "3. HerbaLife \n" +
                "4. McDonald \n" +
                "5. Pet\n" +
                "> ";
        System.out.print(menu);
        
        try{
            int choice = getIntChoice(1, 5);
            int aux=0;
            
            System.out.print("Valore del prodotto: ");
            double valore = in.nextDouble();
            in.nextLine();
            Negozio newNegozio = null;
            
            switch(choice){
                case 1:
                    String nome = "FootLocker";
                    System.out.print(" Tipo Prodotto: ");
                    String appType = in.next();
                    System.out.print("Genere del prodotto (M/F)");
                    String genere;
                    genere = in.next();
                    char genere2 = genere.charAt(0);
                    List tuttiProd = database.getAll();
                    if(tuttiProd.isEmpty()) {//se non ci sono oggetti creati non ha senso chiamare viewID perchè darebbe sempre -1
                        newNegozio = new FootLocker(nome, valore, appType,genere2, 1);
                    }    
                    else {
                        aux = viewID();
                        aux++;
                        newNegozio = new FootLocker(nome, valore, appType,genere2, aux);
                    }    
                    break;
                    
                case 2:
                    nome = "Eventi&Cerimonie";
                    System.out.print("Tipo Prodotto(Abiti o Accessori): ");
                    appType = in.nextLine();
                    System.out.print("Genere del prodotto(M/F): ");
                    genere = in.nextLine();
                    genere2 = genere.charAt(0);
                    tuttiProd = database.getAll();
                    if(tuttiProd.isEmpty()) {//se non ci sono oggetti creati non ha senso chiamare viewID perchè darebbe sempre -1
                        newNegozio = new EventieCerimonie(nome, valore, appType,genere2, 2);
                    }    
                    else {
                        aux = viewID();
                        aux++;
                        newNegozio = new EventieCerimonie(nome, valore, appType,genere2, aux);
                    }    
                    break;
                case 3:
                    nome = "HerbaLife";
                    System.out.print("Tipo Prodotto : ");
                    appType = in.nextLine();
                    tuttiProd = database.getAll();
                    if(tuttiProd.isEmpty()) {//se non ci sono oggetti creati non ha senso chiamare viewID perchè darebbe sempre -1
                        newNegozio = new Herbalife(nome, valore, appType, 1);
                    }    
                    else {
                        aux = viewID();
                        aux++;
                        newNegozio = new Herbalife(nome, valore, appType, aux);
                    }
                    break;
                case 4:
                    nome = "McDonald";
                    System.out.print("Aggiungi un nuovo menù: ");
                    appType = in.nextLine();
                    tuttiProd = database.getAll();
                    if(tuttiProd.isEmpty()) {//se non ci sono oggetti creati non ha senso chiamare viewID perchè darebbe sempre -1
                        newNegozio = new McDonald(nome, valore, appType, 1);
                    }    
                    else {
                        aux = viewID();
                        aux++;
                        newNegozio = new McDonald(nome, valore, appType, aux);
                    }
                    break;
                case 5:
                    nome = "Pet";
                    System.out.print("Aggiungi un tipo di animale (Cane o Gatto): ");
                    appType = in.nextLine();
                    tuttiProd = database.getAll();
                    if(tuttiProd.isEmpty()) {//se non ci sono oggetti creati non ha senso chiamare viewID perchè darebbe sempre -1
                        if (appType.equals("cane") || (appType.equals("Cane"))) {
                            newNegozio = new Cane(nome, valore, 1, appType);
                    }else if(appType.equals("gatto") || (appType.equals("Gatto"))) {
                            newNegozio = new Gatto(nome, valore, 1, appType);
                           }
                    }    
                    else {
                        aux = viewID();
                        aux++;
                        if (appType.equals("cane")) {
                            newNegozio = new Cane(nome, valore, aux, appType);
                    }else if(appType.equals("gatto")) {
                            newNegozio = new Gatto(nome, valore, aux, appType);
                           }
                    }
                    break;
                    
                default:
                    System.err.print("Errore");
            }
            database.addProdotto(newNegozio);
        }catch(Exception e){
            System.out.println("Impossibile aggiungere il prodotto: " + e.getMessage());
        }
    }
    
    public static void rimuoviProdotto(){
        System.out.println("Prodotto ID :");
        int id = in.nextInt();
        in.nextLine();
        database.removeProdotto(id);
        System.out.println("Il Prodotto con ID: " + id + "è stato rimosso con successo!");
        
    }
    
    private static void viewByShop() {
        System.out.print("Nome Negozio: ");
        String nome = in.nextLine();
        List negozi = database.getProdottiNegozio(nome);
        if(negozi == null){
            System.out.print(nome + " non appartiene al centro commerciale");
        }else{
            System.out.println("Prodotti del negozio: " + nome);
            int i = 1;
            Iterator iter = negozi.iterator();
            while(iter.hasNext()){
                System.out.println("" + i + ">"
                        + iter.next().toString());
                i = i + 1;
            }
        }
    }
    
    private static void viewByProdID(){
        System.out.print("ID Prodotto: ");
        int trackID = Integer.parseInt(in.nextLine());
        Negozio negozio = database.getProdottoByID(trackID);
        if(negozio == null){
            System.out.println("Non ci sono prodotti con questo codice ID..");
        }else{
            System.out.println(negozio);
        }
    }
      
    //metodo che restituisce l'ultimo ID dei prodotti aggiuti, và usato con loadfromFile
        public static int viewID(){
       
        List tuttiProd = database.getAll();
        int id=-1;
       
        if(tuttiProd.isEmpty()){
            System.out.println("Il database è vuoto");
        }
        else
        {
            Iterator iter = tuttiProd.iterator();        
            while(iter.hasNext()){                
                Negozio negozio= (Negozio) iter.next();
                id = negozio.getProdottoID();
            }
        }
        return id;
    }
    
    public static void viewAll(){
        List tuttiProd = database.getAll();
        if(tuttiProd.isEmpty()){
            System.out.println("Non ci sono prodotti nel database");
        }else{
            //Collections.sort(tuttiProd);
            Iterator iter = tuttiProd.iterator();
            while(iter.hasNext()){
                System.out.println(iter.next());
            }
        }
    }
   
    public static void Info() {
        Negozio[] a = new Negozio[5];
        a[0] = new McDonald(null,0.0, null,0);
        a[1] = new FootLocker(null,0.0, null,'n',0);
        a[2] = new Herbalife(null,0.0, null,0);
        a[3] = new EventieCerimonie(null,0.0, null,'n',0);
        a[4] = new Cane(null,0.0,0,null);
        System.out.print("PANORAMICA DEI NOSTRI NEGOZI:\n");
            for(int i=0; i<5; i++) {
            System.out.print(">> " + a[i].Info() + "\n");
            }
    }
    
     
    
    public static void saveToFile(){
        ObjectOutputStream oos = null;
        try{
            
            FileOutputStream f = new FileOutputStream("Dati.dat");
            oos = new ObjectOutputStream(f);
            oos.writeObject(database);
            System.out.println("Prodotti salvati nel file: ");
            oos.flush();
            f.close();
            
        }catch(IOException e){
            System.err.println("Errore salvataggio file " + e.getMessage());
        }
    }
    
     public static void loadFromFile() throws IOException{
        ObjectInputStream ois = null;
        
        try{
            
            String filename = ("Dati.dat");
            
            ois = new ObjectInputStream(new FileInputStream(filename));
            database = (CentroCommerciale)ois.readObject();
            System.out.println("File Caricato Correttamente");
            
        }catch(IOException ioe){
            System.err.println( "Impossibile caricare file dal database: "
				+ ioe.getMessage() );
	}
	catch ( ClassCastException cce ) {
	    System.err.println( "Backup fallito." );
	}
	catch ( ClassNotFoundException cnfe ) {
	    System.err.println( "Prodotti del database non corrispondono");
	}
        
        finally{
            if(ois != null){
                try{
                    ois.close();
                }
                catch(IOException e){
                    System.err.println("Errore nella chiusura del database" + e.getMessage());   
                }
            }
        }
    }
    
    
    
}
