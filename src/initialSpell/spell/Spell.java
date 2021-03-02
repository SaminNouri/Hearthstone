package initialSpell.spell;

import game.GameContext;
import initialCard.card.Card;
import initialCard.enumClasses.General;
import initialCard.enumClasses.Type;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.enumSpellClasses.SelectiveTarget;
import initialSpell.enumSpellClasses.SpellType;
import initialSpell.spell.condition.Condition;
import initialSpell.spell.condition.ConditionFactory;
import targets.*;


import java.util.ArrayList;
import java.util.HashMap;

//this class ignores inner spells

public abstract   class Spell extends InitialSpell
{

    private SpellType spellType;
    private boolean battlecry=false;
    private boolean deathrattle=false;
    private boolean repeateadEachTurn=false;
    private boolean atTheEndOfYourTurn=false;
    private boolean whenever=false;
    private int repetition=1;
    private int numberOfSpells=1;
    private HashMap<General,Object> filter;
    private Boolean selective=false;
    private ArrayList<Card> list;
    private ArrayList<Card> targets;
    private boolean conditionalTarget=false;
    private Condition condition;
    private boolean isPerformed=false;
    private Card mainCard;

    public boolean isPerformed() {
        return isPerformed;
    }

    public void setPerformed(boolean performed) {
        isPerformed = performed;
    }

    public Card getMainCard() {
        return mainCard;
    }

    public void setMainCard(Card mainCard) {
        this.mainCard = mainCard;
    }

    public void setPerformedTrue() {
        isPerformed = true;
    }

    public Condition getCondition() {
        return condition;
    }

    public Spell(HashMap<GeneralSpell,Object> generalSpell) throws Exception {
        super(generalSpell);
        filter=new HashMap<General,Object>();
        for(GeneralSpell key:GeneralSpell.values())
        {
            if(generalSpell.containsKey(key))
            {
                Object value=generalSpell.get(key);
                switch (key)
                 {
                    case Filter:
                         setFilter((HashMap<General, Object>) value);
                         break;
                    case Battlecry:
                        setBattlecry((Boolean) value);
                        break;
                    case Deathrattle:
                        setDeathrattle((Boolean) value);
                        break;
                    case AtTheEndOfYourTurn:
                        setAtTheEndOfYourTurn((Boolean) value);
                        break;
                    case RepeatedEachTurn:
                        setRepeateadEachTurn((Boolean) value);
                        break;
                    case SpellType:
                        try{
                            setSpellType((SpellType) value);
                        }catch(Exception e){}
                        break;
                    case NumberOfSpells:
                        setNumberOfSpells(Integer.valueOf(value.toString()));
                        break;
                    case Repetition:
                        setRepetition(Integer.valueOf(value.toString()));;
                        break;
                     case Selective:
                         setSelective(Boolean.valueOf(value.toString()));;
                         break;
                     case Whenever:
                         setWhenever(Boolean.valueOf(value.toString()));;
                         break;
                     case ConditionalTarget:
                         setConditionalTarget(Boolean.valueOf(value.toString()));;
                         break;


                }



            }
        }


    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }


    public   void setConditionalTarget(Boolean valueOf){
        this.conditionalTarget=valueOf;
    }

    public  boolean getConditionalTarget(){
        return conditionalTarget;
    }


    public boolean isWhenever() {
        return whenever;
    }

    public void setWhenever(boolean whenever) {
        this.whenever = whenever;
    }

    public Boolean getSelective() {
        return selective;
    }

    public void performOnTargets(GameContext gameContext, Card card,Card selectedCard,ArrayList<Card> cards){
        if((isBattlecry() && isPerformed()) && card.getType()!= Type.HeroPower)
            return;
       MyTargetHandler myTargetHandler=new MyTargetHandler(gameContext,filter,card,cards);
       this.targets=new ArrayList<Card>();
       if(!this.getSelective())
           targets=myTargetHandler.desiredList();
       else
           targets=myTargetHandler.desiredSelectiveList(selectedCard);

      for(int i=0;i<repetition;i++)
      {
          for(Card cd:targets)
          {

              performOnTarget(cd,myTargetHandler);
          }
      }
      this.setPerformedTrue();

    }

     public abstract void performOnTarget(Card target, MyTargetHandler myTargetHandler);

    private void setSelective(Boolean valueOf) {
        this.selective=valueOf;
    }


    public HashMap<General, Object> getFilter() {
        return filter;
    }

    public void setFilter(HashMap<General, Object> filter) {
        this.addSpellElement(GeneralSpell.Filter,filter);
        this.filter = filter;
    }

    public void setFeature(GeneralSpell key, Object value) throws Exception {
        switch (key)
        {

            case Battlecry:
                setBattlecry((Boolean) value);
                break;
            case Deathrattle:
                setDeathrattle((Boolean) value);
                break;
            case AtTheEndOfYourTurn:
                setAtTheEndOfYourTurn((Boolean) value);
                break;
            case RepeatedEachTurn:
                setRepeateadEachTurn((Boolean) value);
                break;
            case SpellType:
                try{
                    setSpellType((SpellType) value);
                }catch(Exception e){}
                break;
            case NumberOfSpells:
                setNumberOfSpells(Integer.valueOf(value.toString()));
                break;
            case Repetition:
                setRepetition(Integer.valueOf(value.toString()));;
                break;


        }

    }

    public int getNumberOfSpells() {
        return numberOfSpells;
    }

    public void setNumberOfSpells(int numberOfSpells) {
        this.addSpellElement(GeneralSpell.NumberOfSpells,numberOfSpells);
        this.numberOfSpells = numberOfSpells;
    }

    public int getRepetition() {
        return repetition;
    }

    public void setRepetition(int repetition) {
        this.addSpellElement(GeneralSpell.Repetition,repetition);
        this.repetition = repetition;
    }

    public SpellType getSpellType() {
        return spellType;
    }

    public void setSpellType(SpellType spellType) throws Exception {
        this.addSpellElement(GeneralSpell.SpellType,spellType);
        this.spellType = spellType;
    }

    public boolean isAtTheEndOfYourTurn() {
        return atTheEndOfYourTurn;
    }

    public void setAtTheEndOfYourTurn(boolean atTheEndOfYourTurn) {
        this.addSpellElement(GeneralSpell.AtTheEndOfYourTurn,atTheEndOfYourTurn);
        this.atTheEndOfYourTurn = atTheEndOfYourTurn;
    }

    public boolean isBattlecry() {
        return battlecry;
    }

    public void setBattlecry(boolean battlecry) {
        this.addSpellElement(GeneralSpell.Battlecry,battlecry);
        this.battlecry = battlecry;
    }

    public boolean isDeathrattle() {
        return deathrattle;
    }

    public void setDeathrattle(boolean deathrattle) {
        this.addSpellElement(GeneralSpell.Deathrattle,deathrattle);
        this.deathrattle = deathrattle;
    }

    public boolean isRepeateadEachTurn() {
        return repeateadEachTurn;
    }

    public void setRepeateadEachTurn(boolean repeateadEachTurn) {
        this.addSpellElement(GeneralSpell.RepeatedEachTurn,repeateadEachTurn);
        this.repeateadEachTurn = repeateadEachTurn;
    }







}
