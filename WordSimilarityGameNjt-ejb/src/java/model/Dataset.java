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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Djordje Gligorijevic
 */
@Entity
@Table(name = "dataset")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dataset.findAll", query = "SELECT d FROM Dataset d"),
    @NamedQuery(name = "Dataset.findByDatasetID", query = "SELECT d FROM Dataset d WHERE d.datasetID = :datasetID"),
    @NamedQuery(name = "Dataset.findByDatasetName", query = "SELECT d FROM Dataset d WHERE d.datasetName = :datasetName"),
    @NamedQuery(name = "Dataset.findByDatasetDescription", query = "SELECT d FROM Dataset d WHERE d.datasetDescription = :datasetDescription")})
public class Dataset implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="seq", sequenceName="seq") 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
    @Basic(optional = false)
    @Column(name = "datasetID")
    private Integer datasetID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "datasetName")
    private String datasetName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "datasetDescription")
    private String datasetDescription;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataset")
//    private List<WordSimilarity> wordSimilarityList;

    public Dataset() {
    }

    public Dataset(Integer datasetID) {
        this.datasetID = datasetID;
    }

    public Dataset(Integer datasetID, String datasetName, String datasetDescription) {
        this.datasetID = datasetID;
        this.datasetName = datasetName;
        this.datasetDescription = datasetDescription;
    }

    public Integer getDatasetID() {
        return datasetID;
    }

    public void setDatasetID(Integer datasetID) {
        this.datasetID = datasetID;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public String getDatasetDescription() {
        return datasetDescription;
    }

    public void setDatasetDescription(String datasetDescription) {
        this.datasetDescription = datasetDescription;
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
        hash += (datasetID != null ? datasetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dataset)) {
            return false;
        }
        Dataset other = (Dataset) object;
        if ((this.datasetID == null && other.datasetID != null) || (this.datasetID != null && !this.datasetID.equals(other.datasetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dataset[ datasetID=" + datasetID + " ]";
    }
    
}
