package initialSpell.spell.spellTypes;

import game.GameContext;
import initialCard.card.Card;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import targets.MyTargetHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Data on 3/12/2020.
 */
public class RandonSpell extends ComplexSpell
{
    private int randomNumber;

    public RandonSpell(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
    }

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler) {

    }

    @Override
    public void performOnTargets(GameContext gameContext, Card card, Card selectedCard, ArrayList<Card> cards) {
        if(Math.random() < 0.5) {
        getSpell1FirstInnerSpell().performOnTargets(gameContext,card,selectedCard,cards);
        }else{
        getSpell1SecondInnerSpell().performOnTargets(gameContext,card,selectedCard,cards);
        }
    }

    public int getRandomNumber(){
        Random r=new Random();
        this.randomNumber=r.nextInt()+1;
        return randomNumber;
    }
}
