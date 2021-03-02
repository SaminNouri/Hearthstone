package initialCard.settingGeneralMap;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import game.LoggerCreator;
import initialCard.enumClasses.General;
import initialSpell.enumSpellClasses.GeneralSpell;

/**
 * Created by Data on 3/7/2020.
 */

public class ReadingJsonFiles {


    private static String serialNumber;


    private static String filePath;


    public static HashMap<General,Object> getPropertyMap(String filePath)  {


        HashMap<General,Object> map=new HashMap<General,Object>();

        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            java.lang.reflect.Type empMapType = new TypeToken<HashMap<General, Object>>() {}.getType();

            map=new Gson().fromJson(bufferedReader,empMapType);




        }catch(Exception e)
        {
           LoggerCreator.logger.warning(e.toString()+"line:"+e.getStackTrace()[0].getLineNumber());
            e.printStackTrace();
        }


        return map;


    }


    //doesn t check whether it contains firstSpell or not

    public static HashMap<GeneralSpell,Object> getFirstSpellPropertyMap(HashMap<General,Object> generalMap){

        String temp=generalMap.get(General.Spell1).toString();


        java.lang.reflect.Type empMapType = new TypeToken<HashMap<GeneralSpell, Object>>() {}.getType();

        HashMap<GeneralSpell,Object> map=new Gson().fromJson(temp,empMapType);

        return map;

    }



    //doesn t check whether it contains secondSpell or not

    public static HashMap<GeneralSpell,Object> getSecondSpellPropertyMap(HashMap<General,Object> generalMap){

        String temp=generalMap.get(General.Spell2).toString();


        java.lang.reflect.Type empMapType = new TypeToken<HashMap<GeneralSpell, Object>>() {}.getType();

        HashMap<GeneralSpell,Object> map=new Gson().fromJson(temp,empMapType);

        return map;

    }


    //doesn t check whether it contains firstSpell or not

    public static HashMap<GeneralSpell,Object> getFirstInnerSpellPropertyMap(HashMap<GeneralSpell,Object> generalMap){

        String temp=generalMap.get(GeneralSpell.Spell1).toString();

        java.lang.reflect.Type empMapType = new TypeToken<HashMap<GeneralSpell, Object>>() {}.getType();

        HashMap<GeneralSpell,Object> map=new Gson().fromJson(temp,empMapType);


        return map;

    }

    //doesn t check whether it contains secondSpell or not

    public static HashMap<GeneralSpell,Object> getSecondInnerSpellPropertyMap(HashMap<GeneralSpell,Object> generalMap){

        String temp=generalMap.get(GeneralSpell.Spell2).toString();

        java.lang.reflect.Type empMapType = new TypeToken<HashMap<GeneralSpell, Object>>() {}.getType();

        HashMap<GeneralSpell,Object> map=new Gson().fromJson(temp,empMapType);

        return map;

    }









    public String getFilePath(){

        return filePath;
    }
    public String getSerialNumber(){

        return this.serialNumber;
    }





    public static void main(String[] args)
    {

    }





}
