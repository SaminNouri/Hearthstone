package initialSpell.spell;

import initialCard.card.Card;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.enumSpellClasses.Target;
import initialSpell.spell.spellFactory.SpellCreator;
import targets.MyTargetHandler;

import java.lang.Exception;

import java.util.Collection;
import java.util.HashMap;

//contains spell creation!
public   class ComplexSpell extends Spell
{
    private ComplexSpell spell1FirstInnerSpell;
    private ComplexSpell spell1SecondInnerSpell;

    //private Spell spell2FirstInnerSpell;
    //private Spell spell2SecondInnerSpell;


    public ComplexSpell(HashMap<GeneralSpell, Object> generalSpell) throws Exception {

        super(generalSpell);
        if(generalSpell.containsKey(GeneralSpell.Spell1))
            setSpell1FirstInnerSpell((HashMap<GeneralSpell, Object>) generalSpell.get(GeneralSpell.Spell1));
        if(generalSpell.containsKey(GeneralSpell.Spell2))
            setSpell1SecondInnerSpell((HashMap<GeneralSpell, Object>) generalSpell.get(GeneralSpell.Spell2));

    }

    @Override
    public void performOnTarget(Card target, MyTargetHandler myTargetHandler) {

    }


    @Override
    public void setFeature(GeneralSpell key, Object value) throws Exception {
        switch (key)
        {
            case Spell1:
                if(value instanceof Spell)
                    setSpell1FirstInnerSpell((ComplexSpell) value);
                else
                    setSpell1FirstInnerSpell((HashMap<GeneralSpell, Object>) value);
                break;
            case Spell2:
                if(value instanceof Spell)
                    setSpell1FirstInnerSpell((ComplexSpell) value);
                else
                    setSpell1FirstInnerSpell((HashMap<GeneralSpell, Object>) value);
                break;

        }
    }

    public Spell getSpell1FirstInnerSpell() {
        return spell1FirstInnerSpell;
    }

    public void setSpell1FirstInnerSpell(ComplexSpell spell1FirstInnerSpell) {
        this.addSpellElement(GeneralSpell.Spell1,spell1FirstInnerSpell.getGeneralSpellMap());
        this.spell1FirstInnerSpell = spell1FirstInnerSpell;
    }

    public Spell getSpell1SecondInnerSpell() {
        return spell1SecondInnerSpell;
    }

    public void setSpell1SecondInnerSpell(ComplexSpell spell1SecondInnerSpell) {
        this.addSpellElement(GeneralSpell.Spell2,spell1SecondInnerSpell.getGeneralSpellMap());
        this.spell1SecondInnerSpell = spell1SecondInnerSpell;
    }
    public void setSpell1SecondInnerSpell(HashMap<GeneralSpell,Object> map) throws Exception {
        this.addSpellElement(GeneralSpell.Spell2,map);
        this.spell1SecondInnerSpell = (ComplexSpell) SpellCreator.create(map);
    }
    public void setSpell1FirstInnerSpell(HashMap<GeneralSpell,Object> map) throws Exception {
        this.addSpellElement(GeneralSpell.Spell1,map);
        this.spell1FirstInnerSpell = (ComplexSpell)SpellCreator.create(map);
    }

}
