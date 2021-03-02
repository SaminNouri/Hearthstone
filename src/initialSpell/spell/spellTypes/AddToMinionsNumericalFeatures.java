package initialSpell.spell.spellTypes;


import initialCard.card.Card;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.spell.ComplexSpell;
import targets.MyTargetHandler;

import java.util.HashMap;

/**
 * Created by Data on 3/12/2020.
 */
public class AddToMinionsNumericalFeatures extends ComplexSpell
{
    private int addedAttack;
    private int addedHp;

    public AddToMinionsNumericalFeatures(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
        if(generalSpell.containsKey(GeneralSpell.AddedAttack)) {
            setAddedAttack(Integer.valueOf(generalSpell.get(GeneralSpell.AddedAttack).toString()));
        }
        if(generalSpell.containsKey(GeneralSpell.AddedHp)) {
            setAddedAttack(Integer.valueOf(generalSpell.get(GeneralSpell.AddedHp).toString()));
        }
    }

    public int getAddedAttack() {
        return addedAttack;
    }

    public void setAddedAttack(int addedAttack) {
        this.addSpellElement(GeneralSpell.AddedAttack,addedAttack);
        this.addedAttack = addedAttack;
    }

    public int getAddedHp() {
        return addedHp;
    }

    public void setAddedHp(int addedHp) {
        this.addSpellElement(GeneralSpell.AddedHp,addedHp);
        this.addedHp = addedHp;
    }


}
