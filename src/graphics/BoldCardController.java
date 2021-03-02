package graphics;

import collection.Collection;
import com.jfoenix.controls.JFXButton;
import game.GamePlayer;
import game.LoggerCreator;
import initialCard.card.Card;
import initialCard.card.cardFactory.CardCreator;
import initialCard.enumClasses.HeroType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import resources.PicturePaths;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;

public class BoldCardController implements Initializable{

   private Mapper mapper;
    private Drawer drawer;
    private static LoggerCreator myLogger;

    public static void setMyLogger(LoggerCreator myLogger) {
        BoldCardController.myLogger = myLogger;
    }

    @FXML
    private AnchorPane MainAnchorPane;

    private CollectionController collectionController;

    @FXML
    private ImageView MainBlurImage;

    @FXML
    private ImageView BoldCard;

    @FXML
    private ImageView ExplanationImage;

    @FXML
    private JFXButton Back;
    @FXML
    private JFXButton BackToStore;

    @FXML
    private Label CnsRarity;

    @FXML
    private Label CardsRarity;

    @FXML
    private Label CnsCoin;

    @FXML
    private Label Coin;

    @FXML
    private Label CnsRace;

    @FXML
    private Label Race;

    @FXML
    private Label CnsCardNumbers;

    @FXML
    private Label CardNumbers;

    @FXML
    private Label CnsHeroType;

    @FXML
    private Label HeroType;

    @FXML
    private Label CnsType;

    @FXML
    private Label Type;

    @FXML
    private ImageView Lock;

    @FXML
    void backToCollection(ActionEvent event) throws Exception {
      myLogger.logger.log(Level.INFO,"BackCollectionButton");
      ScreenController.activate("Collection");


    }


    @FXML
    void backToStore(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"BackStoreButton");
        ScreenController.activate("Store");


    }



     void loadBoldImage(String name,int possesedCards) throws Exception {
        Card card= CardCreator.createCardWithName(name);
        CardsRarity.setText(card.getRarity().toString());
        CardNumbers.setText(String.valueOf(possesedCards));
        this.HeroType.setText(card.getHeroType().toString());
        this.Type.setText(card.getType().toString());
        this.Coin.setText(String.valueOf(card.getCoin()));
        if(card.getRace()!=null)
          this.Race.setText(card.getRace().toString());
        setBoldImage(name);
    }

    void setBoldImage(String name) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(PicturePaths.getPathByName(name));
        Image image = new Image(input);
        ColorAdjust blackout = new ColorAdjust();
        BoldCard.setImage(image);
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        mapper=Mapper.getInstance();



        drawer=new Drawer("BoldCard");
        try {
            drawer.drawBoldCard(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

}