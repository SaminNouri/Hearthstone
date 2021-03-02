package initialCard.card;

import initialCard.enumClasses.General;
import initialCard.enumClasses.Type;
import initialHeroPower.HeroPower;
import initialHeroPower.HeroPowerFactory.HeroPowerCreator;

import java.util.HashMap;

/**
 * Created by Data on 3/13/2020.
 */
public class HeroCard extends Card
{
    private final Type type=Type.HeroCard;
    private int baseHp;
    private int hp;
    private HeroPower heroPower;
    private int armor=0;

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public HeroCard(HashMap<General, Object> general) throws Exception {
        super(general);
        try {
            if (general.containsKey(General.BaseHp))
                this.baseHp = Integer.valueOf((general.get(General.BaseHp)).toString());
            if (general.containsKey(General.Hp))
                this.hp = Integer.valueOf((general.get(General.Hp)).toString());
            else
                this.hp = baseHp;
            try {
                heroPower = HeroPowerCreator.createWithName(general.get(General.HeroPower).toString());
            }catch(Exception e){

            };


        }catch (Exception e){}
    }
    @Override
    public void setType(Type type){

    }

    public HeroPower getHeroPower() {
        return heroPower;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        addElement(General.Hp,hp);
        this.hp = hp;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(int initialHp) {
        addElement(General.BaseHp,initialHp);
        this.baseHp = initialHp;
    }

    @Override
    public Type getType() {
        return type;
    }
}
