/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import ejb.CallEJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Usertype;

/**
 *
 * @author Djordje Gligorijevic
 */
@FacesConverter(forClass = Usertype.class, value = "usertypeConverter")
public class UsertypeConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return CallEJB.getInstance().getSBPlayer().getUsertype(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((Usertype)value).getId());
    }
    
}
