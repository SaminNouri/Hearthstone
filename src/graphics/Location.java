package graphics;

/**
 * Created by Data on 4/29/2020.
 */
public class Location {
    private double x=0;
    private double y=0;

    public Location(double x,double y){
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
