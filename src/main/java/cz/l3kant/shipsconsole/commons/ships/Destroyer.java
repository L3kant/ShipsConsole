package cz.l3kant.shipsconsole.commons.ships;


/**
 * @author l3kant
 */
public class Destroyer extends Ship{
    
    
    public Destroyer(int xAxis, int yAxis) {
        lives = 2;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        super.createShip();
    }    
    
}
