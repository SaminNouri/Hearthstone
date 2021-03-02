package initialSpell.spell.spellTypes;

import game.GameMapper;
import initialCard.card.Card;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import targets.MyTargetHandler;

import java.util.HashMap;

/**
 * Created by Data on 4/10/2020.
 */
public class Summon extends ComplexSpell {
    public Summon(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
    }

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler) {

        GameMapper.setSummoningCard(target);
        try {
            GameMapper.getInstance().addRequest(GameMapper.RequestType.Summon_Spell_Card);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
