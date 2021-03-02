package initialSpell.spell.condition;

import initialCard.card.Card;

import java.util.HashMap;

public class FriendlyMinionDies extends Condition {
    public FriendlyMinionDies(HashMap<GeneralCondition, Object> generalMap, Card mainCard) {
        super(generalMap, mainCard);
    }
}
