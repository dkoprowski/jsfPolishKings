package it.koprowski.polishKings.web;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "switcher")
@SessionScoped
public class Localizator1 {
    Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    public String switchLocale(String lang) {
        locale = new Locale(lang);

        return FacesContext.getCurrentInstance().getViewRoot().getViewId() +
            "?faces-redirect=true";
    }
    //getLocale() etc. omitted for brevity
    public Locale getLocale(){
    	return locale;
    }
    
    public void setLocale(Locale loc){
    	locale = loc;
    }
}
