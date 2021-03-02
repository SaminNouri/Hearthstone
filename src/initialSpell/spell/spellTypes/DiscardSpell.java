package initialSpell.spell.spellTypes;

import initialCard.card.Card;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import targets.MyTargetHandler;

import java.util.HashMap;

public class DiscardSpell extends ComplexSpell {
    public DiscardSpell(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
    }

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler) {
        myTargetHandler.getGameContext().getCurrentHand().getHandsCards().remove(target);
    }
}
