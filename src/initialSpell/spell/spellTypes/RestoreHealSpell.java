package initialSpell.spell.spellTypes;

import game.GameMapper;
import initialCard.card.Card;
import initialCard.card.HeroCard;
import initialCard.card.MinionCard;
import initialCard.card.WeaponCard;
import initialCard.enumClasses.Type;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import sun.awt.AWTAccessor;
import targets.MyTargetHandler;

import java.util.HashMap;

/**
 * Created by Data on 4/10/2020.
 */
public class RestoreHealSpell extends ComplexSpell {
    private int value;
    public RestoreHealSpell(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
        if(generalSpell.containsKey(GeneralSpell.Value))
            setValue(Integer.valueOf(generalSpell.get(GeneralSpell.Value).toString()) );
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler) {
        if(GameMapper.getGameContext().getHero().getName().equals("Gul-Dan"))
            value*=2;
        if(target.getType()== Type.MinionCard)
           if(((MinionCard)target).getHp()+value<=((MinionCard)target).getBaseHp())
               ((MinionCard)target).setHp(((MinionCard)target).getHp()+value);
           else
               ((MinionCard)target).setHp(((MinionCard)target).getBaseHp());
        if(target.getType()== Type.WeaponCard)
            if(((WeaponCard)target).getDurability()+value<=((WeaponCard)target).getBaseDurability())
                ((WeaponCard)target).setDurability(((WeaponCard)target).getDurability()+value);
            else
                ((WeaponCard)target).setDurability(((WeaponCard)target).getBaseDurability());
        if(target.getType()== Type.HeroCard)
            if(((HeroCard)target).getHp()+value<=((HeroCard)target).getBaseHp())
                ((HeroCard)target).setHp(((HeroCard)target).getHp()+value);
            else
                ((HeroCard)target).setHp(((HeroCard)target).getBaseHp());
    }
}
