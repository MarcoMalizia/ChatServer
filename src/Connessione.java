import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Marco on 06/10/2014.
 */
public class Connessione {
    private Socket sc;
    private DataOutputStream dos;
    private DataInputStream dis;


    public Connessione (Socket sc) throws IOException {
        this.sc=sc;
        this.dis = new DataInputStream(sc.getInputStream());
        this.dos = new DataOutputStream(sc.getOutputStream());
    }

    public String receiveMessage () throws IOException {
        return this.dis.readUTF();
    }

    public void sendMessage (String messaggio) throws IOException {
        this.dos.writeUTF(messaggio);
    }

    public Socket getSc() {
        return sc;
    }

    public String ascolto() throws IOException {
        String messaggio = this.receiveMessage();
        return messaggio;
    }

    public void  connetti (Connessione con,String nome) throws IOException {
        con.sendMessage("Connessione al server avvenuta con successo");
        System.out.println("connessione ricevuta da " + nome + " - " + con.getSc().getInetAddress());

    }


}
