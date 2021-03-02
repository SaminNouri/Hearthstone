package graphics;

import game.GamePlayer;
import game.GamePlayer;
import game.LoggerCreator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class ScreenController {


    private static HashMap<String, URL> screenUrlMap = new HashMap<String,URL>();
    private static Stage primaryStage;
    private static Scene scene;
    private static Parent root;
    private static Mapper mapper;
    private static ArrayList<String> previousScreens= new ArrayList<String>();
    private static LoggerCreator myLogger;



    public static LoggerCreator getMyLogger() {
        return myLogger;
    }

    public static void setMyLogger(LoggerCreator myLogger) {
        ScreenController.myLogger = myLogger;
    }

   private static Mapper getMapper() {
        return mapper;
    }

    public static void setMapper(Mapper mapper) {
        ScreenController.mapper = mapper;
    }

    public ScreenController(Stage primaryStage) {
        this.primaryStage=primaryStage;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        ScreenController.primaryStage = primaryStage;
    }

    public void addScreen(String name, URL url) throws IOException {
        screenUrlMap.put(name,url);

    }

    private static void removeScreen(String name){
        screenUrlMap.remove(name);
    }

     public static void activate(String name) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        FXMLLoader fxmlLoader=new FXMLLoader(screenUrlMap.get(name));
        root=(Parent) fxmlLoader.load();
        if(name.equals("Battlefield") || name.equals("ChooseCards") || name.equals("ChoosePassives"))
        scene=new Scene(root,1000,700);
        else
            scene=new Scene(root,800,500);
        primaryStage.setScene(scene);
        previousScreens.add(name);
        if(myLogger.logger!=null)
        myLogger.logger.log(Level.INFO,name);
        setGameState(name);




    }

    public static String getCurrentPage(){
       return previousScreens.get(previousScreens.size()-1);
    }
    protected static void activatePreviousScreen() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        String prv=previousScreens.get(previousScreens.size()-1);
        String str=previousScreens.get(previousScreens.size()-2);
        for(int i=previousScreens.size()-1;i>=0;i--){
            if(!previousScreens.get(i).equals(prv) && !previousScreens.get(i).equals("BoldImage")  ) {
                str = previousScreens.get(i);
                break;
            }

        }
        if(str.equals("Battlefield"))
            return;
        if(previousScreens.size()!=0)
            previousScreens.remove(previousScreens.size()-1);
        setGameState(str);
        activate();




    }
   public static void activate() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        GamePlayer gameState=mapper.getGameState();
        if(gameState.isMainMenuBoolean())
        {
            activate("MainMenu");

        }
        else if(gameState.isStoreBoolean())
        {
           activate("Store");
        }
        else if(gameState.isLoginBoolean())
        {
            activate("Login");
        }
        else if(gameState.isCompleteDeckBoolean())
        {
            activate("CompleteDeck");
        }
        else if(gameState.isCollectionBoolean())
        {
            activate("Collection");

        }
        else if(gameState.isCardsBackBoolean())
        {
            activate("CardBack");
        }
        else if(gameState.isChooseDeckBoolean())
        {
            activate("ChooseDeck");
        }
        else if(gameState.isChooseHeroBoolean())
        {
            activate("ChooseHero");
        }
        else if(gameState.isBoldImage())
        {
            activate("BoldImage");
        }
        else if(gameState.isBattlefield())
        {
            
            activate("Battlefield");
        }
        else if(gameState.isStatus())
        {
            activate("Status");
        }
        else if(gameState.isCompleteStatus())
        {
            activate("Status2");
        }
        else if(gameState.isBoldImage2())
        {
            activate("BoldImage2");
        }
        else if(gameState.isChooseCards())
        {
            activate("ChooseCards");
        }
        else if(gameState.isChoosePassives())
        {
            activate("ChoosePassives");
        }

    }


    public static void setGameState(String str){
        GamePlayer gameState=mapper.getGameState();
        if(str.equals("MainMenu"))
        {
            gameState.setMainMenuTrue();

        }
        else if(str.equals("Store"))
        {
            gameState.setStoreTrue();
        }
        else if(str.equals("Login"))
        {
            gameState.setLoginTrue();
        }
        else if(str.equals("CompleteDeck"))
        {
            gameState.setCompleteDeckTrue();
        }
        else if(str.equals("Collection"))
        {
            gameState.setCollectionTrue();

        }
        else if(str.equals("CardBack"))
        {
            gameState.setCardsBackTrue();
        }
        else if(str.equals("ChooseDeck"))
        {
            gameState.setChooseDeckTrue();
        }
        else if(str.equals("ChooseHero"))
        {
            gameState.setChooseHeroTrue();
        }
        else if(str.equals("BoldImage"))
        {
            gameState.setBoldImageTrue();
        }
        else if(str.equals("Battlefield"))
        {
            gameState.setBattlefieldTrue();
        }
        else if(str.equals("Status"))
        {
            gameState.setStatusTrue();
        }
        else if(str.equals("Status2"))
        {
            gameState.setCompleteStatusTrue();
        }
        else if(str.equals("BoldImage2"))
        {
            gameState.setBoldImage2True();
        }
        else if(str.equals("ChooseCards"))
        {
            gameState.setChooseCardsTrue();
        }
        else if(str.equals("ChoosePassives"))
        {
            gameState.setChoosePassivesTrue();
        }
        mapper.setGameState(gameState);
    }






}