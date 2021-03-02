package graphics;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import game.LoggerCreator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;

public class StoreController implements Initializable{
    private  Mapper mapper;
    private Drawer drawer;
    private static LoggerCreator myLogger;

    public static void setMyLogger(LoggerCreator myLogger) {
        StoreController.myLogger = myLogger;
    }

    @FXML
    private AnchorPane MainAnchorPane;

    @FXML
    private JFXTextField SearchBar;

    @FXML
    private JFXButton QuitButton;

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
    private JFXButton BackButton;

    @FXML
    private ImageView Card1;

    @FXML
    private JFXButton NextButton;

    @FXML
    private ImageView Card2;

    @FXML
    private ImageView Card3;

    @FXML
    private ImageView Card4;

    @FXML
    private JFXComboBox<String> SellComboBox;

    @FXML
    private JFXComboBox<String> BuyComboBox;

    @FXML
    private ImageView Card5;

    @FXML
    private ImageView Card6;

    @FXML
    private ImageView Card7;

    @FXML
    private ImageView Card8;

    @FXML
    private Label PriceLabel1;
    @FXML
    private Label HeroTypeLabel;

    @FXML
    private Label PriceLabel2;

    @FXML
    private Label PriceLabel3;

    @FXML
    private Label PriceLabel4;

    @FXML
    private Label PriceLabel5;

    @FXML
    private Label PriceLabel6;

    @FXML
    private Label PriceLabel7;

    @FXML
    private Label PriceLabel8;

    @FXML
    private Label PriceCard1;

    @FXML
    private Label PriceCard2;

    @FXML
    private Label PriceCard3;

    @FXML
    private Label PriceCard4;

    @FXML
    private Label PriceCard5;

    @FXML
    private Label PriceCard6;

    @FXML
    private Label PriceCard7;

    @FXML
    private Label PriceCard8;

    @FXML
    private JFXButton SellButton;

    @FXML
    private JFXButton BuyButton;

    @FXML
    private Label WalletLabel;

    @FXML
    private Label CoinLabel;

    @FXML
    private JFXButton MainMenu;

    @FXML
    private JFXButton PreviousButton;

    @FXML
    private JFXTextField ManaTextField;

    @FXML
    private JFXComboBox<String> FilterComboBox;

    @FXML
    private ImageView ManaImage;

    @FXML
    private ImageView SearchMana;

    @FXML
    void backAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"BackButton");
        ScreenController.activatePreviousScreen();

    }

    @FXML
    void buyBoxAction(ActionEvent event) {

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

     void setFilter(){

        ObservableList<String> data = FXCollections.observableArrayList("owned cards", "unowned cards","all cards");
        FilterComboBox.setItems(data);


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
    void quitAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"QuitButton");
            mapper.addRequest(Mapper.RequestType.End_Program);

    }

    @FXML
    void searchAction(ActionEvent event) {

    }

    @FXML
    void sellBoxAction(ActionEvent event) {

    }

    @FXML
    void submitBuy(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Buy");
        String value=BuyComboBox.getValue();
        mapper.setBoughtCard(value);
        mapper.addRequest(Mapper.RequestType.Store_Buy);
        update();

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
    void submitSell(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"Sell");
        String value=SellComboBox.getValue();
        mapper.setSoldCard(value);
        mapper.addRequest(Mapper.RequestType.Store_Sell);
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
        drawer=new Drawer("Store");
        try {
            drawer.drawStore(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
   void update(){
        try {
            ScreenController.activate();
            drawer.drawStore(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
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
    void setSellComboBox(ArrayList<String> options){
        ObservableList<String> oListStavaka = FXCollections.observableArrayList(options);
        SellComboBox.setItems(oListStavaka);

    }

     void setBuyComboBox(ArrayList<String> options){
        ObservableList<String> oListStavaka = FXCollections.observableArrayList(options);
        BuyComboBox.setItems(oListStavaka);

    }

     void setCoinLabel(int coin){
        CoinLabel.setText(String.valueOf(coin));

    }





     void loadCollectionCards(ArrayList<String> imagesAddresses, ArrayList<Boolean> ownedImagesList,ArrayList<String> prices, String pagesHerotype) throws Exception {


        try {


            HeroTypeLabel.setText(pagesHerotype);
            int counter = 0;
            for (String name : imagesAddresses) {
                counter++;
                switch (counter) {
                    case 1: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card1);
                        PriceLabel1.setText("price");
                        PriceCard1.setText(prices.get(counter-1));
                        break;

                    }
                    case 2: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card2);
                        PriceLabel2.setText("price");
                        PriceCard2.setText(prices.get(counter-1));
                        break;

                    }
                    case 3: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card3);
                        PriceLabel3.setText("price");
                        PriceCard3.setText(prices.get(counter-1));
                        break;


                    }
                    case 4: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card4);
                        PriceLabel4.setText("price");
                        PriceCard4.setText(prices.get(counter-1));
                        break;

                    }
                    case 5: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card5);
                        PriceLabel5.setText("price");
                        PriceCard5.setText(prices.get(counter-1));
                        break;

                    }
                    case 6: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card6);
                        PriceLabel6.setText("price");
                        PriceCard6.setText(prices.get(counter-1));
                        break;

                    }
                    case 7: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card7);
                        PriceLabel7.setText("price");
                        PriceCard7.setText(prices.get(counter-1));
                        break;

                    }
                    case 8: {
                        setCardsImage(name, !ownedImagesList.get(counter-1), Card8);
                        PriceLabel8.setText("price");
                        PriceCard8.setText(prices.get(counter-1));
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
















}