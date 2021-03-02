package initialSpell.spell.condition;

import initialCard.card.Card;

import java.util.HashMap;

public class TurnBeginCondition extends Condition {

    private static final ConditionType conditionType= ConditionType.TurnBegin;
    private int ownersIndex;

    public int getOwnersIndex() {
        return ownersIndex;
    }

    public void setOwnersIndex(int ownersIndex) {
        this.ownersIndex = ownersIndex;
    }

    public TurnBeginCondition(HashMap<GeneralCondition, Object> generalMap, Card mainCard) {
        super(generalMap, mainCard);
    }



    @Override
    public ConditionType getConditionType() {
        return conditionType;
    }
    public Boolean isAllowed(){

        return true;
    }
}
