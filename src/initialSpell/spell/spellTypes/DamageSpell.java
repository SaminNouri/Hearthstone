package initialSpell.spell.spellTypes;

import characters.Minion;
import characters.Weapon;
import game.GameContext;
import graphics.CardLocation;
import initialCard.card.Card;
import initialCard.card.HeroCard;
import initialCard.card.MinionCard;
import initialCard.card.WeaponCard;
import initialCard.card.cardFactory.CardCreator;
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
public class DamageSpell extends ComplexSpell {

    private  SpellType spellType=SpellType.DamageSpell;
    private int value;

    public DamageSpell(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
        if(generalSpell.containsKey(GeneralSpell.Value))
            setValue(Integer.valueOf(generalSpell.get(GeneralSpell.Value).toString()) );
    }

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler) {
        if(target.getType()== Type.MinionCard)
            ((MinionCard)target).setHp(((MinionCard)target).getHp()-value);
        if(target.getType()== Type.HeroCard)
            ((HeroCard)target).setHp(((HeroCard)target).getHp()-value);
        if(target.getType()== Type.WeaponCard)
            ((WeaponCard)target).setDurability(((WeaponCard)target).getDurability()-value);
        myTargetHandler.getGameContext().getLogic().checkForDeadCards();

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

    public boolean isAllowed(){
        return true;
    }

    public void performAction(GameContext gameContext, MinionCard target) throws Exception {

      if(!isAllowed()){
          return;
      }
      target.setHp(target.getHp()-value);
      gameContext.getLogic().checkForDeadCards();

    }
}
