package graphics;

import cardList.CardList;
import collection.Collection;
import com.sun.glass.ui.Window;
import game.*;
import game.GamePlayer;
import initialCard.enumClasses.HeroType;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import playersCards.PlayersCards;
import resources.SoundPaths;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mapper {
    static {


        gameState=new GamePlayer(0);
        audioPlayer=new AudioPlayer();
        secondaryGameState=new GamePlayer(1);



    }

    private static Mapper instance = new Mapper();
    private static String Username;
    private static String Password;
    private static GamePlayer gameState;
    private static GamePlayer secondaryGameState;
    private static boolean isUserSwitched=false;

    /**
     * @return the list
     */
    public static ArrayList<CardLocation> getList() {
        return list;
    }

    /**
     * @param aList the list to set
     */
    public static void setList(ArrayList<CardLocation> aList) {
        list = aList;
    }
    private ArrayList<Request> requests;
    private static int searchMana=0;
    private static String searchString;
    private static int decksIndex;
    private static int boldImageIndex;
    private static String soldCard;
    private static String boughtCard;
    private static int SpecifiedDecksIndex;
    private static String specifiedDecksNewName;
    private static Boolean[] specifiedRemovedBooleans;
    private static ArrayList<Integer> addedCardsToSpecifiedDeck;
    private static String specifiedDecksHerotype;
    private static int chooseDeckIndex=0;
    private static GameContext gameContext;
    private static LoggerCreator myLogger;
    private static boolean isInformationCorrect=false;
    private static AudioPlayer audioPlayer;
    private static int backIndex=1;
    private static ArrayList<CardLocation> list;
    private static String playMode="singlePlayer";
    private static int enemiesDeckIndex;

    public static int getEnemiesDeckIndex() {
        return enemiesDeckIndex;
    }

    public static void setEnemiesDeckIndex(int enemiesDeckIndex) {
        Mapper.enemiesDeckIndex = enemiesDeckIndex;
    }

    public static String getPlayMode() {
        return playMode;
    }

    public static void setPlayMode(String playMode) {
        if(playMode==null || playMode.equals(""))
            return;
        Mapper.playMode = playMode;
    }

    public static boolean isIsUserSwitched() {
        return isUserSwitched;
    }

    public static void setIsUserSwitched(boolean is) {
        isUserSwitched = is;
    }

    public static void switchUsers(){

    }
    public static int getBackIndex() {
        return backIndex;
    }

    public static void setBackIndex(int backIndex) {
        Mapper.backIndex = backIndex;
    }

    public static AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public static void setAudioPlayer(AudioPlayer audioPlayer) {
        Mapper.audioPlayer = audioPlayer;
    }

    public static LoggerCreator getMyLogger() {
        return myLogger;
    }

    public static void setMyLogger(LoggerCreator myLogger) {
        Mapper.myLogger = myLogger;
    }

    public static void setGameContext(GameContext gameContext) {
        Mapper.gameContext = gameContext;
    }

    public static void endProgram() throws Exception {
        gameState.getEndProgram().end();
    }

    public static boolean isUserSwitched() {
        return isUserSwitched;
    }

    public static void setUserSwitched(boolean isUserSwitched) {
        Mapper.isUserSwitched = isUserSwitched;
    }

    public static void startGameContext (){
        try {
           System.out.println("why?????");
           GameMapper.setGameContext(new GameContext(new BattlefieldPlayer(gameState.getMainMenu().getCollection().getHandWithIndex(enemiesDeckIndex), 0), new BattlefieldPlayer(gameState.getMainMenu().getCollection().getHandWithIndex(chooseDeckIndex), 1)));
           System.out.println("nooooo:");
           ScreenController.activate("Battlefield");
        }catch (Exception e){}
    }

    public static int getChooseDeckIndex() {
        return chooseDeckIndex;
    }

    public static void setChooseDeckIndex(int chooseDeckIndex) {
        Mapper.chooseDeckIndex = chooseDeckIndex;
    }

    public static void changeSpecifiedDecksHerotype(){
        //System.out.println(specifiedDecksHerotype);
        gameState.getMainMenu().getCollection().getDecks()[gameState.getMainMenu().getCollection().getSpecifiedDecksIndex()].setHeroType(HeroType.valueOf(specifiedDecksHerotype.toUpperCase()));
    }


    public static String getSpecifiedDecksHerotype() {
        return specifiedDecksHerotype;
    }

    public static void setSpecifiedDecksHerotype(String SpecifiedDecksHerotype) {
       specifiedDecksHerotype = SpecifiedDecksHerotype;
    }


    public static ArrayList<Integer> getAddedCardsToSpecifiedDeck() {
        return addedCardsToSpecifiedDeck;
    }

    public static void setAddedCardsToSpecifiedDeck(ArrayList<Integer> addedCardsToSpecifiedDeck) {
        Mapper.addedCardsToSpecifiedDeck = addedCardsToSpecifiedDeck;
    }

    public static void submitCompleteDeck() throws Exception {

        gameState.getMainMenu().getCollection().getDecks()[gameState.getMainMenu().getCollection().getSpecifiedDecksIndex()].setName(specifiedDecksNewName);
        gameState.getMainMenu().getCollection().removeCards();

    }


    public static void nextChooseDeckPage() throws Exception {

        gameState.getMainMenu().getCollection().ChooseDeckNext();


    }

    public static void previousChooseDeckPage() throws Exception {

        gameState.getMainMenu().getCollection().ChooseDeckPrevious();


    }

    public static Boolean[] getSpecifiedRemovedBooleans() {
        return specifiedRemovedBooleans;

    }

    public static void setSpecifiedRemovedBooleans(Boolean[] specifiedRemovedBooleans) throws Exception {
        Mapper.specifiedRemovedBooleans = specifiedRemovedBooleans;
        gameState.getMainMenu().getCollection().setSpecifiedRemovedBooleans(specifiedRemovedBooleans);
    }

    public static String getSpecifiedDecksNewName() {
        return specifiedDecksNewName;
    }

    public static void setSpecifiedDecksNewName(String specifiedDecksNewName) {
        Mapper.specifiedDecksNewName = specifiedDecksNewName;

    }

    public static int getSpecifiedDecksIndex() {

        return SpecifiedDecksIndex;
    }

    public static void setSpecifiedDecksIndex(int specifiedDecksIndex) throws Exception {
       SpecifiedDecksIndex = specifiedDecksIndex;
        gameState.getMainMenu().getCollection().setSpecifiedDecksIndex(specifiedDecksIndex);
        myLogger.logger.log(Level.INFO,"DisplayDeck:"+gameState.getMainMenu().getCollection().getDecks()[specifiedDecksIndex].getName());
    }

    public static int getBoldImageIndex() {
        return boldImageIndex;
    }

    public static void setBoldImageIndex(int boldImageIndex) {
        Mapper.boldImageIndex = boldImageIndex;
    }

    public static void loadLogin(){

        gameState.setLoginTrue();

    }

    public static boolean isInformationCorrect() {
        return isInformationCorrect;
    }

    public static String getSoldCard() {
        return soldCard;
    }

    public static void setSoldCard(String soldCard) {
        Mapper.soldCard = soldCard;
    }

    public static String getBoughtCard() {
        return boughtCard;
    }

    public static void setBoughtCard(String boughtCard) {
        Mapper.boughtCard = boughtCard;
    }

    public static void loadCollection(){
        gameState.setCollectionTrue();
    }
    public static void loadChooseDeck(){
        gameState.setChooseDeckTrue();
    }
    public static void loadChooseHero(){
        gameState.setChooseHeroTrue();
    }
    public static void loadCompleteDeck(){
        gameState.setCompleteDeckTrue();
    }
    public static void loadMainMenu(){
       gameState.setMainMenuTrue();
    }
    public static void loadCardBack(){
        gameState.setCardsBackTrue();
    }
    public static void loadBoldImage(){
        if(boldImageIndex>=gameState.getMainMenu().getCollection().getMainList().get((gameState.getMainMenu().getCollection().getPageCounter())).size())
            return;
        gameState.getMainMenu().getCollection().setBoldCardsIndex(boldImageIndex);
       gameState.setBoldImageTrue();
    }
    public static void loadBattlefield(){
      gameState.setBattlefieldTrue();

    }
    public static void loadStore(){
        gameState.setStoreTrue();
    }

    public static void loadStatus(){
        gameState.setStatusTrue();
    }


    public static int getDecksIndex() {
        return decksIndex;
    }

    public static void setDecksIndex(int decksIndex) {
        Mapper.decksIndex = decksIndex;
    }

    public static String getSearchString() {
        return searchString;
    }

    public static void setSearchString(String searchString) {
        Mapper.searchString = searchString;
    }

    public static String getUsername() {
        return Username;
    }

    public static void setUsername(String username) {
        Username = username;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String password) {
        Password = password;
    }

    public static int getSearchMana() {
        return searchMana;
    }

    public static void setSearchMana(int searchMana) {
        Mapper.searchMana = searchMana;
    }

    private Mapper() {
        requests = new ArrayList<Request>();
        //gameState = new Game();

    }

    public static void setInstance(Mapper instance) {
        Mapper.instance = instance;
    }

    public static void setGameState(GamePlayer gameState) {
        Mapper.gameState = gameState;
    }

    private static boolean login() throws Exception {
        if(gameState.submitData(Username,Password,"yes"))
        {
            isInformationCorrect=true;
            gameState.runMainMenu();
            gameState.setLoginBoolean(false);
            gameState.setMainMenuBoolean(true);
            loadMainMenu();
            return true;

        }
        isInformationCorrect=false;
        return false;
    }


    private static void   addCardsToSpecifiedDeck() throws Exception {
        gameState.getMainMenu().getCollection().setAddedCardsToSpecifiedDeck(addedCardsToSpecifiedDeck);
      if(!gameState.getMainMenu().getCollection().addCards())
          System.out.println("nooooooooooooo");
    }








    private static void signup() throws Exception {
        gameState.submitData(Username,Password,"no");
        gameState.runMainMenu();
        gameState.setLoginBoolean(false);
        gameState.setMainMenuBoolean(true);
        loadMainMenu();
    }

    private static void sellCard() throws Exception {
        if(soldCard==null)
            return;
        gameState.getMainMenu().getStore().sell(soldCard);

    }
    private static void buyCard() throws Exception {
        if(boughtCard==null)
            return;
        gameState.getMainMenu().getStore().buy(boughtCard);

    }

    private static void setAllCollectionImages() throws Exception {
        gameState.getMainMenu().getCollection().loadAllCards();
    }

    private static void setMainCollectionImages() throws Exception {
        gameState.getMainMenu().getCollection().loadMainListCards();
    }
    private static void setOwnedCollectionImages() throws Exception {
        gameState.getMainMenu().getCollection().loadOwnedCards();
    }

    private static void setUnownedCollectionImages() throws Exception {
        gameState.getMainMenu().getCollection().loadUnownedCards();
    }
    private static void setManaBasedCollectionImages() throws Exception {
        gameState.getMainMenu().getCollection().loadCardsWithMana(searchMana);
    }

    private static void loadCollectionsNextPage() {

        if(gameState.getMainMenu().getCollection().getMainList().size()>gameState.getMainMenu().getCollection().getPageCounter()+1)
            gameState.getMainMenu().getCollection().setPageCounter(gameState.getMainMenu().getCollection().getPageCounter()+1);


    }
    private static void removeDeck() throws Exception {

        gameState.getMainMenu().getCollection().removeDeck(decksIndex);


    }


    private static void loadCollectionsPreviousPage() {

        if(gameState.getMainMenu().getCollection().getPageCounter()>=1) {
            gameState.getMainMenu().getCollection().setPageCounter(gameState.getMainMenu().getCollection().getPageCounter() - 1);
        }


    }
    private static void collectionSearchString() throws Exception {

        gameState.getMainMenu().getCollection().loadCardWithSearch(searchString);


    }



    public void addRequest(RequestType requestType) throws Exception {
        if (requestType != null) {
            requests.add(requestType);
            executeRequests();

        }
    }



    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void executeRequests() throws Exception {
        for (Iterator<Request> requestIterator = requests.iterator(); requestIterator.hasNext(); ) {
            Request request = requestIterator.next();
            request.execute();
            requestIterator.remove();
        }
    }

    public enum RequestType implements Request {

        Login {
            @Override
            public void execute() throws Exception {
                ScreenController.activate("Login");
                if (login())
                    myLogger = gameState.getMainMenu().getLoggerCreator();

            }
        },
        SignUp {
            @Override
            public void execute() throws Exception {
                signup();
                myLogger = gameState.getMainMenu().getLoggerCreator();
            }
        }, Collection_Set_All_Images {
            @Override
            public void execute() throws Exception {
                setAllCollectionImages();
                myLogger.logger.log(Level.INFO, "filter:all");
                audioPlayer.playSound("button");
            }
        }, Collecction_Next {
            @Override
            public void execute() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
                loadCollectionsNextPage();
                audioPlayer.playSound(("next"));
            }
        }, Collection_Set_Main_Images {
            @Override
            public void execute() throws Exception {
                setMainCollectionImages();
                //myLogger.logger.log(Level.INFO,"MainMenu");
            }
        }, Collecction_Previous {
            @Override
            public void execute() throws Exception {
                loadCollectionsPreviousPage();
                audioPlayer.playSound(("next"));
            }
        }, Collection_Set_Owned_Images {
            @Override
            public void execute() throws Exception {
                setOwnedCollectionImages();
                myLogger.logger.log(Level.INFO, "filter:owned");
                audioPlayer.playSound("button");
            }
        }, Collection_Set_Unowned_Images {
            @Override
            public void execute() throws Exception {
                setUnownedCollectionImages();
                myLogger.logger.log(Level.INFO, "filter:unowned");
                audioPlayer.playSound("button");
            }
        }, Collection_Set_ManaBased_Images {
            @Override
            public void execute() throws Exception {
                setManaBasedCollectionImages();
                myLogger.logger.log(Level.INFO, "searchMana:" + searchMana);
                audioPlayer.playSound("button");
            }
        }, Collection_Search {
            @Override
            public void execute() throws Exception {
                collectionSearchString();
                myLogger.logger.log(Level.INFO, "search:" + searchString);
                audioPlayer.playSound("button");
            }
        }, Collection_RemoveDeck {
            @Override
            public void execute() throws Exception {
                removeDeck();
                myLogger.logger.log(Level.INFO, "removedDeck:" + decksIndex);
                audioPlayer.playSound("button");
            }
        }, Load_Collection {
            @Override
            public void execute() throws Exception {
                loadCollection();
                //myLogger.logger.log(Level.INFO,"Collection");
                audioPlayer.playSound("click");
            }
        }, Load_MainMenu {
            @Override
            public void execute() throws Exception {
                loadMainMenu();
                //myLogger.logger.log(Level.INFO,"MainMenu");
            }
        }, Load_Login {
            @Override
            public void execute() throws Exception {
                loadLogin();
            }
        }, Load_Store {
            @Override
            public void execute() throws Exception {
                loadStore();
                audioPlayer.playSound("click");
            }
        }, Load_CompleteDeck {
            @Override
            public void execute() throws Exception {
                loadCompleteDeck();
                audioPlayer.playSound("click");
            }
        }, Load_ChooseDeck {
            @Override
            public void execute() throws Exception {
                loadChooseDeck();
                audioPlayer.playSound("click");
            }
        }, Load_ChooseHero {
            @Override
            public void execute() throws Exception {
                loadChooseHero();
                audioPlayer.playSound("button");
            }
        }, Load_CardBack {
            @Override
            public void execute() throws Exception {
                loadCardBack();
                audioPlayer.playSound("button");
            }
        }, Load_BoldImage {
            @Override
            public void execute() throws Exception {
                loadBoldImage();
                audioPlayer.playSound("click");

            }
        }, Load_Battlefield {
            @Override
            public void execute() throws Exception {
                loadBattlefield();
                audioPlayer.playSound("button");
            }
        }, Store_Buy {
            @Override
            public void execute() throws Exception {
                buyCard();
                myLogger.logger.log(Level.INFO, "buy:" + boughtCard);
                myLogger.logger.log(Level.INFO, "wallet:" + gameState.getMainMenu().getStore().getCoins());
                audioPlayer.playSound("buy");
            }
        }, Store_Sell {
            @Override
            public void execute() throws Exception {
                sellCard();
                myLogger.logger.log(Level.INFO, "sell:" + soldCard);
                myLogger.logger.log(Level.INFO, "wallet:" + gameState.getMainMenu().getStore().getCoins());
                audioPlayer.playSound("mana");
            }
        }, CompleteDeck_Specify_Decks_Index {
            @Override
            public void execute() throws Exception {
                specifyDecksIndex();
                audioPlayer.playSound("button");
                myLogger.logger.log(Level.INFO, "chooseDeck:" + gameState.getMainMenu().getCollection().getDecks()[getSpecifiedDecksIndex()].getName());

            }
        }, CompleteDeck_Submit {
            @Override
            public void execute() throws Exception {
                submitCompleteDeck();
                myLogger.logger.log(Level.INFO, gameState.getMainMenu().getCollection().getDecks()[getSpecifiedDecksIndex()].getName() + "-chagedName-" + specifiedDecksNewName);
                audioPlayer.playSound("button");

            }
        }, CompleteDeck_AddCards {
            @Override
            public void execute() throws Exception {
                addCardsToSpecifiedDeck();
                for (int i = 0; i < gameState.getMainMenu().getCollection().getAddedCardsToSpecifiedDeck().size(); i++)
                    myLogger.logger.log(Level.INFO, gameState.getMainMenu().getCollection().getDecks()[getSpecifiedDecksIndex()].getName() + "-addCards-" + gameState.getMainMenu().getCollection().getMainList().get(gameState.getMainMenu().getCollection().getPageCounter()).get(i));
                audioPlayer.playSound("addCards");
            }
        }, CompleteDeck_SpecifiedDecksHero {
            @Override
            public void execute() throws Exception {
                changeSpecifiedDecksHerotype();
                myLogger.logger.log(Level.INFO, gameState.getMainMenu().getCollection().getDecks()[getSpecifiedDecksIndex()].getName() + "-changeHerotype-" + specifiedDecksHerotype);
                audioPlayer.playSound("button");
            }

        }, ChooseDeck_Next {
            @Override
            public void execute() throws Exception {
                nextChooseDeckPage();
                audioPlayer.playSound("next");
            }
        }, ChooseDeck_Previous {
            @Override
            public void execute() throws Exception {
                previousChooseDeckPage();
                audioPlayer.playSound("next");
            }
        }, ChooseDeck_setHand {
            @Override
            public void execute() throws Exception {
                System.out.println("choosenDeck!");
                setHandChooseDeck();
                audioPlayer.playSound("button");
                myLogger.logger.log(Level.INFO, "defaultDeck:" + (gameState.getMainMenu().getCollection().getDecks()[(chooseDeckIndex)].getName()));
                myLogger.logger.log(Level.INFO, "hand:" + CardList.convertCardListToNameList(gameState.getMainMenu().getCollection().getHand().getHandsCards()));
            }
        }, Start_GameContext {
            @Override
            public void execute() throws Exception {
                startGameContext();

                //loadBattlefield();
                audioPlayer.playSound("game");
                //myLogger.logger.log(Level.INFO,"Battlefield");
            }

        }, End_Program {
            @Override
            public void execute() throws Exception {
                audioPlayer.playSound("close");
                endProgram();


            }

        }, load_Status {
            @Override
            public void execute() throws Exception {
                loadStatus();
                //myLogger.logger.log(Level.INFO,"Status");
                audioPlayer.playSound("click");
            }

        }, Load_CompleteStatus {
            @Override
            public void execute() throws Exception {
                loadCompleteStatus();
                // myLogger.logger.log(Level.INFO,"CompleteStatus");
                audioPlayer.playSound("click");
            }
        }, SwitchUsers {
            @Override
            public void execute() throws Exception {
                switchUsers();
            }
        }
    }


    public static void loadCompleteStatus(){
        gameState.setCompleteStatusTrue();
    }


    public static void setHandChooseDeck() throws Exception {
        gameState.getMainMenu().getCollection().setHandWithIndex(chooseDeckIndex);

    }

    public static void specifyDecksIndex() throws Exception {

        gameState.getMainMenu().getCollection().setSpecifiedDecksIndex(SpecifiedDecksIndex);

    }

    public static GamePlayer getGameState() {
        return gameState;
    }

    public static Mapper getInstance() {
        return instance;
    }
}