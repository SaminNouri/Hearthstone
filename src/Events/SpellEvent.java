package Events;

import initialCard.card.Card;
import initialSpell.spell.Spell;

public class SpellEvent extends GameEvent{

    Card mainCard;
    Spell firstSpell;
    Spell secondSpell;


    @Override
    boolean isAllowed() {
        return false;
    }

    @Override
    void performAction() {

    }
}
