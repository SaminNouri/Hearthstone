/*

package graphics;

import com.jfoenix.controls.JFXButton;
import game.GameMapper;
import initialCard.card.Card;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import resources.PicturePaths;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChoosePassives implements Initializable {

    @FXML
    private ImageView BCard1;

    @FXML
    private ImageView BCard2;

    @FXML
    private ImageView BCard3;

    @FXML
    private ImageView X1;

    @FXML
    private ImageView X2;

    @FXML
    private ImageView X3;

    @FXML
    private JFXButton Battlefield;

    @FXML
    void battlefield(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setCards();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        setMouseListeners();

    }
    public void setBCard1() throws FileNotFoundException {
        Card card;
        card= GameMapper.getGameContext().getCurrentHand().getMyPassives().get(0);
        if(card!=null) {
            String name = card.getName();
            FileInputStream input = new FileInputStream(PicturePaths.getPathByName(name));
            Image image = new Image(input);
            ColorAdjust blackout = new ColorAdjust();
            BCard1.setImage(image);
        }
    }
    public void setBCard2() throws FileNotFoundException {
        Card card;
        card= GameMapper.getGameContext().getCurrentHand().getMyPassives().get(1);
        if(card!=null) {
            String name = card.getName();
            FileInputStream input = new FileInputStream(PicturePaths.getPathByName(name));
            Image image = new Image(input);
            ColorAdjust blackout = new ColorAdjust();
            BCard2.setImage(image);
        }
    }
    public void setBCard3() throws FileNotFoundException {
        Card card;
        card= GameMapper.getGameContext().getCurrentHand().getMyPassives().get(2);
        if(card!=null) {
            String name = card.getName();
            FileInputStream input = new FileInputStream(PicturePaths.getPathByName(name));
            Image image = new Image(input);
            ColorAdjust blackout = new ColorAdjust();
            BCard3.setImage(image);
        }
    }
    public void setCards() throws FileNotFoundException {
        setBCard1();
        setBCard2();
        setBCard3();
    }
    public void setMouseListeners(){
        X1.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(javafx.scene.input.MouseEvent event) {

                GameMapper.getGameContext().getCurrentHand().setPassiveCard(GameMapper.getGameContext().getCurrentHand().getMyPassives().get(0));
                try {
                    setCards();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


            }

        });
        X2.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

            @Override
            public void handle(javafx.scene.input.MouseEvent event) {


                GameMapper.getGameContext().getCurrentHand().setPassiveCard(GameMapper.getGameContext().getCurrentHand().getMyPassives().get(1));
                try {
                    setCards();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();}






            }

        });
        X3.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(javafx.scene.input.MouseEvent event) {


                GameMapper.getGameContext().getCurrentHand().setPassiveCard(GameMapper.getGameContext().getCurrentHand().getMyPassives().get(2));
                try {
                    setCards();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();}






            }

        });
    }


}

 */

package graphics;

import com.jfoenix.controls.JFXButton;
import game.GameMapper;
import initialCard.card.Card;
import initialSpell.spell.condition.ConditionHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import resources.PicturePaths;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChoosePassives implements Initializable {

    @FXML
    private ImageView BCard1;

    @FXML
    private ImageView BCard2;

    @FXML
    private ImageView BCard3;

    @FXML
    private ImageView X1;

    @FXML
    private ImageView X2;

    @FXML
    private ImageView X3;

    @FXML
    private JFXButton Battlefield;

    @FXML
    void battlefield(ActionEvent event) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
         ScreenController.activate("ChooseCards");

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setCards();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        setMouseListeners();

    }
    public void setBCard1() throws FileNotFoundException {
        Card card;
        card= GameMapper.getGameContext().getCurrentHand().getMyPassives().get(0);
        if(card!=null) {
            String name = card.getName();
            FileInputStream input = new FileInputStream(PicturePaths.getPathByName(name));
            Image image = new Image(input);
            ColorAdjust blackout = new ColorAdjust();
            BCard1.setImage(image);
        }
    }
    public void setBCard2() throws FileNotFoundException {
        Card card;
        card= GameMapper.getGameContext().getCurrentHand().getMyPassives().get(1);
        if(card!=null) {
            String name = card.getName();
            FileInputStream input = new FileInputStream(PicturePaths.getPathByName(name));
            Image image = new Image(input);
            ColorAdjust blackout = new ColorAdjust();
            BCard2.setImage(image);
        }
    }
    public void setBCard3() throws FileNotFoundException {
        Card card;
        card= GameMapper.getGameContext().getCurrentHand().getMyPassives().get(2);
        if(card!=null) {
            String name = card.getName();
            FileInputStream input = new FileInputStream(PicturePaths.getPathByName(name));
            Image image = new Image(input);
            ColorAdjust blackout = new ColorAdjust();
            BCard3.setImage(image);
        }
    }
    public void setCards() throws FileNotFoundException {
        setBCard1();
        setBCard2();
        setBCard3();
    }
    public void setMouseListeners(){
        X1.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

            @Override
            public void handle(javafx.scene.input.MouseEvent event) {

                GameMapper.getGameContext().getCurrentHand().setPassiveCard(GameMapper.getGameContext().getCurrentHand().getMyPassives().get(0));
                try {
                    setCards();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


            }

        });
        X2.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

            @Override
            public void handle(javafx.scene.input.MouseEvent event) {


                GameMapper.getGameContext().getCurrentHand().setPassiveCard(GameMapper.getGameContext().getCurrentHand().getMyPassives().get(1));
                try {
                    setCards();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();}


            }

        });

        X3.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {

            @Override
            public void handle(javafx.scene.input.MouseEvent event) {


                GameMapper.getGameContext().getCurrentHand().setPassiveCard(GameMapper.getGameContext().getCurrentHand().getMyPassives().get(2));
                try {
                    setCards();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();}


            }

        });


    }

}
