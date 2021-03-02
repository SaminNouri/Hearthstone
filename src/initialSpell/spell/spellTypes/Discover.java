package initialSpell.spell.spellTypes;

import initialCard.enumClasses.General;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.enumSpellClasses.SpellType;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;

import java.util.HashMap;
import java.util.Map;


public class Discover extends ComplexSpell {
    private static final SpellType spellType=SpellType.Discover;
    private ComplexSpell spell1;
    private int numberOfDiscoveries=1;




    public Discover(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
        for(GeneralSpell key:GeneralSpell.values())
        {
            if(generalSpell.containsKey(key))
            {
                Object value=generalSpell.get(key);
                setFeature(key,value);

            }
        }
    }
    @Override
    public void setSpellType(SpellType spellType)  {

    }




    @Override
    public void setFeature(GeneralSpell key, Object value) throws Exception {
        //super.setFeature(key, value);
        switch (key)
        {


            case NumberOfDiscoveries:
                setNumberOfSpells(Integer.valueOf(value.toString()));
                break;
            case Spell1:
                if(value instanceof Spell)
                    setSpell1((ComplexSpell) value);
                else
                    setSpell1((HashMap<GeneralSpell, Object>) value);
                break;

        }
    }




    public int getNumberOfDiscoveries() {
        return numberOfDiscoveries;
    }

    public void setNumberOfDiscoveries(int numberOfDiscoveries) {
        this.addSpellElement(GeneralSpell.NumberOfSpells,numberOfDiscoveries);
        this.numberOfDiscoveries = numberOfDiscoveries;
    }

    public SpellType getSpellType() {
        return spellType;
    }

    public void setSpell1(ComplexSpell spell1) {
        this.addSpellElement(GeneralSpell.Spell1,spell1.getGeneralSpellMap());
        this.spell1 = spell1;
    }
    public void setSpell1(HashMap<GeneralSpell,Object> generalSpell) throws Exception {
        this.addSpellElement(GeneralSpell.Spell1,generalSpell);
        spell1=new ComplexSpell(generalSpell);

    }
    public Spell getSpell1() {
        return spell1;
    }


}
