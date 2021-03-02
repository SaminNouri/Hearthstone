/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

    
    
import game.GameMapper;
import initialCard.card.Card;
import initialCard.card.MinionCard;
import initialCard.card.WeaponCard;
import initialCard.enumClasses.Feature;
import initialCard.enumClasses.Type;
import initialSpell.enumSpellClasses.SpellType;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.PathTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.util.Duration;
import resources.PicturePaths;


import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.PopupWindow;

public class CardImageCreatorController implements Initializable{

    private static Card card;
    private static Integer index=null;


    public static Card getCard() {
        return card;
    }

    public static void setCard(Card aCard) {
        card = aCard;
    }

    /**
     * @return the index
     */
    public static int getIndex() {
        return index;
    }

    /**
     * @param aIndex the index to set
     */
    public static void setIndex(int aIndex) {
        index = aIndex;
    }
    
    @FXML
    private Label CardName;

    @FXML
    private Label CardIndex;
    
     @FXML
    private AnchorPane MainPane;

    @FXML
    private ImageView CardPhoto;

    @FXML
    private ImageView DeathrattleImage;

    @FXML
    private ImageView BattlecryImage;

    @FXML
    private ImageView QuestRewardImage;

    @FXML
    private Circle AttackShape;

    @FXML
    private Ellipse HpShape;

    @FXML
    private ImageView DivineShieldImage;

    @FXML
    private ImageView TauntImage;

    @FXML
    private Label AttackLabel;

    @FXML
    private Label HeroesHand;

    @FXML
    private Label HpLabel;

    @FXML
    private ImageView ChargeImage;

    @FXML
    private ImageView RushImage;

    private void makeTransitionToBattlefield(double x,double y){
        Line l=new Line(x-200,604,240,604);
        PathTransition transition=new PathTransition();
        transition.setNode( MainPane);
        transition.setDuration(Duration.seconds(1));
        transition.setPath(l);
        transition.play();
        MainPane.setLayoutX(240);
        MainPane.setLayoutY(300);


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

             CardIndex.setText((index)+"");
             if(GameMapper.getGameContext().getCurrentHand().getHandsCards().contains(card))
                 HeroesHand.setText("YES");
             else
                 HeroesHand.setText("FALSE");
             MainPane.setOnDragDetected(new EventHandler<MouseEvent> ()
            {
                @Override
                public void handle(MouseEvent t) {
                  GameMapper.setCardDragged(true);
                  Dragboard db=MainPane.startDragAndDrop(TransferMode.MOVE);
                  ClipboardContent cb=new ClipboardContent();
                  System.out.println("sad:"+card.getName());
                    System.out.println("sad:"+CardIndex.getText());
                    System.out.println("sad:"+card.getCardLocation().getCounter());
                    System.out.println("sad:"+card.getOwnerIndex());
                  cb.putString(CardIndex.getText());
                  db.setContent(cb);
                  t.consume();

                }
            });
                MainPane.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {

                        if (event.getButton() == MouseButton.PRIMARY)
                        {
                            //rightCickEvent(event);

                        } else if (event.getButton() == MouseButton.SECONDARY)
                        {
                            if(HeroesHand.getText()!=null && HeroesHand.getText().contains("YES"))
                            {
                                GameMapper.setMaxCard(GameMapper.getGameContext().getCurrentHand().getHandsCards().get(Integer.valueOf(CardIndex.getText())));
                                try {
                                    ScreenController.activate("BoldImage2");
                                }catch (Exception e)
                                {
                                    e.printStackTrace();
                                }

                            }

                        }

                    }

                });






        MainPane.setLayoutX(card.getCardLocation().getX());
       MainPane.setLayoutY(card.getCardLocation().getY());
       Image img;

        try {
            img = new Image(new FileInputStream(PicturePaths.getPathByName(card.getName())));
             CardPhoto.setImage(img);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CardImageCreatorController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    
      
        BattlecryImage.setVisible((card.getSpell1()!=null && card.getSpell1().isBattlecry()==true)||(card.getSpell2()!=null && card.getSpell2().isBattlecry()==true));
        
        DeathrattleImage.setVisible((card.getSpell1()!=null && card.getSpell1().isDeathrattle()==true)||(card.getSpell2()!=null && card.getSpell2().isDeathrattle()==true));
      
        QuestRewardImage.setVisible((card.getSpell1()!=null && card.getSpell1().getSpellType()==SpellType.QuestAndReward)||(card.getSpell2()!=null && card.getSpell2().getSpellType()==SpellType.QuestAndReward));
      
       TauntImage.setVisible(card.isTaunt() || card.getFeaures().containsKey(Feature.Taunt));
       RushImage.setVisible(false);
       ChargeImage.setVisible(card.isCharge() || card.getFeaures().containsKey(Feature.Charge));
       DivineShieldImage.setVisible(card.isDivineShield() || card.getFeaures().containsKey(Feature.DivineShield));
       if(card.getType()==Type.MinionCard)
       {
           MinionCard mcard=(MinionCard)card;
           AttackLabel.setText(mcard.getAttack()+"");
           HpLabel.setText(mcard.getHp()+"");
       }
       else if(card.getType()==Type.WeaponCard){
           WeaponCard mcard=(WeaponCard)card;
           AttackLabel.setText(mcard.getAttack()+"");
           HpLabel.setText(mcard.getDurability()+"");
           
       }
       else 
       {
          AttackShape.setVisible(false);
          HpShape.setVisible(false);
          AttackLabel.setVisible(false);
          HpLabel.setVisible(false);
       }

       index=null;
      // makeTransitionToBattlefield(0,0);
       
    }

}

    

