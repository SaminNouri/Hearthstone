package Events;

import characters.Hero;
import characters.Minion;
import characters.MyCharacter;
import characters.Weapon;
import game.GameContext;
import game.GameMapper;
import initialCard.card.Card;
import initialCard.card.HeroCard;
import initialCard.card.MinionCard;
import initialCard.card.WeaponCard;
import initialCard.enumClasses.Feature;
import initialCard.enumClasses.Type;
import initialSpell.spell.condition.ConditionHandler;

import java.util.ArrayList;

public class WeaponAttackEvent extends GameEvent {

    private Weapon attacker;
    private Card hurtCard;
    private WeaponCard attackerCard;
    private MyCharacter hurt;
    private int damageToAttacker=0;
    private int damageToHurt=0;


    public Weapon getAttacker() {
        return attacker;
    }

    public void setAttacker(Weapon attacker) {
        this.attacker = attacker;
    }

    public Card getHurtCard() {
        return hurtCard;
    }

    public void setHurtCard(Card hurtCard) {
        this.hurtCard = hurtCard;
    }

    public WeaponCard getAttackerCard() {
        return attackerCard;
    }

    public void setAttackerCard(WeaponCard attackerCard) {
        this.attackerCard = attackerCard;
    }

    public int getDamageToAttacker() {
        return damageToAttacker;
    }

    public void setDamageToAttacker(int damageToAttacker) {
        this.damageToAttacker = damageToAttacker;
    }

    public int getDamageToHurt() {
        return damageToHurt;
    }

    public void setDamageToHurt(int damageToHurt) {
        this.damageToHurt = damageToHurt;
    }

    public MyCharacter getHurt() {
        return hurt;
    }

    public void setHurt(MyCharacter hurt) {
        this.hurt = hurt;
    }

    public WeaponAttackEvent(Weapon attacker, MyCharacter hurt, GameContext gameContext) {
        this.attacker = attacker;
        attackerCard=(WeaponCard) attacker.getCard();
        this.hurt=hurt;
        Card card=hurt.getCard();
        hurtCard=card;
        this.setGameContext(gameContext);

    }
    @Override
    public boolean isAllowed() {

        System.out.println("hurt:" + hurt.getClass());
        System.out.println("attacker:" + attacker.getClass());
        ArrayList<Card> arr = getGameContext().getPlayers()[hurt.getOwner()].getCardsWithTaunt();
        System.out.println("boolean:" + (hurt.getClass().getClasses()));
        if(arr.size()!=0 && !arr.contains(hurt.getCard()) )
        {
            System.out.println(11111111);
            return false;
        }

        if(hurtCard.getType()== Type.HeroCard)
        {
               damageToHurt=attackerCard.getAttack();
               damageToAttacker=0;

                return true;

        }
        else if(hurtCard.getType()==Type.MinionCard)
        {
            System.out.println("minionnnnnnnnnnn");
            System.out.println("boolean:"+attackerCard.getFeaures().containsKey(Feature.FirstTurn));


                System.out.println(55555555);
               /* if(attackerCard.getFeaures().containsKey(Feature.FirstTurn))
                {
                    System.out.println(6666666);
                    attackerCard.getFeaures().remove(Feature.rush);
                    attackerCard.getFeaures().remove(Feature.charge);
                }*/
                 System.out.println(777777);
                damageToHurt=attackerCard.getAttack();
                damageToAttacker=((MinionCard)hurtCard).getAttack();
                if(hurtCard.getFeaures().containsKey(Feature.DivineShield))
                {
                    System.out.println(8888888);
                    damageToAttacker=0;
                    damageToHurt=0;
                    hurtCard.getFeaures().remove(Feature.DivineShield);
                }
                 System.out.println(999999);
                  System.out.println("attacker:"+damageToAttacker);
                  System.out.println("attacker:"+damageToHurt);
                return true;
            }

          return true;
        }



    @Override
    public void performAction(){
        System.out.println("isAllowed:"+isAllowed());
       System.out.println("isAllowed:"+damageToAttacker);
         System.out.println("isAllowed:"+damageToHurt);

        if(!isAllowed())
        {
            return;
        }
        if(attackerCard.getType()==Type.WeaponCard)
        {
            System.out.println("before:"+((WeaponCard)attackerCard).getDurability());
            ((Weapon)attacker).setDurability(((Weapon)attacker).getDurability()-damageToAttacker);
            ((WeaponCard)attackerCard).setDurability(((WeaponCard)attackerCard).getDurability()-damageToAttacker);
            System.out.println("before:"+((WeaponCard)attackerCard).getDurability());
        }
        if(hurtCard.getType()==Type.MinionCard)
        {
            ((MinionCard)hurtCard).setHp(((MinionCard)hurtCard).getHp()-damageToHurt);
            if(damageToHurt!=0)
                ConditionHandler.handleMiniontTakesDamageCondition(attackerCard,gameContext);
        }
        if(hurtCard.getType()==Type.HeroCard)
        {
            System.out.println(0000000000000000000000000000000000000);
            ((Hero)hurt).setHp(((Hero)hurt).getHp()-damageToHurt);
            ((HeroCard)hurtCard).setHp(((HeroCard)hurtCard).getHp()-damageToHurt);
            System.out.println("ppppppppp:"+ GameMapper.getGameContext().getHero().getHp());
            System.out.println("rrrrrrrrr:"+ GameMapper.getGameContext().getOtherHero().getHp());
        }

    }

}
