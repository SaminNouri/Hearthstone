package initialSpell.spell.spellTypes;

import game.GameContext;
import game.GameMapper;
import initialCard.card.Card;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.enumSpellClasses.SpellType;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import targets.MyTargetHandler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Data on 3/9/2020.
 */
public class SetHeroPowerMaxUse extends ComplexSpell
{
    private final SpellType spellType=SpellType.SetHeroPowerMaxUse;
    private int value;

    public SetHeroPowerMaxUse(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
        if(generalSpell.containsKey(GeneralSpell.Value))
            this.setValue(Integer.valueOf(generalSpell.get(GeneralSpell.Value).toString()));
    }

    @Override
    public void performOnTargets(GameContext gameContext, Card card, Card selectedCard, ArrayList<Card> cards) {
        performOnTarget(card,null);
    }

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler) {
       GameMapper.getGameContext().getHero().getHeroPower().setAllowedNumberOfUsesPerTurn(GameMapper.getGameContext().getHero().getHeroPower().getAllowedNumberOfUsesPerTurn()+1);
    }

    public SpellType getSpellType() {
        return spellType;
    }
    @Override
    public void setSpellType(SpellType spellType) {

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.addSpellElement(GeneralSpell.Value,value);
        this.value = value;
    }
}
