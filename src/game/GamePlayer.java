package game;

import EndProgram.EndProgram;
import MainMenu.MainMenu;
import UserEntrance.UserIntrance;
import player.Player;
import player.playerEnumClasses.GeneralPlayer;

import java.util.HashMap;

public class GamePlayer {


    private UserIntrance userIntrance;
    private EndProgram endProgram;
    private Player player;
    private LoggerCreator loggerCreator;
    private MainMenu mainMenu;
    private boolean loginBoolean=true;
    private boolean collectionBoolean =false;
    private boolean mainMenuBoolean=false;
    private boolean storeBoolean=false;
    private boolean completeDeckBoolean=false;
    private boolean chooseHeroBoolean=false;
    private boolean cardsBackBoolean=false;
    private boolean chooseDeckBoolean=false;
    private boolean boldImage=false;
    private boolean battlefield=false;
    private boolean completeStatus=false;
    private GameContext gameContext;
    private boolean status=false;
    private static boolean boldImage2=false;
    private static boolean chooseCards=false;
    private static boolean choosePassives=false;
    private int index=0;

    public static boolean isChoosePassives() {
        return choosePassives;
    }

    public static void setChoosePassives(boolean choosePassives) {
        GamePlayer.choosePassives = choosePassives;
    }

    public  boolean isChooseCards() {
        return chooseCards;
    }

    public  void setChooseCards(boolean chooseCards) {
        GamePlayer.chooseCards = chooseCards;
    }

    public GameContext getGameContext() {
        return gameContext;
    }

    public void setGameContext(GameContext gameContext) {
        this.gameContext = gameContext;
    }

    public GamePlayer(int i) {
        index=i;
    }
    public GamePlayer(){

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(boolean completeStatus) {
        this.completeStatus = completeStatus;
    }

    public boolean isBattlefield() {
        return battlefield;
    }

    public void setBattlefield(boolean battlefield) {
        this.battlefield = battlefield;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setBattlefieldTrue() {

        loginBoolean=false;
        collectionBoolean =false;
        mainMenuBoolean=false;
        storeBoolean=false;
        completeDeckBoolean=false;
        chooseHeroBoolean=false;
        cardsBackBoolean=false;
        chooseDeckBoolean=false;
        boldImage=false;
        battlefield=true;
        status=false;
        completeStatus=false;
        boldImage2=false;
        chooseCards=false;
        choosePassives=false;

    }
    public void setChooseCardsTrue() {

        loginBoolean=false;
        collectionBoolean =false;
        mainMenuBoolean=false;
        storeBoolean=false;
        completeDeckBoolean=false;
        chooseHeroBoolean=false;
        cardsBackBoolean=false;
        chooseDeckBoolean=false;
        boldImage=false;
        battlefield=false;
        status=false;
        completeStatus=false;
        boldImage2=false;
        chooseCards=true;
        choosePassives=false;

    }

    public void setChoosePassivesTrue() {

        loginBoolean=false;
        collectionBoolean =false;
        mainMenuBoolean=false;
        storeBoolean=false;
        completeDeckBoolean=false;
        chooseHeroBoolean=false;
        cardsBackBoolean=false;
        chooseDeckBoolean=false;
        boldImage=false;
        battlefield=false;
        status=false;
        completeStatus=false;
        boldImage2=false;
        chooseCards=false;
        choosePassives=true;

    }
    public void setBoldImage2True() {

        loginBoolean=false;
        collectionBoolean =false;
        mainMenuBoolean=false;
        storeBoolean=false;
        completeDeckBoolean=false;
        chooseHeroBoolean=false;
        cardsBackBoolean=false;
        chooseDeckBoolean=false;
        boldImage=false;
        battlefield=false;
        status=false;
        completeStatus=false;
        boldImage2=true;
        chooseCards=false;
        choosePassives=false;

    }
    public void setStatusTrue() {

        loginBoolean=false;
        collectionBoolean =false;
        mainMenuBoolean=false;
        storeBoolean=false;
        completeDeckBoolean=false;
        chooseHeroBoolean=false;
        cardsBackBoolean=false;
        chooseDeckBoolean=false;
        boldImage=false;
        battlefield=false;
        status=true;
        completeStatus=false;
        boldImage2=false;
        chooseCards=false;
        choosePassives=false;

    }

    public void setLoginTrue() {

        loginBoolean=true;
        collectionBoolean =false;
        mainMenuBoolean=false;
        storeBoolean=false;
        completeDeckBoolean=false;
        chooseHeroBoolean=false;
        cardsBackBoolean=false;
        chooseDeckBoolean=false;
        boldImage=false;
        battlefield=false;
        status=false;
        completeStatus=false;
        boldImage2=false;
        chooseCards=false;
        choosePassives=false;

    }
    public void setBoldImageTrue() {

        loginBoolean=false;
        collectionBoolean =false;
        mainMenuBoolean=false;
        storeBoolean=false;
        completeDeckBoolean=false;
        chooseHeroBoolean=false;
        cardsBackBoolean=false;
        chooseDeckBoolean=false;
        boldImage=true;
        battlefield=false;
        status=false;
        completeStatus=false;
        boldImage2=false;
        chooseCards=false;
        choosePassives=false;

    }

    public void setCollectionTrue() {

        loginBoolean=false;
        collectionBoolean =true;
        mainMenuBoolean=false;
        storeBoolean=false;
        completeDeckBoolean=false;
        chooseHeroBoolean=false;
        cardsBackBoolean=false;
        chooseDeckBoolean=false;
        boldImage=false;
        battlefield=false;
        status=false;
        completeStatus=false;
        boldImage2=false;
        chooseCards=false;
        choosePassives=false;

    }
    public void setMainMenuTrue() {

        loginBoolean=false;
        collectionBoolean =false;
        mainMenuBoolean=true;
        storeBoolean=false;
        completeDeckBoolean=false;
        chooseHeroBoolean=false;
        cardsBackBoolean=false;
        chooseDeckBoolean=false;
        boldImage=false;
        battlefield=false;
        status=false;
        completeStatus=false;
        boldImage2=false;
        chooseCards=false;
        choosePassives=false;

    }

    public void setStoreTrue() {

        loginBoolean=false;
        collectionBoolean =false;
        mainMenuBoolean=false;
        storeBoolean=true;
        completeDeckBoolean=false;
        chooseHeroBoolean=false;
        cardsBackBoolean=false;
        chooseDeckBoolean=false;
        boldImage=false;
        battlefield=false;
        status=false;
        completeStatus=false;
        boldImage2=false;
        chooseCards=false;
        choosePassives=false;

    }
    public void setCompleteDeckTrue() {

        loginBoolean=false;
        collectionBoolean =false;
        mainMenuBoolean=false;
        storeBoolean=false;
        completeDeckBoolean=true;
        chooseHeroBoolean=false;
        cardsBackBoolean=false;
        chooseDeckBoolean=false;
        boldImage=false;
        battlefield=false;
        status=false;
        completeStatus=false;
        boldImage2=false;
        chooseCards=false;
        choosePassives=false;

    }

    public void setChooseHeroTrue() {

        loginBoolean=false;
        collectionBoolean =false;
        mainMenuBoolean=false;
        storeBoolean=false;
        completeDeckBoolean=false;
        chooseHeroBoolean=true;
        cardsBackBoolean=false;
        chooseDeckBoolean=false;
        boldImage=false;
        battlefield=false;
        status=false;
        completeStatus=false;
        boldImage2=false;
        chooseCards=false;
        choosePassives=false;

    }

    public void setChooseDeckTrue() {

        loginBoolean=false;
        collectionBoolean =false;
        mainMenuBoolean=false;
        storeBoolean=false;
        completeDeckBoolean=false;
        chooseHeroBoolean=false;
        cardsBackBoolean=false;
        chooseDeckBoolean=true;
        boldImage=false;
        battlefield=false;
        status=false;
        completeStatus=false;
        boldImage2=false;
        chooseCards=false;
        choosePassives=false;

    }

    public void setCardsBackTrue() {

        loginBoolean=false;
        collectionBoolean =false;
        mainMenuBoolean=false;
        storeBoolean=false;
        completeDeckBoolean=false;
        chooseHeroBoolean=false;
        cardsBackBoolean=true;
        chooseDeckBoolean=false;
        boldImage=false;
        battlefield=false;
        status=false;
        completeStatus=false;
        boldImage2=false;
        chooseCards=false;
        choosePassives=false;

    }
    public void setCompleteStatusTrue() {

        loginBoolean=false;
        collectionBoolean =false;
        mainMenuBoolean=false;
        storeBoolean=false;
        completeDeckBoolean=false;
        chooseHeroBoolean=false;
        cardsBackBoolean=false;
        chooseDeckBoolean=false;
        boldImage=false;
        battlefield=false;
        status=false;
        completeStatus=true;
        boldImage2=false;
        chooseCards=false;
        choosePassives=false;

    }



    public boolean isBoldImage() {
        return boldImage;
    }


    public boolean isBoldImage2() {
        return boldImage2;
    }

    public void setBoldImage(boolean boldImage) {
        this.boldImage = boldImage;
    }

    public boolean isChooseDeckBoolean() {
        return chooseDeckBoolean;
    }

    public void setChooseDeckBoolean(boolean chooseDeckBoolean) {
        this.chooseDeckBoolean = chooseDeckBoolean;
    }

    public boolean isCardsBackBoolean() {
        return cardsBackBoolean;
    }

    public void setCardsBackBoolean(boolean cardsBackBoolean) {
        this.cardsBackBoolean = cardsBackBoolean;
    }

    public boolean isChooseHeroBoolean() {
        return chooseHeroBoolean;
    }

    public void setChooseHeroBoolean(boolean chooseHeroBoolean) {
        this.chooseHeroBoolean = chooseHeroBoolean;
    }

    public boolean isCompleteDeckBoolean() {
        return completeDeckBoolean;
    }

    public void setCompleteDeckBoolean(boolean completeDeckBoolean) {
        this.completeDeckBoolean = completeDeckBoolean;
    }

    public boolean isStoreBoolean() {
        return storeBoolean;
    }

    public void setStoreBoolean(boolean storeBoolean) {
        this.storeBoolean = storeBoolean;
    }

    public boolean isMainMenuBoolean() {
        return mainMenuBoolean;
    }

    public boolean isCollectionBoolean() {
        return collectionBoolean;
    }

    public void setCollectionBoolean(boolean collectionBoolean) {
        this.collectionBoolean = collectionBoolean;
    }

    public void setMainMenuBoolean(boolean mainMenuBoolean) {
        this.mainMenuBoolean = mainMenuBoolean;
    }

    public boolean isLoginBoolean() {
        return loginBoolean;
    }

    public void setLoginBoolean(boolean loginBoolean) {
        this.loginBoolean = loginBoolean;
    }



    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public EndProgram getEndProgram() {
        return endProgram;
    }

    public void setEndProgram(EndProgram endProgram) {
        this.endProgram = endProgram;
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    private static HashMap<GeneralPlayer,Object> map=new HashMap<GeneralPlayer, Object>();

    public  void runMainMenu() throws Exception {
        //try {
        loggerCreator = userIntrance.getLoggerCreator();
        map = userIntrance.getMap();
        endProgram = new EndProgram(map);
        endProgram.setLoggerCreator(loggerCreator);
        userIntrance.setEndProgram(endProgram);
        player = new Player(map);
        player.setLoggerCreator(loggerCreator);
        player.setEndProgram(endProgram);
        player.setPassword(userIntrance.getPassword());
        player.setUserName(userIntrance.getUserName());
        mainMenu = new MainMenu(map);
        mainMenu.setLoggerCreator(loggerCreator);
        mainMenu.setEndProgram(endProgram);



        //}catch(Exception e){
        //LoggerCreator.logger.info(e.toString()+" the error line is : "+e.getCause().getStackTrace()[0].getLineNumber());
        //}


    }
    public void inputMainMenu(String input) throws Exception{
        mainMenu.mainMenu(input);
    }



    public  boolean submitData(String username,String password,String input) throws Exception {
        // try {

        userIntrance = new UserIntrance();
        userIntrance.setInput(input);
        userIntrance.setUserName(username);
        userIntrance.setPassword(password);
        System.out.println( userIntrance.entranceMenu());
        return userIntrance.entranceMenu();



        // }catch(Exception e){
        //  LoggerCreator.logger.info(e.toString()+" the error line is : "+e.getCause().getStackTrace()[0].getLineNumber());
        //        return false;
        //  }


    }

}
