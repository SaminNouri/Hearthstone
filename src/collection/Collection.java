package collection;

import EndProgram.EndProgram;
import cardList.CardList;
import cardList.CardListDeck;
import characters.Hero;
import collection.enumCollectionClasses.GeneralCollection;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import deck.Deck;
import deck.Hand;
import deck.enumDeckClasses.GeneralDeck;
import game.LoggerCreator;
import graphics.BoldCardController;
import initialCard.card.Card;
import initialCard.card.cardFactory.CardCreator;
import initialCard.enumClasses.General;
import initialCard.enumClasses.HeroType;
import org.w3c.dom.css.Counter;
import playersCards.PlayersCards;
import resources.PicturePaths;

import java.awt.*;
import java.util.*;
import java.util.logging.Level;

public class Collection extends InitialCollection
{

    private Deck[] decks;
    private Deck defaultDeck;
    private ArrayList<HeroType> defaultHeroTypeArray;
    private HeroType defaultHeroType;
    private PlayersCards playeCards;
    EndProgram endProgram;
    private LoggerCreator loggerCreator;
    private ArrayList<ArrayList<String>> mainList;
    private int pageCounter=0;
    private BoldCardController boldCardController;
    private ArrayList<String> getOwnedCards;
    private int boldCardsIndex;
    private String boldCardsName;
    private int specifiedDecksIndex;
    private Deck specifiedDeck;
    private ArrayList<String> specifiedDecksCards;
    private  Boolean[] specifiedRemovedBooleans;
    private  ArrayList<Integer> addedCardsToSpecifiedDeck;
    private Deck chosenDeck;
    private Hand hand;
    private int chooseDeckPageCounter=0;
    private Status status;

   public Status setStatus(){
       status=new Status(decks);
      for(int i=0;i<16;i++){
           decks[i]=status.getLists().get(i);
      }
       return status;

   }

    public String getTheBestCard(){
        Deck deck=decks[specifiedDecksIndex];
        ArrayList<Card> list=deck.getCardListDeck().getCardList();
        Collections.sort(list,Collections.<Card>reverseOrder());
        return list.get(0).getName();
    }


    public void setHandWithIndex(int i) throws Exception {
        hand=new Hand(decks[i+9*chooseDeckPageCounter],playeCards);

    }

    public Hand getHandWithIndex(int i) throws Exception {
        hand=new Hand(decks[i+9*chooseDeckPageCounter],playeCards);
        return hand;
    }



    public Hand getHand() {
        return hand;
    }

    public ArrayList<String> decksMatchingHeroes() throws Exception {
        ArrayList<String> heroes=new ArrayList<String>();
        ArrayList<Card> list=(decks[specifiedDecksIndex].getCardListDeck().cardList);
        for(Card card:list){
            HeroType heroType=card.getHeroType();
            if(!heroes.contains(heroType) && heroType!=HeroType.NEUTRAL) {
                heroes.add(heroType.toString());
                return heroes;
            }

        }
        if(heroes.size()==0)
        {
            for(HeroType h:HeroType.values())
            {
                if (!h.equals(HeroType.NONE) && !h.equals(HeroType.NEUTRAL))
                    heroes.add(h.toString());
            }
        }
        return heroes;


    }


    public Deck getChosenDeck() {
        return chosenDeck;
    }

    public void setChosenDeck(Deck chosenDeck) throws Exception {
        this.chosenDeck = chosenDeck;
        hand=new Hand(chosenDeck,playeCards);
    }

    public Deck getSpecifiedDeck() {
        return specifiedDeck;
    }

    public ArrayList<String> getSpecifiedDecksCards() {
        return specifiedDecksCards;
    }

    public int getSpecifiedDecksIndex() {
        return specifiedDecksIndex;
    }

    public void setSpecifiedDecksIndex(int specifiedDecksIndex) throws Exception {
        this.specifiedDecksIndex = specifiedDecksIndex;
        this.specifiedDeck=decks[specifiedDecksIndex];
        this.specifiedDecksCards=CardList.convertCardListToNameList(specifiedDeck.getCardListDeck().getCardList());
         saveDecks();
    }



    public int getBoldCardsIndex() {
        return boldCardsIndex;
    }

    public void setBoldCardsIndex(int boldCardsIndex) {
        this.boldCardsIndex = boldCardsIndex;

    }

    public String getBoldCardsName() {
        return boldCardsName;
    }

    public void setBoldCardsName(String boldCardsName) {
        this.boldCardsName = boldCardsName;
    }

    public LoggerCreator getLoggerCreator() {
        return loggerCreator;
    }

    public void setLoggerCreator(LoggerCreator loggerCreator) {
        this.loggerCreator = loggerCreator;
    }

    public void setEndProgram(EndProgram endProgram){
        this.endProgram=endProgram;
    }

    //default herotype and deck need to be checked carefuly need to be set through setter
    //defaultdeck must be set with default hero setter
    public Collection(HashMap<GeneralCollection, Object> general) throws Exception {
        super(general);
        decks=new Deck[16];
        int counter=0;
        for(GeneralCollection generalCollection:GeneralCollection.values()){
            if(generalCollection!=GeneralCollection.DefaultDeck && generalCollection!=GeneralCollection.DefaultHeroType && generalCollection!=GeneralCollection.DefaultHeroTypeArray){
                if(general.containsKey(generalCollection) && counter<=15)
                {

                    HashMap<GeneralDeck,Object> map=((HashMap<GeneralDeck, Object>) general.get(generalCollection));
                    ArrayList<String> list=(ArrayList<String>)map.get(GeneralDeck.CardListDeck);
                    String name=(String) map.get(GeneralDeck.Name);
                    HeroType heroType=(HeroType) map.get(GeneralDeck.HeroType);
                    decks[counter]=new Deck(list,heroType,name);
                    counter++;


                }
            }
        }




    }


    public void saveDecks() throws Exception {
        int counter=0;
        for(GeneralCollection generalCollection:GeneralCollection.values()){
            if(generalCollection!=GeneralCollection.DefaultDeck && generalCollection!=GeneralCollection.DefaultHeroType && generalCollection!=GeneralCollection.DefaultHeroTypeArray){
                if(general.containsKey(generalCollection) && counter<=15)
                {
                    getGeneralMap().remove(generalCollection);
                    getGeneralMap().put(generalCollection,decks[counter].getDecksMap());
                    counter++;


                }
            }
        }

    }


    public PlayersCards getPlayeCards() {
        return playeCards;
    }

    public void setPlayeCards(PlayersCards playeCards) {
        this.playeCards = playeCards;
    }
    public void setPlayeCards( ArrayList<String> ownedCards,ArrayList<String> freeCards,ArrayList<String> lockedCards,ArrayList<String> allCards) {
        this.playeCards = new PlayersCards( ownedCards, freeCards,lockedCards, allCards);
    }

    public Deck getDefaultDeck() {
        return defaultDeck;
    }


    public ArrayList<HeroType> getDefaultHeroTypeArray() {
        return defaultHeroTypeArray;
    }
    public HeroType getDefaultHeroType() {
        return defaultHeroType;
    }

    public void setDefaultHeroTypeArray(ArrayList<HeroType> defaultHeroTypeArray) throws Exception {
    HeroType temp=defaultHeroTypeArray.get(0);
    this.defaultHeroTypeArray = defaultHeroTypeArray;
        saveDecks();
}
    public void setDefaultHeroType(HeroType defaultHeroType) throws Exception {
        if(this.defaultHeroTypeArray.size()==1)
        {
            HeroType temp=this.defaultHeroTypeArray.get(0);
            this.defaultHeroTypeArray.remove(temp);
        }
        this.defaultHeroTypeArray.add(defaultHeroType);
        this.defaultHeroType=defaultHeroType;
        saveDecks();
    }


    public boolean addCardToSpecifiedtDeck(String name) throws Exception {
     boolean flag=addCardToSpecifiedDeck(CardList.convertNameToCard(name));
        saveDecks();
        return flag;
}
    public boolean addCardToSpecifiedDeck(Card card) throws Exception {
        int countInList=PlayersCards.numberOfCardsInList(card.getName(),CardList.convertCardListToNameList(decks[specifiedDecksIndex].getCardListDeck().cardList));
        int countInOwned=PlayersCards.numberOfCardsInList(card.getName(),playeCards.getOwnedCards());
        if(countInList>=countInOwned)
            return false;
        boolean flag=this.decks[specifiedDecksIndex].addCardToDeck(card);
        saveDecks();
        return flag;

    }
    ///////////////////////////////////////////////////////////////////////



    public ArrayList<ArrayList<String>> getMainList() {
        return mainList;
    }

    public void setMainList(ArrayList<ArrayList<String>> mainList) {
        this.mainList = mainList;
    }

    public int getPageCounter() {
        return pageCounter;
    }

    public void setPageCounter(int pageCounter) {
        this.pageCounter = pageCounter;
    }



    public ArrayList<String> getPossibleCardDecks() throws Exception{
        ArrayList<String> ans=new ArrayList<String>();
        ArrayList<String>  ownedCards=this.playeCards.getOwnedCards();
        for(String name:ownedCards)
        {
            if((!defaultDeck.getCardListDeck().getCardList().contains(name))){
                HeroType h=((Card)CardList.convertNameToCard(name)).getHeroType();
                if(h==defaultHeroType || h==HeroType.NEUTRAL)
                {
                    if(defaultDeck.getCardListDeck().countCard(CardList.convertNameToCard(name))<2)
                       ans.add(name);
                }
            }
        }
        return ans;
    }



    public static ArrayList<ArrayList<String>> categorizeList(ArrayList<String> deckNames) throws Exception {

        ArrayList<ArrayList<String>> categorizedList=new ArrayList<ArrayList<String>>();
        int cardCounter=0;
        int groupCounter=-1;
        for(HeroType heroType:HeroType.values()) {
            ArrayList<String> herotypeList = getHerotypeCards(heroType, deckNames);
            addCardsToCategorizedList(categorizedList, herotypeList);
        }
        return categorizedList;

    }

    public static void addCardsToCategorizedList(ArrayList<ArrayList<String>> categorizedList,ArrayList<String> deckNames){
        int cardCounter=0;
        int groupCounter=-1;
        ArrayList<String> currentList=new ArrayList<String>();

        for(String name:deckNames){
            currentList.add(name);
            cardCounter++;
            if(currentList.size()==8 ){
                groupCounter++;
                if(currentList.size()!=0) {
                    categorizedList.add(currentList);
                }
                //System.out.println(categorizedList+" here!");
                currentList=new ArrayList<String>();
            }
        }
        if(currentList.size()<8 && currentList.size()!=0 )
            categorizedList.add(currentList);


    }


    public   void removeDeck(int index) throws Exception {
        ArrayList<String> emptyList=new ArrayList<String>();
        CardList cardList=new CardList(emptyList);
        HashMap<GeneralDeck, Object> generalMap=new HashMap<GeneralDeck,Object>();
        generalMap.put(GeneralDeck.CardListDeck,emptyList);
        generalMap.put(GeneralDeck.HeroType,HeroType.NONE);
        generalMap.put(GeneralDeck.Name,"unknown");
        decks[index].setAllFields(generalMap);
        saveDecks();

    }
    public static ArrayList<String> getHerotypeCards(HeroType heroType,ArrayList<String> deckNames) throws Exception {
        ArrayList<String> ansList=new ArrayList<String>();
        for(String name:deckNames){
            System.out.println(name);
            Card card= CardCreator.createCardWithName(name);
            HeroType cardHeroType=card.getHeroType();
            if(cardHeroType.equals(heroType)){
                ansList.add(name);
            }
        }
        return ansList;
    }
    public static HeroType getCardListHerotype(ArrayList<String> list) throws Exception {
        if(list.size()==0)
            return HeroType.NONE;
        else
        {
            String name=list.get(0);
            Card card=CardCreator.createCardWithName(name);
            return card.getHeroType();
        }

    }

    public Deck[] getDecks() {
        return decks;
    }

    public void setDecks(Deck[] decks) {
        this.decks = decks;
    }

    public ArrayList<String> loadChooseDeck(){
        ArrayList<String> names=new ArrayList<String>();
        if(chooseDeckPageCounter==0)
        {
           for(int i=0;i<9;i++){
               names.add(decks[i].getName());
           }
        }
        if(chooseDeckPageCounter==1)
        {
            for(int i=9;i<16;i++){
                names.add(decks[i].getName());
            }
        }
        return names;
    }

    public void ChooseDeckNext(){
       chooseDeckPageCounter=1;
    }
    public void ChooseDeckPrevious(){
        chooseDeckPageCounter=0;
    }

    public String getDecksHerotypeWithName(String name){
        for(int i=0;i<16;i++){
            if(decks[i].getName().equals(name))
                return decks[i].getHeroType().toString();
        }
        return null;
    }



    public void loadAllCards() throws Exception {
        int num=pageCounter=0;
        ArrayList<String> allCards;
        allCards=playeCards.getAllCards();
        mainList=Collection.categorizeList(allCards);


    }

    public void loadOwnedCards() throws Exception {
        int num=pageCounter=0;
        ArrayList<ArrayList<String>> categorizedList;
        ArrayList<String> ownedCards;
        ownedCards=playeCards.getOwnedCards();
        mainList=Collection.categorizeList(ownedCards);


    }



    public void loadMainListCards() throws Exception {
        int num=pageCounter;
        ArrayList<ArrayList<String>> categorizedList;
        ArrayList<String> allCards;
        allCards=playeCards.getAllCards();
        if(mainList==null)
        {
            categorizedList=Collection.categorizeList(allCards);
            mainList=categorizedList;
        }

    }



    public void loadUnownedCards() throws Exception {
        int num=pageCounter=0;
        ArrayList<ArrayList<String>> categorizedList;
        ArrayList<String> ownedCards;
        ArrayList<String> unownedCards;
        ownedCards=playeCards.getOwnedCards();
        unownedCards=playeCards.getUnownedCards();
        mainList=Collection.categorizeList(unownedCards);


    }


    public void loadCardsWithMana(int mana) throws Exception {
        int num=pageCounter=0;
        ArrayList<String> cards;
        cards=playeCards.getCardsWithMana(mana);
        mainList=Collection.categorizeList(cards);


    }

    public ArrayList<String> getImagesAddresses(){
        ArrayList<String> imagesAddresses=new ArrayList<String>();
        if(mainList==null || mainList.size()==0)
            return imagesAddresses;
        for(String name:mainList.get(pageCounter)){
            imagesAddresses.add(PicturePaths.getPathByName(name));

        }
        return imagesAddresses;
    }

    public ArrayList<String> getDecksNames(){
        ArrayList<String> decksNames=new ArrayList<String>();
        for(Deck deck:decks){
            decksNames.add((deck.getName()));

        }
        return decksNames;
    }

    public String getPagesHerotype() throws Exception {
        if (mainList.size()==0)
            return "";
        return  (getCardListHerotype(mainList.get(pageCounter)).toString());
    }
    public ArrayList<Boolean>  getOwnedImagesList(){
        ArrayList<Boolean> ownedImagesList=new ArrayList<Boolean>();
        if (mainList.size()==0)
            return ownedImagesList;
        for(String name:mainList.get(pageCounter)){
            if(playeCards.getOwnedCards().contains(name))
                ownedImagesList.add(true);
            else
                ownedImagesList.add(false);

        }
        return ownedImagesList;
    }

     public void loadCardWithSearch(String name) throws Exception {
         int num=pageCounter=0;
         ArrayList<ArrayList<String>> categorizedList=new ArrayList<ArrayList<String>>();
         ArrayList<String> cardList=new ArrayList<String>();
         for(String str:playeCards.getAllCards()){
             if(name.contains(str)|| str.contains(name)){
                 cardList.add(str);
             }
         }
         mainList=Collection.categorizeList(cardList);

     }
    public static ArrayList<Integer> getCardListPrices(ArrayList<String> list) throws Exception {
        ArrayList<Integer> prices=new ArrayList<Integer>();
        for(String name:list){
            Card card=CardCreator.createCardWithName(name);
            prices.add(card.getCoin());

        }
        return prices;
    }
    public  ArrayList<String> getCardListPrices() throws Exception {
        ArrayList<String> ans=new ArrayList<String>();
        if(mainList.size()==0)
            return ans;
        ArrayList<String> names=mainList.get(pageCounter);
        ArrayList<String> prices=new ArrayList<String>();
        for(String name:names){
            Card card=CardCreator.createCardWithName(name);
            prices.add(String.valueOf(card.getCoin()));

        }
        return prices;
    }

    public Boolean[] getSpecifiedRemovedBooleans() {
        return specifiedRemovedBooleans;
    }

    public void setSpecifiedRemovedBooleans(Boolean[] specifiedRemovedBooleans) throws Exception {
        this.specifiedRemovedBooleans = specifiedRemovedBooleans;
        saveDecks();
    }

    public void removeCards() throws Exception {

        ArrayList<Card> list=decks[specifiedDecksIndex].getCardListDeck().getCardList();
        ArrayList<Card> newList=new ArrayList<Card>();
        for(int i=0;i<list.size();i++){
            if(!specifiedRemovedBooleans[i])
            {
                newList.add(list.get(i));
            }
        }

        HashMap<GeneralDeck,Object> map=new HashMap<GeneralDeck, Object>();
        map.put(GeneralDeck.CardListDeck,(CardList.convertCardListToNameList(newList)));
        map.put(GeneralDeck.Name,decks[specifiedDecksIndex].getName());
        map.put(GeneralDeck.HeroType,decks[specifiedDecksIndex].getHeroType());
        decks[specifiedDecksIndex]=new Deck(map);
        saveDecks();


    }


    public boolean addCards() throws Exception {

        boolean flag=true;

        for(Integer num:addedCardsToSpecifiedDeck){
           boolean b=addCardToSpecifiedDeck(CardList.convertNameToCard(mainList.get(pageCounter).get(num)));
            if(!b)
               flag=b;

        }
        saveDecks();
        return flag;




    }


    public  ArrayList<Integer> getAddedCardsToSpecifiedDeck() {
        return addedCardsToSpecifiedDeck;
    }

    public  void setAddedCardsToSpecifiedDeck(ArrayList<Integer> addedCardsToSpecifiedDeck) throws Exception {
        this.addedCardsToSpecifiedDeck = addedCardsToSpecifiedDeck;
        saveDecks();
    }
}
