/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import model.Player;
import model.PlayerMeasuredSimilarity;
import model.Usertype;

/**
 *
 * @author Djordje Gligorijevic
 */
@Local
public interface SessionBeanPlayerLocal {
    
    List<Usertype> getUserTypes();
    
    List<Player> getAllPlayers();
    
    void updatePlayer(Player player);
    
    void updateAllPlayers(List<Player> playersList);

    Player getPlayer(Player player);

    boolean isPlayerAdmin(Player player);
    
    void createPlayer(Player player);
    
    void updatePlayerMeasuredSimilarity(PlayerMeasuredSimilarity pms);

    Player login(Player player);
    
    Player registerNewPlayer(Player player);
    
    boolean isPlayerRegistered(Player player);
    
    Usertype getUsertype(int id);
}
