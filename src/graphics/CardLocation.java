/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

/**
 *
 * @author Data
 */
public class CardLocation implements Comparable<Object>{
    private double X;
    private double Y;
    private int counter;
    
    public CardLocation(double X,double Y,int counter){
        this.X=X;
        this.Y=Y;
        this.counter=counter;
    }

    /**
     * @return the X
     */
    public double getX() {
        return X;
    }

    /**
     * @param X the X to set
     */
    public void setX(double X) {
        this.X = X;
    }

    /**
     * @return the Y
     */
    public double getY() {
        return Y;
    }

    /**
     * @param Y the Y to set
     */
    public void setY(double Y) {
        this.Y = Y;
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = counter;
    } 
   @Override
   public int compareTo(Object o){
       CardLocation cardLocation=(CardLocation) o;
       int second=cardLocation.getCounter();
       if(second==counter)
           return 0;
       if(second>counter)
           return -1;
       else
           return 1;
       
   }
   
     @Override
   public String toString(){
     return X+" "+Y+" "+counter;
       
   }
    
}
