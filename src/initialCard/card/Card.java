package initialCard.card;

import collection.enumCollectionClasses.GeneralCollection;
import graphics.CardLocation;
import initialCard.card.cardFactory.CardCreator;
import initialCard.enumClasses.*;
import initialSpell.enumSpellClasses.GeneralSpell;
import initialSpell.spell.ComplexSpell;
import initialSpell.spell.Spell;
import initialSpell.spell.condition.Condition;
import initialSpell.spell.condition.ConditionFactory;
import initialSpell.spell.condition.GeneralCondition;
import initialSpell.spell.spellFactory.SpellCreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Data on 3/9/2020.
 */
public  class Card extends InitialCard implements Cloneable,Comparable
{
    private String name;
    private String serialNumber;
    private String description;
    private Type type;
    private HeroType heroType;
    private int initialManaCost;
    private int coin;
    private boolean locked;
    private boolean owned;
    private Race race=Race.NONE;
    private Rarity rarity;
    protected HashMap<General,Object> general;
    private boolean taunt=false;
    private boolean charge=false;
    private boolean divineShield=false;
    private String owner;
    private ComplexSpell spell1;
    private ComplexSpell spell2;
    private int numberOfUses=0;
    private boolean rush=false;
    private CardLocation cardLocation;
    private Integer ownerIndex;
    private int id;
    private HashMap<Feature,Object> feaures=new HashMap<Feature, Object>();
    private int turnConter=-1;
    private boolean isTargetSelective=false;

    public Card copyCard() throws Exception {
        return CardCreator.createCardWithName(name);
    }

    public boolean isTargetSelective() {
        return isTargetSelective;
    }

    public void setTargetSelective(boolean targetSelective) {
        isTargetSelective = targetSelective;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

         this.id=id;
    }

    public Integer getOwnerIndex() {
        return ownerIndex;
    }

    public void setOwnerIndex(Integer ownerIndex) {
        this.ownerIndex = ownerIndex;
    }

    public void setNumberOfUses(int numberOfUses) {
        this.numberOfUses = numberOfUses;
    }

    public int getTurnConter() {
        return turnConter;
    }

    public HashMap<Feature, Object> getFeaures() {
        return feaures;
    }

    public void setFeaures(HashMap<Feature, Object> feaures) {
        this.feaures = feaures;
    }

    public void setTurnConter(int turnConter) {
        this.turnConter = turnConter;
    }

    public int getNumberOfUses() {
        return numberOfUses;
    }

    public Card(HashMap<General,Object> general) throws Exception {
       super(general);
       setGeneralMap(general);
    }
    public Object clone() throws
            CloneNotSupportedException
    {
        return super.clone();
    }
    public Card copy() throws CloneNotSupportedException {

        Card ans=(Card) this.clone();

        return ans;
    }
    @Override
    public void setGeneralMap(HashMap<General,Object> general){


        for(General key:General.values())
        {
            if(general.containsKey(key))
            {

                Object value=general.get(key);
                try {
                    setFeature(key, value);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
        feaures=new HashMap<Feature,Object>();
        if(rush)
            feaures.put(Feature.Rush,true);
        if(divineShield)
            feaures.put(Feature.DivineShield,true);
        if (taunt)
            feaures.put(Feature.Taunt,true);
        if(charge)
            feaures.put(Feature.Charge,true);
        feaures.put(Feature.FirstTurn,true);



    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setFeature(General key, Object value) throws Exception {
        switch (key)
        {
            case Charge:
                setCharge((Boolean) value);
                break;
            case DivineShield:
                setDivineShield((Boolean) value);
                break;
            case Taunt:
                setTaunt((Boolean) value);
                break;
            case Locked:
                setLocked((Boolean) value);
                break;
            case Owned:
                setOwned((Boolean) value);
                break;
            case Name:
                setName((String)value);
                break;
            case Description:
                setDescription((String)value);;
                break;
            case Coin:
                setCoin((Integer)value);
                break;
            case InitialManaCost:
                setInitialManaCost((Integer) value);
                break;
            case Type:
                setType((Type) value);
                this.type=(Type) value;
                break;
            case HeroType:
                setHeroType((HeroType) value);
                break;
            case Race:
                setRace((Race) value);
                break;
            case Rarity:
                setRarity((Rarity) value);
                break;
            case SerialNumber:
                    setSerialNumber((String) value);
                    break;
            case HeroPower:
                setHeroPower((String) value);
                break;
            case Spell1:
                if(value instanceof ComplexSpell)
                {
                    setSpell1((ComplexSpell)value);
                }
                else
                {
                    setSpell1((HashMap<GeneralSpell,Object>)value);
                }
                break;
            case Spell2:
                if(value instanceof ComplexSpell)
                {
                    setSpell2((ComplexSpell)value);
                }
                else
                {
                    setSpell2((HashMap<GeneralSpell,Object>)value);
                }
                break;
            case Rush:
                this.rush=((boolean)value);
                feaures.put(Feature.Rush,true);
                break;

        }
    }



    public Spell getSpell1() {
        return spell1;
    }

    public void setSpell1(ComplexSpell spell1) throws Exception {
        this.addElement(General.Spell1,spell1.getGeneralSpellMap());
        this.spell1 = spell1;
        if(spell1.getSelective())
            isTargetSelective=true;
        if(spell1.getGeneralSpellMap().containsKey(GeneralSpell.Condition))
        {
            Condition condition=ConditionFactory.build((HashMap<GeneralCondition, Object>) spell1.getGeneralSpellMap().get(GeneralSpell.Condition),this);
            this.spell1.setCondition(condition);

        }
        if(spell1!=null)
        this.spell1.setMainCard(this);
    }

    public Spell getSpell2() {
        return spell2;
    }

    public void setSpell2(ComplexSpell spell2) throws Exception {
    this.addElement(General.Spell2,spell2.getGeneralSpellMap());
    this.spell2 = spell2;
        if(spell2.getSelective())
            isTargetSelective=true;
        if(spell2.getGeneralSpellMap().containsKey(GeneralSpell.Condition))
        {
            Condition condition=ConditionFactory.build((HashMap<GeneralCondition, Object>) spell2.getGeneralSpellMap().get(GeneralSpell.Condition),this);
            this.spell2.setCondition(condition);

        }
        if(spell2!=null)
        this.spell2.setMainCard(this);
}
    public void setSpell2(HashMap<GeneralSpell,Object> map) throws Exception {
        if(map==null)
            return;
        this.addElement(General.Spell2,map.get(GeneralSpell.Spell2));
        this.spell2 = (ComplexSpell) SpellCreator.create(map);
        if(spell2.getSelective())
            isTargetSelective=true;
        if(spell2.getGeneralSpellMap().containsKey(GeneralSpell.Condition))
        {
            Condition condition=ConditionFactory.build((HashMap<GeneralCondition, Object>) spell2.getGeneralSpellMap().get(GeneralSpell.Condition),this);
            this.spell2.setCondition(condition);

        }
        if(spell2!=null)
        this.spell2.setMainCard(this);
    }
    public void setSpell1(HashMap<GeneralSpell,Object> map) throws Exception {
        System.out.println();
        System.out.println(getGeneralMap());
        System.out.println();
        System.out.println("2"+map);
        if(map==null)
            return;

        //this.addElement(General.Spell1,map.get(GeneralSpell.Spell1));
        this.spell1 =(ComplexSpell) SpellCreator.create(map);
        if(spell1!=null)
          if(spell1.getSelective())
            isTargetSelective=true;
        if(map.containsKey(GeneralSpell.Condition))
        {
            Condition condition=ConditionFactory.build((HashMap<GeneralCondition, Object>) spell1.getGeneralSpellMap().get(GeneralSpell.Condition),this);
            this.spell1.setCondition(condition);

        }
        if(spell1!=null)
         this.spell1.setMainCard(this);
    }


    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.addElement(General.Charge,charge);
        this.charge = charge;
    }


    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.addElement(General.Coin,coin);
        this.coin = coin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.addElement(General.Description,description);
        this.description = description;
    }

    public boolean isDivineShield() {
        return divineShield;
    }

    public void setDivineShield(boolean divineShield) {
        this.addElement(General.DivineShield,divineShield);
        this.divineShield = divineShield;
    }


    public HeroType getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroType heroType) {
        this.addElement(General.HeroType,heroType);
        this.heroType = heroType;
    }

    public int getInitialManaCost() {
        return initialManaCost;
    }

    public void setInitialManaCost(int initialManaCost) {
        this.addElement(General.InitialManaCost,initialManaCost);
        this.initialManaCost = initialManaCost;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.addElement(General.Locked,locked);
        this.locked = locked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.addElement(General.Name,name);
        this.name = name;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.addElement(General.Owned,owned);
        this.owned = owned;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.addElement(General.Race,race);
        this.race = race;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.addElement(General.Rarity,rarity);
        this.rarity = rarity;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.addElement(General.SerialNumber,serialNumber);
        this.serialNumber = serialNumber;
    }

    public boolean isTaunt() {
        return taunt;
    }

    public void setTaunt(boolean taunt) {
        this.addElement(General.Taunt,taunt);
        this.taunt = taunt;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        //System.out.println("type");
        this.addElement(General.Type,type);
        this.type = type;
        //System.out.println("type");
    }



    @Override
    public String toString(){

    String str="Card's name is "+this.getName()+"\n";
        str+="Card's cost is "+this.getCoin()+"\n";
        if(this.getRarity()!=null)
        str+="Card's rarity is "+this.getRarity()+"\n";
        if(this.getDescription()!=null)
        str+="Card's description is "+this.getDescription()+"\n";
        str+="Card's mana cost is "+this.getInitialManaCost()+"\n";
        str+="Card's herotype is "+this.getHeroType()+"\n";
        if(this.getType()!=null)
        str+="Card's type is "+this.getType()+"\n";
        if(this.getRace()!=null)
            str+="Card's race is "+this.getRace()+"\n";
        if(this.getGeneralMap().containsKey(General.BaseHp))
            str+="Card's basehp is "+this.getGeneralMap().get(General.BaseHp)+"\n";
        if(this.getGeneralMap().containsKey(General.BaseAttack))
            str+="Card's baseattack is "+this.getGeneralMap().get(General.BaseAttack)+"";
        if(str.substring(str.length()-2).equals("\n"))
            str=str.substring(0,str.length()-2);

        return str;

    }

    public boolean equals(Card card){
        HashMap<General,Object> m=card.getGeneralMap();
        if(m.equals(this.getGeneralMap()))
            return true;
        else
            return false;
    }

    public boolean equal(Card card){
        HashMap<General,Object> m=card.getGeneralMap();
        if(m.equals(this.getGeneralMap()))
            return true;
        else
            return false;
    }
    @Override
    public int compareTo(Object o) {
        List<Rarity> list=new ArrayList<Rarity>();
        list.add(Rarity.FREE);
        list.add(Rarity.COMMON);
        list.add(Rarity.EPIC);
        list.add(Rarity.LEGENDARY);
        list.add(Rarity.RARE);

        Card second=(Card) o;
        Card first=this;
        if(first.getNumberOfUses()!=second.getNumberOfUses())
        {
            if(first.getNumberOfUses()>second.getNumberOfUses())
                return 1;
            else
                return -1;
        }
        else if(first.getRarity()!=second.getRarity())
        {
             int f=list.indexOf(first.getRarity());
            int s=list.indexOf(second.getRarity());
            if(f>s)
                return 1;
            else
                return -1;
        }
        else if(first.getInitialManaCost()!=second.getInitialManaCost())
        {
            if(first.getInitialManaCost()>second.getInitialManaCost())
                return 1;
            else
                return 0;
        }else if(first.getType()!=second.getType()){
            if(first.getType()==Type.MinionCard)
                return 1;
            if(second.getType()==Type.MinionCard)
                return -1;
        }
        return 1;

    }


    public void setHeroPower(String hp) {
        this.addElement(General.HeroPower,hp);
    }

    /**
     * @return the rush
     */
    public boolean isRush() {
        return rush;
    }

    /**
     * @param rush the rush to set
     */
    public void setRush(boolean rush) {
        this.rush = rush;
    }

    /**
     * @return the cardLocation
     */
    public CardLocation getCardLocation() {
        return cardLocation;
    }

    /**
     * @param cardLocation the cardLocation to set
     */
    public void setCardLocation(CardLocation cardLocation) {
        this.cardLocation = cardLocation;
    }


}
