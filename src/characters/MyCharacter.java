package characters;

import initialCard.card.Card;
import initialHeroPower.HeroPower;

/**
 * Created by Data on 3/13/2020.
 */
public class MyCharacter
{
    private String name;
    public Card card;
    private int initialManaCost=0;
    private Integer owner;

    public Integer getOwner() {
        if(owner==null)
            return card.getOwnerIndex();
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
        card.setOwnerIndex(owner);
    }

    public MyCharacter(Card card){
        this.card=card;
        this.name=card.getName();
        this.initialManaCost=card.getInitialManaCost();
    }

    public int getInitialManaCost() {
        return initialManaCost;
    }

    public void setInitialManaCost(int initialManaCost) {
        card.setInitialManaCost(initialManaCost);
        this.initialManaCost = initialManaCost;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        setName(card.getName());
        setInitialManaCost(card.getInitialManaCost());
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        card.setName(name);
        this.name = name;
    }
}
