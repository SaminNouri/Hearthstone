package initialSpell.spell.condition;

import initialCard.card.Card;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.enumSpellClasses.SpellType;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;

import initialSpell.spell.spellTypes.*;

import java.util.HashMap;

public class ConditionFactory {

    public static Condition build(HashMap<GeneralCondition, Object> map, Card card) throws Exception {
        if (map.containsKey(GeneralCondition.ConditionType)) {
            ConditionType conditionType = ConditionType.valueOf(map.get(GeneralCondition.ConditionType).toString());
            switch (conditionType) {
                case SummonMinion:
                    return new SummonMinionCondition(map,card);
                case DrawCard:
                    return new DrawCardCondition(map,card);
                case MinionTakesDamage:
                    return new MinionTakeDamageCondition(map,card);
                case SpendManaOnMinionQuest:
                    return new SpendManaOnMinionQuest(map,card);
                case TurnBegin:
                    return new TurnBeginCondition(map,card);
                case FriendlyMinionDies:
                    return new FriendlyMinionDies(map,card);

            }
        }
        return null;

    }













}
