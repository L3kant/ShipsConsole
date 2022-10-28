package cz.l3kant.shipsconsole.commons.ships;


/**
 * @author l3kant
 */
public class Cruiser extends Ship{
    
    
    public Cruiser(int xAxis, int yAxis) {
        lives = 3;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        super.createShip();
    }    
    
}
