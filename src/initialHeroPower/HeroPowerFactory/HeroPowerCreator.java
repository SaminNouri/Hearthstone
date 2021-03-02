package initialHeroPower.HeroPowerFactory;

import initialCard.enumClasses.General;
import initialCard.settingGeneralMap.ReadingJsonFiles;
import initialCard.settingGeneralMap.SetMap;
import initialHeroPower.HeroPower;
import resources.CardPaths;

import java.util.HashMap;

/**
 * Created by Data on 3/13/2020.
 */
public class HeroPowerCreator
{
    public static HeroPower createWithMap(HashMap<General,Object> map) throws Exception{
        return new HeroPower(map);

    }
    public static HeroPower createWithName(String name) throws Exception{

    String path= CardPaths.getPathByName(name);
    HashMap<General,Object> temp= ReadingJsonFiles.getPropertyMap(path);
    HashMap<General,Object> map=(HashMap<General,Object>) SetMap.setPropertyMap(temp);
    return HeroPowerCreator.createWithMap(map);
}
    public static HeroPower createWithSerialNumber(String serialNumber) throws Exception{
        String path= CardPaths.getPathBySerialNumber(serialNumber);
        HashMap<General,Object> temp= ReadingJsonFiles.getPropertyMap(path);
        HashMap<General,Object> map=(HashMap<General,Object>) SetMap.setPropertyMap(temp);
        return HeroPowerCreator.createWithMap(map);
    }
    public static void main(String[] args) throws Exception {

        HeroPower heroPower=HeroPowerCreator.createWithSerialNumber("heropower_4");
        System.out.println(heroPower.getSpell1().getGeneralSpellMap());
    }
}
