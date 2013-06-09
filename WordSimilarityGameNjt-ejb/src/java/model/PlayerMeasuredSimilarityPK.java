/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Djordje Gligorijevic
 */
@Embeddable
public class PlayerMeasuredSimilarityPK implements Serializable {
    @SequenceGenerator(name="seq", sequenceName="seq") 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "playerid")
    private int playerid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "wordsimilarityid")
    private int wordsimilarityid;

    public PlayerMeasuredSimilarityPK() {
    }

    public PlayerMeasuredSimilarityPK(int id, int playerid, int wordsimilarityid) {
        this.id = id;
        this.playerid = playerid;
        this.wordsimilarityid = wordsimilarityid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerid() {
        return playerid;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }

    public int getWordsimilarityid() {
        return wordsimilarityid;
    }

    public void setWordsimilarityid(int wordsimilarityid) {
        this.wordsimilarityid = wordsimilarityid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) playerid;
        hash += (int) wordsimilarityid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayerMeasuredSimilarityPK)) {
            return false;
        }
        PlayerMeasuredSimilarityPK other = (PlayerMeasuredSimilarityPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.playerid != other.playerid) {
            return false;
        }
        if (this.wordsimilarityid != other.wordsimilarityid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PlayerMeasuredSimilarityPK[ id=" + id + ", playerid=" + playerid + ", wordsimilarityid=" + wordsimilarityid + " ]";
    }
    
}
