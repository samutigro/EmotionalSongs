package EmotionalSongs;

import Database.Database;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.SQLException;
import static EmotionalSongs.Brani.popola;

public class ThreadPopola extends Thread {


    private final String user;
    private final String pwd;

    public ThreadPopola(String user, String pwd){
        this.user = user;
        this.pwd = pwd;
        this.start();
    }



    @Override
    public void run() {
        Database.setUser(user);
        Database.setPassword(pwd);
        Database db = null;
        try {
            db = Database.getInstance();
                popola(db);
                System.out.println("Completato");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
