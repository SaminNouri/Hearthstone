package initialSpell.spell.condition;

import game.GameContext;
import initialCard.card.Card;
import initialCard.card.MinionCard;
import initialCard.card.WeaponCard;
import initialCard.enumClasses.Type;
import initialSpell.spell.ComplexSpell;
import targets.MyTargetHandler;

import java.awt.*;
import java.lang.reflect.Array;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DrawCardCondition extends Condition  {

    private static final ConditionType conditionType= ConditionType.DrawCard;
    private Card drawnCard;

    public DrawCardCondition(HashMap<GeneralCondition, Object> generalMap,Card mainCard) {
        super(generalMap,mainCard);
    }

    public ConditionType getConditionType() {
        return conditionType;
    }



    /*  private static HashMap<ComplexSpell, Card>  wheneverSpells=new HashMap<ComplexSpell, Card>();


    public DrawCardCondition(HashMap<GeneralCondition, Object> generalMap) {
        super(generalMap);
    }

    public static void addSpell(ComplexSpell spell,Card card){

        if(spell.isWhenever())
        {
            addWheneverSpells(spell,card);
        }
    }
    private static void addWheneverSpells(ComplexSpell spell,Card card){
        wheneverSpells.put(spell,card);
    }

    public static void conditionIsDone(GameContext gameContext,Card drawnCard){
        checkForDeadCards();
        for (Map.Entry<ComplexSpell,Card> entry : wheneverSpells.entrySet()) {
            Card card=entry.getValue();
            if(gameContext.getPlayersIndex()==entry.getValue().getOwnerIndex() )
               entry.getKey().performOnTargets(gameContext,entry.getValue(),drawnCard);

        }

    }

    private static void checkForDeadCards() {

        int counter=wheneverSpells.size();
        ArrayList<Card> removedCards=new ArrayList<Card>();
        for (Map.Entry<ComplexSpell,Card> entry : wheneverSpells.entrySet()) {
            Card card=entry.getValue();
            if(card.getType()==Type.MinionCard)
                if(((MinionCard)card).getHp()<=0)
                    removedCards.add(card);
            if(card.getType()==Type.WeaponCard)
                if(((WeaponCard)card).getDurability()<=0)
                    removedCards.add(card);

        }

        Iterator<Map.Entry<ComplexSpell, Card> > iterator = wheneverSpells.entrySet().iterator();
        while (iterator.hasNext()) {

            Map.Entry<ComplexSpell, Card> entry = iterator.next();

            if (removedCards.contains( entry.getKey())) {

                iterator.remove();
            }
        }
    }*/



}
