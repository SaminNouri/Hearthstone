package graphics;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
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
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;

public class CompleteDeckController implements Initializable {
    private Mapper mapper;
    private Drawer drawer;
    private ArrayList<JFXRadioButton> groupDecksCards;
    private static LoggerCreator myLogger;

    public static void setMyLogger(LoggerCreator myLogger) {
        CompleteDeckController.myLogger = myLogger;
    }

    @FXML
    private JFXTextField SearchBar;

    @FXML
    private JFXComboBox<String> FilterComboBox;

    @FXML
    private Label HeroTypeLabel;

    @FXML
    private JFXButton QuitButton;

    @FXML
    private JFXButton NextButton;


    @FXML
    private JFXButton PreviousButton;

    @FXML
    private JFXButton Mana0;

    @FXML
    private JFXButton Mana1;

    @FXML
    private JFXButton Mana2;

    @FXML
    private JFXButton Mana3;

    @FXML
    private JFXButton Mana4;

    @FXML
    private JFXButton Mana5;

    @FXML
    private JFXButton Mana6;

    @FXML
    private JFXButton Mana7;

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
    private JFXRadioButton Card7Deck;

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
    private ImageView HeroImage;

    @FXML
    private JFXButton SubmitButton;

    @FXML
    private JFXComboBox<String> ChooseHeroComboBox;

    @FXML
    private JFXButton BackButton;

    @FXML
    private ImageView SubmitMana;

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
    private JFXRadioButton AddRatioBtn1;

    @FXML
    private JFXRadioButton AddRatioBtn2;

    @FXML
    private JFXRadioButton AddRatioBtn3;

    @FXML
    private JFXRadioButton AddRatioBtn4;

    @FXML
    private JFXRadioButton AddRatioBtn5;

    @FXML
    private JFXRadioButton AddRatioBtn6;

    @FXML
    private JFXRadioButton AddRatioBtn7;

    @FXML
    private JFXRadioButton AddRatioBtn8;

    @FXML
    private JFXButton AddButton;

    @FXML
    private JFXTextField SearchBar1;

    @FXML
    private JFXButton MainMenu;



    @FXML
    private  void addAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"AddButton");
        ArrayList<Integer> list=new ArrayList<Integer>();

        if(AddRatioBtn1.isSelected())
            list.add(0);
        if(AddRatioBtn2.isSelected())
            list.add(1);
        if(AddRatioBtn3.isSelected())
            list.add(2);
        if(AddRatioBtn4.isSelected())
            list.add(3);
        if(AddRatioBtn5.isSelected())
            list.add(4);
        if(AddRatioBtn6.isSelected())
            list.add(5);
        if(AddRatioBtn7.isSelected())
            list.add(6);
        if(AddRatioBtn8.isSelected())
            list.add(7);
        mapper.setAddedCardsToSpecifiedDeck(list);
        mapper.addRequest(Mapper.RequestType.CompleteDeck_AddCards);
        update();




    }



   void resetAddedRatioButtons(){
        AddRatioBtn1.setSelected(false);
        AddRatioBtn2.setSelected(false);
        AddRatioBtn3.setSelected(false);
        AddRatioBtn4.setSelected(false);
        AddRatioBtn5.setSelected(false);
        AddRatioBtn6.setSelected(false);
        AddRatioBtn7.setSelected(false);
        AddRatioBtn8.setSelected(false);

    }









    @FXML
    void addCard1(ActionEvent event) {

    }

    @FXML
    void addCard2(ActionEvent event) {

    }

    @FXML
    void addCard3(ActionEvent event) {

    }

    @FXML
    void addCard4(ActionEvent event) {

    }

    @FXML
    void addCard5(ActionEvent event) {

    }

    @FXML
    void addCard6(ActionEvent event) {

    }

    @FXML
    void addCard7(ActionEvent event) {

    }

    @FXML
    void addCard8(ActionEvent event) {

    }

    @FXML
    void backAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"BackButton");
        ScreenController.activatePreviousScreen();

    }

    @FXML
    void chooseHero(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"ChooseHeroComboBox");
        String value =ChooseHeroComboBox.getValue();
        mapper.setSpecifiedDecksHerotype(value);
        mapper.addRequest(Mapper.RequestType.CompleteDeck_SpecifiedDecksHero);

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
    void getDecksName(ActionEvent event) {

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

    @FXML
    void loadCard1(MouseEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"loadCard1");
        try {
            mapper.setBoldImageIndex(0);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();

        }catch(Exception e){}

    }

    @FXML
    void loadCard2(MouseEvent event) {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"loadCard2");
        try {
            mapper.setBoldImageIndex(1);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();
        }catch(Exception e){}

    }

    @FXML
    void loadCard3(MouseEvent event) {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"loadCard3");
        try {
            mapper.setBoldImageIndex(2);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();
        }catch(Exception e){}
    }

    @FXML
    void loadCard4(MouseEvent event) {
        try {
            myLogger.logger.log(Level.INFO,"buttonClicked:"+"loadCard4");
            mapper.setBoldImageIndex(3);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();
        }catch(Exception e){}

    }

    @FXML
    void loadCard5(MouseEvent event) {
        try {
            myLogger.logger.log(Level.INFO,"buttonClicked:"+"loadCard5");
            mapper.setBoldImageIndex(4);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();
        }catch(Exception e){}

    }

    @FXML
    void loadCard6(MouseEvent event) {
        try {
            myLogger.logger.log(Level.INFO,"buttonClicked:"+"loadCard6");
            mapper.setBoldImageIndex(5);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();
        }catch(Exception e){}

    }

    @FXML
    void loadCard7(MouseEvent event) {
        try {
            myLogger.logger.log(Level.INFO,"buttonClicked:"+"loadCard7");
            mapper.setBoldImageIndex(6);
            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();
        }catch(Exception e){}

    }

    @FXML
    void loadCard8(MouseEvent event) {
        try {
            myLogger.logger.log(Level.INFO,"buttonClicked:"+"loadCard8");
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
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"NextButton");
        mapper.addRequest(Mapper.RequestType.Collecction_Next);
        update();


    }


    @FXML
    void searchAction(ActionEvent event) {

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

    @FXML
    void submitAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"SubmitAndRemove");
        Boolean[] booleans=new Boolean[30];
        String decksName=DecksNameTextField.getText();
        int counter=0;
        for(JFXRadioButton btn:groupDecksCards){
            booleans[counter]=btn.isSelected();
            counter++;

        }
        mapper.setSpecifiedDecksNewName(decksName);
        mapper.setSpecifiedRemovedBooleans(booleans);
        mapper.addRequest(Mapper.RequestType.CompleteDeck_Submit);
        resetCardsDeck();
        update();



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        mapper=Mapper.getInstance();
        resetImageViews();
        try {
            mapper.addRequest(Mapper.RequestType.Collection_Set_Main_Images);
        } catch (Exception e) {
            e.printStackTrace();
        }
        drawer=new Drawer("CompleteDeck");
        try {
            drawer.drawCompleteDeck(this);
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
     void setChooseHeroComboBox(ArrayList<String> heroes, HeroType heroType){

        ObservableList<String> oListStavaka = FXCollections.observableArrayList(heroes);
        ChooseHeroComboBox.setItems(oListStavaka);
        ChooseHeroComboBox.setValue(heroType.toString());


    }

    private void loadCard(int num) throws Exception {
        try {

            mapper.addRequest(Mapper.RequestType.Load_BoldImage);
            update();

        }catch (Exception e){
            e.printStackTrace();
        }

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





    void loadCollectionCards(ArrayList<String> imagesAddresses, ArrayList<Boolean> ownedImagesList, String pagesHerotype) throws Exception {


        try {


            HeroTypeLabel.setText(pagesHerotype);
            int counter = 0;
            for (String name : imagesAddresses) {
                counter++;
                switch (counter) {
                    case 1: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card1);
                        AddRatioBtn1.setVisible(true);
                        break;

                    }
                    case 2: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card2);
                        AddRatioBtn2.setVisible(true);
                        break;

                    }
                    case 3: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card3);
                        AddRatioBtn3.setVisible(true);
                        break;


                    }
                    case 4: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card4);
                        AddRatioBtn4.setVisible(true);
                        break;

                    }
                    case 5: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card5);
                        AddRatioBtn5.setVisible(true);
                        break;

                    }
                    case 6: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card6);
                        AddRatioBtn6.setVisible(true);
                        break;

                    }
                    case 7: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card7);
                        AddRatioBtn7.setVisible(true);
                        break;

                    }
                    case 8: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card8);
                       AddRatioBtn8.setVisible(true);
                        break;

                    }
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @FXML
    void quitAction(ActionEvent event) throws Exception {

        mapper.addRequest(Mapper.RequestType.End_Program);

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



    @FXML
    void submitMana(MouseEvent event){
        System.out.println(
                "i understand"
        );

        myLogger.logger.log(Level.INFO,"buttonClicked:"+"SubmitButton");
        if(SearchBar1.getText()!=null)
        {
            try{
                int mana=Integer.valueOf(SearchBar1.getText());
                mapper.setSearchMana(mana);
                mapper.addRequest(Mapper.RequestType.Collection_Set_ManaBased_Images);
                update();


            }catch (Exception e){return;}
        }
    }

    @FXML
    void removeAction(ActionEvent event) throws Exception {
        Boolean[] booleans=new Boolean[16];


        for(int i=0;i<16;i++){
            Boolean b=booleans[i];
            if(b) {
                mapper.setDecksIndex(i);
                mapper.addRequest(Mapper.RequestType.Collection_RemoveDeck);
                update();
            }
        }


    }
     void setRatioButtonsInvisible(){
        AddRatioBtn1.setVisible(false);
        AddRatioBtn2.setVisible(false);
        AddRatioBtn3.setVisible(false);
        AddRatioBtn4.setVisible(false);
        AddRatioBtn5.setVisible(false);
        AddRatioBtn6.setVisible(false);
        AddRatioBtn7.setVisible(false);
        AddRatioBtn8.setVisible(false);
    }



}