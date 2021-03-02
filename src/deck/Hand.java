package deck;

import cardList.CardList;
import characters.Hero;
import characters.HeroCreator;
import characters.Minion;
import collection.Collection;
import game.GameContext;
import game.GameMapper;
import initialCard.card.Card;
import initialCard.card.MinionCard;
import initialCard.card.cardFactory.CardCreator;
import initialCard.enumClasses.Feature;
import initialCard.enumClasses.HeroType;
import initialCard.enumClasses.Type;
import initialSpell.enumSpellClasses.SpellType;
import initialSpell.spell.condition.Condition;
import initialSpell.spell.condition.ConditionHandler;
import playersCards.PlayersCards;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Data on 4/24/2020.
 */
public class Hand {


    private Deck currentDeck;
    private Deck deck;
    private ArrayList<Card> cards;
    private ArrayList<Card> handsCards;
    private Hero hero;
    private PlayersCards playersCards;
    private Card passiveCard;
    private ArrayList<Card> passives;
    private ArrayList<Card> myPassives;
    private Card addedCard;
    private Integer owner;
    private ArrayList<Card> deadCards;
    private ArrayList<Card> initialInDeckCards;
    private Card card1;
    private Card card2;
    private Card card3;
    private boolean bCard1=false;
    private boolean bCard2=false;
    private boolean bCard3=false;

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
        identifyCards();
    }

    public Deck getCurrentDeck() {
        return currentDeck;
    }

    public Card getCard1() {
        return card1;
    }

    public void setCard1(Card card1) {
        this.card1 = card1;
    }

    public Card getCard2() {
        return card2;
    }

    public void setCard2(Card card2) {
        this.card2 = card2;
    }

    public Card getCard3() {
        return card3;
    }

    public void setCard3(Card card3) {
        this.card3 = card3;
    }

    public void setCurrentDeck(Deck currentDeck) {
        this.currentDeck = currentDeck;
    }

    public Hand(Deck deck, PlayersCards playersCards) throws Exception {
        currentDeck=deck;
        this.deck=deck;
        this.playersCards=playersCards;
        passives=playersCards.getPassiveCards();
        Collections.shuffle(passives);
        myPassives=new ArrayList<Card>();
        myPassives.add(passives.get(0));
        myPassives.add(passives.get(1));
        myPassives.add(passives.get(2));
        cards=copyCards(deck.getCardListDeck().getCardList());
        System.out.print("hand:"+cards);
        handsCards=new ArrayList<Card>();
        if(!deck.getName().equals("Enemy") && !deck.getName().equals("Friend"))
           Collections.shuffle(cards);
        addCardToHand();
        card1=addedCard;
        addCardToHand();
        card2=addedCard;
        addCardToHand();
        card3=addedCard;
        hero= HeroCreator.createHeroWithName(deck.getHeroType().toString());
        identifyCards();
        deadCards=new ArrayList<Card>();
        initialInDeckCards=new ArrayList<Card>();
        initialInDeckCards=getCopy(cards);



    }

    private ArrayList<Card> copyCards(ArrayList<Card> cardList) {
        ArrayList<Card> temp=new ArrayList<Card>();
        for(Card card:cardList)
        {

            try {
                temp.add( card.copyCard());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return temp;

    }

    public ArrayList<Card> getCopy( ArrayList<Card> cards){
        ArrayList<Card> temp=new ArrayList<Card>();
        for(Card card:cards){
            temp.add(card);
        }
        return temp;
    }

    public ArrayList<Card> getInitialInDeckCards() {
        return initialInDeckCards;
    }

    public void setInitialInDeckCards(ArrayList<Card> initialInDeckCards) {
        this.initialInDeckCards = initialInDeckCards;
    }

    public ArrayList<Card> getMyPassives() {
        return myPassives;
    }

    public void setPassiveCard(Card passiveCard) {

        try {
            this.passiveCard = CardCreator.createCardWithName(passiveCard.getName());
            if(owner!=null)
                this.passiveCard.setOwnerIndex(owner);
            this.passiveCard.setOwnerIndex(GameMapper.getGameContext().getPlayersIndex());
            passiveCard.setOwnerIndex(GameMapper.getGameContext().getPlayersIndex());
            Card enteredCard=passiveCard;
            GameContext gameContext=GameMapper.getGameContext();
                if(enteredCard.getSpell1()!=null   && (enteredCard.getSpell1().isBattlecry() || enteredCard.getSpell1().getSpellType()==SpellType.ConditionalSpell))
                {
                    if(enteredCard.getSpell1().isBattlecry() && enteredCard.getSpell1().getSpellType()!= SpellType.ConditionalSpell)
                        enteredCard.getSpell1().performOnTargets(gameContext,enteredCard,null,null);
                    if( enteredCard.getSpell1().getSpellType()== SpellType.ConditionalSpell)
                        ConditionHandler.getInstance().addCondition(enteredCard.getSpell1().getCondition());
                }
                if(enteredCard.getSpell2()!=null  && (enteredCard.getSpell2().isBattlecry() || enteredCard.getSpell2().getSpellType()==SpellType.ConditionalSpell))
                {
                    if(enteredCard.getSpell2().isBattlecry() && enteredCard.getSpell2().getSpellType()!= SpellType.ConditionalSpell)
                        enteredCard.getSpell2().performOnTargets(gameContext,enteredCard,null, null);
                    if(enteredCard.getSpell2().getSpellType()== SpellType.ConditionalSpell)
                        ConditionHandler.getInstance().addCondition(enteredCard.getSpell2().getCondition());
                }




        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Card getPassiveCard() {
        return passiveCard;
    }

    public HeroType getCurrentHero(){
        //System.out.println(deck.getHeroType()+"mew");
       // System.out.println(deck.getName());
        return deck.getHeroType();
    }

    public Hero getHero() {
        return hero;
    }

    public ArrayList<Card> getHandsCards() {
        return handsCards;
    }

    public void setHandsCards(ArrayList<Card> handsCards) {
        this.handsCards = handsCards;
    }

    public int remainedCards(){
       return cards.size();
   }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    public boolean addCardToHand(){

        if(isHandfull())
            return false;
        if(cards.size()==0)
            return false;
        handsCards.add(cards.get(0));
        addedCard=cards.get(0);
        GameMapper.setAddedCardToHand(addedCard);
        cards.remove(0);
        identifyCards();
        try {
            GameMapper.getInstance().addRequest(GameMapper.RequestType.Draw_Card);
            ConditionHandler.handleDrawCardCondition(addedCard,GameMapper.getGameContext());
        }catch (Exception e){}
        return true;
    }

    public boolean addCardToHand(Card card){

        if(isHandfull())
            return false;
        if(cards.size()==0)
            return false;
        GameMapper.setAddedCardToHand(card);
        handsCards.add(card);
        cards.remove(card);
        identifyCards();
        try {
            GameMapper.getInstance().addRequest(GameMapper.RequestType.Draw_Card);
            ConditionHandler.handleDrawCardCondition(card,GameMapper.getGameContext());

        }catch (Exception e){}
        return true;
    }

    public void setAddedCard(Card addedCard) {
        this.addedCard = addedCard;
    }

    public boolean isHandfull(){
        if(handsCards.size()>=12)
            return true;
        else
            return false;
    }
    public Card getNextCard(){
        return cards.get(0);
    }
    public boolean removeCardFromHand(Card card,boolean fromHand){
        if(!fromHand)
            return true;
        if(handsCards.size()==0)
            return false;
        handsCards.remove(card);
        identifyCards();
        return true;
    }
    public int getRemainedCards(){
        return cards.size();
    }

    public Card getAddedCard() {
        return addedCard;
    }
    public int getAddedCardIndex() {
        return handsCards.lastIndexOf(addedCard);
    }

    public void identifyCards(){
        int c=handsCards.size();
        int i=0;
       /* while (true)
        {
            if(i<handsCards.size())
            {
                Card card=handsCards.get(i);
                if(card.getType()== Type.MinionCard)
                {
                    if(((MinionCard)card).getHp()<=0)
                    {
                        deadCards.add(card);
                        handsCards.remove(i);
                        i=-1;
                    }
                }
            }
            else
                break;
            i++;
        }*/

       int counter=0;
        for(Card card:cards)
        {

            card.setOwnerIndex(owner);


        }
    }

    public Card getSpecifiedCard(int owner,int index)
    {
        if(this.owner!=owner)
            return null;
        else if(index>=handsCards.size())
            return null;
        else
        {
            return handsCards.get(index);
        }
    }

    public void discardCard(int index){
        if(index==1 && !bCard1)
        {
            getHandsCards().remove(card1);
            addCardToHand();
            card1=addedCard;
            bCard1=true;
        }
        if(index==2 && !bCard2)
        {
            getHandsCards().remove(card2);
            addCardToHand();
            card2=addedCard;
            bCard2=true;

        }
        if(index==3 && !bCard3)
        {
            getHandsCards().remove(card3);
            addCardToHand();
            card3=addedCard;
            bCard3=true;

        }
    }
}
