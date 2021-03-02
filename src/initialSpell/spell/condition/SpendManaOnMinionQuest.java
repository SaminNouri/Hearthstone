package initialSpell.spell.condition;

import initialCard.card.Card;
import initialCard.enumClasses.Feature;

import java.util.HashMap;

public class SpendManaOnMinionQuest extends Condition {
    private int value;
    private int currentValue=0;
    private static final ConditionType conditionType= ConditionType.SpendManaOnMinionQuest;
    public SpendManaOnMinionQuest(HashMap<GeneralCondition, Object> generalMap, Card mainCard) {
        super(generalMap, mainCard);
        if(generalMap.containsKey(GeneralCondition.Value))
        {
             value= (int) Math.round(Float.valueOf(generalMap.get(GeneralCondition.Value)+"" ));

        }
    }
    public void addValue(int num){
        currentValue+=num;
    }

    @Override
    public ConditionType getConditionType() {
        return conditionType;
    }
    public Boolean isAllowed(){
        if(currentValue<value)
            return false;
        return true;
    }
}
