package cz.l3kant.shipsconsole.commons.ships;


/**
 * @author l3kant
 */
public class Boat extends Ship{
    
    
    public Boat(int xAxis, int yAxis) {
        lives = 1;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        super.createShip();
    }    
    
}
