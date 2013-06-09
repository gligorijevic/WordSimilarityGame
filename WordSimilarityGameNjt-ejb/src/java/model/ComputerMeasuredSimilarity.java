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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Djordje Gligorijevic
 */
@Entity
@Table(name = "computermeasuredsimilarity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComputerMeasuredSimilarity.findAll", query = "SELECT c FROM ComputerMeasuredSimilarity c"),
    @NamedQuery(name = "ComputerMeasuredSimilarity.findById", query = "SELECT c FROM ComputerMeasuredSimilarity c WHERE c.id = :id"),
    @NamedQuery(name = "ComputerMeasuredSimilarity.findBySequenceSimilarity", query = "SELECT c FROM ComputerMeasuredSimilarity c WHERE c.sequenceSimilarity = :sequenceSimilarity"),
    @NamedQuery(name = "ComputerMeasuredSimilarity.findByLevenstein", query = "SELECT c FROM ComputerMeasuredSimilarity c WHERE c.levenstein = :levenstein"),
    @NamedQuery(name = "ComputerMeasuredSimilarity.findByLevensteinWithWrapper", query = "SELECT c FROM ComputerMeasuredSimilarity c WHERE c.levensteinWithWrapper = :levensteinWithWrapper"),
    @NamedQuery(name = "ComputerMeasuredSimilarity.findBySoundex", query = "SELECT c FROM ComputerMeasuredSimilarity c WHERE c.soundex = :soundex"),
    @NamedQuery(name = "ComputerMeasuredSimilarity.findBySoundexWithWrapper", query = "SELECT c FROM ComputerMeasuredSimilarity c WHERE c.soundexWithWrapper = :soundexWithWrapper"),
    @NamedQuery(name = "ComputerMeasuredSimilarity.findByHirstStOnge", query = "SELECT c FROM ComputerMeasuredSimilarity c WHERE c.hirstStOnge = :hirstStOnge"),
    @NamedQuery(name = "ComputerMeasuredSimilarity.findByLeacockChodorow", query = "SELECT c FROM ComputerMeasuredSimilarity c WHERE c.leacockChodorow = :leacockChodorow"),
    @NamedQuery(name = "ComputerMeasuredSimilarity.findByLesk", query = "SELECT c FROM ComputerMeasuredSimilarity c WHERE c.lesk = :lesk"),
    @NamedQuery(name = "ComputerMeasuredSimilarity.findByWuPalmer", query = "SELECT c FROM ComputerMeasuredSimilarity c WHERE c.wuPalmer = :wuPalmer"),
    @NamedQuery(name = "ComputerMeasuredSimilarity.findByResnik", query = "SELECT c FROM ComputerMeasuredSimilarity c WHERE c.resnik = :resnik"),
    @NamedQuery(name = "ComputerMeasuredSimilarity.findByJiangConrath", query = "SELECT c FROM ComputerMeasuredSimilarity c WHERE c.jiangConrath = :jiangConrath"),
    @NamedQuery(name = "ComputerMeasuredSimilarity.findByLin", query = "SELECT c FROM ComputerMeasuredSimilarity c WHERE c.lin = :lin"),
    @NamedQuery(name = "ComputerMeasuredSimilarity.findByPath", query = "SELECT c FROM ComputerMeasuredSimilarity c WHERE c.path = :path")})
public class ComputerMeasuredSimilarity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="seq", sequenceName="seq") 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SequenceSimilarity")
    private float sequenceSimilarity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Levenstein")
    private float levenstein;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LevensteinWithWrapper")
    private float levensteinWithWrapper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Soundex")
    private float soundex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoundexWithWrapper")
    private float soundexWithWrapper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HirstStOnge")
    private float hirstStOnge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LeacockChodorow")
    private float leacockChodorow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Lesk")
    private float lesk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WuPalmer")
    private float wuPalmer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Resnik")
    private float resnik;
    @Basic(optional = false)
    @NotNull
    @Column(name = "JiangConrath")
    private float jiangConrath;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Lin")
    private float lin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Path")
    private float path;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "computerMeasuredSimilarity")
//    private List<WordSimilarity> wordSimilarityList;

    public ComputerMeasuredSimilarity() {
    }

    public ComputerMeasuredSimilarity(Integer id) {
        this.id = id;
    }

    public ComputerMeasuredSimilarity(Integer id, float sequenceSimilarity, float levenstein, float levensteinWithWrapper, float soundex, float soundexWithWrapper, float hirstStOnge, float leacockChodorow, float lesk, float wuPalmer, float resnik, float jiangConrath, float lin, float path) {
        this.id = id;
        this.sequenceSimilarity = sequenceSimilarity;
        this.levenstein = levenstein;
        this.levensteinWithWrapper = levensteinWithWrapper;
        this.soundex = soundex;
        this.soundexWithWrapper = soundexWithWrapper;
        this.hirstStOnge = hirstStOnge;
        this.leacockChodorow = leacockChodorow;
        this.lesk = lesk;
        this.wuPalmer = wuPalmer;
        this.resnik = resnik;
        this.jiangConrath = jiangConrath;
        this.lin = lin;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getSequenceSimilarity() {
        return sequenceSimilarity;
    }

    public void setSequenceSimilarity(float sequenceSimilarity) {
        this.sequenceSimilarity = sequenceSimilarity;
    }

    public float getLevenstein() {
        return levenstein;
    }

    public void setLevenstein(float levenstein) {
        this.levenstein = levenstein;
    }

    public float getLevensteinWithWrapper() {
        return levensteinWithWrapper;
    }

    public void setLevensteinWithWrapper(float levensteinWithWrapper) {
        this.levensteinWithWrapper = levensteinWithWrapper;
    }

    public float getSoundex() {
        return soundex;
    }

    public void setSoundex(float soundex) {
        this.soundex = soundex;
    }

    public float getSoundexWithWrapper() {
        return soundexWithWrapper;
    }

    public void setSoundexWithWrapper(float soundexWithWrapper) {
        this.soundexWithWrapper = soundexWithWrapper;
    }

    public float getHirstStOnge() {
        return hirstStOnge;
    }

    public void setHirstStOnge(float hirstStOnge) {
        this.hirstStOnge = hirstStOnge;
    }

    public float getLeacockChodorow() {
        return leacockChodorow;
    }

    public void setLeacockChodorow(float leacockChodorow) {
        this.leacockChodorow = leacockChodorow;
    }

    public float getLesk() {
        return lesk;
    }

    public void setLesk(float lesk) {
        this.lesk = lesk;
    }

    public float getWuPalmer() {
        return wuPalmer;
    }

    public void setWuPalmer(float wuPalmer) {
        this.wuPalmer = wuPalmer;
    }

    public float getResnik() {
        return resnik;
    }

    public void setResnik(float resnik) {
        this.resnik = resnik;
    }

    public float getJiangConrath() {
        return jiangConrath;
    }

    public void setJiangConrath(float jiangConrath) {
        this.jiangConrath = jiangConrath;
    }

    public float getLin() {
        return lin;
    }

    public void setLin(float lin) {
        this.lin = lin;
    }

    public float getPath() {
        return path;
    }

    public void setPath(float path) {
        this.path = path;
    }

//    @XmlTransient
//    public List<WordSimilarity> getWordSimilarityList() {
//        return wordSimilarityList;
//    }
//
//    public void setWordSimilarityList(List<WordSimilarity> wordSimilarityList) {
//        this.wordSimilarityList = wordSimilarityList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComputerMeasuredSimilarity)) {
            return false;
        }
        ComputerMeasuredSimilarity other = (ComputerMeasuredSimilarity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ComputerMeasuredSimilarity[ id=" + id + " ]";
    }
    
}
