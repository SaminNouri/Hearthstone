package initialSpell.spell.spellTypes;

import game.GameMapper;
import initialCard.card.Card;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import targets.MyTargetHandler;

import java.util.HashMap;

/**
 * Created by Data on 3/12/2020.
 */
public class DrawCard extends ComplexSpell
{
    public DrawCard(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
    }

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler)  {

        try {
              System.out.println("llllllllllllllllllllllllllllll");
              myTargetHandler.getGameContext().getCurrentHand().addCardToHand(target);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
