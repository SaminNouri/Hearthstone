package graphics;

import collection.Collection;
import game.GamePlayer;
import game.GameMapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Data on 4/11/2020.
 */
public class Main extends Application  {
    private AudioPlayer loopAudioPlayer;
    Mapper mapper;
    GameMapper gameMapper;

    @Override
    public void start(Stage primaryStage) throws Exception {

        mapper=Mapper.getInstance();
        gameMapper=GameMapper.getInstance();
        setScreenController(primaryStage);
        primaryStage.show();
        primaryStage.setResizable(false);
        playMusic();


    }

    private void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if(ScreenController.getCurrentPage().equals("Login")) {
            loopAudioPlayer = new AudioPlayer("menu");
            loopAudioPlayer.play();
        }
    }

    private void setScreenController(Stage primaryStage) throws Exception {

        Mapper.setGameContext(GameMapper.getGameContext());
        ScreenController screenController=new ScreenController(primaryStage);
        addPages(screenController);
        screenController.activate("Login");
        //screenController.activate("ChoosePassives");
        addLogger();

    }

    private void addLogger() {

        ScreenController.setMyLogger(mapper.getMyLogger());
        GameMapper.setMyLogger(mapper.getMyLogger());
        MainMenuController.setMyLogger(Mapper.getMyLogger());
        CollectionController.setMyLogger(Mapper.getMyLogger());
        CompleteDeckController.setMyLogger(Mapper.getMyLogger());
        StatusSecondController.setMyLogger(Mapper.getMyLogger());
        StatusController.setMyLogger(Mapper.getMyLogger());
        ChooseDeckController.setMyLogger(Mapper.getMyLogger());
        BattlefieldController.setMyLogger(Mapper.getMyLogger());
        BoldCardController.setMyLogger(Mapper.getMyLogger());
        StoreController.setMyLogger(Mapper.getMyLogger());
    }

    private void addPages(ScreenController screenController) throws Exception {
        screenController.addScreen("Login",getClass().getResource("Login.fxml"));
        screenController.addScreen("Battlefield",getClass().getResource("Battlefield.fxml"));
        screenController.addScreen("BoldImage",getClass().getResource("BoldImage.fxml"));
        screenController.addScreen("CardBack",getClass().getResource("CardBack.fxml"));
        screenController.addScreen("ChooseDeck",getClass().getResource("ChooseDeck.fxml"));
        screenController.addScreen("ChooseHero",getClass().getResource("hooseHero.fxml"));
        screenController.addScreen("Collection",getClass().getResource("Collection.fxml"));
        screenController.addScreen("CompleteDeck",getClass().getResource("CompleteDeck.fxml"));
        screenController.addScreen("MainMenu",getClass().getResource("MainMenu.fxml"));
        screenController.addScreen("Store",getClass().getResource("Store.fxml"));
        screenController.addScreen("Status",getClass().getResource("StatusChooseDeck.fxml"));
        screenController.addScreen("Status2",getClass().getResource("Status2.fxml"));
        screenController.addScreen("BoldImage2",getClass().getResource("BoldImage2.fxml"));
        screenController.addScreen("ChooseCards",getClass().getResource("chooseCards.fxml"));
        screenController.addScreen("ChoosePassives",getClass().getResource("ChoosePassives.fxml"));
    }

    public static void main(String[] args){
        launch(args);

    }


}
