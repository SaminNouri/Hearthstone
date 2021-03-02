package initialSpell.spell.spellTypes;


import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.enumSpellClasses.SpellType;
import initialSpell.spell.ComplexSpell;

import java.util.HashMap;

/**
 * Created by Data on 3/9/2020.
 */
public class SetWeaponsNumericalFeatures extends ComplexSpell
{
    private static final SpellType spellType=SpellType.AddWeaponsNumericalFeatures;
    private int secondaryDurability;
    private int secondaryDamage;

    public int getSecondaryDamage() {
        return secondaryDamage;
    }

    public void setSecondaryDamage(int secondaryDamage) {
        this.addSpellElement(GeneralSpell.SecondaryDamage,secondaryDamage);
        this.secondaryDamage = secondaryDamage;
    }

    public int getSecondaryDurability() {
        return secondaryDurability;
    }

    public void setSecondaryDurability(int secondaryDurability) {
        this.addSpellElement(GeneralSpell.SecondaryDurability,secondaryDurability);
        this.secondaryDurability = secondaryDurability;
    }


    public SetWeaponsNumericalFeatures(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
        if(generalSpell.containsKey(GeneralSpell.SecondaryDamage))
            setSecondaryDamage(Integer.valueOf(generalSpell.get(GeneralSpell.SecondaryDamage).toString()));
        if(generalSpell.containsKey(GeneralSpell.SecondaryDurability))
            setSecondaryDamage(Integer.valueOf(generalSpell.get(GeneralSpell.SecondaryDurability).toString()));

    }

    @Override
    public void setSpellType(SpellType spellType)  {

    }



    @Override
    public void setFeature(GeneralSpell key, Object value)
    {
        switch (key)
        {
            case SecondaryDamage:
                setSecondaryDamage(Integer.valueOf(value.toString()));
                break;
            case SecondaryDurability:
                setSecondaryDurability(Integer.valueOf(value.toString()));
                break;



        }
    }
}
