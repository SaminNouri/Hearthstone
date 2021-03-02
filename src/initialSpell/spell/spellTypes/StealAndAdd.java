package initialSpell.spell.spellTypes;

import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.enumSpellClasses.SpellType;
import initialSpell.spell.ComplexSpell;

import java.util.HashMap;

/**
 * Created by Data on 3/12/2020.
 */
public class StealAndAdd extends ComplexSpell
{
    private static final SpellType spellType=SpellType.StealAndAdd;



    public StealAndAdd(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);

    }
}
