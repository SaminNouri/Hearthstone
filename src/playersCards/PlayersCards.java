package playersCards;

import initialCard.card.Card;
import initialCard.card.cardFactory.CardCreator;
import initialCard.enumClasses.HeroType;
import org.omg.CORBA.PUBLIC_MEMBER;
import resources.CardPaths;

import java.util.ArrayList;

/**
 * Created by Data on 3/14/2020.
 */
public class PlayersCards
{
    private ArrayList<String> ownedCards;
    private ArrayList<String> freeCards;
    private ArrayList<String> lockedCards;
    private ArrayList<String> allCards;
    public PlayersCards( ArrayList<String> ownedCards,ArrayList<String> freeCards,ArrayList<String> lockedCards,ArrayList<String> allCards)
    {
        this.ownedCards=ownedCards;
        this.freeCards=freeCards;
        this.lockedCards=lockedCards;
        this.allCards=allCards;
    }
    //kharidani!
    public ArrayList<String> redeemableCards(){
        ArrayList<String> ans=new ArrayList<String>();
        for(String name:allCards){
            if((!lockedCards.contains(name)) && (!ownedCards.contains(name)) )
                ans.add(name);

        }
        return ans;
    }
    //forooshi
    public ArrayList<String> retailCards(){
        ArrayList<String> ans=new ArrayList<String>();
        for(String name:allCards){
            if((!freeCards.contains(name)) && (ownedCards.contains(name)) )
                ans.add(name);

        }
        return ans;
    }

    public ArrayList<String> getAllCards() {
        return allCards;
    }

    public void setAllCards(ArrayList<String> allCards) {
        this.allCards = allCards;
    }

    public ArrayList<String> getFreeCards() {
        return freeCards;
    }

    public void setFreeCards(ArrayList<String> freeCards) {
        this.freeCards = freeCards;
    }

    public ArrayList<String> getLockedCards() {
        return lockedCards;
    }

    public void setLockedCards(ArrayList<String> lockedCards) {
        this.lockedCards = lockedCards;
    }

    public ArrayList<String> getOwnedCards() {
        return ownedCards;
    }

    public void setOwnedCards(ArrayList<String> ownedCards) {
        this.ownedCards = ownedCards;
    }

    public ArrayList<String> getUnownedCards(){
        ArrayList<String> unownedCards=new ArrayList<String>();
        for(String name:allCards)
        {
            if(!ownedCards.contains(name)){
                unownedCards.add(name);
            }
        }
        return unownedCards;
    }

    public ArrayList<String> getCardsWithMana(int mana) throws Exception {
        ArrayList<String> cards=new ArrayList<String>();
        for(String name:allCards)
        {
            Card card= CardCreator.createCardWithName(name);
            if(card.getInitialManaCost()==mana){
                //System.out.println(mana+" "+card.getInitialManaCost()+" "+name+" "+card.getSerialNumber()+" "+ CardPaths.getPathByName(name)+" "+card.getHeroType());
               cards.add(name);
            }
        }
        return cards;
    }

    public int getNumberOfPossessedCards(String name){
        int counter=0;
        for(String temp:allCards){
            if(temp.equals(name))
                counter++;
        }
        return counter;
    }

    public static int numberOfCardsInList(String name,ArrayList<String> list){
        int counter=0;
        for(String n:list){
            if(n.equals(name))
                counter++;
        }
        return  counter;
    }
    public ArrayList<Card> getPassiveCards() throws Exception {
        ArrayList<Card> cards=new ArrayList<Card>();
        for(String name:allCards)
        {
            Card card=CardCreator.createCardWithName(name);
            if(card.getHeroType()== HeroType.NONE)
                cards.add(card);

        }
        return cards;
    }





}
