package initialSpell.spell.spellTypes;

import game.GameContext;
import initialCard.card.Card;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import initialSpell.spell.condition.Condition;
import initialSpell.spell.condition.ConditionHandler;
import targets.MyTargetHandler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Data on 3/12/2020.
 */
public class ConditionalSpell extends ComplexSpell
{
    Condition condition;

    public ConditionalSpell(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
        condition=getCondition();
        if(condition!=null && !isBattlecry() && !isDeathrattle())
          ConditionHandler.getInstance().addCondition(condition);

    }



    @Override
    public void performOnTargets(GameContext gameContext, Card card, Card selectedCard, ArrayList<Card> cards){
        ((ComplexSpell)getSpell1FirstInnerSpell()).performOnTargets(gameContext,card,selectedCard,cards);

    }
}
