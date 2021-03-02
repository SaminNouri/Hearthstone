package initialSpell.spell.spellTypes;

import game.GameContext;
import game.GameMapper;
import initialCard.card.Card;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import targets.MyTargetHandler;

import java.util.ArrayList;
import java.util.HashMap;

public class CostLessHeroPower extends ComplexSpell {
    public CostLessHeroPower(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
    }

    @Override
    public void performOnTargets(GameContext gameContext, Card card, Card selectedCard, ArrayList<Card> cards) {
        performOnTarget(card,null);
    }

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler) {
        GameMapper.getGameContext().getHero().getHeroPower().setInitialManaCost(GameMapper.getGameContext().getHero().getHeroPower().getInitialManaCost()-1);
    }
}
