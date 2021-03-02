package initialHeroPower;

import initialCard.card.Card;
import initialCard.card.SpellCard;
import initialCard.enumClasses.General;

import java.util.HashMap;

/**
 * Created by Data on 3/12/2020.
 */
public class HeroPower extends SpellCard
{
    private int usePerTurn=0;
    private int allowedNumberOfUsesPerTurn=1;
    public HeroPower(HashMap<General, Object> general) throws Exception {
        super(general);
    }

    public boolean isAllowed(){
        if(allowedNumberOfUsesPerTurn<=usePerTurn)
            return false;
        return true;
    }

    public int getAllowedNumberOfUsesPerTurn() {
        return allowedNumberOfUsesPerTurn;
    }

    public void setAllowedNumberOfUsesPerTurn(int allowedNumberOfUsesPerTurn) {
        this.allowedNumberOfUsesPerTurn = allowedNumberOfUsesPerTurn;
    }

    public int getUsePerTurn() {
        return usePerTurn;
    }

    public void setUsePerTurn(int usePerTurn) {
        this.usePerTurn = usePerTurn;
    }
    public void addUsePerTurn(){
        this.usePerTurn++;

    }
    public void restartUsePerTurn(){
        this.usePerTurn=0;
    }
}
