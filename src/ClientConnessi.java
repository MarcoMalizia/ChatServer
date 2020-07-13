import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Marco on 06/10/2014.
 */
public class ClientConnessi {

    public static HashMap<String,Connessione> clientMap = new HashMap<String,Connessione>();


    public static HashMap<String, Connessione> aggiungiClient (String nome,Connessione con) throws IOException {
        if (!clientMap.containsKey(nome)) {
            clientMap.put(nome,con);
        }
        else{
            System.out.println("client già esistente");
            con.sendMessage("Impossibile connettersi, client già esistente");
        }
        return clientMap;
    }


}
