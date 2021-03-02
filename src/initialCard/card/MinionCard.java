package initialCard.card;

import initialCard.enumClasses.General;
import initialCard.enumClasses.Type;
import initialCard.settingGeneralMap.SetMap;
import initialSpell.spell.spellTypes.Discover;


import java.util.HashMap;

/**
 * Created by Data on 3/9/2020.
 */
public class MinionCard extends Card
{
 private int baseHp;
    private static final Type type=Type.MinionCard;
    private int hp;
    private int baseAttack;
    private int attack;


    @Override
    public  Type getType() {
        return type;
    }

    public MinionCard(HashMap<General,Object> generalMap) throws Exception {

        super(generalMap);
        for(General key:General.values())
        {
            Object value=generalMap.get(key);
            if(generalMap.containsKey(key))
                try {
                    setFeature(key, value);
                }catch (Exception e){
                    e.printStackTrace();
                }
        }
        if(!generalMap.containsKey(General.Attack))
            attack=Integer.valueOf(generalMap.get(General.BaseAttack).toString());
        if(!generalMap.containsKey(General.Hp))
            hp=(Integer.valueOf(generalMap.get(General.BaseHp).toString()));
        for(General key:General.values())
        {
            Object value=generalMap.get(key);
            if(generalMap.containsKey(key))
                setFeature(key,value);
        }
        if(!generalMap.containsKey(General.Attack))
       attack=Integer.valueOf(generalMap.get(General.BaseAttack).toString());
        if(!generalMap.containsKey(General.Hp))
       hp=(Integer.valueOf(generalMap.get(General.BaseHp).toString()));


    }

    @Override
    public void setGeneralMap(HashMap<General,Object> map)
    {
        super.setGeneralMap(map);
        this.baseAttack= (int) map.get(General.BaseAttack);
        this.baseHp= (int) map.get(General.BaseHp);
        this.hp=baseHp;
        this.attack=baseAttack;
    }


    public MinionCard(HashMap<General,Object> generalMap,int hp,int attack) throws Exception {
        super(generalMap);
        this.setGeneralMap(generalMap);
        for(General key:General.values())
        {
            Object value=generalMap.get(key);
            if(generalMap.containsKey(key))
            {
                setFeature(key,value);
            }
        }
        this.hp=hp;
        this.attack=attack;

    }
    @Override
    public void setFeature(General key,Object value) throws Exception {
        super.setFeature(key,value);
        switch (key)
        {

            case Attack:
                setAttack(Integer.valueOf((value.toString())));
                break;
            case Hp:
                setHp(Integer.valueOf((value.toString())));
                break;
            case BaseAttack:
                setBaseAttack(Integer.valueOf((value.toString())));
                break;
            case BaseHp:
                setBaseHp(Integer.valueOf((value.toString())));
                break;
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.addElement(General.Attack,attack);
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.addElement(General.Hp,hp);
        this.hp = hp;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.addElement(General.BaseAttack,baseAttack);
        this.baseAttack = baseAttack;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(int baseHp) {
        this.addElement(General.BaseHp,baseHp);
        this.baseHp = baseHp;
    }




    public static void main(String[] args) throws Exception {

        Card card=new MinionCard(SetMap.setPropertyMap("Card_21"));
        System.out.println(((Discover)card.getSpell1()).getFilter().getClass().getSimpleName());
    }






}
