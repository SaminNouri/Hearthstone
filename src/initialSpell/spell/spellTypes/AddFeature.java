package initialSpell.spell.spellTypes;

import game.GameContext;
import initialCard.card.Card;
import initialCard.card.HeroCard;
import initialCard.card.MinionCard;
import initialCard.card.WeaponCard;
import initialCard.enumClasses.Feature;
import initialCard.enumClasses.Type;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import targets.MyTargetHandler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Data on 4/10/2020.
 */
public class AddFeature extends ComplexSpell {
    private HashMap<Feature,Object> addedFeatures;

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler) {

        if(target==null)
            return;
        for(Feature feature:Feature.values()){
          if(addedFeatures.containsKey(feature)) {
              if (!target.getFeaures().containsKey(feature)) {
                  target.getFeaures().put(feature,addedFeatures.get(feature));
              }
          }
        }

        if(addedFeatures.containsKey(Feature.ExtraAttack))
        {

            int value= (int) Math.round(Float.valueOf(addedFeatures.get(Feature.ExtraAttack)+"" ));
            if(target.getType()== Type.MinionCard)
                ((MinionCard)target).setAttack(((MinionCard)target).getAttack()+value);
            if(target.getType()== Type.WeaponCard)
                ((WeaponCard)target).setAttack(((WeaponCard)target).getAttack()+value);
        }
        if(addedFeatures.containsKey(Feature.ExtraHp))
        {
            int value= (int) Math.round(Float.valueOf(addedFeatures.get(Feature.ExtraHp)+"" ));
            if(target.getType()== Type.MinionCard)
                ((MinionCard)target).setHp(((MinionCard)target).getHp()+value);
            if(target.getType()== Type.HeroCard)
                ((HeroCard)target).setHp(((HeroCard)target).getHp()+value);
        }


    }
    public AddFeature(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
        addedFeatures=new HashMap<Feature,Object>();
        if(generalSpell.containsKey(GeneralSpell.AddedFeature)) {
            addedFeatures = (HashMap<Feature, Object>) generalSpell.get(GeneralSpell.AddedFeature);
        }


    }



}
