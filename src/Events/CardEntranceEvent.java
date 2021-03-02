package Events;

import game.GameContext;
import initialCard.card.Card;
import initialCard.enumClasses.Type;
import initialSpell.enumSpellClasses.SpellType;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.condition.ConditionHandler;

import java.util.ArrayList;

public class CardEntranceEvent extends GameEvent {

    private GameContext gameContext;
    private Card enteredCard;
    private Card selectedCard;
    private ArrayList<Card> cards;

    public CardEntranceEvent(GameContext gameContext, Card card,Card selectedCard, ArrayList<Card> cards){

        this.enteredCard=card;
        this.gameContext=gameContext;
        this.selectedCard=selectedCard;
        this.cards=cards;

    }
    @Override
    boolean isAllowed() {
        return true;
    }

    @Override
    public void performAction() {

        if(enteredCard.getType()== Type.MinionCard)
        {

            if(enteredCard.getSpell1()!=null && (enteredCard.getSpell1().isBattlecry() || enteredCard.getSpell1().getSpellType()==SpellType.ConditionalSpell))
            {

                if(enteredCard.getSpell1().isBattlecry() && enteredCard.getSpell1().getSpellType()!= SpellType.ConditionalSpell) {
                    enteredCard.getSpell1().performOnTargets(gameContext, enteredCard, selectedCard, cards);
                }
                if( enteredCard.getSpell1().getSpellType()== SpellType.ConditionalSpell)
                    ConditionHandler.getInstance().addCondition(enteredCard.getSpell1().getCondition());
            }
            if(enteredCard.getSpell2()!=null  && (enteredCard.getSpell2().isBattlecry()  || enteredCard.getSpell2().getSpellType()==SpellType.ConditionalSpell))
            {
                if(enteredCard.getSpell2().isBattlecry() && enteredCard.getSpell1().getSpellType()!= SpellType.ConditionalSpell)
                     enteredCard.getSpell2().performOnTargets(gameContext,enteredCard,selectedCard,cards);
                if( enteredCard.getSpell2().getSpellType()== SpellType.ConditionalSpell)
                    ConditionHandler.getInstance().addCondition(enteredCard.getSpell2().getCondition());
            }
        }
        if(enteredCard.getType()== Type.SpellCard)
        {
            if(enteredCard.getSpell1()!=null   && (enteredCard.getSpell1().isBattlecry() || enteredCard.getSpell1().getSpellType()==SpellType.ConditionalSpell))
            {
                if(enteredCard.getSpell1().isBattlecry() && enteredCard.getSpell1().getSpellType()!= SpellType.ConditionalSpell)
                     enteredCard.getSpell1().performOnTargets(gameContext,enteredCard,selectedCard,cards);
                if( enteredCard.getSpell1().getSpellType()== SpellType.ConditionalSpell)
                    ConditionHandler.getInstance().addCondition(enteredCard.getSpell1().getCondition());
            }
            if(enteredCard.getSpell2()!=null  &&( enteredCard.getSpell2().isBattlecry() || enteredCard.getSpell2().getSpellType()==SpellType.ConditionalSpell))
            {
                if(enteredCard.getSpell2().isBattlecry() && enteredCard.getSpell2().getSpellType()!= SpellType.ConditionalSpell)
                    enteredCard.getSpell2().performOnTargets(gameContext,enteredCard,selectedCard,cards);
                if(enteredCard.getSpell2().getSpellType()== SpellType.ConditionalSpell)
                    ConditionHandler.getInstance().addCondition(enteredCard.getSpell2().getCondition());
            }

        }
        if(enteredCard.getType()== Type.WeaponCard)
        {
            if(enteredCard.getSpell1()!=null   && (enteredCard.getSpell1().isBattlecry()  || enteredCard.getSpell1().getSpellType()==SpellType.ConditionalSpell))
            {
                if(enteredCard.getSpell1().isBattlecry() && enteredCard.getSpell1().getSpellType()!= SpellType.ConditionalSpell)
                     enteredCard.getSpell1().performOnTargets(gameContext,enteredCard,selectedCard,cards);
                if( enteredCard.getSpell1().getSpellType()== SpellType.ConditionalSpell)
                    ConditionHandler.getInstance().addCondition(enteredCard.getSpell1().getCondition());
            }
            if(enteredCard.getSpell2()!=null  && (enteredCard.getSpell2().isBattlecry()  || enteredCard.getSpell2().getSpellType()==SpellType.ConditionalSpell))
            {

                if(enteredCard.getSpell2().isBattlecry() && enteredCard.getSpell1().getSpellType()!= SpellType.ConditionalSpell)
                    enteredCard.getSpell2().performOnTargets(gameContext,enteredCard,selectedCard,cards);
                if(enteredCard.getSpell2().getSpellType()== SpellType.ConditionalSpell)
                    ConditionHandler.getInstance().addCondition(enteredCard.getSpell2().getCondition());
            }

        }
        if(enteredCard.getType()== Type.HeroPower)
        {
            if(enteredCard.getSpell1()!=null   && (enteredCard.getSpell1().isBattlecry()  || enteredCard.getSpell1().getSpellType()==SpellType.ConditionalSpell))
            {
                if(enteredCard.getSpell1().isBattlecry() && enteredCard.getSpell1().getSpellType()!= SpellType.ConditionalSpell)
                    enteredCard.getSpell1().performOnTargets(gameContext,enteredCard,selectedCard,cards);
                if( enteredCard.getSpell1().getSpellType()== SpellType.ConditionalSpell)
                    ConditionHandler.getInstance().addCondition(enteredCard.getSpell1().getCondition());
            }
            if(enteredCard.getSpell2()!=null  && (enteredCard.getSpell2().isBattlecry()  || enteredCard.getSpell2().getSpellType()==SpellType.ConditionalSpell))
            {

                if(enteredCard.getSpell2().isBattlecry() && enteredCard.getSpell1().getSpellType()!= SpellType.ConditionalSpell)
                    enteredCard.getSpell2().performOnTargets(gameContext,enteredCard,selectedCard,cards);
                if( enteredCard.getSpell2().getSpellType()== SpellType.ConditionalSpell)
                    ConditionHandler.getInstance().addCondition(enteredCard.getSpell2().getCondition());
            }

        }

    }
}
