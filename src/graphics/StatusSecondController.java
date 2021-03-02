package graphics;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.xml.internal.security.Init;
import game.LoggerCreator;
import initialCard.enumClasses.HeroType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;

public class StatusSecondController implements Initializable {

    private Mapper mapper;
    private Drawer drawer;
    private static LoggerCreator myLogger;
    private ArrayList<JFXRadioButton> groupDecksCards;

    public static void setMyLogger(LoggerCreator myLogger) {
        StatusSecondController.myLogger = myLogger;
    }

    @FXML
    private JFXButton QuitButton;

    @FXML
    private JFXRadioButton Card1Deck;

    @FXML
    private JFXRadioButton Card3Deck;

    @FXML
    private JFXRadioButton Card4Deck;

    @FXML
    private JFXRadioButton Card5Deck;

    @FXML
    private JFXRadioButton Card6Deck;

    @FXML
    private JFXRadioButton Card9Deck;

    @FXML
    private JFXRadioButton Card10Deck;

    @FXML
    private JFXRadioButton Card8Deck;

    @FXML
    private JFXRadioButton Card11Deck;

    @FXML
    private JFXRadioButton Card12Deck;

    @FXML
    private JFXRadioButton Card13Deck;

    @FXML
    private JFXRadioButton Card14Deck;

    @FXML
    private JFXRadioButton Card15Deck;

    @FXML
    private JFXRadioButton Card16Deck;

    @FXML
    private JFXRadioButton Card17Deck;

    @FXML
    private JFXRadioButton Card18Deck;

    @FXML
    private JFXRadioButton Card19Deck;

    @FXML
    private JFXRadioButton Card20Deck;

    @FXML
    private JFXRadioButton Card22Deck;

    @FXML
    private JFXRadioButton Card21Deck;

    @FXML
    private JFXRadioButton Card2Deck;

    @FXML
    private JFXRadioButton Card23Deck;

    @FXML
    private JFXRadioButton Card24Deck;

    @FXML
    private JFXRadioButton Card25Deck;

    @FXML
    private JFXRadioButton Card26Deck;

    @FXML
    private JFXRadioButton Card7Deck;

    @FXML
    private JFXRadioButton Card28Deck;

    @FXML
    private JFXRadioButton Card27Deck;

    @FXML
    private JFXRadioButton Card29Deck;

    @FXML
    private JFXRadioButton Card30Deck;

    @FXML
    private TextField DecksNameTextField;

    @FXML
    private JFXButton BackButton;

    @FXML
    private JFXButton MainMenu;

    @FXML
    private Label ratio;

    @FXML
    private Label wins;

    @FXML
    private Label games;

    @FXML
    private Label costs;

    @FXML
    private Label Heotype;

    @FXML
    private Label mostUsedCard;

    @FXML
    void backAction(ActionEvent event) throws Exception {

        ScreenController.activatePreviousScreen();

    }

    @FXML
    void getDecksName(ActionEvent event) {

    }

    @FXML
    void mainMenuAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"MainMenu");
        mapper.addRequest(Mapper.RequestType.Load_MainMenu);
        update();

    }

    @FXML
    void quitAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"QuitAction");
        mapper.addRequest(Mapper.RequestType.End_Program);

    }
    void setGroupDecksCardsArray(){
        groupDecksCards=new ArrayList<JFXRadioButton>();
        groupDecksCards.add(Card1Deck);
        groupDecksCards.add(Card2Deck);
        groupDecksCards.add(Card3Deck);
        groupDecksCards.add(Card4Deck);
        groupDecksCards.add(Card5Deck);
        groupDecksCards.add(Card6Deck);
        groupDecksCards.add(Card7Deck);
        groupDecksCards.add(Card8Deck);
        groupDecksCards.add(Card9Deck);
        groupDecksCards.add(Card10Deck);
        groupDecksCards.add(Card11Deck);
        groupDecksCards.add(Card12Deck);
        groupDecksCards.add(Card13Deck);
        groupDecksCards.add(Card14Deck);
        groupDecksCards.add(Card15Deck);
        groupDecksCards.add(Card16Deck);
        groupDecksCards.add(Card17Deck);
        groupDecksCards.add(Card18Deck);
        groupDecksCards.add(Card19Deck);
        groupDecksCards.add(Card20Deck);
        groupDecksCards.add(Card21Deck);
        groupDecksCards.add(Card22Deck);
        groupDecksCards.add(Card23Deck);
        groupDecksCards.add(Card24Deck);
        groupDecksCards.add(Card25Deck);
        groupDecksCards.add(Card26Deck);
        groupDecksCards.add(Card27Deck);
        groupDecksCards.add(Card28Deck);
        groupDecksCards.add(Card29Deck);
        groupDecksCards.add(Card30Deck);


    }



    void loadDecksCards(ArrayList<String> list){


        try {

            int counter = 0;
            for (String name : list) {
                counter++;
                System.out.println(counter);
                groupDecksCards.get(counter-1).setText("");
                groupDecksCards.get(counter-1).setText(name);
                groupDecksCards.get(counter-1).setLayoutY(110+(counter-1)*25);




            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
   void resetCardsDeck(){

        try {

            for (int counter=0;counter<30;counter++) {
                groupDecksCards.get(counter).setText("");
                //groupDecksCards.get(counter).setVisible(false);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        mapper=Mapper.getInstance();
        drawer=new Drawer("CompleteDeck");
        try {
            drawer.drawStatus2(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    void setDecksName(String name){
        DecksNameTextField.setText(name);
    }

    void update(){
        try {
            ScreenController.activate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

     void setRatioText(double d){
        ratio.setText(String.valueOf(d));
    }

     void setWinsText(int d){
        wins.setText(String.valueOf(d));
    }
    void setCostsText(double d){

        costs.setText(String.valueOf(d));
    }

     void setHeotypeText(String str){
       Heotype.setText(str);
    }
   void setMostUsedCardText(String str){
        mostUsedCard.setText(str);
    }



}

