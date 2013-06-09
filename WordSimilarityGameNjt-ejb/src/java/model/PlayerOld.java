package model;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Djordje Gligorijevic
 */
public class PlayerOld implements Serializable {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String userType;
    private String image;
    private List<MeasuredSimilarityOld> measuredSimilarities;

    public PlayerOld() {
        measuredSimilarities = new ArrayList<MeasuredSimilarityOld>();
    }

    public PlayerOld(String firstName, String lastName, String username, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userType = "regular player";
        measuredSimilarities = new ArrayList<MeasuredSimilarityOld>();
    }

    public PlayerOld(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object obj) {
        if (((PlayerOld) obj).getUsername().equals(username) && ((PlayerOld) obj).getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the measuredSimilarities
     */
    public List<MeasuredSimilarityOld> getMeasuredSimilarities() {
        return measuredSimilarities;
    }

    /**
     * @param measuredSimilarities the measuredSimilarities to set
     */
    public void setMeasuredSimilarities(List<MeasuredSimilarityOld> measuredSimilarities) {
        this.measuredSimilarities = measuredSimilarities;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + email + ")is user: " + username + ", with password: " + password;
    }
}
