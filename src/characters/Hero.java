package characters;

import initialCard.card.Card;
import initialCard.card.HeroCard;
import initialCard.enumClasses.General;
import initialCard.enumClasses.Type;
import initialHeroPower.HeroPower;
import initialHeroPower.HeroPowerFactory.HeroPowerCreator;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;

/**
 * Created by Data on 3/13/2020.
 */
public class Hero extends MyCharacter
{
    private HeroPower heroPower;
    private int baseHp;
    private int hp;
    private int attack=0;




    public int getAttack() {
        ((HeroCard)getCard()).setHp(hp);
        return attack;
    }

    public void setAttack(int attack)
    {
        ((HeroCard)getCard()).setHp(hp);
        this.attack = attack;
    }

    public Hero(Card card) throws Exception {
        super(card);
        System.out.println("hero:"+card.getGeneralMap());
        //System.out.println(card.getGeneralMap());
        if(((HashMap<General,Object>)card.getGeneralMap()).containsKey(General.HeroPower))
        {
            baseHp=((HeroCard)card).getHp();
            String heroPower=(String)((HashMap<General,Object>)card.getGeneralMap()).get(General.HeroPower);
            this.heroPower= ((HeroCard)card).getHeroPower();
        }
        if(((HashMap<General,Object>)card.getGeneralMap()).containsKey(General.Heropower))
        {
            String heroPower=(String)((HashMap<General,Object>)card.getGeneralMap()).get(General.Heropower);
            this.heroPower= HeroPowerCreator.createWithName(heroPower);
        }
        if(((HashMap<General,Object>)card.getGeneralMap()).containsKey(General.BaseHp))
        this.baseHp=((HeroCard)card).getBaseHp();
        if(((HashMap<General,Object>)card.getGeneralMap()).containsKey(General.Hp))
        this.hp=((HeroCard)card).getHp();
        else
            this.hp=baseHp;
        card.setType(Type.HeroCard);
    }

    public HeroPower getHeroPower() {
        return heroPower;
    }

    public void setHeroPower(HeroPower heroPower) {
        this.heroPower = heroPower;
    }

    public int getBaseHp() {
        ((HeroCard)getCard()).setBaseHp(hp);
        return baseHp;
    }

    public void setBaseHp(int baseHp) {
        ((HeroCard)getCard()).setBaseHp(baseHp);
        this.baseHp = baseHp;
    }

    public int getHp() {
        ((HeroCard)getCard()).setHp(hp);
        return hp;
    }

    public void setHp(int hp) {
        System.out.println("hhhhhhhhppppppppppppp:"+hp);
        ((HeroCard)getCard()).setHp(hp);
        this.hp = hp;
    }
    @Override
    public String toString(){

        String str=this.getCard().toString();
        if(this.heroPower!=null)
        {
            if(str.substring(str.length()-2).equals("\n"))
                str+="\n";

            str+="Card's heropower is "+this.getHeroPower()+"";
        }
        return str;

    }



}
