package initialCard.card;

import initialCard.enumClasses.General;
import initialCard.enumClasses.Type;

import java.util.HashMap;

/**
 * Created by Data on 3/9/2020.
 */
public class WeaponCard extends Card
{
     private int BaseDurability;
     private int baseAttack;
     private int durability;
     private int attack;
     private static final Type type=Type.WeaponCard;

    @Override
    public Type getType() {
        return type;
    }

    public WeaponCard(HashMap<General, Object> generalMap) throws Exception {

        super(generalMap);
        this.setGeneralMap(generalMap);
        for(General key:General.values())
        {
            Object value=generalMap.get(key);
            if(generalMap.containsKey(key))
                setFeature(key,value);
        }
        if(!generalMap.containsKey(General.Attack))
            attack=Integer.valueOf(generalMap.get(General.BaseAttack).toString());
        if(!generalMap.containsKey(General.Durability))
            durability=Integer.valueOf(generalMap.get(General.BaseDurability).toString());
    }

    @Override
    public void setFeature(General key,Object value) throws Exception {
        super.setFeature(key,value);
        switch (key)
        {

            case Attack:
                setAttack(Integer.valueOf(value.toString()));
                break;
            case Durability:
                setDurability(Integer.valueOf(value.toString()));
                break;
            case BaseAttack:
                setBaseAttack(Integer.valueOf(value.toString()));
                break;
            case BaseDurability:
                setBaseDurability(Integer.valueOf(value.toString()));
                break;
        }
    }



    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.addElement(General.BaseAttack,baseAttack);
        this.baseAttack = baseAttack;
    }

    public int getBaseDurability() {
        return BaseDurability;
    }

    public void setBaseDurability(int baseDurability) {
        this.addElement(General.BaseDurability,baseDurability);
        BaseDurability = baseDurability;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.addElement(General.Attack,attack);
        this.attack = attack;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.addElement(General.Durability,durability);
        this.durability = durability;
    }
}
