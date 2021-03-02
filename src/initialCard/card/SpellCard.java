package initialCard.card;

import initialCard.enumClasses.General;
import initialCard.settingGeneralMap.SetMap;
import initialSpell.spell.spellTypes.Discover;


import java.util.HashMap;

/**
 * Created by Data on 3/9/2020.
 */
public class SpellCard extends Card
{


    public SpellCard(HashMap<General, Object> general) throws Exception {
        super(general);
    }


 public static void main(String[] args) throws Exception {
     Card card=new SpellCard(SetMap.setPropertyMap("Card_19"));
     System.out.println(((Discover)card.getSpell1()).getSpell1FirstInnerSpell().getClass().getSimpleName());
 }


}
