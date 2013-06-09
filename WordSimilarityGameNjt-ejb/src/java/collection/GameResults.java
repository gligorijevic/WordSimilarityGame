/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.util.ArrayList;
import model.PlayerOld;

/**
 *
 * @author Djordje Gligorijevic
 */
public class GameResults {
    private PlayerOld player;
    private ArrayList<String[]> results = new ArrayList<String[]>();
    
    private GameResults() {
    }
    
    public static GameResults getInstance() {
        return GameResultsHolder.INSTANCE;
    }

    /**
     * @return the player
     */
    public PlayerOld getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(PlayerOld player) {
        this.player = player;
    }

    /**
     * @return the results
     */
    public ArrayList<String[]> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(ArrayList<String[]> results) {
        this.results = results;
    }

    public void addResult(String[] variableToBeStored) {
        results.add(variableToBeStored);
    }
    
    private static class GameResultsHolder {

        private static final GameResults INSTANCE = new GameResults();
    }
    
    
    
}
