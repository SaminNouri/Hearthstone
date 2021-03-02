package initialCard.settingGeneralMap;

import collection.enumCollectionClasses.GeneralCollection;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import game.LoggerCreator;
import initialCard.card.SpellCard;
import initialCard.enumClasses.*;
import initialSpell.enumSpellClasses.*;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import initialSpell.spell.condition.GeneralCondition;
import initialSpell.spell.spellTypes.Discover;
import initialSpell.spell.spellTypes.RandonSpell;
import initialSpell.spell.spellTypes.Steal;


import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


public class SetMap {


    public static HashMap<General,Object> getPropertyMap(String filePath){


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


    public static HashMap<General,Object> setPropertyMap(String serialNumber){

        HashMap<General,Object> map=ReadingJsonFiles.getPropertyMap(serialNumber);


        HashMap<General,Object> ans=new HashMap<General,Object>();


        for(General g:General.values())
        {

            if(map.containsKey(g))
            {
                if(map.get(g).getClass().getSimpleName().equals("Double"))
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
                if(g.equals(General.Description)  || General.Name.equals(g) || General.SerialNumber.equals(g) )
                {
                    ans.put(g,(String)map.get(g));
                }
                if(General.HeroType.equals(g))
                {
                    HeroType h=HeroType.valueOf((String)map.get(g));
                    ans.put(g,h);

                }
                if(General.Rarity.equals(g))
                {
                    Rarity r=Rarity.valueOf((String)map.get(g));
                    ans.put(g,r);

                }
                if(General.Race.equals(g))
                {
                    Race r=Race.valueOf((String)map.get(g));
                    ans.put(g,r);

                }
                if(General.Spell1.equals(g))
                {
                    HashMap<GeneralSpell,Object> temp=ReadingJsonFiles.getFirstSpellPropertyMap(map);
                    HashMap<GeneralSpell,Object> tempSpell=SetMap.setSpellPropertyMap(temp);
                    ans.put(g,tempSpell);

                }
                if(General.Spell2.equals(g))
                {
                    HashMap<GeneralSpell,Object> temp=ReadingJsonFiles.getSecondSpellPropertyMap(map);
                    HashMap<GeneralSpell,Object> tempSpell=SetMap.setSpellPropertyMap(temp);
                    ans.put(g,tempSpell);

                }



            }


        }

        return ans;

    }



    public static HashMap<General,Object> setPropertyMap(HashMap<General,Object> map){

        HashMap<General,Object> ans=new HashMap<General,Object>();

        for(General g:General.values())
        {

            if(map.containsKey(g))
            {
                if(map.get(g).getClass().getSimpleName().equals("Double"))
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
                if(g.equals(General.Description)  || General.Name.equals(g) || General.SerialNumber.equals(g) )
                {
                    ans.put(g,(String)map.get(g));
                }
                if(General.HeroType.equals(g))
                {
                    HeroType h=HeroType.valueOf((String)map.get(g));
                    ans.put(g,h);

                }
                if(General.Rarity.equals(g))
                {
                    Rarity r=Rarity.valueOf((String)map.get(g));
                    ans.put(g,r);

                }
                if(General.Race.equals(g))
                {
                    Race r=Race.valueOf((String)map.get(g));
                    ans.put(g,r);

                }
                if(General.Spell1.equals(g))
                {
                    HashMap<GeneralSpell,Object> temp=ReadingJsonFiles.getFirstSpellPropertyMap(map);
                    HashMap<GeneralSpell,Object> tempSpell=SetMap.setSpellPropertyMap(temp);
                    ans.put(g,tempSpell);

                }
                if(General.Spell2.equals(g))
                {
                    HashMap<GeneralSpell,Object> temp=ReadingJsonFiles.getSecondSpellPropertyMap(map);
                    HashMap<GeneralSpell,Object> tempSpell=SetMap.setSpellPropertyMap(temp);
                    ans.put(g,tempSpell);

                }
                if(General.Type.equals(g))
                {

                    Type r= Type.valueOf((String)map.get(g));
                    ans.put(g,r);


                }
                if(General.HeroPower.equals(g))
                {


                    String r=((String)map.get(g));
                    ans.put(g,r);


                }




            }


        }

        return ans;

    }


    public static HashMap<GeneralSpell,Object> setSpellPropertyMap(HashMap<GeneralSpell,Object> map)
    {


        HashMap<GeneralSpell,Object> ans=new HashMap<GeneralSpell,Object>();


        for(GeneralSpell g:GeneralSpell.values())
        {

            if(map.containsKey(g))
            {
                //System.out.println(g+" "+map.get(g));
               // System.out.println("ans: "+ans);
                if(map.get(g).getClass().getSimpleName().equals("Double"))
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
                if(g.equals(GeneralSpell.To.equals(g))  ) {
                    ans.put(g, (String) map.get(g));
                }

                if(GeneralSpell.Spell1.equals(g))
                {
                   HashMap<GeneralSpell,Object> temp=ReadingJsonFiles.getFirstInnerSpellPropertyMap(map);
                    HashMap<GeneralSpell,Object> tempSpell=SetMap.setSpellPropertyMap(temp);
                    ans.put(g,tempSpell);

                }
                if(GeneralSpell.Spell2.equals(g))
                {
                    HashMap<GeneralSpell,Object> temp=ReadingJsonFiles.getSecondInnerSpellPropertyMap(map);
                    HashMap<GeneralSpell,Object> tempSpell=SetMap.setSpellPropertyMap(temp);
                    ans.put(g,tempSpell);

                }
                if(GeneralSpell.Target.equals(g))
                {
                    initialSpell.enumSpellClasses.Target t= Target.valueOf((String)map.get(g));
                    ans.put(g,t);

                }
                if(GeneralSpell.SelectiveTarget.equals(g))
                {
                    SelectiveTarget s=SelectiveTarget.valueOf((String)map.get(g));
                    ans.put(g,s);

                }
                if(GeneralSpell.SpellType.equals(g))
                {

                    SpellType  s= SpellType.valueOf((String)map.get(g));
                    ans.put(g,s);

                }
                if(GeneralSpell.Filter.equals(g))
                {
                    String temp=map.get(GeneralSpell.Filter).toString();

                    java.lang.reflect.Type empMapType = new TypeToken<HashMap<General, Object>>() {}.getType();

                    HashMap<General,Object> t=new Gson().fromJson(temp,empMapType);

                    ans.put(g,t);
                }
                if(GeneralSpell.To.equals(g))
                {
                    String s= ((String)map.get(g));
                    ans.put(g,s);

                }
                if(GeneralSpell.From.equals(g))
                {
                    From s= From.valueOf((String)map.get(g));
                    ans.put(g,s);

                }
                if(GeneralSpell.AddedFeature.equals(g))
                {
                    String temp=map.get(GeneralSpell.AddedFeature).toString();

                    java.lang.reflect.Type empMapType = new TypeToken<HashMap<Feature, Object>>() {}.getType();

                    HashMap<General,Object> t=new Gson().fromJson(temp,empMapType);

                    ans.put(g,t);
                }
                if(GeneralSpell.AddedTo.equals(g))
                {
                    String temp=map.get(GeneralSpell.AddedTo).toString();

                    java.lang.reflect.Type empMapType = new TypeToken<ArrayList<String>>() {}.getType();

                    ArrayList<String> t=new Gson().fromJson(temp,empMapType);

                    ans.put(g,t);
                }
                if(GeneralSpell.Condition.equals(g))
                {

                    String temp=map.get(GeneralSpell.Condition).toString();


                    java.lang.reflect.Type empMapType = new TypeToken<HashMap<GeneralCondition,Object>>() {}.getType();

                    HashMap<GeneralCondition,Object> t=new Gson().fromJson(temp,empMapType);

                    ans.put(g,t);
                }
                if(GeneralSpell.Filter.equals(g))
                {


                    String temp=map.get(GeneralSpell.Filter).toString();

                    java.lang.reflect.Type empMapType = new TypeToken<HashMap<General,Object>>() {}.getType();

                    HashMap<General,Object> t=new Gson().fromJson(temp,empMapType);

                    ans.put(g,t);
                }



            }


        }
        return ans;

    }





}