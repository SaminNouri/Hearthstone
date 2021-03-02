package initialSpell.spell.spellTypes;

import game.GameContext;
import game.GameMapper;
import initialCard.card.Card;
import initialCard.card.HeroCard;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import targets.MyTargetHandler;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AddArmor extends ComplexSpell {


    public AddArmor(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
    }

    @Override
    public void performOnTargets(GameContext gameContext, Card card, Card selectedCard, ArrayList<Card> cards) {
        performOnTarget(null,null);
    }

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler) {
        ((HeroCard)GameMapper.getGameContext().getHero().getCard()).setArmor( ((HeroCard)GameMapper.getGameContext().getHero().getCard()).getArmor()+2);
        try {
            GameMapper.getBattlefieldController().update();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }
}
