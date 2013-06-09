package collection;

import exception.PlayerNotRegistered;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.PlayerOld;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Djordje Gligorijevic
 */
public class PlayerCollection {

    private List<PlayerOld> players = new ArrayList<PlayerOld>();

    private PlayerCollection() {
        ucitajSveIgrace();
    }

    public static PlayerCollection getInstance() {
        return PlayerCollectionHolder.INSTANCE;
    }

    private static class PlayerCollectionHolder {

        private static final PlayerCollection INSTANCE = new PlayerCollection();
    }

    public void addPlayer(PlayerOld player) {
        players.add(player);
    }

    public void setPlayers(List<PlayerOld> players) {
        this.players = players;
    }

    public PlayerOld getPlayer(PlayerOld player) {
        for (PlayerOld p : players) {
            if (p.equals(player)) {
                System.out.println("Ulogovan igrac je>"+p);
                System.out.println("Neulogovan igrac je>"+player);
                
                return p;
            }
        }
        return null;
    }

    public List<PlayerOld> getPlayers() {
        return players;
    }

    public PlayerOld playerInList(PlayerOld player) throws PlayerNotRegistered {
        if (players.contains(player)) {
            for (PlayerOld p : players) {
                if (p.equals(player)) {
                    System.err.println("Ulogovani igrac je: " + p);
                    return p;
                }
            }
        } else {
            throw new PlayerNotRegistered("Player is not registered!");
        }
        return null;

    }

    public void ucitajSveIgrace() {
        System.err.println("Ucitavanje svih igraca!");
        FileInputStream fis = null;
        try {
            //fis = new FileInputStream("players.out");
            fis = new FileInputStream("C:\\Users\\gligo_000\\Desktop\\players.out");

            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                players = (ArrayList<PlayerOld>) ois.readObject();
                System.err.println("```````"+players.size()+" igraca´´´´´´");
            } catch (ClassNotFoundException ex) {
                players = new ArrayList<PlayerOld>();
            }
            ois.close();
        } catch (FileNotFoundException ex) {
            //          Logger.getLogger(PlayerCollection.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("NIJE NASAOOOOOOOOOOOOOOOOOOO FAJL");
            players = new ArrayList<PlayerOld>();
        } catch (IOException ex) {
//            Logger.getLogger(PlayerCollection.class.getName()).log(Level.SEVERE, null, ex);
            players = new ArrayList<PlayerOld>();
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
//                Logger.getLogger(PlayerCollection.class.getName()).log(Level.SEVERE, null, ex);
                players = new ArrayList<PlayerOld>();
            }
        }
    }

    public void sacuvajSveIgrace() throws FileNotFoundException, IOException {
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\gligo_000\\Desktop\\players.out");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(players);
        out.close();
        fileOut.close();
    }
}
