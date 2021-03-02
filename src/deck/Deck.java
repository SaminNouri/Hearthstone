package deck;

import cardList.CardList;
import cardList.CardListDeck;
import deck.enumDeckClasses.GeneralDeck;
import initialCard.card.Card;
import initialCard.enumClasses.HeroType;
import player.playerEnumClasses.GeneralPlayer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Data on 3/13/2020.
 */
public class Deck extends InitialDeck implements Comparable
{
    private CardListDeck cardListDeck;
    private HeroType heroType;
    private final int maxAllowedNumberOfCards=30;
    private String name;
    protected ArrayList<String> cardsNamesList;
    private int wins=0;
    private int games=0;
    private int ratio;
    private String mostUsedCards="NONE";
       public  HashMap<GeneralDeck, Object> getDecksMap() throws Exception {
           Deck deck=this;
           HashMap<GeneralDeck,Object> map=new HashMap<GeneralDeck, Object>();
           map.put(GeneralDeck.Name,deck.getName());
           map.put(GeneralDeck.CardListDeck,CardList.convertCardListToNameList(deck.getCardListDeck().cardList));
           map.put(GeneralDeck.HeroType,deck.getHeroType());
           this.setGeneralMap(map);
           return map;
       }
    public double getAverageMana(){
        ArrayList<Card> list=this.getCardListDeck().getCardList();
        double average=0;
        int counter=0;
        for(Card card:list){
            average+=card.getInitialManaCost();
            counter++;
        }
        if(counter==0)
            return 0;
        return average/counter;
    }


    public int getWins() {
        return wins;
    }

    public int getRatio() {
        if(games!=0)
            return wins/games;
        else
            return 0;
    }

    public int getGames() {
        return games;
    }

    public String getMostUsedCards() {
        return mostUsedCards;
    }

    public Deck(HashMap<GeneralDeck, Object> general) throws Exception {
       super(general);
        if(general.containsKey(GeneralDeck.CardListDeck))
        {
            cardListDeck=new CardListDeck((ArrayList<String>) general.get(GeneralDeck.CardListDeck));
        }
        if(general.containsKey(GeneralDeck.HeroType))
        {
            heroType=((HeroType) general.get(GeneralDeck.HeroType));
        }
        if(general.containsKey(GeneralDeck.Name))
        {
            name=((String) general.get(GeneralDeck.Name));
        }

    }
    public void setAllFields(HashMap<GeneralDeck, Object> general) throws Exception {
        if(general.containsKey(GeneralDeck.CardListDeck))
        {
            cardListDeck=new CardListDeck((ArrayList<String>) general.get(GeneralDeck.CardListDeck));
        }
        if(general.containsKey(GeneralDeck.HeroType))
        {
            heroType=((HeroType) general.get(GeneralDeck.HeroType));
        }
        if(general.containsKey(GeneralDeck.Name))
        {
            name=((String) general.get(GeneralDeck.Name));
        }


    }

    public Deck(ArrayList<String> cardsNamesList,HeroType heroType,String name) throws Exception{
        this.addElement(GeneralDeck.HeroType,heroType);
        this.addElement(GeneralDeck.Name,name);
        this.addElement(GeneralDeck.CardListDeck,cardsNamesList);
        this.cardListDeck=new CardListDeck(cardsNamesList);
        this.heroType=heroType;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.addElement(GeneralDeck.Name,name);
        this.name = name;
    }

    public HeroType getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroType heroType) {
        this.addElement(GeneralDeck.HeroType,heroType);
        this.heroType = heroType;
    }
    public boolean addCardToDeck(String name) throws Exception {
        Card card=CardListDeck.convertNameToCard(name);
        HeroType heroType=card.getHeroType();
        if(heroType==this.heroType || heroType==HeroType.NEUTRAL)
        return  this.cardListDeck.addCardsName(name);
        else
        {
            System.out.println("card can t be added!herotype doesn t match!");
            return false;
        }
    }
    public boolean addCardToDeck(Card card) throws Exception {
        HeroType heroType=card.getHeroType();
        if(heroType==this.heroType || heroType==HeroType.NEUTRAL)
            return this.cardListDeck.addCard(card);
        else
        {
            System.out.println("card can t be added!herotype doesnt match");
            return false;
        }
    }
    public boolean removeCardNamesDeck(String name) throws Exception {
        if(!CardList.convertCardListToNameList(cardListDeck.getCardList()).contains(name))
            return false;
        Card card=CardListDeck.convertNameToCard(name);
             this.cardListDeck.removeCard(card);
             return true;



    }
    public boolean removeCardDeck(Card card) throws Exception {
        if(!CardList.convertCardListToNameList(cardListDeck.getCardList()).contains(card.getName()))
            return false;


            this.cardListDeck.removeCard(card);

            return true;

    }
    public Deck copy() throws Exception{
        ArrayList<String> temp=((ArrayList<String>)this.cardListDeck.getCardsNamesList());
        ArrayList<String> copy=new ArrayList<String>();
        for(String str:temp)
          copy.add(str);
        Deck ans=new Deck(copy,this.heroType,this.getName() );
        return ans;

    }

    public CardListDeck getCardListDeck() {
        return cardListDeck;
    }





    @Override
    public int compareTo(Object o) {
        Deck second=(Deck)o;
        Deck first=this;
        if(first.getRatio()!=second.getRatio())
        {
            if(first.getRatio()>second.getRatio())
                return 1;
            else
                return -1;
        }
        else  if(first.getWins()!=second.getWins())
        {
            if(first.getWins()>second.getWins())
                return 1;
            else
                return -1;
        }
        else  if(first.getGames()!=second.getGames())
        {
            if(first.getGames()>second.getGames())
                return 1;
            else
                return -1;
        }
        else  if(first.getAverageMana()!=second.getAverageMana())
        {
            if(first.getAverageMana()>second.getAverageMana())
                return 1;
            else
                return -1;
        }
        else
        return 1;
    }
}
