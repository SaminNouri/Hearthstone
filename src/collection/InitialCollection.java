package collection;

import cardList.CardListDeck;
import collection.enumCollectionClasses.GeneralCollection;
import deck.Deck;
import deck.enumDeckClasses.GeneralDeck;

import java.util.HashMap;

/**
 * Created by Data on 3/14/2020.
 */
public abstract class InitialCollection
{
    protected HashMap<GeneralCollection, Object> general;

    public InitialCollection(){
        this.general=new HashMap<GeneralCollection, Object>();
    }


    public InitialCollection(HashMap<GeneralCollection, Object> general){
        this.general = general;
    }

    public HashMap<GeneralCollection, Object> getGeneralMap() {
        return general;
    }


    public void setGeneralMap(HashMap<GeneralCollection, Object> general) {
        this.general = general;
    }

    public void addElement(GeneralCollection generalElement, Object object) {
        if(general.containsKey(generalElement)){
            general.remove(generalElement);
        }
        general.put(generalElement, object);
    }

    public void removeElement(GeneralCollection generalElement, Object object) {
        if(general.containsKey(generalElement))
            general.remove(generalElement, object);
    }
    public void removeElement(GeneralCollection generalElement) {
        if(general.containsKey(generalElement))
            general.remove(generalElement,general.get(generalElement));
    }

    public boolean containsGeneralKey(GeneralCollection generalElement){
        return general.containsKey(generalElement);
    }
    //returns null if general does not contain generalElement
    public Object getObject(GeneralCollection generalElement){
        if(general.containsKey(generalElement))
            return general.get(generalElement);
        else
            return null;
    }

}
