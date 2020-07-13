import java.io.IOException;
import java.util.Map;

/**
 * Created by Marco on 06/10/2014.
 */
public class Postino implements Runnable{
    private Connessione con;
    private String messaggio;
    private String nome;

    public Postino (Connessione con, String nome){
        this.con=con;
        this.nome=nome;
    }

    @Override
    public void run() {
        Logger log = new Logger(con);
        while (true){
            try {
                messaggio =nome+" ha scritto : "+ con.ascolto();
                String messaggioLog = con.getSc().getInetAddress()+" "+ messaggio+"\n";
                log.chatLog(messaggioLog);
                for (Map.Entry<String,Connessione> entry:ClientConnessi.clientMap.entrySet()) {
                    Connessione conn = entry.getValue();
                    conn.sendMessage(messaggio);
                }

            } catch (IOException e) {}
        }
    }
}
