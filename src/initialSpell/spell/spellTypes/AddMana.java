package initialSpell.spell.spellTypes;

import game.GameContext;
import game.GameMapper;
import graphics.ScreenController;
import initialCard.card.Card;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import targets.MyTargetHandler;

import java.util.ArrayList;
import java.util.HashMap;

public class AddMana extends ComplexSpell {
    public AddMana(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
    }

    @Override
    public void performOnTargets(GameContext gameContext, Card card, Card selectedCard, ArrayList<Card> cards) {
        performOnTarget(null,null);
    }

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler) {
        GameMapper.getGameContext().setMaxManaCost(GameMapper.getGameContext().getMaxManaCost()+1);
        GameMapper.getGameContext().setCurrentMana(GameMapper.getGameContext().getMaxManaCost());
        try {
            GameMapper.getBattlefieldController().update();
        }catch (Exception e){

        }
    }
}
