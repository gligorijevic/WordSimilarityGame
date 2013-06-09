/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Djordje Gligorijevic
 */
public class PlayerAlreadyRegistered extends Exception{

    public PlayerAlreadyRegistered(String message) {
        super(message);
    }
    
}
