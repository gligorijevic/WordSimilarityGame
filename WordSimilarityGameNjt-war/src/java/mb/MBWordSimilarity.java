/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import ejb.CallEJB;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Player;
import model.PlayerMeasuredSimilarity;
import model.PlayerMeasuredSimilarityPK;
import model.WordSimilarity;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RateEvent;

/**
 *
 * @author Djordje Gligorijevic
 */
@ManagedBean(name = "mbsimilarity")
@SessionScoped
public class MBWordSimilarity implements Serializable {

//    private List<MeasuredSimilarityOld> results = new ArrayList<MeasuredSimilarityOld>();
//    private MeasuredSimilarityOld currentWordSimilarity = new MeasuredSimilarityOld();
//    private List<MeasuredSimilarityOld> allWords = new ArrayList<MeasuredSimilarityOld>();
    private int currentWordSimRate;
    private WordSimilarity currentWordSimilarity;
    private List<WordSimilarity> wordSimilaritys;
    private int grades[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private Player selectedPlayer = new Player();
//    private List<PlayerMeasuredSimilarity> playerMeasuredSimilaritys;

    public MBWordSimilarity() {
        System.out.println("##############################################################################");
        System.out.println("#################### KREIRAN JE NOVI MBSIMILARITY ############################");
        System.out.println("##############################################################################");

        wordSimilaritys = CallEJB.getInstance().getSBWordSimilarity().getAllWordSimilaritys();

        currentWordSimilarity = wordSimilaritys.get((new Random()).nextInt(wordSimilaritys.size() - 1));
        System.err.println("PRVI SETOVANI: " + currentWordSimilarity);
    }

    /**
     * @return the currentWordSimRate
     */
    public Integer getCurrentWordSimRate() {
        return currentWordSimRate;
    }

    /**
     * @param currentWordSimRate the currentWordSimRate to set
     */
    public void setCurrentWordSimRate(Integer currentWordSimRate) {
        this.currentWordSimRate = currentWordSimRate;
    }

    public void saveRatingAndNext() {
        System.out.println("CURRENT RATING IS: " + currentWordSimRate);
        PlayerMeasuredSimilarity pms = new PlayerMeasuredSimilarity();
        PlayerMeasuredSimilarityPK pmspk = new PlayerMeasuredSimilarityPK();
        MBPlayer mbplayer = (MBPlayer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mbplayer");
        pms.setPlayer(mbplayer.getPlayer());
        pmspk.setPlayerid(mbplayer.getPlayer().getPlayerId());
        pms.setWordSimilarity(currentWordSimilarity);
        pmspk.setWordsimilarityid(currentWordSimilarity.getId());
        pms.setGrade(currentWordSimRate);
        pms.setPlayerMeasuredSimilarityPK(pmspk);
        mbplayer.getPlayer().getPlayerMeasuredSimilarityList().add(pms);
//        getPlayerMeasuredSimilaritys().add(pms);

        System.out.println("OLD CURRENT: " + getCurrentWordSimilarity());
        setCurrentWordSimilarity(getWordSimilaritys().get((new Random()).nextInt(getWordSimilaritys().size() - 1)));
        System.out.println("NEW CURRENT: " + getCurrentWordSimilarity());
        currentWordSimRate = 0;
        System.out.println("NUMBER OF RATED WORDS IS: " + mbplayer.getPlayer().getPlayerMeasuredSimilarityList().size());
    }

    public String finishPlaying() {
        System.out.println("::::FINISHING AND SAVING::::");
        Player player;
        MBPlayer mbplayer = (MBPlayer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mbplayer");
        player = mbplayer.getPlayer();
        System.out.println("player when saving: " + player + " with list of size: " + player.getPlayerMeasuredSimilarityList().size());
        CallEJB.getInstance().getSBWordSimilarity().saveResults(player.getPlayerMeasuredSimilarityList());
        System.out.println("SACUVAO JE");

        return "faces/indexPlayer.xhtml";
    }

    public void onrate(RateEvent rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + ((Integer) rateEvent.getRating()).intValue() + " for words " + getCurrentWordSimilarity().getFirstWord() + " and " + getCurrentWordSimilarity().getSecondWord());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getFirstWordPropertyDescription() {
        return CallEJB.getInstance().getSBWordSimilarity().returnSecondWordPropertyDescription(getCurrentWordSimilarity().getFirstWord());
    }

    public String dbpediaLink() {
        if (getCurrentWordSimilarity() != null) {
            System.out.println("http://dbpedia.org/ontology/" + getCurrentWordSimilarity().getSecondWord());
            return "http://dbpedia.org/ontology/" + getCurrentWordSimilarity().getSecondWord();
        } else {
            return "http://google.com";
        }
    }

    //TODO finish
    public void exportGradesToCsv() {
//        Player player;
//        MBPlayer mbplayer = (MBPlayer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mbplayer");
//        player = mbplayer.getPlayer();
        FacesMessage msg = new FacesMessage("Results Exported", selectedPlayer.getUsername() + "'s results have been saved.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        CallEJB.getInstance().getSBWordSimilarity().exportPlayerMeasuredGradesToCsv(selectedPlayer, "C:\\Users\\gligo_000\\Desktop");
    }

    /**
     * @return the currentWordSimilarity
     */
    public WordSimilarity getCurrentWordSimilarity() {
        return currentWordSimilarity;
    }

    /**
     * @param currentWordSimilarity the currentWordSimilarity to set
     */
    public void setCurrentWordSimilarity(WordSimilarity currentWordSimilarity) {
        this.currentWordSimilarity = currentWordSimilarity;
    }

    /**
     * @return the wordSimilaritys
     */
    public List<WordSimilarity> getWordSimilaritys() {
        return wordSimilaritys;
    }

    /**
     * @param wordSimilaritys the wordSimilaritys to set
     */
    public void setWordSimilaritys(List<WordSimilarity> wordSimilaritys) {
        this.wordSimilaritys = wordSimilaritys;
    }
//    /**
//     * @return the playerMeasuredSimilaritys
//     */
//    public List<PlayerMeasuredSimilarity> getPlayerMeasuredSimilaritys() {
//        return playerMeasuredSimilaritys;
//    }
//
//    /**
//     * @param playerMeasuredSimilaritys the playerMeasuredSimilaritys to set
//     */
//    public void setPlayerMeasuredSimilaritys(List<PlayerMeasuredSimilarity> playerMeasuredSimilaritys) {
//        this.playerMeasuredSimilaritys = playerMeasuredSimilaritys;
//    }

    void endSession() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    /**
     * @return the grades
     */
    public int[] getGrades() {
        return grades;
    }

    /**
     * @param grades the grades to set
     */
    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    /**
     * @return the selectedPlayer
     */
    public Player getSelectedPlayer() {
        return selectedPlayer;
    }

    /**
     * @param selectedPlayer the selectedPlayer to set
     */
    public void setSelectedPlayer(Player selectedPlayer) {
        this.selectedPlayer = selectedPlayer;
    }
}
