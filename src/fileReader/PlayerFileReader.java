package fileReader;

import collection.Collection;
import collection.enumCollectionClasses.GeneralCollection;
import com.google.gson.Gson;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import initialCard.enumClasses.General;
import initialCard.enumClasses.HeroType;
import initialSpell.enumSpellClasses.GeneralSpell;
import player.playerEnumClasses.GeneralPlayer;
import playerHeroes.EnumPlayerHeroesClasses.GeneralHero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Data on 3/16/2020.
 */
public class PlayerFileReader
{
    private static String filePath;


    public static HashMap<GeneralPlayer,Object> getPropertyMap(String filePath){


        HashMap<GeneralPlayer,Object> map=new HashMap<GeneralPlayer,Object>();

        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            java.lang.reflect.Type empMapType = new TypeToken<HashMap<GeneralPlayer, Object>>() {}.getType();

            map=new Gson().fromJson(bufferedReader,empMapType);


        }catch(Exception e)
        {
           System.out.println("you ve entered your information incorrectly!");
        }


        return map;


    }


    //doesn t check whether it contains firstSpell or not

    public static HashMap<GeneralHero,Object> getPlayersHeroesMap(HashMap<General,Object> generalMap){

        String temp=generalMap.get(GeneralPlayer.PlayersHeroes).toString();

        java.lang.reflect.Type empMapType = new TypeToken<HashMap<GeneralHero, Object>>() {}.getType();

        HashMap<GeneralHero,Object> map=new Gson().fromJson(temp,empMapType);

        return map;

    }



    //doesn t check whether it contains secondSpell or not

    public static ArrayList<String> getArray(HashMap<GeneralPlayer,Object> generalMap,GeneralPlayer generalPlayer){

        String temp=generalMap.get(generalPlayer).toString();

        java.lang.reflect.Type empMapType = new TypeToken<ArrayList<String>>() {}.getType();

        ArrayList<String> map=new Gson().fromJson(temp,empMapType);

        return map;

    }
    public static HashMap<GeneralCollection,ArrayList<String>> getCollectionMap(HashMap<GeneralPlayer,Object> map){

        String temp=map.get(GeneralPlayer.Collection).toString();

        java.lang.reflect.Type empMapType = new TypeToken<HashMap<GeneralCollection,ArrayList<String>>>() {}.getType();

        HashMap<GeneralCollection,ArrayList<String>> m=new Gson().fromJson(temp,empMapType);


        return m;


    }
    public static HashMap<GeneralHero,Object> getHeroMap(HashMap<GeneralPlayer,Object> map){

        String temp=map.get(GeneralPlayer.PlayersHeroes).toString();

        java.lang.reflect.Type empMapType = new TypeToken<HashMap<GeneralHero,Object>>() {}.getType();

        HashMap<GeneralHero,Object> m=new Gson().fromJson(temp,empMapType);


        return m;


    }

    public static ArrayList<String> getArray(HashMap<GeneralCollection,Object> generalMap,GeneralCollection generalCollection){

        String temp=generalMap.get(generalCollection).toString();

        java.lang.reflect.Type empMapType = new TypeToken<ArrayList<String>>() {}.getType();

        ArrayList<String>list=new Gson().fromJson(temp,empMapType);

        return list;

    }
    public static ArrayList<Integer> getArrayInteger(HashMap<GeneralPlayer,Object> generalMap,GeneralPlayer generalPlayer){

        String temp=generalMap.get(generalPlayer).toString();

        java.lang.reflect.Type empMapType = new TypeToken<ArrayList<Integer>>() {}.getType();

        ArrayList<Integer>list=new Gson().fromJson(temp,empMapType);

        return list;

    }
    public static ArrayList<HeroType> getArrayHero(HashMap<GeneralHero,Object> map,GeneralHero generalHero){


        String temp=map.get(generalHero).toString();

        java.lang.reflect.Type empMapType = new TypeToken<ArrayList<HeroType>>() {}.getType();

        ArrayList<HeroType>list=new Gson().fromJson(temp,empMapType);

        return list;

    }



}
