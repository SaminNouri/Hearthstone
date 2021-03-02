package graphics;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CardBackController implements Initializable {
private  Mapper mapper;
    @FXML
    private AnchorPane MainAnchorPane;

    @FXML
    private Pane MainPane;

    @FXML
    private ImageView CollectionImage;

    @FXML
    private JFXTextField SearchBar;

    @FXML
    private Label HeroTypeLabel;

    @FXML
    private JFXButton BackButton;

    @FXML
    private JFXButton QuitButton;

    @FXML
    private JFXButton Mana0;

    @FXML
    private JFXButton Mana1;

    @FXML
    private JFXButton Mana2;

    @FXML
    private JFXButton Mana4;

    @FXML
    private JFXButton Mana5;

    @FXML
    private JFXButton Mana6;

    @FXML
    private JFXButton Mana7;

    @FXML
    private ImageView Back1;

    @FXML
    private ImageView Back2;

    @FXML
    private ImageView Back3;

    @FXML
    private ImageView Back4;

    @FXML
    private ImageView Back5;

    @FXML
    private ImageView Back6;

    @FXML
    private ImageView Back7;

    @FXML
    private ImageView Back8;

    @FXML
    private JFXButton NextButton;

    @FXML
    private JFXButton MainMenu;

    @FXML
    void BackAction(ActionEvent event) {

    }


    @FXML
    void loadCard1(MouseEvent event) {
       mapper.setBackIndex(1);
    }

    @FXML
    void loadCard2(MouseEvent event) {
        mapper.setBackIndex(2);
    }

    @FXML
    void loadCard3(MouseEvent event) {
        mapper.setBackIndex(3);
    }

    @FXML
    void loadCard4(MouseEvent event) {
        mapper.setBackIndex(4);
    }

    @FXML
    void loadCard5(MouseEvent event) {
        mapper.setBackIndex(5);
    }

    @FXML
    void loadCard6(MouseEvent event) {
        mapper.setBackIndex(6);
    }

    @FXML
    void loadCard7(MouseEvent event) {
        mapper.setBackIndex(7);
    }

    @FXML
    void loadCard8(MouseEvent event) {
        mapper.setBackIndex(8);
    }



    @FXML
    void nextAction(ActionEvent event) {

    }


    @FXML
    void searchAction(ActionEvent event) {

    }

    @FXML
    void backAction(ActionEvent event) throws Exception {
        ScreenController.activatePreviousScreen();
    }

    @FXML
    void mainMenuAction(ActionEvent event) throws Exception {
        ScreenController.activate("MainMenu");
    }


    @FXML
    void quitAction(ActionEvent event) throws Exception {

        mapper.addRequest(Mapper.RequestType.End_Program);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapper=Mapper.getInstance();
    }
}

/*public class CardBackController implements Initializable{

    private Mapper mapper;
    private Drawer drawer;

    @FXML
    private AnchorPane MainAnchorPane;

    @FXML
    private Pane MainPane;

    @FXML
    private ImageView CollectionImage;

    @FXML
    private JFXTextField SearchBar;

    @FXML
    private Label HeroTypeLabel;

    @FXML
    private JFXButton BackButton;

    @FXML
    private JFXButton QuitButton;

    @FXML
    private JFXButton Mana0;

    @FXML
    private JFXButton Mana1;

    @FXML
    private JFXButton Mana2;

    @FXML
    private JFXButton Mana4;

    @FXML
    private JFXButton Mana5;

    @FXML
    private JFXButton Mana6;

    @FXML
    private JFXButton Mana7;

    @FXML
    private ImageView Back1;

    @FXML
    private ImageView Back2;

    @FXML
    private ImageView Back3;

    @FXML
    private ImageView Back4;

    @FXML
    private ImageView Back5;

    @FXML
    private ImageView Back6;

    @FXML
    private ImageView Back7;

    @FXML
    private ImageView Back8;

    @FXML
    private JFXButton NextButton;

    @FXML
    private JFXButton MainMenu;

    @FXML
    void BackAction(ActionEvent event) throws IOException {
        ScreenController.activatePreviousScreen();
    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
        ScreenController.activatePreviousScreen();
    }

    @FXML
    void loadCard1(MouseEvent event) {

    }

    @FXML
    void loadCard2(MouseEvent event) {

    }

    @FXML
    void loadCard3(MouseEvent event) {

    }

    @FXML
    void loadCard4(MouseEvent event) {

    }

    @FXML
    void loadCard5(MouseEvent event) {

    }

    @FXML
    void loadCard6(MouseEvent event) {

    }

    @FXML
    void loadCard7(MouseEvent event) {

    }

    @FXML
    void loadCard8(MouseEvent event) {

    }

    @FXML
    void mainMenuAction(ActionEvent event) throws IOException {
       ScreenController.activate("MainMenu");
    }

    @FXML
    void nextAction(ActionEvent event) {

    }


    public void loadCollectionCards() throws Exception {


        try {


            for (int counter=1;counter<9;counter++) {

                String name="back"+counter;
                name= CardPaths.getPathByName(name);
                switch (counter) {
                    case 1: {
                        setCardsImage(name,  Back1);
                        break;

                    }
                    case 2: {
                        setCardsImage(name,  Back2);
                        break;

                    }
                    case 3: {
                        setCardsImage(name,  Back3);
                        break;


                    }
                    case 4: {
                        setCardsImage(name,  Back4);
                        break;

                    }
                    case 5: {
                        setCardsImage(name,  Back5);
                        break;

                    }
                    case 6: {
                        setCardsImage(name,  Back6);
                        break;

                    }
                    case 7: {
                        setCardsImage(name,  Back7);
                        break;

                    }
                    case 8: {
                        setCardsImage(name, Back8);
                        break;

                    }
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setCardsImage(String name,ImageView card1) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(name);
        Image image = new Image(input);
        card1.setImage(image);

    }


    public void resetImageViews(){

        Back1.setImage(null);
        Back2.setImage(null);
        Back3.setImage(null);
        Back4.setImage(null);
        Back5.setImage(null);
        Back6.setImage(null);
        Back7.setImage(null);
        Back8.setImage(null);

    }

    @FXML
    void quitAction(ActionEvent event) throws Exception {

        mapper.addRequest(Mapper.RequestType.End_Program);

    }

    @FXML
    void searchAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resetImageViews();
        try {
            loadCollectionCards();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mapper=Mapper.getInstance();
        try {
            mapper.addRequest(Mapper.RequestType.Collection_Set_Main_Images);
        } catch (Exception e) {
            e.printStackTrace();
        }
        drawer=new Drawer("Collection");
        try {
           // drawer.drawCollection(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void update(){
        //System.out.println(mapper.getSpecifiedDecksIndex()+" check");
        try {
            ScreenController.activate();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}*/