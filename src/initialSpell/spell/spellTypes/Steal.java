package initialSpell.spell.spellTypes;

import initialCard.enumClasses.General;
import initialSpell.enumSpellClasses.From;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.enumSpellClasses.Target;
import initialSpell.spell.ComplexSpell;

import java.util.HashMap;

public class Steal extends ComplexSpell
{
    private From from;
    private final Target target=Target.Enemys;
    private HashMap<General,Object> filter;

    public Steal(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
        if(generalSpell.containsKey(GeneralSpell.Filter))
            setFilter((HashMap<General, Object>)generalSpell.get(GeneralSpell.Filter));
        if(generalSpell.containsKey(GeneralSpell.From))
            setFrom((From)generalSpell.get(GeneralSpell.From));
    }

    public HashMap<General, Object> getFilter() {
        return filter;
    }

    public void setFilter(HashMap<General, Object> filter) {
        this.addSpellElement(GeneralSpell.Filter,filter);
        this.filter = filter;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.addSpellElement(GeneralSpell.From,from);
        this.from = from;
    }


}
