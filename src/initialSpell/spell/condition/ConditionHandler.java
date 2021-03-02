package initialSpell.spell.condition;

import game.GameContext;
import game.GameMapper;
import initialCard.card.Card;
import initialSpell.spell.spellTypes.DrawCard;

import java.util.ArrayList;
import java.util.ListIterator;

public class ConditionHandler {

    private static ArrayList<Condition> conditions=new ArrayList<Condition>();
    private static ConditionHandler instance;
    private static int turnCounterBegin=-10;
    private static int turnCounterManaMinion=-10;
    private static int turnCounterDraw=-10;


    private ConditionHandler() {


    }

    public static ConditionHandler getInstance(){
        if(instance==null)
            return new ConditionHandler();
        else
            return instance;
    }

    public static void handleDrawCardCondition(Card drawnCard,GameContext gameContext){
        ArrayList<Card> cards=new ArrayList<Card>();
        cards.add(drawnCard);
        for(Condition condition:conditions)
        {
            if(condition.getConditionType()== ConditionType.DrawCard)
            {
                if(GameMapper.getTurn()==turnCounterDraw)
                    return;
                Card mainCard=condition.getMainCard();
                //System.out.println();
                //System.out.println();
               // System.out.println("mainCard:"+mainCard);
               // System.out.println();
               // System.out.println();
                if(mainCard.getOwnerIndex()==drawnCard.getOwnerIndex())
                {
                    condition.perform(gameContext,cards,null);
                  turnCounterDraw=  GameMapper.getTurn();
                }
            }
        }
    }

    public static void handleSummonedCardCondition(Card card,GameContext gameContext){
        ArrayList<Card> cards=new ArrayList<Card>();
        cards.add(card);
        for(Condition condition:conditions)
        {
            if(condition.getConditionType()== ConditionType.SummonMinion)
            {
                Card mainCard=condition.getMainCard();
                if(mainCard.getOwnerIndex()==card.getOwnerIndex())
                {
                    condition.perform(gameContext,cards,null);
                }
            }
        }
    }

    public static void handleMiniontTakesDamageCondition(Card card,GameContext gameContext){
        ArrayList<Card> cards=new ArrayList<Card>();
        cards.add(card);
        for(Condition condition:conditions)
        {
            if(condition.getConditionType()== ConditionType.MinionTakesDamage)
            {
                Card mainCard=condition.getMainCard();
                if(mainCard.getOwnerIndex()==card.getOwnerIndex())
                {
                    if(condition.getMainCard().equals(card)) {
                        condition.perform(gameContext, cards, null);
                    }
                }
            }
        }
    }

    public static  void addCondition(Condition condition)
    {
        if(conditions==null)
        {
            conditions=new ArrayList<Condition>();
        }
        conditions.add(condition);
    }


    public static void handleSpendManaOnMinionQuest(Card card,GameContext gameContext){
        ArrayList<Card> cards=new ArrayList<Card>();
        cards.add(card);

        ListIterator<Condition> iter = conditions.listIterator();
        while (iter.hasNext()) {
            Condition condition=iter.next();

            if(condition.getConditionType()== ConditionType.SpendManaOnMinionQuest)
            {
                Card mainCard=condition.getMainCard();
                if(mainCard.getOwnerIndex()==card.getOwnerIndex())
                {

                    ((SpendManaOnMinionQuest)condition).addValue(card.getInitialManaCost());

                    if(((SpendManaOnMinionQuest)condition).isAllowed()) {

                        condition.perform(gameContext, cards, null);
                        iter.remove();
                    }
                }
            }


        }
    }


    public static void handleBeginTurn(Card card,GameContext gameContext){

        gameContext= GameMapper.getGameContext();
        ListIterator<Condition> iter = conditions.listIterator();
        while (iter.hasNext()) {
            Condition condition=iter.next();

            if(condition.getConditionType()== ConditionType.TurnBegin)
            {
                Card mainCard=condition.getMainCard();
                if(mainCard.getOwnerIndex()==null ||  mainCard.getOwnerIndex()==gameContext.getPlayersIndex())
                {
                    if(GameMapper.getTurn()==turnCounterBegin)
                        return;



                        condition.perform(gameContext, null, null);
                        turnCounterBegin=GameMapper.getTurn();




                }
            }


        }
    }

    public static void handleFriendlyMinionDies(int hurtIndex){

        GameContext gameContext;
        gameContext= GameMapper.getGameContext();
        ListIterator<Condition> iter = conditions.listIterator();
        while (iter.hasNext()) {
            Condition condition=iter.next();

            if(condition.getConditionType()== ConditionType.FriendlyMinionDies)
            {
                Card mainCard=condition.getMainCard();
                if(mainCard.getOwnerIndex()==null ||  mainCard.getOwnerIndex()==hurtIndex)
                {



                    condition.perform(gameContext, null, null);



                }
            }


        }

    }










}
