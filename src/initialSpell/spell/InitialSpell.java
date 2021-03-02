package initialSpell.spell;


import initialCard.enumClasses.General;
import initialSpell.enumSpellClasses.GeneralSpell;

import java.util.HashMap;

/**
 * Created by Data on 3/9/2020.
 */
public abstract class InitialSpell
{
    protected HashMap<GeneralSpell, Object> generalSpell;

    public InitialSpell(){
        this.generalSpell=new HashMap<GeneralSpell, Object>();
    }
    public InitialSpell(HashMap<GeneralSpell, Object> generalSpell){
        this.generalSpell = generalSpell;
    }

    public HashMap<GeneralSpell, Object> getGeneralSpellMap() {
        return generalSpell;
    }
    public void setGeneralSpellMap(HashMap<GeneralSpell, Object> generalSpell) {
        this.generalSpell = generalSpell;
    }
    public void addSpellElement(GeneralSpell generalSpellElement, Object object) {
        if(generalSpell.containsKey(generalSpellElement)){
            generalSpell.remove(generalSpellElement);
        }
        generalSpell.put(generalSpellElement, object);
    }
    public void removeSpellElement(GeneralSpell generalSpellElement, Object object) {
        if(generalSpell.containsKey(generalSpellElement))
            generalSpell.remove(generalSpellElement, object);
    }
    public void removeSpellElement(General generalElement) {
        if(generalSpell.containsKey(generalElement))
            generalSpell.remove(generalElement,generalSpell.get(generalElement));
    }
    public boolean containsGeneralSpellKey(GeneralSpell generalSpellElement){
        return generalSpell.containsKey(generalSpellElement);
    }
    //returns null if general does not contain generalElement
    public Object getSpellObject(GeneralSpell generalSpellElement){
        if(generalSpell.containsKey(generalSpellElement))
            return generalSpell.get(generalSpellElement);
        else
            return null;
    }


}
