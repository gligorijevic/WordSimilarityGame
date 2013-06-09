/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DBBroker;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.Player;
import model.PlayerMeasuredSimilarity;
import model.WordSimilarity;
import property.SchemaPropertyDescription;

/**
 *
 * @author Djordje Gligorijevic
 */
@Stateless
public class SessionBeanMeasuredSimilarity implements SessionBeanMeasuredSimilarityLocal {

    @Override
    public String returnSecondWordPropertyDescription(String propertyName) {
        try {
            return SchemaPropertyDescription.schemaPropertyDescriptionTxt(propertyName);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SessionBeanMeasuredSimilarityLocal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SessionBeanMeasuredSimilarityLocal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public List<WordSimilarity> getAllWordSimilaritys() {
        return DBBroker.getInstance().getAllWordSimilaritys();
    }

    @Override
    public void saveResults(List<PlayerMeasuredSimilarity> playerMeasuredSimilaritys) {
        DBBroker.getInstance().saveGameResults(playerMeasuredSimilaritys);
    }

    @Override
    public void exportPlayerMeasuredGradesToCsv(Player player, String filePath) {
        ExportResults.exportMeasuredSimilaritiesCsv(player, filePath);
    }
}
