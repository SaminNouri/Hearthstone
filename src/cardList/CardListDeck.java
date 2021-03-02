package cardList;

import initialCard.card.Card;

import java.util.ArrayList;

/**
 * Created by Data on 3/14/2020.
 */
public class CardListDeck extends CardList
{
    public CardListDeck(ArrayList<String> cardList) throws Exception {
    super(cardList);
}

    public  boolean isCardListDeckAllowed(){
        ArrayList<Card> list=this.getCardList();
        if(list.size()>30)
            return false;
           /* if(playeCards.getOwnedCards().containsAll(decks[counter].getCardListDeck().cardList))
        {
            System.out.println("mewwwww");
        }*/
        for(Card card:list)
            if(countCard(card)>2)
                return false;

        return true;
    }
    public  boolean isCardListDeckAllowed(Card card){
        ArrayList<Card> list=this.getCardList();
        if(list.size()>30)
            return false;
            if(countCard(card)>2)
                return false;

        return true;
    }
    public int countCard(Card card){
        ArrayList<Card> list=this.getCardList();
        int count=0;
        for(Card temp:list){
            if(temp.equals(card))
                count++;

        }
        return count;

    }
    @Override
    public boolean addCardsName(String name) throws Exception {
        super.addCardsName(name);
        if(!this.isCardListDeckAllowed(CardList.convertNameToCard(name)))
        {
            ;
            removeCardsName(name);
            System.out.println("Warning!Adding this card is not possible");
            return false;
        }
        return true;
    }
    @Override
    public boolean addCard(Card card) throws Exception {
        super.addCard(card);
        if(!this.isCardListDeckAllowed())
        {

            removeCard(card);
            System.out.println("Warning!Adding this card is not possible");
            return false;
        }
        else
            return false;


    }
    @Override
    public void removeCardsName(String name) throws Exception {
        super.removeCardsName(name);

    }
    @Override
    public void removeCard(Card card) throws Exception {
        super.removeCard(card);

    }


}
