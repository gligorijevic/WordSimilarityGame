/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Djordje Gligorijevic
 */
@Entity
@Table(name = "wordsimilarity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WordSimilarity.findAll", query = "SELECT w FROM WordSimilarity w"),
    @NamedQuery(name = "WordSimilarity.findById", query = "SELECT w FROM WordSimilarity w WHERE w.id = :id"),
    @NamedQuery(name = "WordSimilarity.findByFirstWord", query = "SELECT w FROM WordSimilarity w WHERE w.firstWord = :firstWord"),
    @NamedQuery(name = "WordSimilarity.findBySecondWord", query = "SELECT w FROM WordSimilarity w WHERE w.secondWord = :secondWord")})
public class WordSimilarity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="seq", sequenceName="seq") 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FirstWord")
    private String firstWord;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SecondWord")
    private String secondWord;
    @JoinColumn(name = "ComputerMeasuredSimilarity", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComputerMeasuredSimilarity computerMeasuredSimilarity;
    @JoinColumn(name = "Dataset", referencedColumnName = "datasetID")
    @ManyToOne(optional = false)
    private Dataset dataset;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wordSimilarity")
    private List<PlayerMeasuredSimilarity> playerMeasuredSimilarityList;

    public WordSimilarity() {
    }

    public WordSimilarity(Integer id) {
        this.id = id;
    }

    public WordSimilarity(Integer id, String firstWord, String secondWord) {
        this.id = id;
        this.firstWord = firstWord;
        this.secondWord = secondWord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }

    public ComputerMeasuredSimilarity getComputerMeasuredSimilarity() {
        return computerMeasuredSimilarity;
    }

    public void setComputerMeasuredSimilarity(ComputerMeasuredSimilarity computerMeasuredSimilarity) {
        this.computerMeasuredSimilarity = computerMeasuredSimilarity;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    @XmlTransient
    public List<PlayerMeasuredSimilarity> getPlayerMeasuredSimilarityList() {
        return playerMeasuredSimilarityList;
    }

    public void setPlayerMeasuredSimilarityList(List<PlayerMeasuredSimilarity> playerMeasuredSimilarityList) {
        this.playerMeasuredSimilarityList = playerMeasuredSimilarityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WordSimilarity)) {
            return false;
        }
        WordSimilarity other = (WordSimilarity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.WordSimilarity[ id=" + id + " ]";
    }
    
}
