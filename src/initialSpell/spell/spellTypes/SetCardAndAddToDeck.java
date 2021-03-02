package initialSpell.spell.spellTypes;


import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.enumSpellClasses.SpellType;
import initialSpell.enumSpellClasses.Target;
import initialSpell.spell.*;

import java.util.HashMap;


public class SetCardAndAddToDeck extends ComplexSpell
{
    private static final SpellType spellType=SpellType.SetCardAndAddToDeck;
    private SetWeaponsNumericalFeatures spell1;
    private   AddTo spell2;



    public SetCardAndAddToDeck(HashMap<GeneralSpell, Object> generalSpell) throws Exception {
        super(generalSpell);
        if(generalSpell.containsKey(GeneralSpell.Spell1))
            setSpell1((HashMap<GeneralSpell, Object>) generalSpell.get(GeneralSpell.Spell1));
        if(generalSpell.containsKey(GeneralSpell.Spell2))
            setSpell1((HashMap<GeneralSpell, Object>) generalSpell.get(GeneralSpell.Spell2));


    }
    @Override
    public void setSpellType(SpellType spellType)  {

    }



    @Override
    public void setFeature(GeneralSpell key, Object value) throws Exception {
        switch (key)
        {
            case Spell1:
                if(value.getClass().getSimpleName().equals("SetWeaponsNumericalFeatures"))
                    setSpell1((SetWeaponsNumericalFeatures) value);
                else
                    setSpell1((HashMap<GeneralSpell, Object>) value);
                break;
            case Spell2:
                if(value.getClass().getSimpleName().equals("AddTo"))
                    setSpell2((AddTo) value);
                else
                    setSpell1((HashMap<GeneralSpell, Object>) value);
                break;



        }
    }


    public SetWeaponsNumericalFeatures getSpell1() {
        return spell1;
    }

    public void setSpell1(SetWeaponsNumericalFeatures spell1) {
        this.spell1 = spell1;
    }
    public void setSpell1(HashMap<GeneralSpell,Object> map) throws Exception {

        SetWeaponsNumericalFeatures temp=new SetWeaponsNumericalFeatures(map);
        spell1=temp;

    }
    public  void setSpell2(HashMap<GeneralSpell,Object> map) throws Exception {

        AddTo temp=new AddTo(map);
        this.spell2=temp;

    }

    public  AddTo getSpell2() {
        return spell2;
    }

    public  void setSpell2(AddTo spell2) {
        this.spell2 = spell2;
    }
}
