package game;

import characters.Weapon;
import deck.Hand;
import graphics.CardLocation;
import initialCard.card.Card;
import initialCard.card.MinionCard;
import initialCard.enumClasses.Feature;
import initialCard.enumClasses.Type;

import java.util.ArrayList;
import java.util.HashMap;

public class BattlefieldPlayer {
    private Hand hand;
    private ArrayList<Card> minions;
    private ArrayList<Card> spellCards;
    private ArrayList<Card> questCards;
    private ArrayList<Card> drawnMinions;
    private ArrayList<Card> drawnSpellCards;
    private ArrayList<Card> drawnQuestCards;
    private ArrayList<Card> onBattlefieldCards;
    private HashMap<Integer,Boolean> HCardsLocations;
    private ArrayList<Card> drawnCards;
    private ArrayList<CardLocation> cardLocations;
    private int currentMana=1;
    private int maxManaCost=1;
    private int playersIndex=0;
    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public BattlefieldPlayer(Hand hand, int index) {

        minions=new ArrayList<Card>();
        spellCards=new ArrayList<Card>();
        questCards=new ArrayList<Card>();
        drawnSpellCards=new ArrayList<Card>();
        drawnSpellCards=new ArrayList<Card>();
        drawnQuestCards=new ArrayList<Card>();
        onBattlefieldCards=new ArrayList<Card>();
        drawnMinions=new ArrayList<Card>();
        drawnCards=new ArrayList<Card>();
        HCardsLocations=new HashMap<Integer, Boolean>();
        cardLocations=new ArrayList<CardLocation>();
        playersIndex=index;
        this.hand=hand;
        hand.setOwner(index);
        hand.getHero().setOwner(playersIndex);
        hand.getHero().getCard().setOwnerIndex(playersIndex);
        if(hand.getPassiveCard()!=null)
            hand.getPassiveCard().setOwnerIndex(playersIndex);


    }



    public ArrayList<Card> getCardsWithTaunt(){
        ArrayList<Card> arr=new ArrayList<Card>();
        for(Card card:onBattlefieldCards)
        {
            if(card.getFeaures().containsKey(Feature.Taunt))
                arr.add(card);
        }
        return arr;
    }

    public void identifyCards(){

       int counter=0;
        for(Card card:onBattlefieldCards)
        {

            card.setOwnerIndex(playersIndex);
            card.setId(counter);
            int turnCounter=card.getTurnConter();
            card.setTurnConter((turnCounter)++);
            card.getFeaures().remove(Feature.FirstTurn);
            card.getFeaures().remove(Feature.Attack1);
            card.getFeaures().remove(Feature.Attack2);
            counter++;

        }
        for(Card card:hand.getHandsCards())
        {

            card.setOwnerIndex(playersIndex);
            card.setId(counter);
            int turnCounter=card.getTurnConter();
            card.setTurnConter((turnCounter)++);
            card.getFeaures().remove(Feature.FirstTurn);
            card.getFeaures().remove(Feature.Attack1);
            card.getFeaures().remove(Feature.Attack2);
            counter++;

        }
        for(Card card:hand.getCards())
        {

            card.setOwnerIndex(playersIndex);
            card.setId(counter);
            int turnCounter=card.getTurnConter();
            card.setTurnConter((turnCounter)++);
            card.getFeaures().remove(Feature.FirstTurn);
            card.getFeaures().remove(Feature.Attack1);
            card.getFeaures().remove(Feature.Attack2);
            counter++;

        }
    }

    public Hand getHand() {
        return hand;
    }

    public int getPlayersIndex() {
        return playersIndex;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getMinions() {
        return minions;
    }

    public void setMinions(ArrayList<Card> minions) {
        this.minions = minions;
    }

    public ArrayList<Card> getSpellCards() {
        return spellCards;
    }

    public void setSpellCards(ArrayList<Card> spellCards) {
        this.spellCards = spellCards;
    }

    public ArrayList<Card> getQuestCards() {
        return questCards;
    }

    public void setQuestCards(ArrayList<Card> questCards) {
        this.questCards = questCards;
    }

    public ArrayList<Card> getDrawnMinions() {
        return drawnMinions;
    }

    public void setDrawnMinions(ArrayList<Card> drawnMinions) {
        this.drawnMinions = drawnMinions;
    }

    public ArrayList<Card> getDrawnSpellCards() {
        return drawnSpellCards;
    }

    public void setDrawnSpellCards(ArrayList<Card> drawnSpellCards) {
        this.drawnSpellCards = drawnSpellCards;
    }

    public ArrayList<Card> getDrawnQuestCards() {
        return drawnQuestCards;
    }

    public void setDrawnQuestCards(ArrayList<Card> drawnQuestCards) {
        this.drawnQuestCards = drawnQuestCards;
    }

    public ArrayList<Card> getOnBattlefieldCards() {
        return onBattlefieldCards;
    }

    public void setOnBattlefieldCards(ArrayList<Card> onBattlefieldCards) {
        this.onBattlefieldCards = onBattlefieldCards;
    }

    public HashMap<Integer, Boolean> getHCardsLocations() {
        return HCardsLocations;
    }

    public void setHCardsLocations(HashMap<Integer, Boolean> HCardsLocations) {
        this.HCardsLocations = HCardsLocations;
    }

    public ArrayList<Card> getDrawnCards() {
        return drawnCards;
    }

    public void setDrawnCards(ArrayList<Card> drawnCards) {
        this.drawnCards = drawnCards;
    }

    public ArrayList<CardLocation> getCardLocations() {
        return cardLocations;
    }

    public void setCardLocations(ArrayList<CardLocation> cardLocations) {
        this.cardLocations = cardLocations;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getMaxManaCost() {
        return maxManaCost;
    }

    public void setMaxManaCost(int maxManaCost) {
        this.maxManaCost = maxManaCost;
    }

    public void setPlayersIndex(int playersIndex) {
        this.playersIndex = playersIndex;
    }
    public ArrayList<Card> getHandCards()
    {
        return hand.getHandsCards();
    }
}
