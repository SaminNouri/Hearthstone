package Store;

import EndProgram.EndProgram;
import cardList.CardList;
import cardList.CardListDeck;
import deck.Deck;
import game.GamePlayer;
import game.LoggerCreator;
import initialCard.card.Card;
import initialCard.card.cardFactory.CardCreator;
import initialCard.enumClasses.HeroType;
import player.Player;
import player.playerEnumClasses.GeneralPlayer;
import playersCards.PlayersCards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PlayersStore
{
    private ArrayList<Integer> wallet;
    private PlayersCards playersCards;
    private int coins;
    private ArrayList<HeroType> heroType;
    private Deck defaultDeck;
    private HashMap<GeneralPlayer,Object> map;
    EndProgram endProgram;
    private LoggerCreator loggerCreator;

    public LoggerCreator getLoggerCreator() {
        return loggerCreator;
    }

    public void setLoggerCreator(LoggerCreator loggerCreator) {
        this.loggerCreator = loggerCreator;
    }

    public void setEndProgram(EndProgram endProgram){
        this.endProgram=endProgram;
    }

    public HashMap<GeneralPlayer, Object> getMap() {
        return map;
    }

    public void setMap(HashMap<GeneralPlayer, Object> map) {
        this.map = map;
    }

    public PlayersStore(ArrayList<Integer> wallet, ArrayList<String> ownedCards, ArrayList<String> freeCards, ArrayList<String> lockedCards, ArrayList<String> allCards){
        this.setWallet(wallet);
        this.playersCards= new PlayersCards(ownedCards,freeCards,lockedCards,allCards);
    }
    public PlayersStore(ArrayList<Integer> wallet,PlayersCards playersCards){
        this.setWallet(wallet);
        this.playersCards=playersCards;
    }
    public PlayersStore(int coins,PlayersCards playersCards){
        this.setCoins(coins);
        this.playersCards=playersCards;
    }

    public Deck getDefaultDeck() {
        return defaultDeck;
    }

    public void setDefaultDeck(Deck defaultDeck) {
        this.defaultDeck = defaultDeck;
    }

    public ArrayList<Integer> getWallet() {
        return wallet;
    }

    public void setWallet(ArrayList<Integer> wallet) {
        if(wallet.size()==1)
            coins=wallet.get(0);
        this.wallet = wallet;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        if(this.wallet.size()==1)
        {
            int temp=wallet.get(0);
            wallet.remove(0);
        }
        wallet.add(coins);
        this.coins = coins;
    }

    public PlayersCards getPlayersCards() {
        return playersCards;
    }

    public void setPlayersCards(PlayersCards playersCards) {
        this.playersCards = playersCards;
    }


    public void storeMenu() throws Exception{
        boolean flag=true;
        try{
            while(flag)
            {

                flag=this.getStoreInput();


            }
            return;

        }catch(Exception e){

            LoggerCreator.logger.warning(e.toString()+"line:"+e.getCause().getStackTrace()[0].getLineNumber());
        }

        return;

    }
    public void storeHelp(){

        System.out.println("1/to show redeemable cards enter ls-b!");
        System.out.println("2/to show retail cards enter enter ls-s!");
        System.out.println("3/to see wallet enter enter wallet!");
        System.out.println("4/to return to the main menu enter back!");
        System.out.println("5/to end the program enter exit!");
        System.out.println("6/to ask for help enter help!");

    }

    public boolean getStoreInput() throws Exception{

        System.out.println("Store menu:");
        System.out.println("1/show redeemable cards!");
        System.out.println("2/show retail cards!");
        System.out.println("3/see wallet!");
        System.out.println("4/return to the main menu!");
        System.out.println("5/end the program!");
        System.out.println("6/help!");

        LoggerCreator.logger.info("navigate:store");

        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        if (input.equals("ls-s")) {
            LoggerCreator.logger.info("cardlist:retail");
            ArrayList<String> list = playersCards.redeemableCards();
            System.out.println(list);
            return cardDisplay(list);
        } else if (input.equals("ls-b")) {
            LoggerCreator.logger.info("cardlist:reedamble");
            ArrayList<String> list = playersCards.retailCards();
            return cardDisplay(list);
        } else if (input.equals("wallet")) {
            LoggerCreator.logger.info("wallet:coins");
            System.out.println("you have " + wallet.get(0) + " coins");
            getStoreInput();

            LoggerCreator.logger.info("exit");
            System.out.println("Do you want to exit the program?");
            String str = scanner.nextLine();
            if (str.equals("yes"))
                endProgram.end();
            else {
                getStoreInput();
                LoggerCreator.logger.severe("error:wrongInput");
            }

            LoggerCreator.logger.info("navigate:back");
            return false;
        } else if (input.equals("exit")) {
            LoggerCreator.logger.info("exit");
            System.out.println("Do you want to exit the program?");
            String str = scanner.nextLine();
            if (str.equals("yes"))
                endProgram.end();
            else {
                getStoreInput();
                LoggerCreator.logger.severe("error:wrongInput");
            }

            LoggerCreator.logger.info("navigate:back");
            return false;
        } else if (input.equals("back")) {
            LoggerCreator.logger.info("navigate:back");
            return false;
        } else if (input.equals("help")) {
            LoggerCreator.logger.info("navigate:help");
            storeHelp();
            return true;
        }
        System.out.println("wrong input!try again");
        LoggerCreator.logger.severe("error:wrongInput");
        return false;
    }



    public boolean cardDisplay(ArrayList<String> deck) throws Exception{


        for(Card card:CardList.convertNameListToCardList(deck))
        {
            System.out.println(card.toString());
        }
        boolean flag=true;
        while(flag)
        {

            flag=this.cardDisplayInput( deck);


        }
        return false;
    }


    



    public void cardDisplayInputHelp(){
        System.out.println("1/to buy a card enter buy [card s name]!");
        System.out.println("2/to sell a card from deck enter sell [remove s name]!");
        System.out.println("3/to end the program enter exit!");
        System.out.println("4/to return to the main menu enter back!");
        System.out.println("5/to ask for help enter help!");
    }

    public boolean cardDisplayInput(ArrayList<String> deck) throws Exception{
        System.out.println("1/buy a card!");
        System.out.println("2/sell a card!");
        System.out.println("3/end the program!");
        System.out.println("4/return to the main menu!");
        System.out.println("5/ask for help!");

        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        String[] parts=input.split(" ");
        if (input.equals("exit")) {
            LoggerCreator.logger.info("navigate:exit");
            System.out.println("Do you want to exit the program?");
            String str = scanner.nextLine();
            if (str.equals("yes"))
                endProgram.end();
            else {
                cardDisplayInput(deck);
                LoggerCreator.logger.severe("error:wrongInput");
            }

            LoggerCreator.logger.info("navigate:back");
            return false;
        } else if (input.equals("back")) {
            LoggerCreator.logger.info("navigate:back");
            return false;
        } else if (input.equals("help")) {
            LoggerCreator.logger.info("navigate:help");
            cardDisplayInputHelp();
            return true;
        }
        if(parts.length==2)
        {

            if(parts[0].equals("buy"))
            {
                try{
                LoggerCreator.logger.info("buy:"+parts[1]);
                this.buy(parts[1]);
                return true;}catch (Exception e){
                    LoggerCreator.logger.warning(e.toString()+"line:"+e.getCause().getStackTrace()[0].getLineNumber());
                    System.out.println("you ve entered card s name wrongly!");
                }

            }
            if(parts[0].equals("sell"))
            {
                try{
                LoggerCreator.logger.info("sell:"+parts[1]);
                this.sell(parts[1]);
                return true;}catch(Exception e){
                    LoggerCreator.logger.warning(e.toString()+"line:"+e.getCause().getStackTrace()[0].getLineNumber());
                    System.out.println("you ve entered card s name wrongly!");
                }

            }

            else
            {
                LoggerCreator.logger.severe("error:wrongInput");
                System.out.println("wrong input!try again");
                cardDisplayInput(deck);
            }

        }
        else
        {
            LoggerCreator.logger.severe("error:wrongInput");
            System.out.println("wrong input!try again");
            cardDisplayInput(deck);
        }
        LoggerCreator.logger.severe("error:wrongInput");
        System.out.println("wrong input!try again");
        return false;

    }
//has changed.doesn t work right
    public void sell(String name) throws Exception{


            Card card=CardList.convertNameToCard(name);
            int cost=card.getCoin();
            setCoins(this.coins+cost);
            playersCards.getOwnedCards().remove(name);
        System.out.println(coins);





    }
    public void buy(String name) throws Exception{

            Card card=CardList.convertNameToCard(name);
            int cost=card.getCoin();

                setCoins(this.coins-cost);
                playersCards.getOwnedCards().add(name);
        System.out.println(coins);

    }

    public  ArrayList<String> sellCondition(Deck[] decks) throws Exception {
        ArrayList<String> ownedCards=playersCards.getOwnedCards();
        ArrayList<String> sellCards=playersCards.retailCards();
        System.out.println(sellCards);
        ArrayList<String> sellCardsCopy=new ArrayList<String>();
        for(String n:sellCards){
            sellCardsCopy.add(n);
        }
          for(String name:sellCardsCopy) {
              ownedCards.remove(name);
              for (int i = 0; i < 16; i++) {
                  ArrayList<String> temp = CardList.convertCardListToNameList(decks[i].getCardListDeck().getCardList());
                  //System.out.println(ownedCards+" own "+temp+" temp "+i+" name"+name);
                  if (!ownedCards.containsAll(temp) || countInList(ownedCards,name)<countInList(temp,name)) {
                      sellCards.remove(name);
                      break;
                  }

              }
              ownedCards.add(name);
          }

        return sellCards;

    }
    private int countInList(ArrayList<String> list,String name){
        int counter=0;
        for(String str:list){
            if(str.equals(name))
                counter++;
        }
        return counter;
    }
    public ArrayList<String> buyableCards() throws Exception {
        ArrayList<String> ans=new ArrayList<String>();
        for(String name:playersCards.getAllCards())
            if(CardCreator.createCardWithName(name).getCoin()<=getCoins() && countInList(playersCards.getOwnedCards(),name)<=1 && !playersCards.getLockedCards().contains(name))
                ans.add(name);
        return ans;

    }







}
