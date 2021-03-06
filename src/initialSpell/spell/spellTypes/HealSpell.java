package initialSpell.spell.spellTypes;


import initialCard.card.Card;
import initialCard.card.HeroCard;
import initialCard.card.MinionCard;
import initialCard.card.WeaponCard;
import initialCard.enumClasses.Type;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.enumSpellClasses.SpellType;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import targets.MyTargetHandler;

import java.util.HashMap;

/**
 * Created by Data on 3/9/2020.
 */
public class HealSpell extends ComplexSpell {
    private  SpellType spellType=SpellType.HealSpell;
    private int value;

    public HealSpell(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
        if(generalSpell.containsKey(GeneralSpell.Value))
            setValue(Integer.valueOf(generalSpell.get(GeneralSpell.Value).toString()));
    }

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler) {
          System.out.println();
        System.out.println("mewwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        System.out.println(target);
        System.out.println();
        if(target.getType()== Type.MinionCard)
                ((MinionCard)target).setHp(((MinionCard)target).getHp()+value);
        if(target.getType()== Type.WeaponCard)
                ((WeaponCard)target).setDurability(((WeaponCard)target).getDurability()+value);
        if(target.getType()== Type.HeroCard)
                ((HeroCard)target).setHp(((HeroCard)target).getHp()+value);


    }

    public  SpellType getSpellType() {
        return spellType;
    }
    @Override
    public void setSpellType(SpellType spellType){

    }



    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.addSpellElement(GeneralSpell.Value,value);
        this.value = value;
    }
}
