package initialSpell.spell.spellTypes;

import game.GameContext;
import game.GameMapper;
import initialCard.card.Card;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import targets.MyTargetHandler;

import java.util.ArrayList;
import java.util.HashMap;

public class MinionCostLess extends ComplexSpell {
    public MinionCostLess(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);

    }

    @Override
    public void performOnTargets(GameContext gameContext, Card card, Card selectedCard, ArrayList<Card> cards) {
        performOnTarget(null,null);
    }

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler) {
        ArrayList<Card> list= GameMapper.getGameContext().getCurrentHand().getCards();
        ArrayList<Card> temp=GameMapper.getGameContext().getCurrentHand().getHandsCards();
        for (Card card:list)
        {
            if(card.getInitialManaCost()>=1)
            {
                card.setInitialManaCost(card.getInitialManaCost()-1);
            }
        }
        for (Card card:temp)
        {
            if(card.getInitialManaCost()>=1)
            {
                card.setInitialManaCost(card.getInitialManaCost()-1);
            }
        }
    }
}
