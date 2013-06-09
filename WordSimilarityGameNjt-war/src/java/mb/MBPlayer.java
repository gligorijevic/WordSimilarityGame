/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import ejb.CallEJB;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Player;
import model.PlayerMeasuredSimilarity;
import model.Usertype;
import org.primefaces.event.RateEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Djordje Gligorijevic
 */
@ManagedBean(name = "mbplayer")
@SessionScoped
public class MBPlayer implements Serializable {
    
    private Player player;
    private Player newPlayer;
    private Player logPlayer;
    private List<Player> allPlayers = null;
    private List<Usertype> usertypes = null;
    
    public MBPlayer() {
        System.out.println("##############################################################################");
        System.out.println("######################### KREIRAN JE NOVI MBPLAYER ###########################");
        System.out.println("##############################################################################");
        player = new Player();
        newPlayer = new Player();
        logPlayer = new Player();
    }

//    public void setListaSvihIgraca(List<PlayerOld> listaSvihIgraca) {
//        PlayerCollection.getInstance().setPlayers(listaSvihIgraca);
//    }
//
//    public List<PlayerOld> getListaSvihIgraca() {
//        return PlayerCollection.getInstance().getPlayers();
//    }
    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return the newPlayer
     */
    public Player getNewPlayer() {
        return newPlayer;
    }

    /**
     * @param newPlayer the newPlayer to set
     */
    public void setNewPlayer(Player newPlayer) {
        this.newPlayer = newPlayer;
    }

//    public void clearLogin() {
//        player = new Player();
//    }
    /**
     * @return the logPlayer
     */
    public Player getLogPlayer() {
        return logPlayer;
    }

    /**
     * @param logPlayer the logPlayer to set
     */
    public void setLogPlayer(Player logPlayer) {
        this.logPlayer = logPlayer;
    }
    
    public String indexPlayer() {
        return "faces/indexPlayer.xhtml";
    }
    
    public void onrate(RateEvent rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + ((Integer) rateEvent.getRating()).intValue());
        
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
        
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String register() {
        System.out.println("::::Registracja igraca::::");
        if (newPlayer.getUsername() != null && newPlayer.getPassword() != null) {
            if (!CallEJB.getInstance().getSBPlayer().isPlayerRegistered(newPlayer)) {
                player = CallEJB.getInstance().getSBPlayer().registerNewPlayer(newPlayer);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Welcome, " + player.getFirstName() + " " + player.getLastName() + " ! :)"));
                return "faces/indexPlayer.xhtml";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("This player is already registered."));
                return "faces/login.xhtml";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, player.getFirstName() + ", you are already logged in!", "Already loged in!!!"));
            return "faces/indexPlayer.xhtml";
        }
    }
    
    public boolean isLoggedIn() {
        if (getPlayer().getUsername() != null && getPlayer().getPassword() != null) {
            return false;
        } else {
            return true;
        }
    }
    
    public String login() {
        System.out.println("::::Logovanje igraca::::");
        if (logPlayer.getUsername() != null && logPlayer.getPassword() != null) {
            if (CallEJB.getInstance().getSBPlayer().isPlayerRegistered(logPlayer)) {
                player = CallEJB.getInstance().getSBPlayer().login(logPlayer);
                System.err.println("dosao je player ovde" + player);
                if (player != null) {
                    if (CallEJB.getInstance().getSBPlayer().isPlayerAdmin(player)) {
                        setAllPlayers(CallEJB.getInstance().getSBPlayer().getAllPlayers());
                        setUsertypes(CallEJB.getInstance().getSBPlayer().getUserTypes());
                    }
                    System.out.println("ULOGOVANI KORISNIK: " + player);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Welcome, " + player.getFirstName() + " " + player.getLastName() + " ! :)"));
                    return "./indexPlayer.xhtml";
                } else {
                    System.out.println("KORISNIK NIJE ULOGOVAN");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unsuccessfull login!!!", "Check your username and password!"));
                    return "./login.xhtml";
                }
            } else {
                System.out.println("KORISNIK NIJE REGISTROVAN");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unsuccessfull login!!!", "This player does not exist in database!"));
                return "./register.xhtml";
            }
        } else {
            System.out.println("PARAMETRI O LOGOVANJU KORISNIKA NISU UNETI!");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Missing parameters", "You have to enter all parameters!"));
            return "./login.xhtml";
        }
    }
    
    public boolean isPlayerAdmin() {
        return CallEJB.getInstance().getSBPlayer().isPlayerAdmin(getPlayer());
    }
    
    public String logout() {
        player = new Player();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//        MBWordSimilarity mbsimilarity = (MBWordSimilarity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mbsimilarity");
//        mbsimilarity.endSession();
        return "./index.xhtml?faces-redirect=true";
    }
    
    public String play() {
        if (player.getUsername() != null && player.getPassword() != null) {
            System.out.println("Korisnik je ulogovan i moze da zapocne igru.");
            return "./game.xhtml";
        } else {
            System.out.println("Korisnik nije ulogovan i ne moze da zapocne igru.");
            return "./index.xhtml";
        }
    }
    
    public String playersResults() {
        if (player.getUsername() != null && player.getPassword() != null) {
            System.out.println("Korisnik je ulogovan i moze da zapocne igru.");
            return "./playerResults.xhtml";
        } else {
            System.out.println("Korisnik nije ulogovan i ne moze da zapocne igru.");
            return "./index.xhtml";
        }
    }
    
    public void onEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Player Edited", ((Player) event.getObject()).getUsername());
        CallEJB.getInstance().getSBPlayer().updatePlayer(((Player) event.getObject()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Player Cancelled", ((Player) event.getObject()).getUsername());
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onEditResults(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Grade Edited", ((PlayerMeasuredSimilarity) event.getObject()).toString());
        CallEJB.getInstance().getSBPlayer().updatePlayerMeasuredSimilarity(((PlayerMeasuredSimilarity) event.getObject()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onCancelResults(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Grade Cancelled", ((PlayerMeasuredSimilarity) event.getObject()).toString());
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
//    public void onCellEdit(CellEditEvent event) {  
//        Object oldValue = event.getOldValue();  
//        Object newValue = event.getNewValue();  
//          
//        if(newValue != null && !newValue.equals(oldValue)) {  
//            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);  
//            FacesContext.getCurrentInstance().addMessage(null, msg);  
//        }  
//    }  

    /**
     * @return the allPlayers
     */
    public List<Player> getAllPlayers() {
        return allPlayers;
    }

    /**
     * @param allPlayers the allPlayers to set
     */
    public void setAllPlayers(List<Player> allPlayers) {
        this.allPlayers = allPlayers;
    }

    /**
     * @return the usertypes
     */
    public List<Usertype> getUsertypes() {
        return usertypes;
    }

    /**
     * @param usertypes the usertypes to set
     */
    public void setUsertypes(List<Usertype> usertypes) {
        this.usertypes = usertypes;
    }
    
    public String administrate() {
        if (CallEJB.getInstance().getSBPlayer().isPlayerAdmin(getPlayer())) {
            
            return "faces/adminPage.xhtml";
        } else {
            FacesMessage msg = new FacesMessage("No administrator found", "Player " + getPlayer().getUsername() + " is not administrator!");
            
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return "faces/indexPlayer.xhtml";
    }
    
    public String exportResults() {
        if (CallEJB.getInstance().getSBPlayer().isPlayerAdmin(getPlayer())) {
            
            return "faces/adminExport.xhtml";
        } else {
            FacesMessage msg = new FacesMessage("No administrator found", "Player " + getPlayer().getUsername() + " is not administrator!");
            
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return "faces/indexPlayer.xhtml";
    }
    
    public void updateAllPlayers() {
        if (CallEJB.getInstance().getSBPlayer().isPlayerAdmin(getPlayer())) {
            CallEJB.getInstance().getSBPlayer().updateAllPlayers(getAllPlayers());
        } else {
            FacesMessage msg = new FacesMessage("No administrator found", "Player " + getPlayer().getUsername() + " is not administrator!");
            
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
