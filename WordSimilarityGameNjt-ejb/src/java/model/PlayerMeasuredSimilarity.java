/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Djordje Gligorijevic
 */
@Entity
@Table(name = "playermeasuredsimilarity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlayerMeasuredSimilarity.findAll", query = "SELECT p FROM PlayerMeasuredSimilarity p"),
    @NamedQuery(name = "PlayerMeasuredSimilarity.findById", query = "SELECT p FROM PlayerMeasuredSimilarity p WHERE p.playerMeasuredSimilarityPK.id = :id"),
    @NamedQuery(name = "PlayerMeasuredSimilarity.findByPlayerid", query = "SELECT p FROM PlayerMeasuredSimilarity p WHERE p.playerMeasuredSimilarityPK.playerid = :playerid"),
    @NamedQuery(name = "PlayerMeasuredSimilarity.findByWordsimilarityid", query = "SELECT p FROM PlayerMeasuredSimilarity p WHERE p.playerMeasuredSimilarityPK.wordsimilarityid = :wordsimilarityid"),
    @NamedQuery(name = "PlayerMeasuredSimilarity.findByGrade", query = "SELECT p FROM PlayerMeasuredSimilarity p WHERE p.grade = :grade")})
public class PlayerMeasuredSimilarity implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlayerMeasuredSimilarityPK playerMeasuredSimilarityPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grade")
    private int grade;
    @JoinColumn(name = "wordsimilarityid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WordSimilarity wordSimilarity;
    @JoinColumn(name = "playerid", referencedColumnName = "playerId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Player player;

    public PlayerMeasuredSimilarity() {
    }

    public PlayerMeasuredSimilarity(PlayerMeasuredSimilarityPK playerMeasuredSimilarityPK) {
        this.playerMeasuredSimilarityPK = playerMeasuredSimilarityPK;
    }

    public PlayerMeasuredSimilarity(PlayerMeasuredSimilarityPK playerMeasuredSimilarityPK, int grade) {
        this.playerMeasuredSimilarityPK = playerMeasuredSimilarityPK;
        this.grade = grade;
    }

    public PlayerMeasuredSimilarity(int id, int playerid, int wordsimilarityid) {
        this.playerMeasuredSimilarityPK = new PlayerMeasuredSimilarityPK(id, playerid, wordsimilarityid);
    }

    public PlayerMeasuredSimilarityPK getPlayerMeasuredSimilarityPK() {
        return playerMeasuredSimilarityPK;
    }

    public void setPlayerMeasuredSimilarityPK(PlayerMeasuredSimilarityPK playerMeasuredSimilarityPK) {
        this.playerMeasuredSimilarityPK = playerMeasuredSimilarityPK;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public WordSimilarity getWordSimilarity() {
        return wordSimilarity;
    }

    public void setWordSimilarity(WordSimilarity wordSimilarity) {
        this.wordSimilarity = wordSimilarity;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playerMeasuredSimilarityPK != null ? playerMeasuredSimilarityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayerMeasuredSimilarity)) {
            return false;
        }
        PlayerMeasuredSimilarity other = (PlayerMeasuredSimilarity) object;
        if ((this.playerMeasuredSimilarityPK == null && other.playerMeasuredSimilarityPK != null) || (this.playerMeasuredSimilarityPK != null && !this.playerMeasuredSimilarityPK.equals(other.playerMeasuredSimilarityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PlayerMeasuredSimilarity[ playerMeasuredSimilarityPK=" + playerMeasuredSimilarityPK + " ]";
    }
    
}
