package EmotionalSongs;

import Database.*;
import Database.serverES;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.jar.JarEntry;
import static Database.CreateDatabase.CreaDb;
import static EmotionalSongs.Brani.popola;

public class EmotionalSongs {
    static String user ;
    static String pwd ;
    public static Boolean flag;

    public static void main(String[] args) throws SQLException, IOException, NotBoundException {
        // Creazione del frame principale
        JFrame frame = new JFrame("Input String");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(null);

        // Etichette per le stringhe
        JLabel label1 = new JLabel("Inserire username Postgres: ");
        label1.setBounds(10, 20, 200, 20);
        frame.add(label1);

        JLabel label2 = new JLabel("Inserire Password Postgres: ");
        label2.setBounds(10, 60, 200, 20);
        frame.add(label2);

        // Campi di testo per l'input delle stringhe
        JTextField textField1 = new JTextField(40);
        textField1.setBounds(200, 20, 100, 20);
        frame.add(textField1);

        JTextField textField2 = new JTextField(40);
        textField2.setBounds(200, 60, 100, 20);
        frame.add(textField2);

        // Bottone per confermare l'input
        JButton button = new JButton("Conferma");
        button.setBounds(100, 100, 100, 30);
        frame.add(button);

        // Azione del bottone
        button.addActionListener(e -> {
            frame.setVisible(false);
             user = textField1.getText();
             pwd = textField2.getText();
            Database.setUser(user);
            Database.setPassword(pwd);

            try {
                flag = CreaDb(user,pwd);
                System.out.println(flag);
                Database db = Database.getInstance();
                serverES serverImpl = new serverES();
                Registry registry = LocateRegistry.createRegistry(8999);
                registry.rebind("SERVER", serverImpl);

                clientES emsong = new clientES();
            } catch (org.postgresql.util.PSQLException ex) {
                JOptionPane.showMessageDialog(null, "Errore di autenticazione: " + ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (AccessException ex) {
                throw new RuntimeException(ex);
            } catch (NotBoundException ex) {
                throw new RuntimeException(ex);
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }


            if(flag!=true){
                String currentDirectory = System.getProperty("user.dir");
                System.out.println("Current Directory: " + currentDirectory);
                ThreadPopola t = new ThreadPopola(user,pwd);
            }

        });

        // Mostra il frame
        frame.setSize(350,200);
        frame.setVisible(true);


    }
}

