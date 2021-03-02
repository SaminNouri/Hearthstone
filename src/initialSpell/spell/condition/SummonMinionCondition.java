package initialSpell.spell.condition;

import game.GameContext;
import initialCard.card.Card;
import initialSpell.spell.ComplexSpell;
import java.util.ArrayList;
import java.util.HashMap;

public class SummonMinionCondition extends Condition {

    private static final ConditionType conditionType= ConditionType.SummonMinion;
    public SummonMinionCondition(HashMap<GeneralCondition, Object> generalMap, Card mainCard) {
        super(generalMap, mainCard);
    }

    public ConditionType getConditionType() {
        return conditionType;
    }


}
