package cardList;

import initialCard.card.Card;
import initialCard.card.cardFactory.CardCreator;
import java.lang.Exception;

import java.util.ArrayList;

public class CardList extends cardList.InitialCardList
{
    public ArrayList<Card> cardList;

    public CardList(ArrayList<String> cardList) throws Exception {
        super(cardList);
        this.cardList=CardList.convertNameListToCardList(cardList);
    }

    public static ArrayList<Card> convertNameListToCardList(ArrayList<String> nameList) throws Exception {
        ArrayList<Card> cards=new ArrayList<Card>();
        for(String name:nameList){
            System.out.println(name);
            Card card=convertNameToCard(name);
            cards.add(card);
        }
        return cards;
    }

    @Override
    public boolean addCardsName(String name) throws Exception {
        super.addCardsName(name);
        Card card= CardList.convertNameToCard(name);
        this.cardList=CardList.convertNameListToCardList(this.cardsNamesList);
        return true;
    }
    public static Card convertNameToCard(String name) throws Exception {
        Card card= CardCreator.createCardWithName(name);
        return card;
    }
    public static String convertCardToName(Card card) throws Exception {
       String name=card.getName();
        return name;
    }
    @Override
    public void removeCardsName(String name) throws Exception{
        super.removeCardsName(name);
        this.cardList=CardList.convertNameListToCardList(this.cardsNamesList);
    }
    public boolean addCard(Card card) throws Exception {
        String name=card.getName();
        this.addCardsName(name);
        return true;

    }
    public void removeCard(Card card) throws Exception {
        String name=card.getName();
        this.removeCardsName(name);

    }

    public ArrayList<Card> getCardList() {
        return cardList;
    }

    public void setCardList(ArrayList<Card> cardList) throws Exception {
        this.setCardsNamesList(CardList.convertCardListToNameList(cardList));
        this.cardList = cardList;
    }

    public static ArrayList<String> convertCardListToNameList(ArrayList<Card> cardList) throws Exception {
        ArrayList<String> names=new ArrayList<String>();
        for(Card card:cardList){
            String name=card.getName();
            names.add(name);
        }
        return names;
    }
    @Override
    public void setCardsNamesList(ArrayList<String> cardList) throws Exception {
        super.setCardsNamesList(cardList);
        this.cardList=CardList.convertNameListToCardList(cardList);
    }
    public CardList copy() throws Exception {
        ArrayList<String> copy=new ArrayList<String>();
        for (String name:this.cardsNamesList){
            copy.add(name);
        }
        CardList copyList=new CardList(copy);
        return copyList;
    }

}
