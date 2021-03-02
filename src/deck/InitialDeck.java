package deck;

import deck.enumDeckClasses.GeneralDeck;

import java.util.HashMap;

/**
 * Created by Data on 3/13/2020.
 */
public abstract class InitialDeck
{

    protected HashMap<GeneralDeck, Object> general;

    public InitialDeck(){
        this.general=new HashMap<GeneralDeck,Object>();
    }


    public InitialDeck(HashMap<GeneralDeck, Object> general){
        this.general = general;
    }

    public HashMap<GeneralDeck, Object> getGeneralMap() {
        return general;
    }


    public void setGeneralMap(HashMap<GeneralDeck, Object> general) {
        this.general = general;
    }

    public void addElement(GeneralDeck generalElement, Object object) {
        if(general.containsKey(generalElement)){
            general.remove(generalElement);
        }
        general.put(generalElement, object);
    }

    public void removeElement(GeneralDeck generalElement, Object object) {
        if(general.containsKey(generalElement))
            general.remove(generalElement, object);
    }
    public void removeElement(GeneralDeck generalElement) {
        if(general.containsKey(generalElement))
            general.remove(generalElement,general.get(generalElement));
    }

    public boolean containsGeneralKey(GeneralDeck generalElement){
        return general.containsKey(generalElement);
    }
    //returns null if general does not contain generalElement
    public Object getObject(GeneralDeck generalElement){
        if(general.containsKey(generalElement))
            return general.get(generalElement);
        else
            return null;
    }
}
