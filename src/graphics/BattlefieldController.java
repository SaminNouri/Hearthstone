package graphics;

import com.jfoenix.controls.JFXButton;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import game.GameMapper;
import game.LoggerCreator;
import graphics.battlefield.Location;
import initialCard.card.Card;
import initialCard.card.HeroCard;
import initialCard.enumClasses.Type;
import initialSpell.spell.condition.ConditionHandler;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import org.omg.PortableServer.IMPLICIT_ACTIVATION_POLICY_ID;
import resources.PicturePaths;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.AnnotatedArrayType;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.w3c.dom.css.Counter;
import sun.awt.AWTAccessor;

public class BattlefieldController  implements Initializable{
    private Drawer drawer;
    private Mapper mapper;
    private GameMapper gameMapper;
    private double imageViewX=0;
    private double imageViewY=0;
    private double imageViewHeight=0;
    private double imageViewWidth=0;
    private ImageView[] historyImageView=new ImageView[60];
    private static LoggerCreator myLogger;
    private List<CardLocation> list=new ArrayList<CardLocation>();
    private ArrayList<Pane> HCardsPanels=new ArrayList<Pane>();
    private ArrayList<ImageView> HCardsImageViews=new ArrayList<ImageView>();
    private ArrayList<Pane> HGCardsPanels=new ArrayList<Pane>();
    private ArrayList<ImageView> ECardsImageViews=new ArrayList<ImageView>();
    private ArrayList<ImageView> HGCardsImageViews=new ArrayList<ImageView>();
    private ArrayList<AnchorPane> HGECardsPanels=new ArrayList<AnchorPane>();
    private final int playGroundsMinY=180;
    private final int playGroundsMaxY=400;
    private final int playGroundsMinX=100;
    private final int playGroundsMaxX=800;



    public static void setMyLogger(LoggerCreator myLogger) {
        BattlefieldController.myLogger = myLogger;
    }



    @FXML
    private AnchorPane MainAnchorPane1;

    @FXML
    private ImageView MainImage;

    @FXML
    private ImageView Mana1;

    @FXML
    private ImageView Mana2;

    @FXML
    private ImageView Mana3;

    @FXML
    private ImageView Mana4;

    @FXML
    private ImageView Weapon1;

    @FXML
    private ImageView Weapon2;

    @FXML
    private ImageView Mana5;

    @FXML
    private ImageView Mana6;

    @FXML
    private ImageView Mana7;

    @FXML
    private ImageView Mana8;

    @FXML
    private ImageView Mana9;

    @FXML
    private ImageView Mana10;

    @FXML
    private Label CurrentMana1;

    @FXML
    private Label CurrentMana2;

    @FXML
    private Label messagesLabel;

    @FXML
    private Label Attack2;

    @FXML
    private Label Attack1;

    @FXML
    private Label Durability2;

    @FXML
    private Label Durability1;

    @FXML
    private JFXButton EndTurnButton;

    @FXML
    private ImageView Hero1;

    @FXML
    private ImageView Hero2;

    @FXML
    private ImageView HeroPower2;

    @FXML
    private ImageView HeroPower1;

    @FXML
    private AnchorPane Pane11;

    @FXML
    private ImageView HCard11;

    @FXML
    private AnchorPane Pane9;

    @FXML
    private ImageView HCard9;

    @FXML
    private AnchorPane Pane7;

    @FXML
    private ImageView HCard7;

    @FXML
    private AnchorPane Pane12;

    @FXML
    private ImageView HCard12;

    @FXML
    private AnchorPane Pane10;

    @FXML
    private ImageView HCard10;

    @FXML
    private AnchorPane Pane8;

    @FXML
    private ImageView HCard8;

    @FXML
    private AnchorPane Pane6;

    @FXML
    private ImageView HCard6;

    @FXML
    private AnchorPane Pane5;

    @FXML
    private ImageView HCard5;

    @FXML
    private AnchorPane Pane4;

    @FXML
    private ImageView HCard4;

    @FXML
    private AnchorPane Pane3;

    @FXML
    private ImageView HCard3;

    @FXML
    private AnchorPane Pane2;

    @FXML
    private ImageView HCard2;

    @FXML
    private AnchorPane Pane1;

    @FXML
    private ImageView HCard1;

    @FXML
    private JFXButton QuitButton;

    @FXML
    private JFXButton BackAction;

    @FXML
    private JFXButton MainMenuButton;

    @FXML
    private ScrollPane MainScrollPane;

    @FXML
    private AnchorPane HistoryAnchorPane;

    @FXML
    private ImageView HistoryImage;

    @FXML
    private ImageView ECard12;

    @FXML
    private ImageView ECard10;

    @FXML
    private ImageView ECard8;

    @FXML
    private ImageView ECard6;

    @FXML
    private ImageView ECard4;

    @FXML
    private ImageView ECard11;

    @FXML
    private ImageView ECard9;

    @FXML
    private ImageView ECard7;

    @FXML
    private ImageView ECard5;

    @FXML
    private ImageView ECard3;

    @FXML
    private ImageView ECard2;

    @FXML
    private ImageView ECard1;

    @FXML
    private Label HLeftCards;

    @FXML
    private Label ELeftCards;

    @FXML
    private AnchorPane GPane1;

    @FXML
    private ImageView HGCard1;

    @FXML
    private AnchorPane GPane3;

    @FXML
    private ImageView HGCard3;

    @FXML
    private AnchorPane GPane2;

    @FXML
    private ImageView HGCard2;

    @FXML
    private AnchorPane GPane4;

    @FXML
    private ImageView HGCard4;

    @FXML
    private AnchorPane GPane6;

    @FXML
    private ImageView HGCard6;

    @FXML
    private AnchorPane GPane5;

    @FXML
    private ImageView HGCard5;

    @FXML
    private AnchorPane GPane7;

    @FXML
    private ImageView HGCard7;

    @FXML
    private Label Hp1;

    @FXML
    private Label Armor2;

    @FXML
    private Label Hp2;

    @FXML
    private Label Armor1;

    @FXML
    private AnchorPane EGPane7;

    @FXML
    private ImageView EGCard7;

    @FXML
    private AnchorPane LocationAnchorPane1;

    @FXML
    private AnchorPane EGPane5;

    @FXML
    private ImageView EGCard5;

    @FXML
    private AnchorPane EGPane2;

    @FXML
    private ImageView EGCard2;

    @FXML
    private AnchorPane EGPane1;

    @FXML
    private ImageView EHCard1;

    @FXML
    private AnchorPane EGPane3;

    @FXML
    private ImageView EGCard3;

    @FXML
    private AnchorPane EGPane4;

    @FXML
    private ImageView EGCard4;

    @FXML
    private AnchorPane EGPane6;

    @FXML
    private ImageView EGCard6;



    ///////////////////////////////////////////////////////////////////



    @FXML
    private ImageView EGCard1;



  /*  private void setNewLocation(double x,double y){
       if(mapper.getList()==null)
       {
           for(int i=0;i<12;i++){
               AnchorPane pane=HGCardsImageViews.get(i);
               list.add(new CardLocation(, , i))
           }
       }
    }


    @FXML
    void handleDragDropped(DragEvent event) {
          System.out.println("X:"+event.getSceneX());
            System.out.println("Y:"+event.getSceneY());
            System.out.println(TestPane.getLayoutX()+" "+TestPane.getLayoutY());
        try{
        Image img=event.getDragboard().getImage();
        HGCard1.setImage(img);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void handleDragOver(DragEvent event) {

            if(event.getDragboard().hasImage())
            event.acceptTransferModes(TransferMode.MOVE);

    }

       @FXML
    void handleDragDetected(MouseEvent event) {

           Dragboard db=HCard1.startDragAndDrop(TransferMode.MOVE);
           ClipboardContent cb=new ClipboardContent();
           cb.putImage(HCard1.getImage());
           db.setContent(cb);
           event.consume();

    }*/


   /* @FXML
    void bCard1(MouseEvent event) throws Exception {
        if(BCard1.isVisible())
        {
            //BCard1.setVisible(false);
            //BCard2.setVisible(false);
            //BCard3.setVisible(false);
        }
        gameMapper.setChosenPassive(0);
        gameMapper.addRequest(GameMapper.RequestType.Passives_were_Shown);
        myLogger.logger.log(Level.INFO,"ClickButton:Passive1");
        makePssiveTransition(BCard3);
        makePssiveTransition(BCard2);
        makePssiveTransition(BCard1);
        drawer.drawBattlefield(this);


    }*/
  /*  @FXML
    void bCard2(MouseEvent event) throws Exception {
        if(BCard2.isVisible())
        {
            //BCard1.setVisible(false);
            //BCard2.setVisible(false);
            //BCard3.setVisible(false);
        }
        gameMapper.setChosenPassive(1);
        gameMapper.addRequest(GameMapper.RequestType.Passives_were_Shown);
        myLogger.logger.log(Level.INFO,"ClickButton:Passive2");
        //gameMapper.addRequest(GameMapper.RequestType.EndTurn);
        // myLogger.logger.log(Level.INFO,"EndTurn");
        makePssiveTransition(BCard3);
        makePssiveTransition(BCard1);
        makePssiveTransition(BCard2);
        drawer.drawBattlefield(this);

    }

    public void setBCards(ArrayList<String> cards) throws Exception {
        try {
            String path = cards.get(0);
            FileInputStream fileInputStream = new FileInputStream(path);
            Image image = new Image(fileInputStream);
            BCard1.setImage(image);

            path = cards.get(1);
            fileInputStream = new FileInputStream(path);
            image = new Image(fileInputStream);
            BCard2.setImage(image);

            path = cards.get(2);
            fileInputStream = new FileInputStream(path);
            image = new Image(fileInputStream);
            BCard3.setImage(image);
        }catch (Exception e){}
        gameMapper.addRequest(GameMapper.RequestType.Passives_were_Shown);


    }
    @FXML
    void bCard3(MouseEvent event) throws Exception {
        if(BCard3.isVisible())
        {
            // BCard1.setVisible(false);
            //BCard2.setVisible(false);
            //BCard3.setVisible(false);
        }
        gameMapper.setChosenPassive(1);
        gameMapper.addRequest(GameMapper.RequestType.Passives_were_Shown);
        myLogger.logger.log(Level.INFO,"ClickButton:Passive3");
        makePssiveTransition(BCard1);
        makePssiveTransition(BCard2);
        makePssiveTransition(BCard3);
        drawer.drawBattlefield(this);
        // makePssiveTransition(BCard2);
        /// makePssiveTransition(BCard3);
        //gameMapper.addRequest(GameMapper.RequestType.EndTurn);
        // myLogger.logger.log(Level.INFO,"EndTurn");
        //update();
    }*/

    @FXML
    void endRurnAction(ActionEvent event) throws Exception {
        System.out.println("i notice!");
        gameMapper.addRequest(GameMapper.RequestType.EndTurn);
        myLogger.logger.log(Level.INFO,"EndTurn");
        update();
    }

    @FXML
    void mainMenuAction(ActionEvent event) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"MainMenu");
        ScreenController.activate("MainMenu");

    }

    @FXML
    void quitAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"QuitButton");
        mapper.addRequest(Mapper.RequestType.End_Program);

    }


    @FXML
    void releaseCard10(MouseEvent event) {

    }

    @FXML
    void releaseCard11(MouseEvent event) {

    }

    @FXML
    void releaseCard12(MouseEvent event) {

    }

    @FXML
    void releaseCard2(MouseEvent event) {

    }

    @FXML
    void releaseCard3(MouseEvent event) {

    }

    @FXML
    void releaseCard4(MouseEvent event) {

    }

    @FXML
    void releaseCard5(MouseEvent event) {

    }

    @FXML
    void releaseCard6(MouseEvent event) {

    }

    @FXML
    void releaseCard7(MouseEvent event) {

    }

    @FXML
    void releaseCard9(MouseEvent event) {

    }

    @FXML
    void releaseECard1(MouseEvent event) {

    }

    @FXML
    void releaseECard10(MouseEvent event) {

    }

    @FXML
    void releaseECard11(MouseEvent event) {

    }

    @FXML
    void releaseECard12(MouseEvent event) {

    }

    @FXML
    void releaseECard2(MouseEvent event) {

    }

    @FXML
    void releaseECard3(MouseEvent event) {

    }

    @FXML
    void releaseECard4(MouseEvent event) {

    }

    @FXML
    void releaseECard5(MouseEvent event) {

    }

    @FXML
    void releaseECard6(MouseEvent event) {

    }

    @FXML
    void releaseECard7(MouseEvent event) {

    }

    @FXML
    void releaseECard8(MouseEvent event) {

    }

    @FXML
    void releaseECard9(MouseEvent event) {

    }

    @FXML
    void releasrCard8(MouseEvent event) {

    }
    private void setDraggableHeroPower(){

        HeroPower1.setOnDragDetected(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
                GameMapper.setIsHeroPowerDragged(true);
                Dragboard db=HeroPower1.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent cb=new ClipboardContent();
                cb.putString(0+"");
                db.setContent(cb);
                t.consume();

            }

        });

    }



    private void setWeapons(){

        Weapon1.setOnDragDetected(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) {
                GameMapper.setWeaponDragged(true);
                Dragboard db=Weapon1.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent cb=new ClipboardContent();
                cb.putString(0+"");
                db.setContent(cb);
                t.consume();

            }

        });

    }

    private  void setHeroes(int attacker) {



        gameMapper.setAttacker(attacker);

        try {
            if(GameMapper.isWeaponDragged())
            {gameMapper.addRequest(GameMapper.RequestType.Weapon_Attacked_Hero_Event);
            update();}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    private Integer isAnAttackDrop(double x,double y){
        for(CardLocation cardLocation:GameMapper.getHGEnemyCardLocations())
        {

            if(x<=cardLocation.getX()+50 && x>=cardLocation.getX() && y>=200 && y<=300)
                return cardLocation.getCounter()-1;

        }
        return null;
    }

    void setAttackDrag(){
        for(Pane pane:HGCardsPanels) {
            pane.setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    Dragboard db = pane.startDragAndDrop(TransferMode.MOVE);
                    ClipboardContent cb = new ClipboardContent();
                    cb.putString(HGCardsPanels.indexOf(pane)+"");
                    db.setContent(cb);
                    t.consume();

                }
            });
        }

    }

    @FXML
    void backAction(ActionEvent event) throws Exception {
        myLogger.logger.log(Level.INFO,"buttonClicked:"+"BackButton");
        ScreenController.activatePreviousScreen();
        update();
    }





    private void setHCardsPanes(){
        HCardsPanels.add(Pane1);
        HCardsPanels.add(Pane2);
        HCardsPanels.add(Pane3);
        HCardsPanels.add(Pane4);
        HCardsPanels.add(Pane5);
        HCardsPanels.add(Pane6);
        HCardsPanels.add(Pane7);
        HCardsPanels.add(Pane8);
        HCardsPanels.add(Pane9);
        HCardsPanels.add(Pane10);
        HCardsPanels.add(Pane11);
        HCardsPanels.add(Pane12);


    }
    private void setHCardImageViews(){
        HCardsImageViews.add(HCard1);
        HCardsImageViews.add(HCard2);
        HCardsImageViews.add(HCard3);
        HCardsImageViews.add(HCard4);
        HCardsImageViews.add(HCard5);
        HCardsImageViews.add(HCard6);
        HCardsImageViews.add(HCard7);
        HCardsImageViews.add(HCard8);
        HCardsImageViews.add(HCard9);
        HCardsImageViews.add(HCard10);
        HCardsImageViews.add(HCard11);
        HCardsImageViews.add(HCard12);

    }

    private void setHGCardsPanes(){

        HGCardsPanels.add(GPane1);
        HGCardsPanels.add(GPane2);
        HGCardsPanels.add(GPane3);
        HGCardsPanels.add(GPane4);
        HGCardsPanels.add(GPane5);
        HGCardsPanels.add(GPane6);
        HGCardsPanels.add(GPane7);



    }
    private void setHGCardsImageViews(){

        HGCardsImageViews.add(HGCard1);
        HGCardsImageViews.add(HGCard2);
        HGCardsImageViews.add(HGCard3);
        HGCardsImageViews.add(HGCard4);
        HGCardsImageViews.add(HGCard5);
        HGCardsImageViews.add(HGCard6);
        HGCardsImageViews.add(HGCard7);




    }



    private void setECardsImageViews(){

        ECardsImageViews.add(ECard1);
        ECardsImageViews.add(ECard2);
        ECardsImageViews.add(ECard3);
        ECardsImageViews.add(ECard4);
        ECardsImageViews.add(ECard5);
        ECardsImageViews.add(ECard6);
        ECardsImageViews.add(ECard7);
        ECardsImageViews.add(ECard8);
        ECardsImageViews.add(ECard9);
        ECardsImageViews.add(ECard10);
        ECardsImageViews.add(ECard11);
        ECardsImageViews.add(ECard12);

    }

    public void  setHCards(ArrayList<Card> cards) throws FileNotFoundException, IOException {
        int counter=0;
        Collections.sort(GameMapper.getLocations());
        for(Card card:cards){
            Pane newPane;
            try {

                card.setCardLocation(GameMapper.getLocations().get(counter));
                CardImageCreatorController cd=new CardImageCreatorController();
                CardImageCreatorController.setCard(card);
                CardImageCreatorController.setIndex(counter);
                newPane = FXMLLoader.load(getClass().getResource("MainCard.fxml"));
                List<Node> parentChildren = ((Pane)HCardsPanels.get(counter).getParent()).getChildren();
                parentChildren.set(parentChildren.indexOf(HCardsPanels.get(counter)), newPane);

            } catch (IOException ex) {
                Logger.getLogger(BattlefieldController.class.getName()).log(Level.SEVERE, null, ex);
            }
            counter++;
        }
    }

    private void  setECardsImageViewsPictures() throws FileNotFoundException {
        int index=mapper.getBackIndex();

        String path= PicturePaths.getPathByName("back"+index);
        for(int counter=0;counter<ECardsImageViews.size();counter++){
            FileInputStream fileInputStream=new FileInputStream(path);
            Image image=new Image(fileInputStream);
            ECardsImageViews.get(counter).setImage(image);

        }
    }


    public void  setHGCards(ArrayList<Card> cards) throws Exception, IOException {
        synchronized (Color.RED) {
            int counter = 0;
            Collections.sort(GameMapper.gethGLocations());
            for (Card card : cards) {
                Pane newPane;
                try {
                    if(counter>=7)
                        return;
                    System.out.println("test:"+card.getName());
                    System.out.println("test:"+counter);
                    System.out.println("test:"+GameMapper.getHGEnemyCardLocations().get(counter));
                    card.setCardLocation(GameMapper.gethGLocations().get(counter));
                    CardImageCreatorController cd = new CardImageCreatorController();
                    CardImageCreatorController.setCard(card);
                    CardImageCreatorController.setIndex(counter);
                    System.out.println("counter:" + counter);
                    newPane = FXMLLoader.load(getClass().getResource("MainCard.fxml"));
                    List<Node> parentChildren = ((Pane) HGCardsPanels.get(counter).getParent()).getChildren();
                    parentChildren.set(parentChildren.indexOf(HGCardsPanels.get(counter)), newPane);

                } catch (IOException ex) {
                    Logger.getLogger(BattlefieldController.class.getName()).log(Level.SEVERE, null, ex);
                }
                counter++;
            }
        }
    }


    public void  setHGECards(ArrayList<Card> cards) throws Exception, IOException {

        int counter=0;
        Collections.sort(GameMapper.getHGEnemyCardLocations());
        for(Card card:cards){
            Pane newPane;
            try {
                System.out.println("testCounter:"+card.getName());
                System.out.println("testCounter:"+counter);
                System.out.println("testCounter:"+GameMapper.getHGEnemyCardLocations().get(counter));
                // System.out.println("mapper;"+(GameMapper.getInstance().gethGLocations().size())+":X:"+GameMapper.getInstance().gethGLocations().get(counter).getX());
                card.setCardLocation(GameMapper.getHGEnemyCardLocations().get(counter));
                CardImageCreatorController cd=new CardImageCreatorController();
                CardImageCreatorController.setCard(card);
                newPane = FXMLLoader.load(getClass().getResource("MainCard.fxml"));
                List<Node> parentChildren = ((Pane)HGECardsPanels.get(counter).getParent()).getChildren();
                parentChildren.set(parentChildren.indexOf(HGECardsPanels.get(counter)), newPane);

            } catch (IOException ex) {
                Logger.getLogger(BattlefieldController.class.getName()).log(Level.SEVERE, null, ex);
            }
            counter++;
        }
    }


   /* private void  resetHCardsImageViewsPictures() throws FileNotFoundException {

        for(int i=0;i<12;i++){
          HCardsPanels.get(i).getChildren().;
        }
    }*/

    /* private void  resetECardsImageViewsPictures() throws FileNotFoundException {

         for(int i=0;i<12;i++){
             ECardsImageViews.get(i).setImage(null);
         }
     }*/
    public void setHLedtCards(int num){
        HLeftCards.setText(String.valueOf(num));
    }

  /*  private void  resetHGCardsImageViewsPictures() throws FileNotFoundException {

            for(int i=0;i<7;i++){
                HGCardsImageViews.get(i).setImage(null);
            }

    }*/

    private void addDecksActionListeners(){

        final int c=0;

        for(final ImageView pane:HCardsImageViews){

            if(pane==null)
                continue;

            pane.setOnMouseDragged(new EventHandler<MouseEvent> ()
            {
                @Override
                public void handle(MouseEvent t) {
                    System.out.println("111111111");
                 /* Dragboard db=pane.startDragAndDrop(TransferMode.MOVE);
                  ClipboardContent cb=new ClipboardContent();
                  cb.putImage(HCardsImageViews.get(HCardsPanels.indexOf(pane)).getImage());
                  db.setContent(cb);
                  t.consume();
                  CardImageCreatorController.setIndex(HCardsPanels.indexOf(pane));*/

                }
            });










         /*  imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    MouseButton button = event.getButton();
                    if(button==MouseButton.PRIMARY){
                        myLogger.logger.log(Level.INFO,"buttonLeftClicked:"+"InDeckCard");
                        if(imageView.getLayoutX()>100)
                            try {
                                minimizeCard(imageView);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (UnsupportedAudioFileException e) {
                                e.printStackTrace();
                            } catch (LineUnavailableException e) {
                                e.printStackTrace();
                            }
                        else
                            try {
                                maximizeCard(imageView);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                    }else if(button==MouseButton.SECONDARY){
                        {
                            GameMapper.setSpecifiedCardIndex(HCardsImageViews.indexOf(imageView));
                            try {
                                myLogger.logger.log(Level.INFO,"buttonRightClicked:"+"InDeckCard");
                                gameMapper.addRequest(GameMapper.RequestType.Enter_Card);
                                makeTransitionToBattlefield(imageView,imageView.getLayoutX(),imageView.getY());
                                double i=System.currentTimeMillis();
                                while(true)
                                {
                                    if(System.currentTimeMillis()-i>1000) {
                                        update();
                                        break;
                                    }
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }else if(button==MouseButton.MIDDLE){

                    }
               }
           });*/

        }


    }

    private  void makeTransitionMax(Pane imageView){
        Line l=new Line(imageViewX,imageViewY,240,250);
        PathTransition transition=new PathTransition();
        transition.setNode( imageView);
        transition.setDuration(Duration.seconds(1));
        transition.setPath(l);
        transition.play();
        imageView.setLayoutX(240);
        imageView.setLayoutY(250);
        imageView.setLayoutY(imageViewHeight*1.5);
        imageView.setLayoutY(imageViewWidth*1.5);

    }


    private void makePssiveTransition(ImageView imageView){
        Line l=new Line(imageView.getX()-20,imageView.getY()+90,-900,imageView.getY()+90);
        PathTransition transition=new PathTransition();
        transition.setNode( imageView);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(l);
        transition.play();
        imageView.setX(-900);
        imageView.setY(imageView.getY()+90);

    }


    private void maximizeCard(Pane imageView) throws InterruptedException, IOException {
        imageViewHeight=imageView.getLayoutY();
        imageViewWidth=imageView.getLayoutX();
        imageViewX=imageView.getLayoutX()-200;
        imageViewY=imageView.getLayoutY()-200;
        makeTransitionMax(imageView);


    }

    private void minimizeCard(Pane imageView) throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException {
        update();



    }


    void addHistoryImageViews(ArrayList<String> paths) throws FileNotFoundException {
        int counter=0;
        for(String path:paths){
            historyImageView[counter]=new ImageView();
            historyImageView[counter].setFitWidth(40);
            historyImageView[counter].setFitHeight(50);
            historyImageView[counter].setLayoutX(3);
            historyImageView[counter].setLayoutY(5+counter*50);
            FileInputStream fileInputStream=new FileInputStream(path);
            Image image=new Image(fileInputStream);
            historyImageView[counter].setImage(image);
            HistoryAnchorPane.getChildren().add(historyImageView[counter]);
            counter++;


        }



    }
    void addHerosImage(String path) throws FileNotFoundException {
        FileInputStream fileInputStream=new FileInputStream(path);
        Image image=new Image(fileInputStream);
        Hero1.setImage(image);
    }

    void addHeropowersImage(String path) throws FileNotFoundException {
        FileInputStream fileInputStream=new FileInputStream(path);
        Image image=new Image(fileInputStream);
        HeroPower1.setImage(image);
    }


    void setSelectedLocationPane() {

            MainAnchorPane1.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                        if (event.getButton() == MouseButton.PRIMARY)
                        {
                            rightCickEvent(event);

                        } else if (event.getButton() == MouseButton.SECONDARY)
                        {
                            leftClickEvent(event);
                        }



                }

            });


    }

    private void rightCickEvent(MouseEvent event){
        System.out.println(event.getSceneX()+" "+event.getSceneY()+" ");
        System.out.println(GameMapper.gethGLocations().get(0).getX()+" "+GameMapper.gethGLocations().get(1).getX()+" "+GameMapper.gethGLocations().get(2).getX()+" "+GameMapper.gethGLocations().get(3).getX());
        if (event.getSceneX() >= 430 && event.getSceneX() <= 530 && event.getSceneY() >= 80 && event.getSceneY() <= 200) {
            GameMapper.setTarget("E");
            try {
                gameMapper.addRequest(GameMapper.RequestType.Traget_Selected);
                update();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (event.getSceneX() >= 430 && event.getSceneX() <= 530 && event.getSceneY() >= 498 && event.getSceneY() <= 577) {
            GameMapper.setTarget("H");
            try {
                gameMapper.addRequest(GameMapper.RequestType.Traget_Selected);
                update();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (event.getSceneX() >= 143 && event.getSceneX() <= 844 && event.getSceneY() >= 329 && event.getSceneY() <= 452) {
            Integer num=getHGCardsIndex(event.getX(),event.getY());
            if(num!=null) {
                GameMapper.setTarget("H" + num);
                try {
                    gameMapper.addRequest(GameMapper.RequestType.Traget_Selected);
                    update();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (event.getSceneX() >= 173 && event.getSceneX() <= 815 && event.getSceneY() >= 214 && event.getSceneY() <= 311) {
            Integer num=getHGECardsIndex(event.getX(),event.getY());
            if(num!=null) {
                GameMapper.setTarget("E" + num);
                try {
                    gameMapper.addRequest(GameMapper.RequestType.Traget_Selected);
                    update();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void leftClickEvent(MouseEvent event)
    {

        System.out.println(event.getSceneX()+" "+event.getSceneY()+" ");
        System.out.println(GameMapper.gethGLocations().get(0).getX()+" "+GameMapper.gethGLocations().get(1).getX()+" "+GameMapper.gethGLocations().get(2).getX()+" "+GameMapper.gethGLocations().get(3).getX());
        if (event.getSceneX() >= 430 && event.getSceneX() <= 530 && event.getSceneY() >= 80 && event.getSceneY() <= 200) {
            GameMapper.setMaxCardString("E");
            try {
                gameMapper.addRequest(GameMapper.RequestType.Max_Card);
                ScreenController.activate("BoldImage2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (event.getSceneX() >= 430 && event.getSceneX() <= 530 && event.getSceneY() >= 498 && event.getSceneY() <= 577) {
            GameMapper.setMaxCardString("H");

            try {
                gameMapper.addRequest(GameMapper.RequestType.Max_Card);
                ScreenController.activate("BoldImage2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (event.getSceneX() >= 143 && event.getSceneX() <= 844 && event.getSceneY() >= 329 && event.getSceneY() <= 452) {
            Integer num=getHGCardsIndex(event.getX(),event.getY());
            if(num!=null) {
                GameMapper.setMaxCardString("H" + num);
                try {
                    gameMapper.addRequest(GameMapper.RequestType.Max_Card);
                    ScreenController.activate("BoldImage2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (event.getSceneX() >= 173 && event.getSceneX() <= 815 && event.getSceneY() >= 214 && event.getSceneY() <= 311) {
            Integer num=getHGECardsIndex(event.getX(),event.getY());
            if(num!=null) {
                GameMapper.setMaxCardString("E" + num);
                try {
                    gameMapper.addRequest(GameMapper.RequestType.Max_Card);
                    ScreenController.activate("BoldImage2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private Integer getHGCardsIndex(double x,double y){
        ArrayList<CardLocation> l=GameMapper.gethGLocations();
        for(CardLocation cl:l)
        {
            if(cl.getX()+75>=x && cl.getX()-5<=x )
            {
                return l.indexOf(cl);
            }
        }
        return null;
    }
    private Integer getHGECardsIndex(double x,double y){
        ArrayList<CardLocation> l=GameMapper.getHGEnemyCardLocations();
        for(CardLocation cl:l)
        {
            if(cl.getX()+75>=x && cl.getX()-5<=x )
            {
                return l.indexOf(cl);
            }
        }
        return null;
    }


    void setLocationPane() {
        MainAnchorPane1.setOnDragOver(new EventHandler<DragEvent>(){
            @Override
            public void handle(DragEvent t) {
                if(t.getDragboard().hasString())
                    t.acceptTransferModes(TransferMode.MOVE);
            }

        });
        MainAnchorPane1.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {

                System.out.println("dropped!" + event.getDragboard().getString());
                System.out.println(event.getSceneX() + " " + event.getSceneY() + " " + GameMapper.isCardDragged());


                //MINION ATTACK HERO
                if (event.getDragboard().getString() != null && GameMapper.isCardDragged()) {
                    System.out.println("HHHHHHHHHHHHHHHHH11111111111111");
                    if (event.getSceneX() >= 430 && event.getSceneX() <= 530 && event.getSceneY() >= 80 && event.getSceneY() <= 200) {
                        try {
                            GameMapper.setAttacker(Integer.valueOf(event.getDragboard().getString()));
                            gameMapper.addRequest(GameMapper.RequestType.Minion_Attacked_Hero_Event);
                            GameMapper.setCardDragged(false);
                            update();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                }
                //MINION ATTACK MINION
                if (isAnAttackDrop(event.getSceneX(), event.getSceneY()) != null && GameMapper.isCardDragged()) {
                    System.out.println("222222222");
                    String name = event.getDragboard().getString();
                    int a = Integer.valueOf(name);
                    GameMapper.setHurt(isAnAttackDrop(event.getSceneX(), event.getSceneY()));
                    if (a >= GameMapper.getGameContext().getOnBattlefieldCards().size())
                        a = 0;
                    GameMapper.setAttacker(a);
                    System.out.println(a + " " + isAnAttackDrop(event.getSceneX(), event.getSceneY()));
                    try {
                        gameMapper.addRequest(GameMapper.RequestType.Minion_Attacked_Minion_Event);
                        update();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    GameMapper.setCardDragged(false);
                    return;
                }

                //CARD ENTERING BATTLEFIELD
                if (event.getSceneY() >= 300 && event.getSceneY() <= 420 && event.getSceneX() >= 130 && event.getSceneX() <= 850 && GameMapper.isCardDragged()) {
                    try {

                        System.out.println("3333333333");
                        String name = event.getDragboard().getString();
                        System.out.print(name);
                        int num = ((GameMapper.getGameContext().getOnBattlefieldCards())).size();
                        if (num != 0) {
                            Card card=GameMapper.getGameContext().getCurrentHand().getHandsCards().get(Integer.valueOf(name));
                            setNewLocations(event.getSceneX(), event.getSceneY(), card);
                        }
                        ///System.out.println("card:" + name);
                        //System.out.println("cardName:" + GameMapper.getGameContext().getCurrentHand().getHandsCards().get(Integer.valueOf(name)).getName());
                        GameMapper.setSpecifiedCardIndex(Integer.valueOf(name));
                        System.out.println("list:" + cardList.CardList.convertCardListToNameList(GameMapper.getGameContext().getCurrentHand().getHandsCards()));
                        gameMapper.addRequest(GameMapper.RequestType.Enter_Card);
                        GameMapper.setCardDragged(false);
                        update();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                //HerpPower ENTERING BATTLEFIELD
                if (event.getSceneY() >= 300 && event.getSceneY() <= 420 && event.getSceneX() >= 130 && event.getSceneX() <= 850 && GameMapper.getIsHeroPowerDragged()) {
                    try {

                        System.out.println("3333333333");
                        gameMapper.addRequest(GameMapper.RequestType.HeroPower_Used);
                        GameMapper.setIsHeroPowerDragged(false);
                        update();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }



                //WEAPON ATTACK HERO
                if( event.getDragboard().getString()!=null && GameMapper.isWeaponDragged()) {
                    System.out.println("4444444444");
                    if (event.getSceneX() >= 430 && event.getSceneX() <= 530 && event.getSceneY() >= 80 && event.getSceneY() <= 200) {
                        setHeroes(Integer.valueOf(event.getDragboard().getString()));
                        GameMapper.setWeaponDragged(false);
                    }

                }
                //WEAPON ATTACK MINION
                if(isAnAttackDrop(event.getSceneX(),event.getSceneY())!=null && GameMapper.isWeaponDragged()) {
                    System.out.println("5555555555555555");
                    String name = event.getDragboard().getString();
                    int a = Integer.valueOf(name);
                    GameMapper.setHurt(isAnAttackDrop(event.getSceneX(), event.getSceneY()));
                    if (a >= GameMapper.getGameContext().getOnBattlefieldCards().size())
                        a = 0;
                    GameMapper.setAttacker(a);
                    System.out.println(a + " " + isAnAttackDrop(event.getSceneX(), event.getSceneY()));
                    try {
                        gameMapper.addRequest(GameMapper.RequestType.Weapon_Attacked_Minion_Event);
                        update();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    GameMapper.setWeaponDragged(false);
                    return;
                }

                GameMapper.setCardDragged(false);
                GameMapper.setWeaponDragged(false);

            }
        });

    }



    public void cardEnteringBattlefield(){

    }





    public void setNewLocations(double x,double y,Card card) throws Exception {

        System.out.println("entered here!");
        boolean bl=GameMapper.getGameContext().getCurrentMana()>=card.getInitialManaCost();
        System.out.println("canBeBought:"+GameMapper.isCanSpecifiedCardBeBought());
        if (GameMapper.getGameContext().getOnBattlefieldCards().size() >= 7 || !bl || card.getType() != Type.MinionCard) {

            return;

        }
        ArrayList<CardLocation> locations = GameMapper.gethGLocations();
        Collections.sort(locations);
        int num = ((GameMapper.getGameContext().getOnBattlefieldCards())).size();
        System.out.println(num+" "+(GameMapper.getGameContext().getOnBattlefieldCards()));
        int index = num + 1;
        double max = 0;
        double min = 9000;
        double rightX = 0;
        int indexMax = -11;
        int indexMin = -11;
        double minHere=9000;
        boolean fl = false;
        for (CardLocation cl : locations) {
            if (cl.getX() > x && cl.getCounter() < index) {
                fl = true;
                if(minHere>cl.getX())
                    minHere=cl.getX();
                System.out.println("XHere:"+cl.getX());
            }
            if (cl.getX() < x && cl.getCounter() < index) {
                fl = false;
                System.out.println("tanaghoz1:"+cl);
                break;

            }
        }
        if (fl)
        {
            x=minHere-5;
            System.out.println("oh no!min:"+minHere);
        }
        double maxHere=-1000;
        boolean flm = false;
        for (CardLocation cl : locations) {
            if (cl.getX() < x && cl.getCounter() < index) {
                flm = true;
                if(maxHere<cl.getX())
                    maxHere=cl.getX();
                System.out.println("XHere:"+cl.getX());
            }
            if (cl.getX() > x && cl.getCounter() < index) {
                System.out.println("tanaghoz2:"+cl);
                flm = false;
                break;

            }
        }
        if (flm)
        {
            x=maxHere+5;
            System.out.println("oh no!max:"+(x));
        }
        for (CardLocation cl : locations) {
            System.out.println("graphics.BattlefieldController.setNewLocations()" + x + " " + y);
            System.out.println("location:" + cl);
            if (cl.getX() > x) {

                {
                    cl.setX(cl.getX() + 55);
                    if (min > cl.getX()) {
                        min = cl.getX();
                        indexMin = cl.getCounter();
                    }
                }
                if (cl.getCounter() == num - 1)
                    rightX = cl.getX();
                //System.out.println("location+:"+cl);
            }
            if (cl.getX() < x) {

                {
                    cl.setX(cl.getX() - 55);
                    if (max < cl.getX()) {
                        max = cl.getX();
                        indexMax = cl.getCounter();
                    }
                }
                if (cl.getCounter() == num - 1) rightX = cl.getX();
                System.out.println("location-:" + cl);
            }
        }


        for (CardLocation cl : locations) {
            if (cl.getCounter() == index ) {
                System.out.println("index:" + index);
                System.out.println("max:" + max + "min:" + min + "beyn:" + (max + min) / 2 + "indexMax:" + indexMax + "indexMin:" + indexMin);
                cl.setX((max + min) / 2);
                if(fl)
                    cl.setX(minHere-50);
                if(flm)
                    cl.setX(maxHere+50);
                if (min == 9000) {
                    System.out.println("minnnn");
                    for (CardLocation clo : locations) {

                        if (clo.getCounter() == index - 2) {
                            System.out.println("indexminnnn:" + (index - 2) + " " + (clo.getX()));

                            //  cl.setX(clo.getX() + 70);
                        }
                    }
                    // cl.setX((max + 800) / 2);

                }

                System.out.println("location:vasat" + ((max + min) / 2) + " " + max + " " + min + " " + cl.getCounter());
            }
            if (cl.getCounter() > num + 1 && (num + 1) % 2 == cl.getCounter() % 2 && num + 1 % 2 == 0) {
                cl.setX(rightX + (cl.getCounter() - num + 1 - 2) * 35);
                System.out.println("location:--" + cl);
            }
            if (cl.getCounter() > num + 1 && (num + 1) % 2 == cl.getCounter() % 2 && num + 1 % 2 == 1) {
                cl.setX(rightX + (cl.getCounter() - num + 1 - 2) * 35);
                System.out.println("location:++" + cl);
            }


        }


        for(CardLocation cl:locations)
        {

            System.out.println("X:"+cl.getX()+" counter:"+cl.getCounter());
            try{
                System.out.println("card:"+(GameMapper.getGameContext().getOnBattlefieldCards().get(cl.getCounter()-1)).getName());
            }catch(Exception e){
                System.out.println("exception:)");
            }




        }


    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
       if(!GameMapper.isTimerStarts())
       {
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           MyTimer timer=new MyTimer();
           timer.start();
           try {
               GameMapper.setTimerStarts(true);
           } catch (UnsupportedAudioFileException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           } catch (LineUnavailableException e) {
               e.printStackTrace();
           }
       }
        mapper=Mapper.getInstance();
        gameMapper=GameMapper.getInstance();
        GameMapper.setBattlefieldController(this);
        setECardsImageViews();
        setHCardsPanes();
        setHGCardsPanes();
        setHero1Properties(0);
        setHero2Properties(0);
        setHCardImageViews();
        setLocationPane();
        setHGCardsImageViews();
        addDecksActionListeners();
        setHGECardsPanels();
        setWeapons();
        setAttackDrag();
        isAnAttackDrop(100,200);
        setSelectedLocationPane();
        setDraggableHeroPower();
        setArmor();
        drawer=new Drawer("");
        try {
            drawer.drawBattlefield(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addDecksActionListeners();
        setMessage();




    }


    private void setHGECardsPanels(){
        HGECardsPanels.add(EGPane1);
        HGECardsPanels.add(EGPane2);
        HGECardsPanels.add(EGPane3);
        HGECardsPanels.add(EGPane4);
        HGECardsPanels.add(EGPane5);
        HGECardsPanels.add(EGPane6);
        HGECardsPanels.add(EGPane7);
    }

    void makeTransitionToBattlefield(int x1,int y1,int x2,int y2,int index){
        Line l=new Line(x1,y1,x2,y2);
        PathTransition transition=new PathTransition();
        transition.setNode( HCardsPanels.get(index));
        transition.setDuration(Duration.seconds(3));
        transition.setPath(l);
        transition.play();
    }

    void setHero1Properties(int hp)
    {

        String str=((HeroCard)GameMapper.getGameContext().getHero().getCard()).getHp()+"";
        Hp1.setText(str+"");
        System.out.println("hhhhhhhhhhhhhpppppppppppppppppppp111111111:"+Hp1.getText());
    }

    void setHero2Properties(int hp)
    {

        String str=((HeroCard)GameMapper.getGameContext().getOtherHero().getCard()).getHp()+"";
        Hp2.setText(str+"");
        System.out.println("hhhhhhhhhhhhhpppppppppppppppppppp2222222222:"+Hp2.getText());
    }



    public void update() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        ScreenController.activate();
    }

    ArrayList<Pane> getHCardsImageViews() {
        return HCardsPanels;
    }

    void setHCardsImageViews(ArrayList<Pane> HCardsImageViews) {
        this.HCardsPanels = HCardsImageViews;
    }

    ArrayList<Pane> getHGCardsImageViews() {
        return HGCardsPanels;
    }

    void setHGCardsImageViews(ArrayList<Pane> HGCardsImageViews) {
        this.HGCardsPanels= HGCardsImageViews;
    }

    /**
     * @return the Pane1
     */
    public AnchorPane getPane1() {
        return Pane1;
    }

    /**
     * @param Pane1 the Pane1 to set
     */
    public void setPane1(AnchorPane Pane1) {
        this.Pane1 = Pane1;
    }

    public void addEnemyHerosImage(String path) throws Exception{
        Image img=new Image(new FileInputStream(path));
        Hero2.setImage(img);
    }
    void addEnemyHeropowersImage(String path) throws FileNotFoundException {
        FileInputStream fileInputStream=new FileInputStream(path);
        Image image=new Image(fileInputStream);
        HeroPower2.setImage(image);
    }
    public void setCurrentMana(int turn,String text){

        CurrentMana1.setText(text);
        CurrentMana2.setText(text);


    }

    public void setWeaponsNumericalFeatures(int attack1,int durability1,int attack2,int durability2){
       Attack1.setText(attack1+"");
        Durability1.setText(durability1+"");
        Durability2.setText(durability2+"");
       Attack2.setText(attack2+"");
    }
    public void setMessage(){
        messagesLabel.setText(GameMapper.getTimerMessage());
    }

    public void setArmor (){
        Armor1.setText(((HeroCard)GameMapper.getGameContext().getHero().getCard()).getArmor()+"");
        Armor1.setText(((HeroCard)GameMapper.getGameContext().getOtherHero().getCard()).getArmor()+"");
    }














}




