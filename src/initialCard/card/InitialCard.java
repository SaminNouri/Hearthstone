package initialCard.card;

import initialCard.enumClasses.General;

import java.util.HashMap;



import initialCard.enumClasses.General;
import initialCard.enumClasses.HeroType;
import jdk.nashorn.internal.codegen.types.Type;


import java.util.HashMap;

public abstract class InitialCard {

    protected HashMap<General, Object> general;

    public InitialCard(){
        this.general=new HashMap<General,Object>();
    }


    public InitialCard(HashMap<General, Object> general){
        this.general = general;
    }

    public HashMap<General, Object> getGeneralMap() {
        return general;
    }


    public void setGeneralMap(HashMap<General, Object> general) {
        this.general = general;
    }

    public void addElement(General generalElement, Object object) {
        if(general.containsKey(generalElement)){
            general.remove(generalElement);
        }
        general.put(generalElement, object);
    }

    public void removeElement(General generalElement, Object object) {
        if(general.containsKey(generalElement))
            general.remove(generalElement, object);
    }
    public void removeElement(General generalElement) {
        if(general.containsKey(generalElement))
            general.remove(generalElement,general.get(generalElement));
    }

    public boolean containsGeneralKey(General generalElement){
        return general.containsKey(generalElement);
    }
    //returns null if general does not contain generalElement
    public Object getObject(General generalElement){
        if(general.containsKey(generalElement))
            return general.get(generalElement);
        else
            return null;
    }

}