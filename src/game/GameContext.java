package game;

import Events.CardEntranceEvent;
import Events.MinionAttackEvent;
import Events.WeaponAttackEvent;
import characters.Hero;
import characters.Minion;
import characters.MyCharacter;
import characters.Weapon;
import collection.Collection;
import deck.Hand;
import graphics.ScreenController;
import initialCard.card.Card;
import initialCard.card.MinionCard;
import initialCard.enumClasses.Type;
import graphics.CardLocation;
import initialHeroPower.HeroPower;
import initialSpell.spell.condition.Condition;
import initialSpell.spell.condition.ConditionHandler;
import player.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;


public class GameContext {
    private ArrayList<Card> minions;
    private ArrayList<Card> spellCards;
    private ArrayList<Card> questCards;
    private ArrayList<Card> drawnMinions;
    private ArrayList<Card> drawnSpellCards;
    private ArrayList<Card> drawnQuestCards;
    private ArrayList<Card> onBattlefieldCards;
    private ArrayList<Card> otherOnBattlefieldCards;
    private ArrayList<Card> drawnCards;
    private ArrayList<Card> inHandCards;
    private Hand[] hands=new Hand[2];
    private Hand currentHand;
    private Hero hero;
    private Hero otherHero;
    private int currentMana=1;
    private int maxManaCost=1;
    private int playersIndex=0;
    private int turnCounter=1;
    private BattlefieldPlayer[] players=new BattlefieldPlayer[2];
    private BattlefieldPlayer currentPlayer;
    private Logic logic;
    private Weapon weapon;
    private Weapon otherWeapon;
    private Card boughtCard;
    private HeroPower heroPower;
    private HeroPower otherHeropower;

    public BattlefieldPlayer[] getPlayers() {
        return players;
    }

    public void setPlayers(BattlefieldPlayer[] players) {
        this.players = players;
    }

    public Logic getLogic() {
        return logic;
    }

    public void setLogic(Logic logic) {
        this.logic = logic;
    }

    public Hand[] getHands() {
        return hands;
    }

    public void setHands(Hand[] hands) {
        this.hands = hands;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public ArrayList<Card> getOtherOnBattlefieldCards() {
        return otherOnBattlefieldCards;
    }

    public void setOtherOnBattlefieldCards(ArrayList<Card> otherOnBattlefieldCards) {
        this.otherOnBattlefieldCards = otherOnBattlefieldCards;
    }

    public GameContext(BattlefieldPlayer p1, BattlefieldPlayer p2){

        System.out.println("enters Here");

        otherOnBattlefieldCards=new ArrayList<Card>();
        minions=new ArrayList<Card>();
        spellCards=new ArrayList<Card>();
        questCards=new ArrayList<Card>();
        drawnSpellCards=new ArrayList<Card>();
        drawnQuestCards=new ArrayList<Card>();
        onBattlefieldCards=new ArrayList<Card>();
        drawnMinions=new ArrayList<Card>();
        drawnCards=new ArrayList<Card>();
        inHandCards=new ArrayList<Card>();
        hands[0]=p1.getHand();
        hands[1]=p2.getHand();
        currentHand=hands[0];
        hero=hands[0].getHero();
        players=new BattlefieldPlayer[2];
        players[0]=p1;
        players[1]=p2;
        currentPlayer=players[0];
        otherHero=hands[1].getHero();
        otherOnBattlefieldCards=players[playersIndex*(-1)+1].getOnBattlefieldCards();
        minions=players[playersIndex].getMinions();
        spellCards=players[playersIndex].getSpellCards();
        questCards=players[playersIndex].getQuestCards();
        drawnSpellCards=players[playersIndex].getDrawnSpellCards();
        drawnQuestCards=players[playersIndex].getDrawnQuestCards();
        onBattlefieldCards=players[playersIndex].getOnBattlefieldCards();
        drawnMinions=players[playersIndex].getDrawnMinions();
        drawnCards=players[playersIndex].getDrawnCards();
        currentHand=hands[playersIndex];
        hero=hands[playersIndex].getHero();
        currentPlayer=players[playersIndex];
        otherHero=hands[playersIndex*(-1)+1].getHero();
        inHandCards=players[playersIndex].getHandCards();
        players[0].identifyCards();
        players[1].identifyCards();
        logic=new Logic(this);
        if(hero!=null)
          heroPower=hero.getHeroPower();
        if(otherHero!=null)
            otherHeropower=otherHero.getHeroPower();






    }

    public ArrayList<Card> getInHandCards() {
        return inHandCards;
    }

    public void setInHandCards(ArrayList<Card> inHandCards) {
        this.inHandCards = inHandCards;
    }

    public Hero getOtherHero() {
        return otherHero;
    }

    public void setOtherHero(Hero otherHero) {
        this.otherHero = otherHero;
    }

    public void switchTurn()
    {
        players[0].identifyCards();
        players[1].identifyCards();

        minions=null;
        spellCards=null;
        questCards=null;
        drawnSpellCards=null;
        drawnQuestCards=null;
        onBattlefieldCards=null;
        drawnMinions=null;
        drawnCards=null;
        currentHand=null;
        hero=null;
        currentPlayer=null;
        otherHero=null;

        minions=players[playersIndex].getMinions();
        spellCards=players[playersIndex].getSpellCards();
        questCards=players[playersIndex].getQuestCards();
        drawnSpellCards=players[playersIndex].getDrawnSpellCards();
        drawnQuestCards=players[playersIndex].getDrawnQuestCards();
        onBattlefieldCards=players[playersIndex].getOnBattlefieldCards();
        otherOnBattlefieldCards=players[playersIndex*(-1)+1].getOnBattlefieldCards();
        drawnMinions=players[playersIndex].getDrawnMinions();
        drawnCards=players[playersIndex].getDrawnCards();
        currentHand=hands[playersIndex];
        hero=hands[playersIndex].getHero();
        currentPlayer=players[playersIndex];
        otherHero=hands[playersIndex*(-1)+1].getHero();
        inHandCards=players[playersIndex].getHandCards();
        weapon=players[playersIndex].getWeapon();
        otherWeapon=players[playersIndex*(-1)+1].getWeapon();
        if(hero!=null)
            heroPower=hero.getHeroPower();
        if(otherHero!=null)
            otherHeropower=otherHero.getHeroPower();
        heroPower.setUsePerTurn(0);
        otherHeropower.setUsePerTurn(0);




    }

    public BattlefieldPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(BattlefieldPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setPlayer(BattlefieldPlayer player)
    {
        hands[player.getPlayersIndex()]=player.getHand();
    }

    public ArrayList<Card> getDrawnCards() {
        return drawnCards;
    }

    public int getMaxManaCost() {
        return maxManaCost;
    }

    public void setMaxManaCost(int maxManaCost) {
        this.maxManaCost = maxManaCost;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getPlayersIndex() {
        return playersIndex;
    }

    public void setPlayersIndex(int playersIndex) {
        this.playersIndex = playersIndex;
    }

    public ArrayList<Card> getOnBattlefieldCards() {
        return onBattlefieldCards;
    }

    public ArrayList<Card> getDrawnSpellCards() {
        return drawnSpellCards;
    }

    public Hand getCurrentHand() {

        return currentHand;
    }

    public boolean getCardWithMana(Card card,boolean fromHand){
        if(card.getInitialManaCost()-2<=currentMana && card.getType()==Type.SpellCard && !card.getName().equals("Fireblast") )
        if(hero.getName().equals("Jaina-Proudmoore"))
        {
            if(card.getInitialManaCost()-2>0)
                card.setInitialManaCost(card.getInitialManaCost()-2);
            else
                card.setInitialManaCost(0);

        }
        if(card.getInitialManaCost()<=currentMana) {

            if (card.getType() == Type.MinionCard) {
                if(onBattlefieldCards.size()<7) {
                      if(! currentHand.removeCardFromHand(card,fromHand)  )
                        return false;
                    currentMana -= card.getInitialManaCost();
                    drawnCards.add(card);
                    onBattlefieldCards.add(card);
                    drawnMinions.add(card);
                    boughtCard=card;
                    ConditionHandler.handleSpendManaOnMinionQuest(card,this);
                      if(!card.isTargetSelective())
                      {
                          CardEntranceEvent cardEntranceEvent=new CardEntranceEvent(this,card,null,null);
                          cardEntranceEvent.performAction();
                      }
                    return true;
                }
                return false;

            }
            if (card.getType() == Type.SpellCard) {

                currentMana -= card.getInitialManaCost();
                drawnCards.add(card);
                currentHand.removeCardFromHand(card,fromHand);
                drawnSpellCards.add(card);
                boughtCard=card;
                if(!card.isTargetSelective())
                {
                    CardEntranceEvent cardEntranceEvent=new CardEntranceEvent(this,card,null,null);
                    cardEntranceEvent.performAction();
                }
                return true;

            }
            if (card.getType() == Type.WeaponCard) {
                currentMana -= card.getInitialManaCost();
                drawnCards.add(card);
                currentHand.removeCardFromHand(card,fromHand);
                weapon=new Weapon(card);
                players[playersIndex].setWeapon(weapon);
                boughtCard=card;
                if(!card.isTargetSelective())
                {
                    CardEntranceEvent cardEntranceEvent=new CardEntranceEvent(this,card,null,null);
                    cardEntranceEvent.performAction();
                }
                return true;

            }
            if (card.getType() == Type.HeroPower) {
                if(!((HeroPower)card).isAllowed())
                    return false;
                currentMana -= card.getInitialManaCost();
                boughtCard=card;
                ((HeroPower)card).setUsePerTurn( ((HeroPower)card).getUsePerTurn()+1);
                if(!card.isTargetSelective())
                {
                    CardEntranceEvent cardEntranceEvent=new CardEntranceEvent(this,card,null,null);
                    cardEntranceEvent.performAction();
                }
                return true;

            }
        }
        return false;

    }

    public void endTurn(){;
    if(hero.getName().equals( "The-Silver-Hand"))
    {
        for(Card card:onBattlefieldCards)
        {
            if(card.getType()==Type.MinionCard)
            {
                MinionCard c=(MinionCard)card;
                c.setHp(c.getHp()+1);
                c.setAttack(c.getAttack()+1);
                break;
            }
        }
    }
        playersIndex=playersIndex*(-1)+1;
        switchTurn();
        maxManaCost=turnCounter/2+1;
        ConditionHandler.handleBeginTurn(null,this);
        if(maxManaCost>=11)
            maxManaCost=10;
       currentMana=maxManaCost;
        currentHand.addCardToHand();
        turnCounter++;
      if(turnCounter==2)
      {
          try {
              ScreenController.activate("ChoosePassives");
          }catch (Exception e){
              e.printStackTrace();
          }
      }
    }



    public void handleMinionAttack(Minion attacker, MyCharacter hurt){

        MinionAttackEvent event=new MinionAttackEvent(attacker,hurt,this);
        event.performAction();
        logic.checkForDeadCards();


    }

    public void handleWeaponAttack(Weapon attacker, MyCharacter hurt){

        WeaponAttackEvent event=new WeaponAttackEvent(attacker,hurt,this);
        event.performAction();
        logic.checkForDeadCards();


    }



    public void resetCards(){
        players[0].identifyCards();
        players[1].identifyCards();
    }

    public void cardsTargetSelected(Card mainCard,Card selectedCard){
        if(mainCard==null)
            return;
          if(mainCard.isTargetSelective()){
            CardEntranceEvent cardEntranceEvent=new CardEntranceEvent(this,mainCard,selectedCard,null);
            cardEntranceEvent.performAction();
          }

    }

    public Card getBoughtCard() {
        return boughtCard;
    }

    public void setBoughtCard(Card boughtCard) {
        this.boughtCard = boughtCard;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getOtherWeapon() {
        return otherWeapon;
    }

    public void setOtherWeapon(Weapon otherWeapon) {
        this.otherWeapon = otherWeapon;
    }
}
