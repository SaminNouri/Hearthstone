package Events;

import characters.Hero;
import characters.Minion;
import characters.MyCharacter;
import game.GameContext;
import game.GameMapper;
import initialCard.card.Card;
import initialCard.card.HeroCard;
import initialCard.card.MinionCard;
import initialCard.enumClasses.Feature;
import initialCard.enumClasses.Type;
import initialSpell.spell.condition.ConditionHandler;

import java.nio.CharBuffer;
import java.util.ArrayList;

public class MinionAttackEvent extends  GameEvent {

    private Minion attacker;
    private Card hurtCard;
    private MinionCard attackerCard;
    private MyCharacter hurt;
    private int damageToAttacker = 0;
    private int damageToHurt = 0;


    public Minion getAttacker() {
        return attacker;
    }

    public void setAttacker(Minion attacker) {
        this.attacker = attacker;
    }

    public MyCharacter getHurt() {
        return hurt;
    }

    public void setHurt(MyCharacter hurt) {
        this.hurt = hurt;
    }

    public MinionAttackEvent(Minion attacker, MyCharacter hurt, GameContext gameContext) {
        this.attacker = attacker;
        attackerCard = (MinionCard) attacker.getCard();
        this.hurt = hurt;
        Card card = hurt.getCard();
        hurtCard = card;
        this.setGameContext(gameContext);

    }

    @Override
    public boolean isAllowed() {

        // System.out.println("hurt:" + hurt.getClass());
        // System.out.println("attacker:" + attacker.getClass());
        ArrayList<Card> arr = getGameContext().getPlayers()[hurt.getOwner()].getCardsWithTaunt();
        //System.out.println("boolean:" + (hurt.getClass().getClasses()));
        if (arr.size() != 0 && !arr.contains(hurt.getCard())) {
            System.out.println(11111111);
            return false;
        }
        if (attackerCard.getFeaures().containsKey(Feature.Attack1) && !attackerCard.getFeaures().containsKey(Feature.Windfury)) {
            return false;

        }
        if (attackerCard.getFeaures().containsKey(Feature.Attack2) && attackerCard.getFeaures().containsKey(Feature.Windfury)) {
            return false;

        }

        if (hurtCard.getType() == Type.HeroCard) {
            if (attackerCard.getFeaures().containsKey(Feature.FirstTurn) && !attackerCard.getFeaures().containsKey(Feature.Charge)) {
                // System.out.println(2222222);
                return false;
            } else {
                // System.out.println(3333333);
                damageToHurt = attackerCard.getAttack();
                return true;
            }
        } else if (hurtCard.getType() == Type.MinionCard) {
            // System.out.println("minionnnnnnnnnnn");
            // System.out.println("boolean:"+attackerCard.getFeaures().containsKey(Feature.FirstTurn));
            if (attackerCard.getFeaures().containsKey(Feature.FirstTurn) && !attackerCard.getFeaures().containsKey(Feature.Charge) && !attackerCard.getFeaures().containsKey(Feature.Rush)) {
                // System.out.println(44444444);
                return false;
            } else {
                // System.out.println(55555555);
                if (attackerCard.getFeaures().containsKey(Feature.FirstTurn)) {
                    // System.out.println(6666666);
                    attackerCard.getFeaures().remove(Feature.Rush);
                    attackerCard.getFeaures().remove(Feature.Charge);
                }
                // System.out.println(777777);
                damageToHurt = attackerCard.getAttack();
                damageToAttacker = ((MinionCard) hurtCard).getAttack();
                if (hurtCard.getFeaures().containsKey(Feature.DivineShield)) {
                    //System.out.println(8888888);
                    damageToAttacker = 0;
                    damageToHurt = 0;
                    hurtCard.getFeaures().remove(Feature.DivineShield);
                }
                //  System.out.println(999999);
                //  System.out.println("attacker:"+damageToAttacker);
                //  System.out.println("attacker:"+damageToHurt);
                return true;
            }
        }


        return true;
    }

    @Override
    public void performAction() {
        //System.out.println("isAllowed:"+isAllowed());
        //System.out.println("isAllowed:"+damageToAttacker);
        // System.out.println("isAllowed:"+damageToHurt);

        if (!isAllowed()) {
            return;
        }
        if (attackerCard.getType() == Type.MinionCard) {
            //System.out.println("before:"+((MinionCard)attackerCard).getHp());
            ((MinionCard) attackerCard).setHp(((MinionCard) attackerCard).getHp() - damageToAttacker);
            //System.out.println("after:"+((MinionCard)attackerCard).getHp());
            if (attackerCard.getFeaures().containsKey(Feature.Attack1))
                attackerCard.getFeaures().put(Feature.Attack2, true);
            else
                attackerCard.getFeaures().put(Feature.Attack1, true);


            if (hurtCard.getType() == Type.MinionCard) {
                ((MinionCard) hurtCard).setHp(((MinionCard) hurtCard).getHp() - damageToHurt);
                if (attackerCard.getFeaures().containsKey(Feature.Poisonous))
                    ((MinionCard) hurtCard).setHp(0);
                if (damageToHurt != 0)
                    ConditionHandler.handleMiniontTakesDamageCondition(attackerCard, gameContext);
            }
            if (hurtCard.getType() == Type.HeroCard) {
                //System.out.println(0000000000000000000000000000000000000);
                //((Hero)hurt).setHp(((Hero)hurt).getHp()-damageToHurt);
                ((HeroCard) hurtCard).setHp(((HeroCard) hurtCard).getHp() - damageToHurt);
                //System.out.println("ppppppppp:"+ GameMapper.getGameContext().getHero().getHp());
                //System.out.println("rrrrrrrrr:"+ GameMapper.getGameContext().getOtherHero().getHp());
                if (attackerCard.getFeaures().containsKey(Feature.Lifesteal)) {
                    if (gameContext.getHero().getHp() < gameContext.getHero().getBaseHp()) {
                        HeroCard heroCard = ((HeroCard) gameContext.getHero().getCard());
                        int hp = heroCard.getHp();
                        int bhp = heroCard.getBaseHp();
                        if (bhp > hp && attackerCard.getAttack() + hp >= bhp)
                            heroCard.setHp(heroCard.getBaseHp());
                        {
                            if (bhp > hp && attackerCard.getAttack() + hp < bhp)
                                heroCard.setHp(heroCard.getHp() + attackerCard.getAttack());
                            {

                            }
                        }
                    }

                }
            }

        }
    }
}
