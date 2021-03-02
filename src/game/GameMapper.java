package game;

import cardList.CardList;
import characters.Hero;
import characters.Minion;
import characters.MyCharacter;
import graphics.*;
import initialCard.card.Card;
import initialCard.card.HeroCard;
import initialCard.card.MinionCard;
import initialCard.enumClasses.Type;
import initialSpell.spell.condition.Condition;
import initialSpell.spell.condition.ConditionHandler;
import resources.SoundPaths;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.nio.charset.CoderMalfunctionError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;

/**
 * Created by Data on 4/25/2020.
 */
public class GameMapper {


  
 
    {
        audioPlayer=new AudioPlayer();
        timer=new MyTimer();
    }
    private static GameContext gameContext;
    private static GameMapper instance=new GameMapper();
    private ArrayList<Request> requests=new ArrayList<Request>();
    private static boolean canSpecifiedCardBeBought=false;
    private static Integer specifiedCardIndex=null;
    private static LoggerCreator myLogger;
    private static int turn;
    private static boolean passives=true;
    private static int chosenPassive=0;
    private static AudioPlayer audioPlayer;
    private static AudioPlayer loopAudioPlayer;
    private static ArrayList<CardLocation> locations;
    private static ArrayList<CardLocation> hGLocations0;
    private static ArrayList<CardLocation> hGLocations1;
    private static Integer attacker;
    private static Integer hurt;
    private static Integer heroesIndex;
    private static boolean cardDragged=false;
    private static boolean weaponDragged=false;
    private static boolean fromHand=true;
    private static BattlefieldController battlefieldController;
    private static Card summoningCard;
    private static Card addedCardToHand;
    private static String target;
    private static Card targetCard;
    private static Card boughtCard;
    private static Card boughtSelectedCard;
    private static Card maxCard;
    private static Boolean isHeroPowerDragged=false;
    private static boolean firstTime=true;
    private static MyTimer timer;
    private static String timerMessage="";
    private static boolean timerStarts=false;

    public static boolean isTimerStarts() {
        return timerStarts;
    }

    public static void setTimerStarts(boolean timerStarts) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        GameMapper.timerStarts = timerStarts;

        battlefieldController.setMessage();
        battlefieldController.update();
    }

    public static String getTimerMessage() {
        return timerMessage;
    }

    public static void setTimerMessage(String timerMessag) {
       timerMessage = timerMessag;

    }

    public static boolean isFirstTime() {
        return firstTime;
    }

    public static void setFirstTime(boolean firstTime) {
        GameMapper.firstTime = firstTime;
    }

    public static Boolean getIsHeroPowerDragged() {
        return isHeroPowerDragged;
    }

    public static void setIsHeroPowerDragged(Boolean isHeroPowerDragge) {
       isHeroPowerDragged = isHeroPowerDragge;
    }

    public static Card getMaxCard() {
        return maxCard;
    }

    public static void setMaxCard(Card maxCard) {
        GameMapper.maxCard = maxCard;
    }

    public static String getTarget() {
        return target;
    }

    public static void setTarget(String target) {
        System.out.println("tarrrrrggeeeetttttt:"+target);
        GameMapper.target = target;
        if(target.equals("H"))
            targetCard= gameContext.getHero().getCard();
        if(target.equals("E"))
            targetCard= gameContext.getOtherHero().getCard();
        else if(target.charAt(0)=='H') {
            try {
                String str=target.substring(1);
                targetCard = gameContext.getOnBattlefieldCards().get(Integer.valueOf(str));
            }catch (Exception e){}
        }
        else if(target.charAt(0)=='E') {
            try {
                String str=target.substring(1);
                targetCard = gameContext.getOtherOnBattlefieldCards().get(Integer.valueOf(str));
            }catch (Exception e){}
        }


    }



    public static Card getTargetCard() {
        return targetCard;
    }

    public static void setTargetCard(Card targetCard) {
        GameMapper.targetCard = targetCard;
    }

    public static Card getAddedCardToHand() {
        return addedCardToHand;
    }

    public static void setAddedCardToHand(Card addedCardToHand) {
        GameMapper.addedCardToHand = addedCardToHand;
    }

    public static Card getSummoningCard() {
        return summoningCard;
    }

    public static void setSummoningCard(Card summoningCard) {
        GameMapper.summoningCard = summoningCard;
    }

    public static BattlefieldController getBattlefieldController() {
        return battlefieldController;
    }

    public static void setBattlefieldController(BattlefieldController battlefieldController) {
        GameMapper.battlefieldController = battlefieldController;
    }

    public static boolean isWeaponDragged() {
        return weaponDragged;
    }

    public static void setWeaponDragged(boolean weaponDragged) {
        GameMapper.weaponDragged = weaponDragged;
    }

    public static boolean isCardDragged() {
        return cardDragged;
    }

    public static void setCardDragged(boolean cardDragged) {
        GameMapper.cardDragged = cardDragged;
    }

    public static Integer getHeroesIndex() {
        return heroesIndex;
    }

    public static void setHeroesIndex(Integer heroesIndex) {
        GameMapper.heroesIndex = heroesIndex;
    }

    public static int getHurt() {
        return hurt;
    }

    public static void setHurt(int hurt) {
        GameMapper.hurt = hurt;
    }

    public static int getAttacker() {
        return attacker;
    }

    public static void setAttacker(int attacker) {
        GameMapper.attacker = attacker;
    }

    public static ArrayList<CardLocation> gethGLocations0() {
        return hGLocations0;
    }

    public static ArrayList<CardLocation> gethGLocations1() {
        return hGLocations1;
    }

    public static void sethGLocations1(ArrayList<CardLocation> hGLocations1) {
        GameMapper.hGLocations1 = hGLocations1;
    }

    public static void sethGLocations0(ArrayList<CardLocation> hGLocations0) {
        GameMapper.hGLocations0 = hGLocations0;
    }

    private static ArrayList<CardLocation> getEnemyLocations(){
        if(gameContext.getPlayersIndex()==1) {
            if (hGLocations0 == null || hGLocations0.size() == 0) {
                hGLocations0 = new ArrayList<CardLocation>();
                for (int i = 1; i < 8; i++) {
                    if (i % 2 == 0)
                        hGLocations0.add(new CardLocation(460 + (i / 2) * 100, 343, i));
                    else
                        hGLocations0.add(new CardLocation(460 - (i / 2) * 100, 343, i));
                }
            }
            return hGLocations0;
        }
        else{
            if (hGLocations1 == null || hGLocations1.size() == 0) {
                hGLocations1 = new ArrayList<CardLocation>();
                for (int i = 1; i < 8; i++) {
                    if (i % 2 == 0)
                        hGLocations1.add(new CardLocation(460 + (i / 2) * 100, 343, i));
                    else
                        hGLocations1.add(new CardLocation(460 - (i / 2) * 100, 343, i));
                }
            }

            return hGLocations1;
        }

    }
  public static ArrayList<CardLocation> getHGEnemyCardLocations(){
        ArrayList<CardLocation> cardLocations=new ArrayList<CardLocation>();
        ArrayList<CardLocation> temp=getEnemyLocations();
        for(CardLocation cl:temp)
        {
            CardLocation c=new CardLocation(cl.getX(),220,cl.getCounter());
            cardLocations.add(c);
            
        }
        return cardLocations;
  }


    public static ArrayList<CardLocation> gethGLocations() {

         if(gameContext.getPlayersIndex()==0) {
             if (hGLocations0 == null || hGLocations0.size() == 0) {
                 hGLocations0 = new ArrayList<CardLocation>();

                     for (int i = 1; i < 8; i++) {
                         if (i % 2 == 0)
                             hGLocations0.add(new CardLocation(460 + (i / 2) * 100, 343, i));
                         else
                             hGLocations0.add(new CardLocation(460 - (i / 2) * 100, 343, i));
                     }

             }
             return hGLocations0;
         }
         else{
             if (hGLocations1 == null || hGLocations1.size() == 0) {
                 hGLocations1 = new ArrayList<CardLocation>();
                     for (int i = 1; i < 8; i++) {
                         if (i % 2 == 0)
                             hGLocations1.add(new CardLocation(460 + (i / 2) * 100, 343, i));
                         else
                             hGLocations1.add(new CardLocation(460 - (i / 2) * 100, 343, i));
                     }
                 }
             }

             return hGLocations1;


    }

    public static void sethGCardLocations(ArrayList<CardLocation> cardLocations){
        hGLocations0=cardLocations;
        hGLocations1=cardLocations;
    }

    
    
    public static ArrayList<CardLocation> getLocations() {

           if(locations==null || locations.size()==0) {
               locations = new ArrayList<CardLocation>();
               for (int i = 1; i < 13; i++) {
                   if (i % 2 == 0)
                       locations.add(new CardLocation(430 + (i / 2) * 30, 604, i));
                   else
                       locations.add(new CardLocation(430 - (i / 2) * 30, 604, i));
               }
           }
              

        return locations;
    }
    public static void setLocations(ArrayList<CardLocation> aLocations) {
        locations = aLocations;
    }
    public static AudioPlayer getLoopAudioPlayer() {
        return loopAudioPlayer;
    }

    public static void setLoopAudioPlayer(AudioPlayer loopAudioPlayer) {
        GameMapper.loopAudioPlayer = loopAudioPlayer;
    }

    public static AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public static void setAudioPlayer(AudioPlayer audioPlayer) {
        GameMapper.audioPlayer = audioPlayer;
    }

    public static int getChosenPassive() {
        return chosenPassive;
    }

    public static void setChosenPassive(int chosenPassive1) {
        chosenPassive = chosenPassive1;
    }
    public static void setChosenPassive() {
        gameContext.getCurrentHand().setPassiveCard(gameContext.getCurrentHand().getMyPassives().get(chosenPassive));
    }

    public static void setPassivesFalse(){
        passives=false;
    }

    public boolean isPassives() {
        return passives;
    }

    public static int getTurn() {
        return turn;
    }

    public static void setTurn() {
       turn = gameContext.getTurnCounter();
    }

    public static LoggerCreator getMyLogger() {
        return myLogger;
    }

    public static void setMyLogger(LoggerCreator myLogger) {
        GameMapper.myLogger = myLogger;
    }

    public static boolean isCanSpecifiedCardBeBought() {
        return canSpecifiedCardBeBought;
    }

    public static void setSpecifiedCardIndex(int specifiedCardIndex1) {
     specifiedCardIndex = specifiedCardIndex1;
    }

    public static GameContext getGameContext() {
        return gameContext;
    }

    public static void endTurn () {
        gameContext.endTurn();
    }

    public static void setGameContext(GameContext gameContext) {
        GameMapper.gameContext = gameContext;
    }

    private static void startGame(){

    }

    public static GameMapper getInstance() {
        return instance;
    }


    public void addRequest(RequestType requestType) throws Exception {
        if (requestType != null) {

            requestType.execute();

        }
    }

    public static void setFromHand(boolean fromHand) {
        GameMapper.fromHand = fromHand;
    }

    private static void enterCard(){
          if(fromHand) {
              canSpecifiedCardBeBought = gameContext.getCardWithMana(gameContext.getCurrentHand().getHandsCards().get(specifiedCardIndex), true);
              if(canSpecifiedCardBeBought )
                boughtCard=gameContext.getBoughtCard();

          }
        if(boughtCard!=null && boughtCard.getType()==Type.MinionCard)
            ConditionHandler.handleSummonedCardCondition(boughtCard,gameContext);
          if(boughtCard!=null && boughtCard.isTargetSelective())
          {
              boughtSelectedCard=boughtCard;
          }

    }
     static void useHeroPower(){
        if(isHeroPowerDragged)
        {
            canSpecifiedCardBeBought = gameContext.getCardWithMana(gameContext.getHero().getHeroPower(), false);
            if(canSpecifiedCardBeBought )
                boughtCard=gameContext.getBoughtCard();
        }
        if(boughtCard!=null && boughtCard.isTargetSelective())
        {
            boughtSelectedCard=boughtCard;
        }

    }
    
    public static Card getSpecifiedCard() {
        return gameContext.getCurrentHand().getHandsCards().get(specifiedCardIndex);
    }
    
    public static Card getWantedCardInHand(int index){
        return gameContext.getCurrentHand().getHandsCards().get(specifiedCardIndex);
    }



    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void executeRequests() throws Exception {
        for (Iterator<Request> requestIterator = requests.iterator();
             requestIterator.hasNext(); ) {
            Request request = requestIterator.next();
            request.execute();
            requestIterator.remove();
        }
    }

    public enum RequestType implements Request {

        StartGame {
            @Override
            public void execute() throws Exception {
                startGame();
                ConditionHandler.handleBeginTurn(null,gameContext);
                myLogger.logger.log(Level.INFO,"GameStarted");

            }
        },
        EndTurn {
            @Override
            public void execute() throws Exception {
                myLogger.logger.log(Level.INFO,"CurrentMana:"+gameContext.getCurrentMana());
                myLogger.logger.log(Level.INFO,"MaxMana:"+gameContext.getMaxManaCost());
                endTurn();
                MyTimer.setCounter(0);
                myLogger.logger.log(Level.INFO,"EndTurn");
                myLogger.logger.log(Level.INFO,"DrawnCards:"+ CardList.convertCardListToNameList(gameContext.getDrawnCards()));
                myLogger.logger.log(Level.INFO,"OnBattlefieldMinions:"+ CardList.convertCardListToNameList(gameContext.getOnBattlefieldCards()));
                myLogger.logger.log(Level.INFO,"RemainedCards:"+ gameContext.getCurrentHand().getRemainedCards());
                audioPlayer.playSound("endTurn");
                audioPlayer.playSound("mana");
                audioPlayer.playSound("draw");
            }
        }, Enter_Card{
            @Override
            public void execute() throws Exception {
                System.out.println("card entered");
                enterCard();
                fromHand=true;
                myLogger.logger.log(Level.INFO,"EnterCard");
                myLogger.logger.log(Level.INFO,"DrawnCards:"+ CardList.convertCardListToNameList(gameContext.getDrawnCards()));
                myLogger.logger.log(Level.INFO,"OnBattlefieldMinions:"+ CardList.convertCardListToNameList(gameContext.getOnBattlefieldCards()));
                audioPlayer.playSound("entergame");
            }
        }, Set_Turn {
            @Override
            public void execute() {
                setTurn();
            }
        }, Passives_were_Shown {
            @Override
            public void execute() throws Exception {
                setPassivesFalse();
                audioPlayer.playSound("passive");
            }
        }, Set_Chosen_Passive {
            @Override
            public void execute() throws Exception {
                setChosenPassive();
                audioPlayer.playSound("passive");
            }
        },Minion_Attacked_Minion_Event(){
            @Override
            public void execute() throws Exception {
                  handleMinionAttack();
            }
        },Minion_Attacked_Hero_Event(){
            @Override
            public void execute() throws Exception {
                handleMinionAttackHero();
            }
        },Weapon_Attacked_Minion_Event(){
            @Override
            public void execute() throws Exception {
                handleWeaponAttack();
            }
        },Weapon_Attacked_Hero_Event(){
            @Override
            public void execute() throws Exception {
                handleWeaponAttackHero();
            }
        },Summon_Card(){
            @Override
            public void execute() throws Exception {
                summonCard();
            }
        },Draw_Card(){
            @Override
            public void execute() throws Exception {
                //not done yet
            }
        },Traget_Selected(){
            @Override
            public void execute() throws Exception {
                targetSeleceted();
            }
        },Max_Card(){
            @Override
            public void execute() throws Exception {
                Mapper.getGameState().setBoldImage2True();
            }
        },Summon_Spell_Card(){
            @Override
            public void execute() throws Exception {
                gameContext.getOnBattlefieldCards().add(summoningCard);
                summonCard();
                battlefieldController.update();
            }
        },HeroPower_Used(){
            @Override
            public void execute() throws Exception {
                useHeroPower();
                battlefieldController.update();
            }
        },Start_Timer(){
            @Override
            public void execute() throws Exception {
                //timer.start();
                //Thread.sleep(10);
               // battlefieldController.update();
            }
            
        }

    }

    private static void targetSeleceted(){
            gameContext.cardsTargetSelected(boughtCard,targetCard);
    }

    public static void setMaxCardString(String string){

        if(string.equals("H"))
            maxCard= gameContext.getHero().getCard();
        else if(string.equals("E"))
            maxCard= gameContext.getOtherHero().getCard();
        else if(string.charAt(0)=='H') {
            try {
                String str=string.substring(1);
                maxCard = gameContext.getOnBattlefieldCards().get(Integer.valueOf(str));
            }catch (Exception e){}
        }
        else if(string.charAt(0)=='E') {
            try {
                String str=string.substring(1);
                maxCard = gameContext.getOtherOnBattlefieldCards().get(Integer.valueOf(str));
            }catch (Exception e){}
        }


    }


    public static void  handleMinionAttack(){
        if(attacker==null || hurt==null)
            return;
        if(attacker>=gameContext.getOnBattlefieldCards().size())
            return;
        if(hurt>=gameContext.getOtherOnBattlefieldCards().size())
            return;
        Card attackerCard=gameContext.getOnBattlefieldCards().get(attacker);
        Card hurtCard=gameContext.getOtherOnBattlefieldCards().get(hurt);
        Minion minion=new Minion((MinionCard) attackerCard);
        MyCharacter character=new MyCharacter((Card)hurtCard);
        gameContext.handleMinionAttack(minion,character);
        attacker=null;
        hurt=null;
    }
    public static void  handleMinionAttackHero() throws Exception{
        if(attacker==null )
            return;
        if(attacker>=gameContext.getOnBattlefieldCards().size())
            return;
        Card attackerCard=gameContext.getOnBattlefieldCards().get(attacker);
        Minion minion=new Minion((MinionCard) attackerCard);
        gameContext.handleMinionAttack(minion,gameContext.getOtherHero());
        attacker=null;
        heroesIndex=null;

    }

    public static void  handleWeaponAttack(){
        if( hurt==null)
            return;
        if(hurt>=gameContext.getOtherOnBattlefieldCards().size())
            return;
        Card hurtCard=gameContext.getOtherOnBattlefieldCards().get(hurt);
        MyCharacter character=new MyCharacter((Card)hurtCard);
        gameContext.handleWeaponAttack(gameContext.getWeapon(),character);
        attacker=null;
        hurt=null;
    }

    private static void summonCard() throws Exception {
        if(!gameContext.getOnBattlefieldCards().contains(summoningCard))
            gameContext.getOnBattlefieldCards().add(summoningCard);
        battlefieldController.setNewLocations(300,130, summoningCard);
        if(summoningCard!=null && summoningCard.getType()== Type.MinionCard)
           ConditionHandler.handleSummonedCardCondition(summoningCard,gameContext);
    }
    public static void  handleWeaponAttackHero() throws Exception{

        gameContext.handleWeaponAttack(gameContext.getWeapon(),gameContext.getOtherHero());
        heroesIndex=null;

    }
    
}
