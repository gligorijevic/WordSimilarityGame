/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Djordje Gligorijevic
 */
public class MeasuredSimilarityOld implements Serializable{

    private String firstWord;
    private String secondWord;
    private int result  ;
    private List<Double> computerResult;

    public MeasuredSimilarityOld() {
    }

    public MeasuredSimilarityOld(String firstWord, String secondWord, int result, List<Double> computerResult) {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
        this.result = result;
        this.computerResult = computerResult;
    }

    /**
     * @return the firstWord
     */
    public String getFirstWord() {
        return firstWord;
    }

    /**
     * @param firstWord the firstWord to set
     */
    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    /**
     * @return the secondWord
     */
    public String getSecondWord() {
        return secondWord;
    }

    /**
     * @param secondWord the secondWord to set
     */
    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }

    /**
     * @return the result
     */
    public int getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(int result) {
        this.result = result;
    }

    /**
     * @return the computerResult
     */
    public List<Double> getComputerResult() {
        return computerResult;
    }

    /**
     * @param computerResult the computerResult to set
     */
    public void setComputerResult(List<Double> computerResult) {
        this.computerResult = computerResult;
    }

    @Override
    public String toString() {
        return firstWord + " " + secondWord + " = " + result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.firstWord.equals(((MeasuredSimilarityOld) obj).firstWord) && this.secondWord.equals(((MeasuredSimilarityOld) obj).secondWord)) {
            return true;
        } else {
            return false;
        }
    }
}
