package game;

import collection.Collection;
import graphics.CardLocation;
import graphics.ScreenController;
import initialCard.card.Card;
import initialCard.card.MinionCard;
import initialCard.enumClasses.Type;
import initialSpell.spell.condition.ConditionHandler;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class Logic {

 private GameContext gameContext;

    public Logic(GameContext gameContext)
    {
        this.gameContext=gameContext;
    }

    public void checkForDeadCards(){
        ArrayList<Card> onBattlefieldsCards=gameContext.getOnBattlefieldCards();
        ArrayList<Card> otherOnBattlefiedsCards=gameContext.getOtherOnBattlefieldCards();
        checkForDeadCards(onBattlefieldsCards,"SELF");
        checkForDeadCards(otherOnBattlefiedsCards,"other");

    }
    private void checkForDeadCards(ArrayList<Card>  cards,String str){



        ListIterator<Card> iter = cards.listIterator();
        while (iter.hasNext()) {
            Card card=iter.next();
            if(card.getType()== Type.MinionCard)
            {
                if(((MinionCard)card).getHp()<=0)
                {
                    ConditionHandler.handleFriendlyMinionDies(card.getOwnerIndex());
                    iter.remove();
                    if(card.getSpell1()!=null && card.getSpell1().isDeathrattle())
                    {
                        card.getSpell1().performOnTargets(GameMapper.getGameContext(),card,null,null);
                    }
                    if(card.getSpell2()!=null && card.getSpell2().isDeathrattle())
                    {
                        card.getSpell2().performOnTargets(GameMapper.getGameContext(),card,null,null);
                    }

                    GameMapper.sethGLocations1(null);
                    GameMapper.sethGLocations0(null);
                    try {
                        GameMapper.getBattlefieldController().update();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (LineUnavailableException e) {
                        e.printStackTrace();
                    } catch (UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

    }
    public void setLocation(String str) {
        System.out.println("truuuuuuueeeeeeeeeeeeeeeeeeeeeeee");

        ArrayList<CardLocation> hGLocations0 = GameMapper.gethGLocations0();
        ArrayList<CardLocation> hGLocations1 = GameMapper.gethGLocations1();
        if (gameContext.getPlayers()[0].getOnBattlefieldCards().size() % 2 == 0 && gameContext.getPlayers()[0].getOnBattlefieldCards().size() != 0) {
           // if (gameContext.getPlayersIndex() == 0) {
                if (hGLocations0 == null || hGLocations0.size() == 0) {
                    hGLocations0 = new ArrayList<CardLocation>();

                    for (int i = 2; i < 9; i++) {
                        if (i % 2 == 0)
                            hGLocations0.add(new CardLocation(460 + (i / 2) * 100, 343, i - 1));
                        else
                            hGLocations0.add(new CardLocation(460 - (i / 2) * 100, 343, i - 1));
                    }

              //  }
                GameMapper.sethGLocations0(hGLocations0);


            }
        }
        if (gameContext.getPlayers()[1].getOnBattlefieldCards().size() % 2 == 0 && gameContext.getPlayers()[1].getOnBattlefieldCards().size() != 0) {
          //  if (gameContext.getPlayersIndex() == 1) {
                if (hGLocations1 == null || hGLocations1.size() == 0) {
                    hGLocations1 = new ArrayList<CardLocation>();
                    if (gameContext != null && gameContext.getPlayers()[gameContext.getPlayersIndex()].getOnBattlefieldCards().size() % 2 == 0 && gameContext.getPlayers()[gameContext.getPlayersIndex()].getOnBattlefieldCards().size() != 0) {
                        for (int i = 2; i < 9; i++) {
                            if (i % 2 == 0)
                                hGLocations1.add(new CardLocation(460 + (i / 2) * 100, 343, i));
                            else
                                hGLocations1.add(new CardLocation(460 - (i / 2) * 100, 343, i));
                        }
                    }
                    GameMapper.sethGLocations1(hGLocations1);
                }
            //}
        }


    }
    }

    /*private void setNewLocations(int i,String str,int owner) {


            if (owner == 0) {
                Collections.sort(GameMapper.gethGLocations0());
                CardLocation cd = GameMapper.gethGLocations0().get(i);
                double xMax = -200;
                ArrayList<CardLocation> cardLocations = GameMapper.gethGLocations0();
                for (CardLocation cardLocation : cardLocations) {
                    if (cardLocation.getX() > xMax)
                        xMax = cardLocation.getX();
                    if (cd.getX() >= cardLocation.getX()) {
                        cd.setX(cd.getX() + 50);
                    }
                    if (cd.getX() < cardLocation.getX()) {
                        cd.setX(cd.getX() - 50);
                    }
                    System.out.println("1:" + cardLocation);
                }
            }
            if (owner == 1) {
                Collections.sort(GameMapper.gethGLocations1());
                CardLocation cd = GameMapper.gethGLocations1().get(i);
                double xMax = -200;
                ArrayList<CardLocation> cardLocations = GameMapper.gethGLocations1();
                for (CardLocation cardLocation : cardLocations) {
                    if (cardLocation.getX() > xMax)
                        xMax = cardLocation.getX();
                    if (cd.getX() >= cardLocation.getX()) {
                        cd.setX(cd.getX() + 50);
                    }
                    if (cd.getX() < cardLocation.getX()) {
                        cd.setX(cd.getX() - 50);
                    }
                    System.out.println("1:" + cardLocation);
                }




        }*/





