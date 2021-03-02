package collection;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import deck.Deck;
import initialCard.card.Card;

import java.awt.geom.Ellipse2D;
import java.util.*;

/**
 * Created by Data on 4/27/2020.
 */
public class Status {
    private List<Deck> lists=new ArrayList<Deck>();
    private Deck[] decks=new Deck[16];
    public Status(Deck[] decks){
        Collections.addAll(lists,decks);
       Collections.sort(lists, Collections.reverseOrder());


    }
    public Card getTheBestCard(ArrayList<Card> list){
        Collections.sort(list,Collections.<Card>reverseOrder());
        return list.get(0);
    }



    public List<Deck> getLists() {
        return lists;
    }
}
