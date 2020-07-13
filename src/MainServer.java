
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Created by Marco on 06/10/2014.
 */
public class MainServer {

    public static void main(String[] args) throws IOException {
        String nome;
        ServerSocket ss = new ServerSocket(21025);
        while (true){
            Socket sc = ss.accept();
            Connessione con = new Connessione(sc);
            nome = con.receiveMessage();
            con.connetti(con,nome);
            ClientConnessi.aggiungiClient(nome,con);
            Logger log = new Logger(con);
            log.connessioniLog();
            new Thread(new Postino(con,nome)).start();
        }
    }
}
