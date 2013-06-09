/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.ComputerMeasuredSimilarity;
import model.Dataset;
import model.Player;
import model.PlayerMeasuredSimilarity;
import model.PlayerMeasuredSimilarityPK;
import model.Usertype;
import model.WordSimilarity;

/**
 *
 * @author Djordje Gligorijevic
 */
public class DBBroker {

    private EntityManagerFactory emf;

    private DBBroker() {
        emf = Persistence.createEntityManagerFactory("njtws");
    }

    public static DBBroker getInstance() {
        return DBBrokerHolder.INSTANCE;
    }

    private static class DBBrokerHolder {

        private static final DBBroker INSTANCE = new DBBroker();
    }

    public List<Usertype> getUserTypes() {
        EntityManager em = emf.createEntityManager();
        List<Usertype> ut = em.createQuery("SELECT ut FROM Usertype ut").getResultList();
        em.close();
        return ut;
    }

    public Usertype getPlayerUserType() {
        EntityManager em = emf.createEntityManager();
        List<Usertype> ut = em.createQuery("SELECT ut FROM Usertype ut WHERE ut.name='Player'").getResultList();
        em.close();
        return ut.get(0);
    }

    public Usertype getAdminUserType() {
        EntityManager em = emf.createEntityManager();
        List<Usertype> ut = em.createQuery("SELECT ut FROM Usertype ut WHERE ut.name='Administrator'").getResultList();
        em.close();
        return ut.get(0);
    }

    public Usertype getUsertype(int id) {
        EntityManager em = emf.createEntityManager();
        List<Usertype> ut = em.createNamedQuery("Usertype.findById").setParameter("id", id).getResultList();
        em.close();
        return ut.get(0);
    }

    public boolean saveNewPlayer(Player newPlayer) {
        if (newPlayer.getUserType() == null) {
            newPlayer.setUserType(getPlayerUserType());
        }

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(newPlayer);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return false;
        }
    }

    public void updatePlayer(Player oldPlayer) {
        EntityManager em = emf.createEntityManager();
        Player player = em.find(Player.class, oldPlayer.getPlayerId());
        if (player != null) {
            em.getTransaction().begin();
            em.merge(oldPlayer);
            em.getTransaction().commit();
        }
    }

    public void updateAllPlayers(List<Player> playersList) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            for (int i = 0; i < playersList.size(); i++) {
                Player player = em.find(Player.class, playersList.get(i).getPlayerId());
                if (player != null) {
                    em.merge(playersList.get(i));
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public List<Player> getAllPlayers() {
        EntityManager em = emf.createEntityManager();
        List<Player> players = em.createQuery("Select p FROM Player p").getResultList();
        em.close();
        return players;
    }

    public Player getPlayerLogin(Player playerLogin) {
        EntityManager em = emf.createEntityManager();
        List<Player> players = em.createQuery("Select p FROM Player p WHERE p.username='" + playerLogin.getUsername() + "' AND p.password='" + playerLogin.getPassword() + "'").getResultList();
        em.close();
        return players.get(0);
    }

    public Player getPlayerFromId(Player player) {
        EntityManager em = emf.createEntityManager();
        Player p = em.find(Player.class, player.getPlayerId());
        em.close();
        return p;
    }

    public boolean doesPlayerExists(Player newPlayer) {
        EntityManager em = emf.createEntityManager();
        System.out.println("PROVERA DA LI IGRAC POSTOJI");
//        List<Player> players = em.createNamedQuery("Player.findByUsername").setParameter("username", newPlayer.getUsername()).getResultList();
        List<Player> players = em.createQuery("Select p FROM Player p WHERE p.username='" + newPlayer.getUsername() + "'").getResultList();
        em.close();
        if (players.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void updatePlayerMeasuredSimilarity(PlayerMeasuredSimilarity pms) {
        EntityManager em = emf.createEntityManager();
        PlayerMeasuredSimilarity playerms = em.find(PlayerMeasuredSimilarity.class, pms.getPlayerMeasuredSimilarityPK());
        if (playerms != null) {
            em.getTransaction().begin();
            em.merge(pms);
            em.getTransaction().commit();
        }

    }

    public Dataset getDataset(int datasetID) {
        EntityManager em = emf.createEntityManager();
        List<Dataset> datasets = em.createQuery("SELECT d FROM Dataset d WHERE d.datasetID='" + datasetID + "'").getResultList();
        em.close();
        return datasets.get(0);
    }

    public int getMaxComputerMeasuredSimilarityIndex() {
        EntityManager em = emf.createEntityManager();
        List<ComputerMeasuredSimilarity> m = em.createQuery("SELECT cms FROM ComputerMeasuredSimilarity cms").getResultList();
        int max = 0;
        for (int i = 0; i < m.size(); i++) {
            max = Math.max(max, m.get(i).getId());
        }
        return max;
    }

    public void saveAllWordSimilarities(List<WordSimilarity> wordSimilarities) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        for (int i = 0; i < wordSimilarities.size(); i++) {

//            WordSimilarity ws = em.find(WordSimilarity.class, wordSimilarities.get(i).getId());
//           if (ws == null) {
//                em.getTransaction().begin();
            em.persist(wordSimilarities.get(i).getComputerMeasuredSimilarity());
            em.flush();
            System.out.println("Prosao flush cms");
            em.refresh(wordSimilarities.get(i).getComputerMeasuredSimilarity());
            System.out.println("Prosao refresh cms");
            System.out.println(wordSimilarities.get(i).getComputerMeasuredSimilarity());
//                wordSimilarities.get(i).getComputerMeasuredSimilarity().setId(i);
            em.persist(wordSimilarities.get(i));
            em.flush();
            System.out.println("Prosao flush ws");
            em.refresh(wordSimilarities.get(i));
            System.out.println("Prosao refresh ws");
            System.out.println(wordSimilarities.get(i));

//                em.getTransaction().commit();
//            } else {
//                em.getTransaction().rollback();
//            }
        }
        em.getTransaction().commit();
    }

    public void insertNewWordSimilarities(List<WordSimilarity> wordSimilarities) {
        EntityManager em = emf.createEntityManager();
        for (int i = 0; i < wordSimilarities.size(); i++) {
            WordSimilarity ws = em.find(WordSimilarity.class, wordSimilarities.get(i).getId());
            em.getTransaction().begin();

            if (ws == null) {
                ComputerMeasuredSimilarity cms = em.find(ComputerMeasuredSimilarity.class, 
                        wordSimilarities.get(i).getComputerMeasuredSimilarity().getId());
                if(cms==null){
                    em.persist(wordSimilarities.get(i).getComputerMeasuredSimilarity());
                    em.flush();
                }
                em.persist(wordSimilarities.get(i));
                System.out.println("Persisted " + wordSimilarities.get(i).getId());
                em.flush();
                em.getTransaction().commit();
            } else {
                em.merge(wordSimilarities.get(i).getComputerMeasuredSimilarity());
                System.out.println("EROOOOOOOORRRRRRRRRRRRRRR " + wordSimilarities.get(i).getId());
                em.getTransaction().rollback();
            }
        }
        System.out.println("Commited");
    }

    public void refreshWordSimilarities(List<WordSimilarity> wordSimilarities) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        for (int i = 0; i < wordSimilarities.size(); i++) {
            em.merge(wordSimilarities.get(i).getComputerMeasuredSimilarity());
        }
        em.getTransaction().commit();
    }

    public List<WordSimilarity> getAllWordSimilaritys() {
        EntityManager em = emf.createEntityManager();
        List<WordSimilarity> wordSimilaritys = em.createQuery("SELECT ws FROM WordSimilarity ws").getResultList();
        em.close();
        return wordSimilaritys;
    }

    public void saveGameResults(List<PlayerMeasuredSimilarity> playerMeasuredSimilaritys) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            for (int i = 0; i < playerMeasuredSimilaritys.size(); i++) {
                PlayerMeasuredSimilarity pms = em.find(PlayerMeasuredSimilarity.class, playerMeasuredSimilaritys.get(i).getPlayerMeasuredSimilarityPK());
                if (pms != null) {
                    em.merge(playerMeasuredSimilaritys.get(i));
                } else {
                    em.persist(playerMeasuredSimilaritys.get(i));
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public List<PlayerMeasuredSimilarity> getPreviousPlayersGameResults(Player player) {
        EntityManager em = emf.createEntityManager();
        List<PlayerMeasuredSimilarity> playerMeasuredSimilaritys = em.createQuery("SELECT pms FROM PlayerMeasuredSimilarity pms WHERE pms.playerid='" + player.getPlayerId() + "'").getResultList();
        em.close();
        if (playerMeasuredSimilaritys != null) {
            return playerMeasuredSimilaritys;
        } else {
            return new ArrayList<PlayerMeasuredSimilarity>();
        }
    }
}
