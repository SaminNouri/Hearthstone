package initialSpell.spell.condition;


import initialCard.card.Card;
import initialCard.card.MinionCard;
import java.util.ArrayList;
import java.util.HashMap;

public class MinionTakeDamageCondition extends Condition {

    private static final ConditionType conditionType= ConditionType.MinionTakesDamage;


    public MinionTakeDamageCondition(HashMap<GeneralCondition, Object> generalMap, Card mainCard) {
        super(generalMap, mainCard);
    }

    public  ConditionType getConditionType() {
        return conditionType;
    }


}
