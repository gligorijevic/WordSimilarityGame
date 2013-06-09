/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.HashMap;
import java.util.Properties;
import javax.naming.InitialContext;
import logic.SessionBeanMeasuredSimilarityLocal;
import logic.SessionBeanPlayerLocal;

/**
 *
 * @author Djordje Gligorijevic
 */
public class CallEJB {

    private static CallEJB instance;
    private HashMap<String, Object> mapa = new HashMap<String, Object>();

    private CallEJB() {
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial",
                "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("java.naming.factory.url.pkgs",
                "com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state",
                "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        try {
            InitialContext ctx = new InitialContext(props);

            SessionBeanPlayerLocal SBadmin = (SessionBeanPlayerLocal) ctx.lookup("java:global/WordSimilarityGameNjt/WordSimilarityGameNjt-ejb/SessionBeanPlayer");
            SessionBeanMeasuredSimilarityLocal SBws = (SessionBeanMeasuredSimilarityLocal) ctx.lookup("java:global/WordSimilarityGameNjt/WordSimilarityGameNjt-ejb/SessionBeanMeasuredSimilarity");
            mapa.put("SBadmin", SBadmin);
            mapa.put("SBws", SBws);
        } catch (Exception e) {
            System.err.println("GRESKA: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static CallEJB getInstance() {
        if (instance == null) {
            instance = new CallEJB();
        }
        return instance;
    }

    public SessionBeanPlayerLocal getSBPlayer() {
        return (SessionBeanPlayerLocal) mapa.get("SBadmin");
    }

    public SessionBeanMeasuredSimilarityLocal getSBWordSimilarity() {
        return (SessionBeanMeasuredSimilarityLocal) mapa.get("SBws");
    }
}
