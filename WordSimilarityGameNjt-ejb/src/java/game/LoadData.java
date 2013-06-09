/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import data.DBBroker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.ComputerMeasuredSimilarity;
import model.Dataset;
import model.MeasuredSimilarityOld;
import model.WordSimilarity;

/**
 *
 * @author Djordje Gligorijevic
 */
public class LoadData {

    @Deprecated
    public static List<MeasuredSimilarityOld> getGameData(String filePath) throws FileNotFoundException, IOException {
//        List<String[]> gameData = new ArrayList<String[]>();
        List<MeasuredSimilarityOld> dataForWSGame = new ArrayList<MeasuredSimilarityOld>();
        File data = new File(filePath);

        BufferedReader bufRdr = new BufferedReader(new FileReader(data));

        String line = null;
        int row = 0;
        while ((line = bufRdr.readLine()) != null) {
//            String[] row = null;
            MeasuredSimilarityOld ms = null;
            String[] elementsInLine = line.split(",");

            if (elementsInLine[0].contains("-") && row != 0) {
//                row = new String[]{elementsInLine[0].substring(1, elementsInLine[0].indexOf("-")),
//                    elementsInLine[0].substring(elementsInLine[0].indexOf("-") + 1,
//                    elementsInLine[0].length() - 1), elementsInLine[1], elementsInLine[2],
//                    elementsInLine[3], elementsInLine[4], elementsInLine[5], elementsInLine[6],
//                    elementsInLine[7], elementsInLine[8], elementsInLine[9], elementsInLine[10],
//                    elementsInLine[11], elementsInLine[12], elementsInLine[13], elementsInLine[14].substring(1, elementsInLine[14].length() - 1)};
                ms = new MeasuredSimilarityOld(elementsInLine[0].substring(1, elementsInLine[0].indexOf("-")), elementsInLine[0].substring(elementsInLine[0].indexOf("-") + 1, elementsInLine[0].length() - 2), -1,
                        Arrays.asList(new Double[]{Double.parseDouble(elementsInLine[1]),
                    Double.parseDouble(elementsInLine[2]),
                    Double.parseDouble(elementsInLine[3]),
                    Double.parseDouble(elementsInLine[4]),
                    Double.parseDouble(elementsInLine[5]),
                    Double.parseDouble(elementsInLine[6]),
                    Double.parseDouble(elementsInLine[7]),
                    Double.parseDouble(elementsInLine[8]),
                    Double.parseDouble(elementsInLine[9]),
                    Double.parseDouble(elementsInLine[10]),
                    Double.parseDouble(elementsInLine[11]),
                    Double.parseDouble(elementsInLine[12]),
                    Double.parseDouble(elementsInLine[13]),
                    Double.parseDouble(elementsInLine[14].substring(1, elementsInLine[14].length() - 1))}));
            }
//            gameData.add(row);
            dataForWSGame.add(ms);
            row++;
        }
        return dataForWSGame;
    }

    public static void getGameDataJPA(String filePath) throws FileNotFoundException, IOException {
        List<WordSimilarity> wordSimilaritys = new ArrayList<WordSimilarity>();

        Dataset ds = DBBroker.getInstance().getDataset(1);

        File data = new File(filePath);

        BufferedReader bufRdr = new BufferedReader(new FileReader(data));

        String line = null;
        int row = 0;
        int index = 1;
        while ((line = bufRdr.readLine()) != null) {
            MeasuredSimilarityOld ms = null;
            String[] elementsInLine = line.split(",");

            if (elementsInLine[0].contains("-") && row != 0) {
                WordSimilarity ws = new WordSimilarity();
                ws.setFirstWord(elementsInLine[0].substring(1, elementsInLine[0].indexOf("-")));
                ws.setSecondWord(elementsInLine[0].substring(elementsInLine[0].indexOf("-") + 1, elementsInLine[0].length() - 2));
                ws.setDataset(ds);
                ws.setId(index);
                ComputerMeasuredSimilarity cms = new ComputerMeasuredSimilarity();
                cms.setSequenceSimilarity(Float.parseFloat(elementsInLine[5]));
                cms.setLevenstein(Float.parseFloat(elementsInLine[1]));
                cms.setLevensteinWithWrapper(Float.parseFloat(elementsInLine[2]));
                cms.setSoundex(Float.parseFloat(elementsInLine[3]));
                cms.setSoundexWithWrapper(Float.parseFloat(elementsInLine[4]));
                cms.setHirstStOnge(Float.parseFloat(elementsInLine[6]));
                cms.setLeacockChodorow(Float.parseFloat(elementsInLine[7]));
                cms.setLesk(Float.parseFloat(elementsInLine[8]));
                cms.setWuPalmer(Float.parseFloat(elementsInLine[9]));
                cms.setResnik(Float.parseFloat(elementsInLine[10]));
                cms.setJiangConrath(Float.parseFloat(elementsInLine[11]));
                cms.setLin(Float.parseFloat(elementsInLine[12]));
                cms.setPath(Float.parseFloat(elementsInLine[13]));
                cms.setId(index);
                ws.setComputerMeasuredSimilarity(cms);
                wordSimilaritys.add(ws);
                index++;

            }

            row++;
        }
        DBBroker.getInstance().refreshWordSimilarities(wordSimilaritys);

    }
    
    public static void getGameDataJPA2(String filePath) throws FileNotFoundException, IOException {
        List<WordSimilarity> wordSimilaritys = new ArrayList<WordSimilarity>();

        Dataset ds = DBBroker.getInstance().getDataset(2);

        File data = new File(filePath);

        BufferedReader bufRdr = new BufferedReader(new FileReader(data));

        String line = null;
        int row = 0;
//        int index = DBBroker.getInstance().getMaxComputerMeasuredSimilarityIndex() + 1;
        int index = 1071;
        while ((line = bufRdr.readLine()) != null) {
            MeasuredSimilarityOld ms = null;
            String[] elementsInLine = line.split(",");

            if (row != 0) {
                WordSimilarity ws = new WordSimilarity();
                ws.setFirstWord(elementsInLine[1]);
                ws.setSecondWord(elementsInLine[0]);
                ws.setDataset(ds);
                ws.setId(index);
                ComputerMeasuredSimilarity cms = new ComputerMeasuredSimilarity();
                cms.setSequenceSimilarity(Float.parseFloat(elementsInLine[2]));
                cms.setLevenstein(Float.parseFloat(elementsInLine[3]));
                cms.setLevensteinWithWrapper(Float.parseFloat(elementsInLine[4]));
                cms.setSoundex(Float.parseFloat(elementsInLine[5]));
                cms.setSoundexWithWrapper(Float.parseFloat(elementsInLine[6]));
                cms.setHirstStOnge(Float.parseFloat(elementsInLine[7]));
                cms.setLeacockChodorow(Float.parseFloat(elementsInLine[8]));
                cms.setLesk(Float.parseFloat(elementsInLine[9]));
                cms.setWuPalmer(Float.parseFloat(elementsInLine[10]));
                cms.setResnik(Float.parseFloat(elementsInLine[11]));
                cms.setJiangConrath(Float.parseFloat(elementsInLine[12]));
                cms.setLin(Float.parseFloat(elementsInLine[13]));
                cms.setPath(Float.parseFloat(elementsInLine[14]));
                cms.setId(index);
                ws.setComputerMeasuredSimilarity(cms);
                wordSimilaritys.add(ws);
                index++;
            }
            row++;
        }
        DBBroker.getInstance().insertNewWordSimilarities(wordSimilaritys);
    }
}
