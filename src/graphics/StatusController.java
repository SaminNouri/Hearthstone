package graphics;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import game.LoggerCreator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;

/**
 * Created by Data on 4/27/2020.
 */
public class StatusController implements Initializable {
    private Drawer drawer;
    private static Mapper mapper;
    private static LoggerCreator myLogger;

    public static void setMyLogger(LoggerCreator myLogger) {
        StatusController.myLogger = myLogger;
    }

    public Drawer getDrawer() {
        return drawer;
    }

    public void setDrawer(Drawer drawer) {
        this.drawer = drawer;
    }


    public ImageView getCard6() {
        return Card6;
    }

    public ImageView getCard8() {
        return Card8;
    }

    public void setCard8(ImageView card8) {
        Card8 = card8;
    }

    public ImageView getCard7() {
        return Card7;
    }

    public void setCard7(ImageView card7) {
        Card7 = card7;
    }

    public void setCard6(ImageView card6) {
        Card6 = card6;
    }

    public ImageView getCard2() {
        return Card2;
    }

    public ImageView getCard3() {
        return Card3;
    }

    public ImageView getCard5() {
        return Card5;
    }

    public void setCard5(ImageView card5) {
        Card5 = card5;
    }

    public ImageView getCard4() {
        return Card4;
    }

    public void setCard4(ImageView card4) {
        Card4 = card4;
    }

    public void setCard3(ImageView card3) {
        Card3 = card3;
    }

    public void setCard2(ImageView card2) {
        Card2 = card2;
    }


    @FXML
    private JFXButton PreviousButton;

    @FXML
    private AnchorPane MainAnchorPane;

    @FXML
    private Pane MainPane;


    @FXML
    private ImageView CollectionImage;

    @FXML
    private JFXTextField SearchBar;

    @FXML
    private JFXComboBox<String> FilterComboBox;

    @FXML
    private Label HeroTypeLabel;


    @FXML
    private JFXButton QuitButton;

    @FXML
    private JFXButton Mana0;

    @FXML
    private JFXButton Mana1;

    @FXML
    private JFXButton Mana3;

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
    private ScrollPane MainScrollPane;

    @FXML
    private Pane SubPane;

    @FXML
    private ImageView ScrollDeckImage;

    @FXML
    private JFXButton BackButton;

    @FXML
    private JFXButton Deck_1_Button;

    @FXML
    private JFXButton Deck_2_Button;

    @FXML
    private JFXButton Deck_3_Button;

    @FXML
    private JFXButton Deck_4_Button;

    @FXML
    private JFXButton Deck_5_Button;

    @FXML
    private JFXButton Deck_6_Button;

    @FXML
    private JFXButton Deck_7_Button;

    @FXML
    private JFXButton Deck_8_Button;

    @FXML
    private JFXButton Deck_9_Button;

    @FXML
    private JFXButton Deck_10_Button;

    @FXML
    private JFXButton Deck_11_Button;

    @FXML
    private JFXButton Deck_12_Button;

    @FXML
    private JFXButton Deck_13_Button;

    @FXML
    private JFXButton Deck_14_Button;

    @FXML
    private JFXButton Deck_15_Button;

    @FXML
    private JFXButton Deck_16_Button;

    @FXML
    private JFXRadioButton Deck_1_RatioButton;

    @FXML
    private JFXRadioButton Deck_2_RatioButton;

    @FXML
    private JFXRadioButton Deck_3_RatioButton;

    @FXML
    private JFXRadioButton Deck_4_RatioButton;

    @FXML
    private JFXRadioButton Deck_5_RatioButton;

    @FXML
    private JFXRadioButton Deck_6_RatioButton;

    @FXML
    private JFXRadioButton Deck_7_RatioButton;

    @FXML
    private JFXRadioButton Deck_8_RatioButton;

    @FXML
    private JFXRadioButton Deck_9_RatioButton;

    @FXML
    private JFXRadioButton Deck_10_RatioButton;

    @FXML
    private JFXRadioButton Deck_11_RatioButton;

    @FXML
    private JFXRadioButton Deck_12_RatioButton;

    @FXML
    private JFXRadioButton Deck_13_RatioButton;

    @FXML
    private JFXRadioButton Deck_14_RatioButton;

    @FXML
    private JFXRadioButton Deck_15_RatioButton;

    @FXML
    private JFXRadioButton Deck_16_RatioButton;

    @FXML
    private JFXButton RemoveButton;

    @FXML
    private ImageView Card1;

    @FXML
    private ImageView Card2;

    @FXML
    private ImageView Card3;

    @FXML
    private ImageView Card4;

    @FXML
    private ImageView Card5;

    @FXML
    private ImageView Card6;

    @FXML
    private ImageView Card7;

    @FXML
    private ImageView Card8;

    @FXML
    private ImageView ManaImage;

    @FXML
    private ImageView SearchMana;

    @FXML
    private JFXButton NextButton;

    @FXML
    private JFXButton MainMenu;

    @FXML
    private JFXTextField ManaTextField;

    @FXML
    void BackAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"BackButton");
        ScreenController.activatePreviousScreen();

    }





    @FXML
    void Mana7Action(ActionEvent event) {

    }

    @FXML
    void deck_10_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck10");
        mapper.setSpecifiedDecksIndex(9);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();

    }
    @FXML
    void manaAction(MouseEvent event) {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"SubmitMana");
        if(ManaTextField.getText()!=null)
        {
            try{
                int mana=Integer.valueOf(ManaTextField.getText());
                mapper.setSearchMana(mana);
                mapper.addRequest(Mapper.RequestType.Collection_Set_ManaBased_Images);
                update();


            }catch (Exception e){return;}
        }
    }


    @FXML
    void submitSearch(MouseEvent event) {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"SubmitSearch");
        if(SearchBar.getText()!=null)
        {
            try{
                String search=(SearchBar.getText());
                mapper.setSearchString(search);
                mapper.addRequest(Mapper.RequestType.Collection_Search);
                update();

            }catch (Exception e){return;}
        }
    }

    private void loadCardWithSearch(String search) {


    }

    public ImageView getCard1() {
        return Card1;
    }

    public void setCard1(ImageView card1) {
        Card1 = card1;
    }


    @FXML
    void deck_10_RemoveAction(ActionEvent event) {

    }

    @FXML
    void deck_11_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck11");
        mapper.setSpecifiedDecksIndex(10);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();

    }

    @FXML
    void deck_11_RemoveAction(ActionEvent event) {

    }

    @FXML
    void deck_12_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck12");
        mapper.setSpecifiedDecksIndex(11);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();

    }

    @FXML
    void deck_12_RemoveAction(ActionEvent event) {

    }

    @FXML
    void deck_13_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck13");
        mapper.setSpecifiedDecksIndex(12);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();

    }

    @FXML
    void deck_13_RemoveAction(ActionEvent event) {

    }

    @FXML
    void deck_14_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck14");
        mapper.setSpecifiedDecksIndex(13);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();

    }

    @FXML
    void deck_14_RemoveAction(ActionEvent event) {

    }

    @FXML
    void deck_15_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck15");
        mapper.setSpecifiedDecksIndex(14);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();;

    }

    @FXML
    void deck_15_RemoveAction(ActionEvent event) {

    }

    @FXML
    void deck_16_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck16");
        mapper.setSpecifiedDecksIndex(15);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();

    }

    @FXML
    void deck_16_RemoveAction(ActionEvent event) {

    }

    @FXML
    void deck_1_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck1");
        mapper.setSpecifiedDecksIndex(0);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();

    }

    @FXML
    void deck_1_RemoveAction(ActionEvent event) {

    }

    @FXML
    void deck_2_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck2");
        mapper.setSpecifiedDecksIndex(1);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();

    }

    @FXML
    void deck_2_RemoveAction(ActionEvent event) {

    }

    @FXML
    void deck_3_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck3");
        mapper.setSpecifiedDecksIndex(2);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();

    }

    @FXML
    void deck_3_RemoveAction(ActionEvent event) {

    }

    @FXML
    void deck_4_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck4");
        mapper.setSpecifiedDecksIndex(3);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();

    }

    @FXML
    void deck_4_RemoveAction(ActionEvent event) throws Exception {


    }

    @FXML
    void deck_5_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck5");
        mapper.setSpecifiedDecksIndex(4);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();

    }

    @FXML
    void deck_5_RemoveAction(ActionEvent event) {

    }

    @FXML
    void deck_6_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck6");
        mapper.setSpecifiedDecksIndex(5);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();

    }

    @FXML
    void deck_6_RemoveAction(ActionEvent event) {

    }

    @FXML
    void deck_7_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck7");
        mapper.setSpecifiedDecksIndex(6);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();

    }

    @FXML
    void deck_7_RemoveAction(ActionEvent event) {

    }

    @FXML
    void deck_8_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck8");
        mapper.setSpecifiedDecksIndex(7);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();

    }

    @FXML
    void deck_8_RemoveAction(ActionEvent event) {

    }

    @FXML
    void deck_9_Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Deck9");
        mapper.setSpecifiedDecksIndex(8);
        mapper.addRequest(Mapper.RequestType.Load_CompleteStatus);
        update();

    }


    @FXML
    void backAction(ActionEvent event) throws Exception {

        ScreenController.activatePreviousScreen();

    }

    @FXML
    void deck_9_RemoveAction(ActionEvent event) {

    }

    @FXML
    void filterAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"FilterComboBox");
        String value=(FilterComboBox.getValue());
        if (value.equals("owned cards")) {
            mapper.addRequest(Mapper.RequestType.Collection_Set_Owned_Images);
            update();
        } else if (value.equals("unowned cards")) {
            mapper.addRequest(Mapper.RequestType.Collection_Set_Unowned_Images);
            update();
        } else if (value.equals("all cards")) {
            mapper.addRequest(Mapper.RequestType.Collection_Set_All_Images);
            update();
        }

    }


    @FXML
    void loadCard1(MouseEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Card1");
        try {
            mapper.setBoldImageIndex(0);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();

        }catch(Exception e){}

    }

    @FXML
    void loadCard2(MouseEvent event) {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Card2");
        try {
            mapper.setBoldImageIndex(1);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();
        }catch(Exception e){}

    }

    @FXML
    void loadCard3(MouseEvent event) {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Card3");
        try {
            mapper.setBoldImageIndex(2);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();
        }catch(Exception e){}
    }

    @FXML
    void loadCard4(MouseEvent event) {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Card4");
        try {
            mapper.setBoldImageIndex(3);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();
        }catch(Exception e){}

    }

    @FXML
    void loadCard5(MouseEvent event) {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Card5");
        try {
            mapper.setBoldImageIndex(4);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();
        }catch(Exception e){}

    }

    @FXML
    void loadCard6(MouseEvent event) {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Card6");
        try {
            mapper.setBoldImageIndex(5);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();
        }catch(Exception e){}

    }

    @FXML
    void loadCard7(MouseEvent event) {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Card7");
        try {
            mapper.setBoldImageIndex(6);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();
        }catch(Exception e){}

    }

    @FXML
    void loadCard8(MouseEvent event) {
            myLogger.logger.log(Level.INFO,"buttonClicked:"+"Card8");
        try {
            mapper.setBoldImageIndex(7);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();
        }catch(Exception e){}

    }

    @FXML
    void mainMenuAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"MainMenu");
        mapper.addRequest(Mapper.RequestType.Load_MainMenu);
        update();

    }

    @FXML
    void mana0Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Mana0");
        mapper.setSearchMana(0);
        mapper.addRequest(Mapper.RequestType.Collection_Set_ManaBased_Images);
        update();

    }

    @FXML
    void mana1Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Mana1");
        mapper.setSearchMana(1);
        mapper.addRequest(Mapper.RequestType.Collection_Set_ManaBased_Images);
        update();
    }

    @FXML
    void mana2Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Mana2");
        mapper.setSearchMana(2);
        mapper.addRequest(Mapper.RequestType.Collection_Set_ManaBased_Images);
        update();
    }

    @FXML
    void mana3Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Mana3");
        mapper.setSearchMana(3);
        mapper.addRequest(Mapper.RequestType.Collection_Set_ManaBased_Images);
        update();
    }

    @FXML
    void mana4Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Mana4");
        mapper.setSearchMana(4);
        mapper.addRequest(Mapper.RequestType.Collection_Set_ManaBased_Images);
        update();
    }

    @FXML
    void mana5Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Mana5");
        mapper.setSearchMana(5);
        mapper.addRequest(Mapper.RequestType.Collection_Set_ManaBased_Images);
        update();
    }

    @FXML
    void mana6Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Mana6");
        mapper.setSearchMana(6);
        mapper.addRequest(Mapper.RequestType.Collection_Set_ManaBased_Images);
        update();
    }
    @FXML
    void mana7Action(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Mana7");
        mapper.setSearchMana(7);
        mapper.addRequest(Mapper.RequestType.Collection_Set_ManaBased_Images);
        update();
    }

    @FXML
    void previousAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Previous");
        mapper.addRequest(Mapper.RequestType.Collecction_Previous);
        update();

    }


    @FXML
    void nextAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Next");
        mapper.addRequest(Mapper.RequestType.Collecction_Next);
        update();


    }


    @FXML
    void quitAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"QuitAction");
        mapper.addRequest(Mapper.RequestType.End_Program);

    }

    @FXML
    void removeAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"RemoveButton");
        Boolean[] booleans=new Boolean[16];

        booleans[0]=Deck_1_RatioButton.isSelected();
        booleans[1]=Deck_2_RatioButton.isSelected();
        booleans[2]=Deck_3_RatioButton.isSelected();
        booleans[3]=Deck_4_RatioButton.isSelected();
        booleans[4]=Deck_5_RatioButton.isSelected();
        booleans[5]=Deck_6_RatioButton.isSelected();
        booleans[6]=Deck_7_RatioButton.isSelected();
        booleans[7]=Deck_8_RatioButton.isSelected();
        booleans[8]=Deck_9_RatioButton.isSelected();
        booleans[9]=Deck_10_RatioButton.isSelected();
        booleans[10]=Deck_11_RatioButton.isSelected();
        booleans[11]=Deck_12_RatioButton.isSelected();
        booleans[12]=Deck_13_RatioButton.isSelected();
        booleans[13]=Deck_14_RatioButton.isSelected();
        booleans[14]=Deck_15_RatioButton.isSelected();
        booleans[15]=Deck_16_RatioButton.isSelected();

        for(int i=0;i<16;i++){
            Boolean b=booleans[i];
            if(b) {
                mapper.setDecksIndex(i);
                mapper.addRequest(Mapper.RequestType.Collection_RemoveDeck);
                update();
            }
        }






    }

    private void resetRatioButtons(){
        Deck_1_RatioButton.setSelected(false);
        Deck_2_RatioButton.setSelected(false);
        Deck_3_RatioButton.setSelected(false);
        Deck_4_RatioButton.setSelected(false);
        Deck_5_RatioButton.setSelected(false);
        Deck_6_RatioButton.setSelected(false);
        Deck_7_RatioButton.setSelected(false);
        Deck_8_RatioButton.setSelected(false);
        Deck_9_RatioButton.setSelected(false);
        Deck_10_RatioButton.setSelected(false);
        Deck_11_RatioButton.setSelected(false);
        Deck_12_RatioButton.setSelected(false);
        Deck_13_RatioButton.setSelected(false);
        Deck_14_RatioButton.setSelected(false);
        Deck_15_RatioButton.setSelected(false);
        Deck_16_RatioButton.setSelected(false);

    }



     void resetImageViews(){

        Card1.setImage(null);
        Card2.setImage(null);
        Card3.setImage(null);
        Card4.setImage(null);
        Card5.setImage(null);
        Card6.setImage(null);
        Card7.setImage(null);
        Card8.setImage(null);

    }





     void loadCollectionCards(ArrayList<String> imagesAddresses,ArrayList<Boolean> ownedImagesList,String pagesHerotype) throws Exception {


        try {


            HeroTypeLabel.setText(pagesHerotype);
            int counter = 0;
            for (String name : imagesAddresses) {
                counter++;
                switch (counter) {
                    case 1: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card1);
                        break;

                    }
                    case 2: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card2);
                        break;

                    }
                    case 3: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card3);
                        break;


                    }
                    case 4: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card4);
                        break;

                    }
                    case 5: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card5);
                        break;

                    }
                    case 6: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card6);
                        break;

                    }
                    case 7: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card7);
                        break;

                    }
                    case 8: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card8);
                        break;

                    }
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


     void setCardsImage(String name,boolean flag,ImageView card1) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(name);
        Image image = new Image(input);
        ColorAdjust blackout = new ColorAdjust();
        if(flag)
            blackout.setBrightness(-0.4);
        card1.setEffect(blackout);
        card1.setImage(image);

    }





    void setFilter(){

        ObservableList<String> data = FXCollections.observableArrayList("owned cards", "unowned cards","all cards");
        FilterComboBox.setItems(data);


    }


     void setDecksNames(ArrayList<String> decksNames){
        Deck_1_Button.setText(decksNames.get(0));
        Deck_2_Button.setText(decksNames.get(1));
        Deck_3_Button.setText(decksNames.get(2));
        Deck_4_Button.setText(decksNames.get(3));
        Deck_5_Button.setText(decksNames.get(4));
        Deck_6_Button.setText(decksNames.get(5));
        Deck_7_Button.setText(decksNames.get(6));
        Deck_8_Button.setText(decksNames.get(7));
        Deck_9_Button.setText(decksNames.get(8));
        Deck_10_Button.setText(decksNames.get(9));
        Deck_11_Button.setText(decksNames.get(10));
        Deck_12_Button.setText(decksNames.get(11));
        Deck_13_Button.setText(decksNames.get(12));
        Deck_14_Button.setText(decksNames.get(13));
        Deck_15_Button.setText(decksNames.get(14));
        Deck_16_Button.setText(decksNames.get(15));

    }

    private void loadCard(int num) throws Exception {
        try {

            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();

        }catch (Exception e){
            e.printStackTrace();
        }

    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {

        mapper=Mapper.getInstance();
        resetImageViews();
        resetRatioButtons();
        try {
            mapper.addRequest(Mapper.RequestType.Collection_Set_Main_Images);
        } catch (Exception e) {
            e.printStackTrace();
        }
        drawer=new Drawer("Collection");
        try {
            drawer.drawStatus(this);
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
