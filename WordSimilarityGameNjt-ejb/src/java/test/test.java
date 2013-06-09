/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.PlayerOld;

/**
 *
 * @author Djordje Gligorijevic
 */
public class test {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        List<PlayerOld> players = new ArrayList<PlayerOld>();
        players.add(new PlayerOld("Djordje", "Gligorijevic", "Djole", "Djole", "gligorijevic@outlook.com"));
        
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\gligo_000\\Desktop\\players.out");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(players);
        out.close();
        fileOut.close();
    }
}
