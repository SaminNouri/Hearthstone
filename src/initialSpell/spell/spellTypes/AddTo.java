package initialSpell.spell.spellTypes;


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
public class AddTo extends ComplexSpell {
    private static final SpellType   spellType=SpellType.AddTo;
    private ArrayList<String> to;





    public AddTo(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
        if(generalSpell.containsKey(GeneralSpell.AddedTo))
            to= (ArrayList<String>) generalSpell.get(GeneralSpell.AddedTo);

    }

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler) {
        if(to.contains("Battlefield"))
        {
            GameMapper.setSummoningCard(target);
            try {
                GameMapper.getInstance().addRequest(GameMapper.RequestType.Summon_Spell_Card);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(to.contains("Deck"))
        {
            myTargetHandler.getGameContext().getCurrentHand().getCards().add(target);
            try {
                GameMapper.getBattlefieldController().update();;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(to.contains("Hand"))
        {
            myTargetHandler.getGameContext().getCurrentHand().getHandsCards().add(target);
            try {
                GameMapper.getBattlefieldController().update();;
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }


}
