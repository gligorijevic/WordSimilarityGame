/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import game.LoadData;
import java.io.FileNotFoundException;
import java.io.IOException;
import model.Player;

/**
 *
 * @author Djordje Gligorijevic
 */
public class Tests {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        LoadData.getGameDataJPA2("C:\\Users\\gligo_000\\Desktop\\ds2.csv");
//        Player p = new Player();
//        p.setUsername("Djole");
//        if (DBBroker.getInstance().doesPlayerExists(p)) {
//            System.out.println("Djole");
//        }
    }
}
