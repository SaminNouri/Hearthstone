package cardList;

import initialCard.card.InitialCard;

import java.util.ArrayList;

/**
 * Created by Data on 3/14/2020.
 */
public abstract   class InitialCardList
{
    public ArrayList<String> cardsNamesList;

    public InitialCardList(ArrayList<String> cardList) {
        this.cardsNamesList = cardList;
    }

    public boolean addCardsName(String name) throws Exception {
        cardsNamesList.add(name);
        return true;
    }

    public void removeCardsName(String name) throws Exception {
        cardsNamesList.remove(name);

    }

    public ArrayList<String> getCardsNamesList() {
        return cardsNamesList;
    }

    public void setCardsNamesList(ArrayList<String> cardList) throws Exception {
        this.cardsNamesList = cardList;
    }

}
