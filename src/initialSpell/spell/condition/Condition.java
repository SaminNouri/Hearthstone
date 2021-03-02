package initialSpell.spell.condition;

import com.sun.org.apache.xpath.internal.operations.Bool;
import game.GameContext;
import initialCard.card.Card;
import initialSpell.spell.ComplexSpell;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Data on 3/12/2020.
 */
public  class Condition {


    private HashMap<GeneralCondition,Object> generalMap;
    private ComplexSpell If;
    private ComplexSpell Else;
    private Card mainCard;
    private ConditionType conditionType;
    private Boolean flag=false;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Condition(HashMap<GeneralCondition,Object> generalMap, Card mainCard){
         this.mainCard=mainCard;
         this.generalMap=generalMap;
         if(generalMap.containsKey(GeneralCondition.ConditionType))
             setConditionType(ConditionType.valueOf(generalMap.get(GeneralCondition.ConditionType).toString()));
         if(generalMap.containsKey(GeneralCondition.If))
             setIf((generalMap.get(GeneralCondition.If).toString()));
         if(generalMap.containsKey(GeneralCondition.Else))
             setElse((generalMap.get(GeneralCondition.Else)).toString());

     }

     private Boolean isConditionTrue(){
        return flag;
     }


    public void perform(GameContext gameContext, ArrayList<Card> cards,Card selectedCard) {
        // if(!isConditionTrue())
            // return;
        ComplexSpell spell=this.getIf();
        spell.performOnTargets(gameContext,getMainCard(),selectedCard,cards);
        flag=false;

    }

    public ComplexSpell getIf() {
        return If;
    }

    public ComplexSpell getElse() {
        return Else;
    }

    public void setElse(ComplexSpell anElse) {
        Else = anElse;
    }

    public void setIf(ComplexSpell anIf) {
        If = anIf;
    }

    public Card getMainCard() {
        return mainCard;
    }

    public void setMainCard(Card mainCard) {
        this.mainCard = mainCard;
    }

    public ConditionType getConditionType() {
        return conditionType;
    }

    private void setElse(String toString) {
         if(toString.equals("Spell1"))
            Else= (ComplexSpell) mainCard.getSpell1();
        if(toString.equals("Spell2"))
            Else= (ComplexSpell) mainCard.getSpell2();
    }

    private void setIf(String toString) {
        if(toString.equals("Spell1")) {
            If = (ComplexSpell) mainCard.getSpell1();

        }
        if(toString.equals("spell2"))
            If= (ComplexSpell) mainCard.getSpell2();
    }

    private void setConditionType(ConditionType valueOf) {
         conditionType=valueOf;
    }

    public HashMap<GeneralCondition, Object> getGeneralMap() {
        return generalMap;
    }

    public void setGeneralMap(HashMap<GeneralCondition, Object> generalMap) {
        this.generalMap = generalMap;
    }

}
