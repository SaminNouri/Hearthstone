package graphics;

import MainMenu.MainMenu;
import collection.Collection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.BoundsAccessor;
import deck.Deck;
import game.GamePlayer;
import game.GameMapper;
import game.LoggerCreator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import resources.CardPaths;
import resources.PicturePaths;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;

public class MainMenuController implements Initializable {

    private static Mapper mapper;
    private static LoggerCreator myLogger;

    @FXML
    private JFXComboBox<String> gameMode;
    @FXML
    private AnchorPane MainAnchorPane;

    @FXML
    private ImageView MainImage;
    @FXML
    private JFXButton QuitButton;

    @FXML
    private JFXButton StatusButton;

    @FXML
    private JFXButton PlayButton;

    @FXML
    private JFXButton SettingButton;

    @FXML
    private JFXButton CollectionButton;

    @FXML
    private JFXButton ShopButton;

    @FXML
    private JFXButton CollectionButton1;

    @FXML
    void collectionAction(ActionEvent event) throws Exception {
        mapper.addRequest(Mapper.RequestType.Load_Collection);
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"CollectionButton");
       ScreenController.activate();

    }

    private void setPlayModeCpmboBox(){
        ArrayList<String> options= new ArrayList<String>();
        options.add("SinglePlayer");
        options.add("SystemMode");
        options.add("DeckReader");
        ObservableList<String> oListStavaka = FXCollections.observableArrayList(options);
        gameMode.setItems(oListStavaka);
    }

    @FXML
    void gameModeSelected(ActionEvent event) {
    }

    @FXML
    void playAction(ActionEvent event) throws Exception {

        Mapper.setPlayMode(gameMode.getValue());
        mapper.addRequest(Mapper.RequestType.Load_ChooseDeck);
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"PlayButton");
        ScreenController.activate();

    }

    @FXML
    void settingAction(ActionEvent event) throws Exception {
        mapper.addRequest(Mapper.RequestType.Load_CardBack);
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"SettingButton");
        ScreenController.activate();
    }



    @FXML
    void shopAction(ActionEvent event) throws Exception {

        mapper.addRequest(Mapper.RequestType.Load_Store);
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"shopButton");
        ScreenController.activate();



    }

    @FXML
    void statusAction(ActionEvent event) throws Exception {
         mapper.addRequest(Mapper.RequestType.load_Status);
        ScreenController.activate("Status");
        //mapper.addRequest(Mapper.RequestType.Load_Store);
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"StatusButton");
        ScreenController.activate();



    }

    @FXML
    void quitAction(ActionEvent event) throws Exception {

        mapper.addRequest(Mapper.RequestType.End_Program);
        mapper.addRequest(Mapper.RequestType.Load_Store);
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"QuitButton");
        ScreenController.activate();


    }

    public static void setMyLogger(LoggerCreator myLogger) {
        MainMenuController.myLogger = myLogger;
    }

    public static Mapper getMapper() {
        return mapper;
    }

    public static void setMapper(Mapper temp) {
        mapper = temp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       setPlayModeCpmboBox();
        mapper=Mapper.getInstance();
    }
}
