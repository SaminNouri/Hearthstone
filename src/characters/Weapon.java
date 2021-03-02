package characters;

import initialCard.card.Card;
import initialCard.card.WeaponCard;

/**
 * Created by Data on 3/13/2020.
 */
public class Weapon extends MyCharacter{

    private int BaseDurability;
    private int baseAttack;
    private int durability;
    private int attack;

    public Weapon(Card card) {
        super(card);
        BaseDurability=((WeaponCard)card).getBaseDurability();
        baseAttack=((WeaponCard)card).getBaseAttack();
        durability=BaseDurability;
        attack=baseAttack;

    }

    public int getBaseDurability() {
        return BaseDurability;
    }

    public void setBaseDurability(int baseDurability) {
        BaseDurability = baseDurability;
        ((WeaponCard)card).setBaseDurability(baseDurability);
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
        ((WeaponCard)card).setBaseAttack(baseAttack);
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
        ((WeaponCard)card).setDurability(durability);
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
        ((WeaponCard)card).setAttack(attack);
    }
}
