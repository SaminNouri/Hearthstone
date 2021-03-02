package initialSpell.spell.spellTypes;

import cardList.CardList;
import characters.Minion;
import characters.MyCharacter;
import game.GameContext;
import graphics.CardLocation;
import initialCard.card.Card;
import initialCard.card.MinionCard;
import initialCard.card.cardFactory.CardCreator;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import targets.MyTargetHandler;

import java.util.HashMap;

/**
 * Created by Data on 3/9/2020.
 */
public class TransformSpell extends ComplexSpell
{
    private  String to;
    private Character target;
    private Card toCard;

    public TransformSpell(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
        if(generalSpell.containsKey(GeneralSpell.To)) {
            setTo((String) generalSpell.get(GeneralSpell.To));
            System.out.println("toooooooo:"+ generalSpell.get(GeneralSpell.To));
            toCard=CardCreator.createCardWithSerialNumber(to);
        }


    }

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler) {

         Integer playerIndex=target.getOwnerIndex();
         CardLocation cardLocation=target.getCardLocation();
        ((MinionCard)target).setGeneralMap(((MinionCard)toCard).getGeneralMap());
        target.setOwnerIndex(playerIndex);
       target.setCardLocation(cardLocation);
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.addSpellElement(GeneralSpell.To,to);
        this.to = to;
    }

    public boolean isAllowed(){
           return true;
    }

    public void performAction(GameContext gameContext, MinionCard minion) throws Exception {

        int index=minion.getOwnerIndex();
        CardLocation cardLocation=minion.getCardLocation();
        int id=minion.getId();
        minion=(MinionCard) CardCreator.createCardWithName(to);
        minion.setOwnerIndex(index);
        minion.setCardLocation(cardLocation);
        minion.setId(id);

    }
}
