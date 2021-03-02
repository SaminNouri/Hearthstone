package fileReader;

import collection.Collection;
import collection.enumCollectionClasses.GeneralCollection;
import com.google.gson.Gson;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import deck.Deck;
import deck.enumDeckClasses.GeneralDeck;
import initialCard.enumClasses.*;
import initialCard.settingGeneralMap.ReadingJsonFiles;
import initialSpell.enumSpellClasses.*;
import player.InitialPlayer;
import player.playerEnumClasses.GeneralPlayer;
import playerHeroes.EnumPlayerHeroesClasses.GeneralHero;
import resources.CardPaths;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Data on 3/16/2020.
 */
public class SetPlayerMap
{



    public static HashMap<GeneralPlayer,Object> setPropertyMapWithPath(String path){

        HashMap<GeneralPlayer,Object> map= PlayerFileReader.getPropertyMap(path);

        HashMap<GeneralPlayer,Object> ans=new HashMap<GeneralPlayer,Object>();

        for(GeneralPlayer g:GeneralPlayer.values())
        {

            if(map.containsKey(g))
            {

                if(map.get(g).getClass().getSimpleName().equals("Double") || map.get(g).getClass().getSimpleName().equals("Integer"))
                {
                    Double d=(Double)map.get(g);
                    int i=d.intValue();
                    Integer integer=new Integer(i);
                    ans.put(g,i);
                }
                if(map.get(g).getClass().getSimpleName().equals("Boolean"))
                {
                    ans.put(g,(Boolean)map.get(g));
                }
                if(g.equals(GeneralPlayer.Password)  || GeneralPlayer.UserName.equals(g)  )
                {
                    ans.put(g,(String)map.get(g));
                }
                if(GeneralPlayer.AllCards.equals(g) || GeneralPlayer.OwnedCards.equals(g)  || GeneralPlayer.FreeCards.equals(g)  || GeneralPlayer.LockedCards.equals(g) )
                {
                    String temp=map.get(g).toString();

                    java.lang.reflect.Type empMapType = new TypeToken<ArrayList<String>>() {}.getType();

                   ArrayList<String> m=new Gson().fromJson(temp,empMapType);
                    ans.put(g,m);

                }

                if(GeneralPlayer.Collection.equals(g))
                {
                    HashMap<GeneralCollection,Object> p=new HashMap<GeneralCollection,Object>();
                    ////////////////////////////////////////////////////////
                    String temp=map.get(GeneralPlayer.Collection).toString();

                    java.lang.reflect.Type empMapType = new TypeToken<HashMap<GeneralCollection,Object>>() {}.getType();

                    HashMap<GeneralCollection,Object> m=new Gson().fromJson(temp,empMapType);
                    ////////////////////////////////////////////////////////
                    for(GeneralCollection generalCollection:GeneralCollection.values()){
                        if(generalCollection!=GeneralCollection.DefaultDeck && generalCollection!=GeneralCollection.DefaultHeroType && generalCollection!=GeneralCollection.DefaultHeroTypeArray){
                            String str1;
                            java.lang.reflect.Type empMapTypemage = new TypeToken<HashMap<GeneralDeck,Object>>() {}.getType();
                            String hero1;
                            HashMap<GeneralDeck,Object> map1;
                            ///////////////////////////////////////////////////////
                            str1=m.get(generalCollection).toString();
                            map1=new Gson().fromJson(str1,empMapTypemage);
                            ///////////////////////////////////////////////////////////
                            hero1=(String)map1.get(GeneralDeck.HeroType);
                            map1.remove(GeneralDeck.HeroType);
                            map1.put(GeneralDeck.HeroType,HeroType.valueOf(hero1));
                            //System.out.println(map1);
                            //////////////////////////////////////////////////////////
                            p.put(generalCollection,map1);
                            ////////////////////////////////////////////////////
                        }
                    }

                    ans.put(g,p);




                }
                if(GeneralPlayer.PlayersHeroes.equals(g))
                {

                    String temp=map.get(GeneralPlayer.PlayersHeroes).toString();

                    java.lang.reflect.Type empMapType = new TypeToken<HashMap<GeneralHero,ArrayList<HeroType>>>() {}.getType();

                    HashMap<GeneralHero,ArrayList<HeroType>> m=new Gson().fromJson(temp,empMapType);

                    ans.put(g,m);
                }
                if(GeneralPlayer.Wallet.equals(g))
                {
                    String temp=map.get(GeneralPlayer.Wallet).toString();

                    java.lang.reflect.Type empMapType = new TypeToken<ArrayList<Integer>>() {}.getType();

                   ArrayList<Integer> m=new Gson().fromJson(temp,empMapType);
                    ans.put(g,m);
                }



            }


        }


        return ans;

    }


     public static void main(String[] args){


         //System.out.println(SetPlayerMap.setPropertyMapWithPath("C:\\Users\\Data\\Desktop\\hearthstoneGame\\usersJsonFiles\\defaultUser.json"));




     }







}
