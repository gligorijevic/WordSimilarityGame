/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Player;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ExportResults {

    public static void exportMeasuredSimilaritiesCsv(Player player, String filePath) {
        try {
            FileWriter writer1 = new FileWriter(filePath + "\\" + player.getFirstName() + "_" + player.getLastName() + "_" + player.getUsername() + "_SchDBp_results.csv", true);
            FileWriter writer2 = new FileWriter(filePath + "\\" + player.getFirstName() + "_" + player.getLastName() + "_" + player.getUsername() + "_SchGR_results.csv", true);

//            writer.write(player.toString());
//            writer.write("\n");

            for (int i = 0; i < player.getPlayerMeasuredSimilarityList().size(); i++) {
                if (player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getDataset().getDatasetID() == 1) {
                    writer1.write(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getFirstWord());
                    writer1.write(",");
                    writer1.write(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getSecondWord());
                    writer1.write(",");
                    writer1.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getGrade()));
                    writer1.write(",");
                    writer1.write("computer results");
                    writer1.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getSequenceSimilarity()));
                    writer1.write(",");
                    writer1.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getLevenstein()));
                    writer1.write(",");
                    writer1.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getLevensteinWithWrapper()));
                    writer1.write(",");
                    writer1.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getSoundex()));
                    writer1.write(",");
                    writer1.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getSoundexWithWrapper()));
                    writer1.write(",");
                    writer1.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getHirstStOnge()));
                    writer1.write(",");
                    writer1.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getLeacockChodorow()));
                    writer1.write(",");
                    writer1.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getLesk()));
                    writer1.write(",");
                    writer1.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getWuPalmer()));
                    writer1.write(",");
                    writer1.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getResnik()));
                    writer1.write(",");
                    writer1.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getJiangConrath()));
                    writer1.write(",");
                    writer1.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getLin()));
                    writer1.write(",");
                    writer1.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getPath()));
                    writer1.write("\n");
                } else if (player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getDataset().getDatasetID() == 2) {
                    writer2.write(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getFirstWord());
                    writer2.write(",");
                    writer2.write(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getSecondWord());
                    writer2.write(",");
                    writer2.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getGrade()));
                    writer2.write(",");
                    writer2.write("computer results");
                    writer2.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getSequenceSimilarity()));
                    writer2.write(",");
                    writer2.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getLevenstein()));
                    writer2.write(",");
                    writer2.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getLevensteinWithWrapper()));
                    writer2.write(",");
                    writer2.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getSoundex()));
                    writer2.write(",");
                    writer2.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getSoundexWithWrapper()));
                    writer2.write(",");
                    writer2.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getHirstStOnge()));
                    writer2.write(",");
                    writer2.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getLeacockChodorow()));
                    writer2.write(",");
                    writer2.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getLesk()));
                    writer2.write(",");
                    writer2.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getWuPalmer()));
                    writer2.write(",");
                    writer2.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getResnik()));
                    writer2.write(",");
                    writer2.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getJiangConrath()));
                    writer2.write(",");
                    writer2.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getLin()));
                    writer2.write(",");
                    writer2.write(String.valueOf(player.getPlayerMeasuredSimilarityList().get(i).getWordSimilarity().getComputerMeasuredSimilarity().getPath()));
                    writer2.write("\n");
                }
            }
            writer1.flush();
            writer1.close();
            writer2.flush();
            writer2.close();
        } catch (IOException ex) {
            Logger.getLogger(SessionBeanMeasuredSimilarity.class.getName()).log(Level.SEVERE, null, ex);
        }




    }
}
