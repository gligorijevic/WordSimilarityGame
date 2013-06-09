/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Djordje Gligorijevic
 */
public class PlayerNotRegistered extends Exception{

    public PlayerNotRegistered() {
        super();
    }

    public PlayerNotRegistered(String message) {
        super(message);
    }
    
    
    
}
