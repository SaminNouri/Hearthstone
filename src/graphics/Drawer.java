package graphics;

import Events.GameEvent;
import cardList.CardList;
import characters.Hero;
import game.BattlefieldPlayer;
import game.GameContext;
import game.GameMapper;
import graphics.battlefield.*;
import graphics.battlefield.Location;
import initialCard.card.Card;
import resources.PicturePaths;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Data on 4/20/2020.
 */
public class Drawer {
    private Mapper mapper;
    private GameMapper gameMapper;
    private String controller;
    public Drawer(String controller){
        this.controller=controller;
        mapper=Mapper.getInstance();
        gameMapper=GameMapper.getInstance();


    }
    void drawCollection(CollectionController collectionController) throws Exception {
        collectionController.setFilter();
        ArrayList<String>  imagesAddresses=mapper.getGameState().getMainMenu().getCollection().getImagesAddresses();
        ArrayList<String>  decksNames=Mapper.getGameState().getMainMenu().getCollection().getDecksNames();
        ArrayList<Boolean>  ownedImagesList=Mapper.getGameState().getMainMenu().getCollection().getOwnedImagesList();
        String pagesHerotype=Mapper.getGameState().getMainMenu().getCollection().getPagesHerotype();
        collectionController.resetImageViews();
        collectionController.setDecksNames(decksNames);
        collectionController.loadCollectionCards(imagesAddresses,ownedImagesList,pagesHerotype);
    }

     void drawBattlefield(BattlefieldController battlefieldController) throws Exception {

        if(GameMapper.getGameContext()==null )
        GameMapper.setGameContext(new GameContext(new BattlefieldPlayer(Mapper.getGameState().getMainMenu().getCollection().getHandWithIndex(Mapper.getEnemiesDeckIndex()), 0), new BattlefieldPlayer(mapper.getGameState().getMainMenu().getCollection().getHandWithIndex(Mapper.getChooseDeckIndex()), 1)));


        if ( GameMapper.getGameContext().getCurrentHand() == null) {
            ScreenController.activate("ChooseDeck");
            return;
        }
        int attack1=0;
        int durability1=0;
        if(GameMapper.getGameContext().getWeapon()!=null)
        {
            attack1=GameMapper.getGameContext().getWeapon().getAttack();
            durability1=GameMapper.getGameContext().getWeapon().getDurability();
            System.out.println(attack1+" 1 "+durability1);
        }
         int attack2=0;
         int durability2=0;
         if(GameMapper.getGameContext().getOtherWeapon()!=null)
         {

             attack2=GameMapper.getGameContext().getOtherWeapon().getAttack();
             durability2=GameMapper.getGameContext().getOtherWeapon().getDurability();

         }
         battlefieldController.setWeaponsNumericalFeatures(attack1,durability1,attack2,durability2);
         Hero hero1=GameMapper.getGameContext().getHero();
         Hero hero2=GameMapper.getGameContext().getOtherHero();
        ArrayList<String> historyImages = PicturePaths.getPathListByNameList(CardList.convertCardListToNameList(GameMapper.getGameContext().getDrawnCards()));
        ArrayList<Card> DeckImagesAddresses = ((GameMapper.getGameContext().getInHandCards()));
        ArrayList<Card> GroundImagesAddresses = ((GameMapper.getGameContext().getOnBattlefieldCards()));
        int turnIndex = GameMapper.getGameContext().getPlayersIndex();
        battlefieldController.setHGECards(GameMapper.getGameContext().getOtherOnBattlefieldCards());
        battlefieldController.addHerosImage(PicturePaths.getPathByName(GameMapper.getGameContext().getCurrentHand().getCurrentHero().toString()));
         battlefieldController.addEnemyHerosImage(PicturePaths.getPathByName(GameMapper.getGameContext().getOtherHero().getName().toString()));
        battlefieldController.addHeropowersImage(PicturePaths.getPathByName(GameMapper.getGameContext().getCurrentHand().getHero().getHeroPower().getName()));
         battlefieldController.addEnemyHeropowersImage(PicturePaths.getPathByName(GameMapper.getGameContext().getOtherHero().getHeroPower().getName()));
        gameMapper.addRequest(GameMapper.RequestType.Set_Turn);
       // if (gameMapper.getTurn() == 1 && gameMapper.isPassives()) {
       //     battlefieldController.setBCards(PicturePaths.getPathListByNameList(CardList.convertCardListToNameList((gameMapper.getGameContext().getCurrentHand().getMyPassives()))));

       // }
      //  else if (!gameMapper.isPassives()) {
            battlefieldController.setHCards(DeckImagesAddresses);
            String currentMana = String.valueOf(GameMapper.getGameContext().getCurrentMana());
            String maxMana = String.valueOf(GameMapper.getGameContext().getMaxManaCost());
            System.out.println("checkMana:"+currentMana+" maxMana:"+maxMana);
            battlefieldController.setCurrentMana(turnIndex, currentMana + "/" + maxMana);
            battlefieldController.setHGCards(GroundImagesAddresses);
            battlefieldController.setHLedtCards(GameMapper.getGameContext().getCurrentHand().getRemainedCards());
            battlefieldController.addHistoryImageViews(historyImages);
            System.out.println("hero:"+ hero1.getName());
            System.out.println("hero:"+ hero1.getBaseHp());
            if (GameMapper.getGameContext().getCurrentHand().getAddedCard() != null && DeckImagesAddresses.size()<12) {

                int index2 = gameMapper.getGameContext().getCurrentHand().getHandsCards().indexOf(gameMapper.getGameContext().getCurrentHand().getAddedCard());
                if (index2 < 0)
                    return;
                double x2 = battlefieldController.getHCardsImageViews().get(index2).getLayoutX();
                x2-=390;

                     x2=-2*(index2)+43;;

                battlefieldController.makeTransitionToBattlefield(800,49,(int)x2,49,index2);
                GameMapper.getGameContext().getCurrentHand().setAddedCard(null);
            }

      //  }


    }



    void drawChooseDeck(ChooseDeckController chooseDeckController) throws Exception {

        System.out.println(Mapper.getGameState().getMainMenu()==null);
        //ArrayList<String>  imagesAddresses=mapper.getGameState().getMainMenu().getCollection().getImagesAddresses();
        ArrayList<String>  decksNames=Mapper.getGameState().getMainMenu().getCollection().loadChooseDeck();
        chooseDeckController.resetDeckButtons();
        chooseDeckController.setDecksNamesButtons(decksNames);

    }

   void drawStatus(StatusController collectionController) throws Exception {
        collectionController.setFilter();
        mapper.getGameState().getMainMenu().getCollection().setStatus();
        ArrayList<String>  imagesAddresses=mapper.getGameState().getMainMenu().getCollection().getImagesAddresses();
        ArrayList<String>  decksNames=Mapper.getGameState().getMainMenu().getCollection().getDecksNames();
        ArrayList<Boolean>  ownedImagesList=Mapper.getGameState().getMainMenu().getCollection().getOwnedImagesList();
        String pagesHerotype=Mapper.getGameState().getMainMenu().getCollection().getPagesHerotype();
        collectionController.resetImageViews();
        collectionController.setDecksNames(decksNames);
        collectionController.loadCollectionCards(imagesAddresses,ownedImagesList,pagesHerotype);

    }

   void drawStore(StoreController storeController) throws Exception {
        ArrayList<String>  imagesAddresses=mapper.getGameState().getMainMenu().getCollection().getImagesAddresses();
        ArrayList<String>  decksNames=Mapper.getGameState().getMainMenu().getCollection().getDecksNames();
        ArrayList<String> prices=Mapper.getGameState().getMainMenu().getCollection().getCardListPrices();
        ArrayList<String> buyCards=Mapper.getGameState().getMainMenu().getStore().buyableCards();
        ArrayList<Boolean>  ownedImagesList=Mapper.getGameState().getMainMenu().getCollection().getOwnedImagesList();
        int coins=Mapper.getGameState().getMainMenu().getStore().getCoins();
        ArrayList<String> sellCards=Mapper.getGameState().getMainMenu().getStore().sellCondition(Mapper.getGameState().getMainMenu().getCollection().getDecks());
        storeController.setSellComboBox(sellCards);
        storeController.setBuyComboBox(buyCards);
        String pagesHerotype=Mapper.getGameState().getMainMenu().getCollection().getPagesHerotype();
        storeController.resetImageViews();
        storeController.setFilter();
        storeController.setCoinLabel(coins);
        storeController.loadCollectionCards(imagesAddresses,ownedImagesList,prices,pagesHerotype);
    }
   void drawCompleteDeck(CompleteDeckController completeDeckController) throws Exception {
        ArrayList<String>  imagesAddresses=mapper.getGameState().getMainMenu().getCollection().getImagesAddresses();
        //ArrayList<String>  decksNames=Mapper.getGameState().getMainMenu().getCollection().getDecksNames();
        //ArrayList<String> prices=Mapper.getGameState().getMainMenu().getCollection().getCardListPrices();
        ArrayList<Boolean>  ownedImagesList=Mapper.getGameState().getMainMenu().getCollection().getOwnedImagesList();
        String pagesHerotype=Mapper.getGameState().getMainMenu().getCollection().getPagesHerotype();
        completeDeckController.resetImageViews();
        completeDeckController.setGroupDecksCardsArray();
        completeDeckController.resetCardsDeck();
        completeDeckController.resetAddedRatioButtons();
        completeDeckController.setFilter();
        completeDeckController.setChooseHeroComboBox(Mapper.getGameState().getMainMenu().getCollection().decksMatchingHeroes(),Mapper.getGameState().getMainMenu().getCollection().getDecks()[Mapper.getGameState().getMainMenu().getCollection().getSpecifiedDecksIndex()].getHeroType());
        completeDeckController.setDecksName(Mapper.getGameState().getMainMenu().getCollection().getDecks()[Mapper.getGameState().getMainMenu().getCollection().getSpecifiedDecksIndex()].getName());
        completeDeckController.loadDecksCards(Mapper.getGameState().getMainMenu().getCollection().getDecks()[Mapper.getGameState().getMainMenu().getCollection().getSpecifiedDecksIndex()].getCardListDeck().cardsNamesList);
        completeDeckController.setRatioButtonsInvisible();
        completeDeckController.loadCollectionCards(imagesAddresses,ownedImagesList,pagesHerotype);
        System.out.println(Mapper.getGameState().getMainMenu().getCollection().getDecks()[Mapper.getGameState().getMainMenu().getCollection().getSpecifiedDecksIndex()].getName()+"mmmm"+Mapper.getGameState().getMainMenu().getCollection().getSpecifiedDecksIndex());

    }

    void drawStatus2(StatusSecondController completeDeckController) throws Exception {

        //ArrayList<String>  imagesAddresses=mapper.getGameState().getMainMenu().getCollection().getImagesAddresses();
        ArrayList<String>  decksNames=Mapper.getGameState().getMainMenu().getCollection().getDecksNames();
        //ArrayList<String> prices=Mapper.getGameState().getMainMenu().getCollection().getCardListPrices();
        //ArrayList<Boolean>  ownedImagesList=Mapper.getGameState().getMainMenu().getCollection().getOwnedImagesList();
        String pagesHerotype=Mapper.getGameState().getMainMenu().getCollection().getPagesHerotype();
        completeDeckController.setGroupDecksCardsArray();
        completeDeckController.resetCardsDeck();
        completeDeckController.setDecksName(Mapper.getGameState().getMainMenu().getCollection().getDecks()[Mapper.getGameState().getMainMenu().getCollection().getSpecifiedDecksIndex()].getName());
        completeDeckController.loadDecksCards(Mapper.getGameState().getMainMenu().getCollection().getDecks()[Mapper.getGameState().getMainMenu().getCollection().getSpecifiedDecksIndex()].getCardListDeck().cardsNamesList);
        completeDeckController.setCostsText(Mapper.getGameState().getMainMenu().getCollection().getDecks()[Mapper.getGameState().getMainMenu().getCollection().getSpecifiedDecksIndex()].getAverageMana());
        completeDeckController.setHeotypeText(Mapper.getGameState().getMainMenu().getCollection().getDecks()[Mapper.getGameState().getMainMenu().getCollection().getSpecifiedDecksIndex()].getHeroType().toString());
        completeDeckController.setRatioText(Mapper.getGameState().getMainMenu().getCollection().getDecks()[Mapper.getGameState().getMainMenu().getCollection().getSpecifiedDecksIndex()].getRatio());
        completeDeckController.setWinsText(Mapper.getGameState().getMainMenu().getCollection().getDecks()[Mapper.getGameState().getMainMenu().getCollection().getSpecifiedDecksIndex()].getWins());
        completeDeckController.setMostUsedCardText(Mapper.getGameState().getMainMenu().getCollection().getTheBestCard());


    }



    void drawBoldCard(BoldCardController boldCardController) throws Exception {
        Integer index=mapper.getGameState().getMainMenu().getCollection().getBoldCardsIndex();
        if(index!=null) {

            String name;
            ArrayList<String> temp=mapper.getGameState().getMainMenu().getCollection().getMainList().get(mapper.getGameState().getMainMenu().getCollection().getPageCounter());
            if(index>=temp.size()) {
                mapper.addRequest(Mapper.RequestType.Load_Collection);
                ScreenController.activate();
                return;


            }
            try{
               name=temp.get(index);

                if(name==null|| name.equals(""))
                    return;

            }catch (Exception e){
                return;
            }

            boldCardController.loadBoldImage(name,mapper.getGameState().getMainMenu().getCollection().getPlayeCards().getNumberOfPossessedCards(name));


        }

    }

    void drawBoldCard2(BoldImage2Controller boldCardController) throws Exception {

            Card name=GameMapper.getMaxCard();
            boldCardController.loadBoldImage(name);


        }



}
