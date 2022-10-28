package cz.l3kant.shipsconsole.commons.ships;


/**
 * @author l3kant
 */
public class Battleship extends Ship{
    
    
    public Battleship(int xAxis, int yAxis) {
        lives = 4;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        super.createShip();
    }    
    
}
