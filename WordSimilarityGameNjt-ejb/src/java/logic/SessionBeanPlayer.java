/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DBBroker;
import java.util.List;
import javax.ejb.Stateless;
import model.Player;
import model.PlayerMeasuredSimilarity;
import model.Usertype;

/**
 *
 * @author Djordje Gligorijevic
 */
@Stateless
public class SessionBeanPlayer implements SessionBeanPlayerLocal {

    @Override
    public Player getPlayer(Player player) {
        return DBBroker.getInstance().getPlayerFromId(player);
    }

    @Override
    public void createPlayer(Player player) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Player login(Player player) {
        Player p = DBBroker.getInstance().getPlayerLogin(player);
        return p;
    }

    @Override
    public Player registerNewPlayer(Player player) {
        DBBroker.getInstance().saveNewPlayer(player);
        System.out.println("########################## " + player + " has been added to list of players.");
        return DBBroker.getInstance().getPlayerFromId(player);
    }

    @Override
    public boolean isPlayerRegistered(Player player) {
        return DBBroker.getInstance().doesPlayerExists(player);
    }

    @Override
    public List<Player> getAllPlayers() {
        return DBBroker.getInstance().getAllPlayers();
    }

    @Override
    public boolean isPlayerAdmin(Player player) {
        return player.getUserType().equals(DBBroker.getInstance().getAdminUserType());
    }

    @Override
    public List<Usertype> getUserTypes() {
        return DBBroker.getInstance().getUserTypes();
    }

    @Override
    public void updateAllPlayers(List<Player> playersList) {
        DBBroker.getInstance().updateAllPlayers(playersList);
    }

    @Override
    public Usertype getUsertype(int id) {
        return DBBroker.getInstance().getUsertype(id);
    }

    @Override
    public void updatePlayer(Player player) {
        DBBroker.getInstance().updatePlayer(player);
    }

    @Override
    public void updatePlayerMeasuredSimilarity(PlayerMeasuredSimilarity pms) {
        DBBroker.getInstance().updatePlayerMeasuredSimilarity(pms);
    }
}
