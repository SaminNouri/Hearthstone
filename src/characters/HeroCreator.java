package characters;

import initialCard.card.Card;
import initialCard.card.HeroCard;
import initialCard.card.cardFactory.CardCreator;
import initialCard.enumClasses.General;
import initialCard.settingGeneralMap.ReadingJsonFiles;
import initialCard.settingGeneralMap.SetMap;
import initialSpell.spell.ComplexSpell;
import resources.CardPaths;

import java.util.HashMap;

/**
 * Created by Data on 3/16/2020.
 */
public class HeroCreator
{
    public  static  Hero createHeroWithName(String name) throws Exception{
        System.out.print(name);
        String path= CardPaths.getPathByName(name);
        HashMap<General,Object> temp= ReadingJsonFiles.getPropertyMap(path);
        HashMap<General,Object> map=(HashMap<General,Object>) SetMap.setPropertyMap(temp);
        HeroCard card=(HeroCard) CardCreator.createCardWithMap(map);
        Hero h=new Hero(card);
        return h;
    }
    public static void main(String[] args) throws Exception{
        Hero h=HeroCreator.createHeroWithName("WARLOCK");
        System.out.println("thisssssss"+((ComplexSpell)h.getHeroPower().getSpell2()).getSpell1SecondInnerSpell().getGeneralSpellMap());
    }
}
