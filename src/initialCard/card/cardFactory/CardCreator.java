package initialCard.card.cardFactory;

import initialCard.card.*;
import initialCard.enumClasses.General;
import initialCard.enumClasses.Type;
import initialCard.settingGeneralMap.ReadingJsonFiles;
import initialCard.settingGeneralMap.SetMap;
import initialSpell.spell.ComplexSpell;
import resources.CardPaths;

import javax.annotation.Resource;

import java.util.HashMap;

public class CardCreator {


    public static Card createCardWithMap(HashMap<General, Object> map) throws Exception {
        if (map.containsKey(General.Type)) {
            Type type = (Type) map.get(General.Type);
            switch (type) {
                case MinionCard:
                    return new MinionCard(map);
                //break;
                case SpellCard:
                    return new SpellCard(map);
                // break;
                case WeaponCard:
                    return new WeaponCard(map);
                // break;
                case HeroCard:
                    return new HeroCard(map);
                // break;

            }
        }
        return null;

    }

    public static Card createCardWithName(String name) throws Exception {

        String path=CardPaths.getPathByName(name);
        HashMap<General,Object> temp= ReadingJsonFiles.getPropertyMap(path);
        HashMap<General,Object> map=(HashMap<General,Object>) SetMap.setPropertyMap(temp);
        return CardCreator.createCardWithMap(map);

    }
    public static Card createCardWithSerialNumber(String serialNumber) throws Exception {

        String path=CardPaths.getPathBySerialNumber(serialNumber);
        HashMap<General,Object> temp= ReadingJsonFiles.getPropertyMap(path);
        HashMap<General,Object> map=(HashMap<General,Object>) SetMap.setPropertyMap(temp);
        return  CardCreator.createCardWithMap(map);


    }
    public static void main(String[] args) throws Exception{
        Card card;
            card = CardCreator.createCardWithName("Locusts");
         System.out.println("final"+card.isRush());


    }
}