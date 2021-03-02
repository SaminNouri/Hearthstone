package initialSpell.spell.spellFactory;

import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.enumSpellClasses.SpellType;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import initialSpell.spell.spellTypes.*;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.HashMap;

/**
 * Created by Data on 3/11/2020.
 */
public class SpellCreator {
    public static Spell create(HashMap<GeneralSpell, Object> map) throws Exception {
        if (map.containsKey(GeneralSpell.SpellType)) {
            SpellType spellType = (SpellType) map.get(GeneralSpell.SpellType);
            switch (spellType) {
                case AddTo:
                    return new AddTo(map);
                //break;
                case Discover:
                    return new Discover(map);
                // break;
                case DamageSpell:
                    return new DamageSpell(map);
                // break;
                case TransformSpell:
                    return new TransformSpell(map);
                //break;
                case HealSpell:
                    return new HealSpell(map);
                //break;
                case SetCardAndAddToDeck:
                    return new SetCardAndAddToDeck(map);
                //break;
                case SetHeroPowerMaxUse:
                    return new SetHeroPowerMaxUse(map);
                //break;
                case SetHpSpell:
                    return new SetHpSpell(map);
                //break;
                case AddWeaponsNumericalFeatures:
                    return new SetHpSpell(map);
                //break;
                case ComplexSpell:
                    return new ComplexSpell(map);
                //break;
                case ConditionalSpell:
                    return new ConditionalSpell(map);
                //break;
                case DrawCard:
                    return new DrawCard(map);
                //break;
                case RandomSpell:
                    return new RandonSpell(map);
                //break;
                case StealAndAdd:
                    return new StealAndAdd(map);
                //break;
                case Steal:
                    return new Steal(map);
                //break;
                case AddFeature:
                    return new AddFeature(map);
                case RestoreHealSpell:
                    return new RestoreHealSpell(map);
                case DiscardSpell:
                    return new DiscardSpell(map);
                case Summon:
                    return new Summon(map);
                case QuestAndReward:
                    return new ComplexSpell(map);
                case  MinionCostLess:
                    return new MinionCostLess(map);
                case CostLessHeroPower:
                    return new CostLessHeroPower(map);
                case AddMana:
                    return new AddMana(map);
                case AddArmor:
                    return new AddArmor(map);
            }
        }
        return null;

    }
}