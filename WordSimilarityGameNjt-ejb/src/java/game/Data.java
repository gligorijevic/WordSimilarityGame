/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.List;
import model.MeasuredSimilarityOld;

/**
 *
 * @author Djordje Gligorijevic
 */
public class Data {

    private static List<String[]> gameData;
    private static List<MeasuredSimilarityOld> wsData;

    private Data() {
    }

    public static Data getInstance() {
        return DataHolder.INSTANCE;
    }

    /**
     * @return the gameData
     */
    public static List<String[]> getGameData() {
        return gameData;
    }

    /**
     * @param gameData the gameData to set
     */
    public static void setGameData(List<String[]> gameDataI) {
        gameData = gameDataI;
    }

    private static class DataHolder {

        private static final Data INSTANCE = new Data();
    }

    public static void setWsData(List<MeasuredSimilarityOld> wsData) {
        Data.wsData = wsData;
    }

    public static List<MeasuredSimilarityOld> getWsData() {
        return wsData;
    }
    

}
