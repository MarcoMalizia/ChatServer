import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Marco on 06/10/2014.
 */
public class Logger {
    Connessione con;
    Date date;

    public Logger (Connessione con){
        this.con = con;
        this.date = new Date();
    }
    public void connessioniLog() throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String data = dateFormat.format(date);
        String messaggioLog = con.getSc().getInetAddress()+" si è connesso alle ore "+data+"\n";
        Files.write(Paths.get("./Log/LogConnessioni.txt"), messaggioLog.getBytes(), StandardOpenOption.APPEND);
    }

    public void chatLog(String messaggio) throws IOException {
        Files.write(Paths.get("./Log/LogConnessioni.txt"), messaggio.getBytes(), StandardOpenOption.APPEND);
        System.out.println(messaggio);
    }
}
