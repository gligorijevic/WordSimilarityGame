/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import model.Player;
import model.PlayerMeasuredSimilarity;
import model.WordSimilarity;


/**
 *
 * @author Djordje Gligorijevic
 */
@Local
public interface SessionBeanMeasuredSimilarityLocal {
    
    public List<WordSimilarity> getAllWordSimilaritys();
    
    public void saveResults(List<PlayerMeasuredSimilarity> playerMeasuredSimilaritys);
    
    public String returnSecondWordPropertyDescription(String propertyName);
    
    public void exportPlayerMeasuredGradesToCsv(Player player, String filePath);
    
}
