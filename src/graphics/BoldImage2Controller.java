package graphics;

import com.jfoenix.controls.JFXButton;
import game.GameMapper;
import initialCard.card.Card;
import initialCard.card.cardFactory.CardCreator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import resources.PicturePaths;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;

public class BoldImage2Controller implements Initializable {

    private Mapper mapper;
    private GameMapper gameMapper;
    private Drawer drawer;


    @FXML
    private AnchorPane MainAnchorPane;

    @FXML
    private ImageView MainBlurImage;

    @FXML
    private AnchorPane MainPane;

    @FXML
    private ImageView BoldCard;

    @FXML
    private ImageView ExplanationImage;

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
    private JFXButton Battlefield;


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



    void loadBoldImage(Card card) throws Exception {
        CardsRarity.setText(card.getRarity().toString());
        this.HeroType.setText(card.getHeroType().toString());
        this.Type.setText(card.getType().toString());
        this.Coin.setText(String.valueOf(card.getCoin()));
        if(card.getRace()!=null)
            this.Race.setText(card.getRace().toString());
        setBoldImage(card.getName());



    }

    void setBoldImage(String name) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(PicturePaths.getPathByName(name));
        Image image = new Image(input);
        ColorAdjust blackout = new ColorAdjust();
        BoldCard.setImage(image);
    }



    public void initialize(URL location, ResourceBundle resources) {

        mapper=Mapper.getInstance();
        gameMapper=GameMapper.getInstance();



        drawer=new Drawer("BoldCard");
        try {
            drawer.drawBoldCard2(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void BATTLE(ActionEvent event) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        ScreenController.activate("Battlefield");
    }


}
