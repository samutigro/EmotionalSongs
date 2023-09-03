package EmotionalSongs;

import Database.*;
import Database.serverES;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.jar.JarEntry;

import static Database.CreateDatabase.CreaDb;

public class EmotionalSongs {
    public static void main(String[] args) {
       CreaDb("postgres","admin");
    }
}