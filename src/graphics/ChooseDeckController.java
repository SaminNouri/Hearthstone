package graphics;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import game.GameMapper;
import game.LoggerCreator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;

public class ChooseDeckController implements Initializable {

    private ArrayList<JFXButton> deckButtons;
    private Drawer drawer;
    private Mapper mapper;
    private static LoggerCreator myLogger;
    private GameMapper gameMapper;
    public static void setMyLogger(LoggerCreator myLogger1) {
        myLogger = myLogger1;
    }


    @FXML
    private JFXComboBox<String> ChooseEnemyDeck;

    @FXML

    private JFXButton CollectionButton;

    @FXML
    private JFXButton PlayButton;

    @FXML
    private JFXButton BackButton;
    @FXML
    private JFXButton QuitButton;
    @FXML
    private JFXButton MainMenu;

    @FXML
    private JFXButton NextButton;

    @FXML
    private ImageView MainHeroImage;

    @FXML
    private JFXButton Deck1;

    @FXML
    private JFXButton Deck2;

    @FXML
    private JFXButton Deck3;

    @FXML
    private JFXButton Deck4;

    @FXML
    private JFXButton Deck5;

    @FXML
    private JFXButton Deck6;

    @FXML
    private JFXButton Deck7;

    @FXML
    private JFXButton Deck8;

    @FXML
    private JFXButton Deck9;


    @FXML
    private JFXButton Deck10;

    @FXML
    private JFXButton Deck11;

    @FXML
    private JFXButton Deck12;

    @FXML
    private JFXButton Deck13;

    @FXML
    private JFXButton Deck14;

    @FXML
    private JFXButton Deck15;

    @FXML
    private JFXButton Deck16;



    @FXML
    private JFXButton PreviousButton;

    @FXML
    void collectionAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Collection");
      ScreenController.activate("Collection");
    }

    @FXML
    void backAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"BackAction");
        ScreenController.activatePreviousScreen();
    }

    @FXML
    void deck1Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck1");
        mapper.setChooseDeckIndex(0);
        mapper.addRequest(Mapper.RequestType.ChooseDeck_setHand);

    }

    @FXML
    void deck2Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck2");
        mapper.setChooseDeckIndex(1);
        mapper.addRequest(Mapper.RequestType.ChooseDeck_setHand);


    }

    @FXML
    void deck3Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck3");
        mapper.setChooseDeckIndex(2);
        mapper.addRequest(Mapper.RequestType.ChooseDeck_setHand);

    }

    @FXML
    void deck4Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck4");
        mapper.setChooseDeckIndex(3);
        mapper.addRequest(Mapper.RequestType.ChooseDeck_setHand);


    }

    @FXML
    void deck5Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck5");
        mapper.setChooseDeckIndex(4);
        mapper.addRequest(Mapper.RequestType.ChooseDeck_setHand);

    }

    @FXML
    void deck6Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck6");
        mapper.setChooseDeckIndex(5);
        mapper.addRequest(Mapper.RequestType.ChooseDeck_setHand);


    }

    @FXML
    void deck7Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck7");
        mapper.setChooseDeckIndex(6);
        mapper.addRequest(Mapper.RequestType.ChooseDeck_setHand);

    }
    @FXML
    void mainMenuAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"MainMenu");
        mapper.addRequest(Mapper.RequestType.Load_MainMenu);
        update();
    }

    @FXML
    void deck8Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck8");
        mapper.setChooseDeckIndex(7);
        mapper.addRequest(Mapper.RequestType.ChooseDeck_setHand);

    }

    @FXML
    void deck9Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck9");
        mapper.setChooseDeckIndex(8);
        mapper.addRequest(Mapper.RequestType.ChooseDeck_setHand);


    }

    @FXML
    void quitAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"QuitButton");
        mapper.addRequest(Mapper.RequestType.End_Program);

    }


    @FXML
    void nextAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Next");
       mapper.addRequest(Mapper.RequestType.ChooseDeck_Next);
        update();
    }

    @FXML
    void playAction(ActionEvent event) throws Exception {
         String string=ChooseEnemyDeck.getValue();
         String temp="";
         for(int i=0;i<string.length();i++)
         {   if(string.charAt(i)==':')
               break;
             temp+=string.charAt(i);
         }
         Mapper.setEnemiesDeckIndex(Integer.valueOf(temp));
         mapper.addRequest(Mapper.RequestType.Start_GameContext);
         ScreenController.activate("ChoosePassives");

        //gameMapper.addRequest(GameMapper.RequestType.StartGame);
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Play");
       // mapper.addRequest(Mapper.RequestType.Start_GameContext);

        update();
    }

     void setDeckButtons() {
       deckButtons=new ArrayList<JFXButton>();
        deckButtons.add(Deck1);
        deckButtons.add(Deck2);
        deckButtons.add(Deck3);
        deckButtons.add(Deck4);
        deckButtons.add(Deck5);
        deckButtons.add(Deck6);
        deckButtons.add(Deck7);
        deckButtons.add(Deck8);
        deckButtons.add(Deck9);

    }

    @FXML
    void previousAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Previous");
        mapper.addRequest(Mapper.RequestType.ChooseDeck_Previous);
        update();
    }

    void  resetDeckButtons(){
        for(JFXButton btn:deckButtons){
            btn.setText("");
        }
    }
     void  setDecksNamesButtons(ArrayList<String> names){
        int counter=0;
        ArrayList<String> tempList=new ArrayList<String>();
        for(String name:names){
            JFXButton btn=deckButtons.get(counter);
            btn.setText(name);
            tempList.add(counter+":"+name);
            counter++;

        }
         ObservableList<String> oListStavaka = FXCollections.observableArrayList(tempList);
         ChooseEnemyDeck.setItems(oListStavaka);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameMapper=GameMapper.getInstance();
        mapper=Mapper.getInstance();
        setDeckButtons();
        resetDeckButtons();
        drawer=new Drawer("ChooseDeckController");
        try {
            drawer.drawChooseDeck(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    void update() throws Exception {
        ScreenController.activate();
    }
}