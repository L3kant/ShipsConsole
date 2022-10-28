package cz.l3kant.shipsconsole.commons.ships;


/**
 * @author l3kant
 */
public abstract class Ship {
    
    boolean isDestroyed = false;
    int xAxis;
    int yAxis;
    public int lives;
    int[][] postion;
    
    public void createShip() {
        postion = new int[lives][2];
        for(int i = 0; i<lives; i++) {
            postion[i][0] = xAxis+i;
            postion[i][1] = yAxis;
        }
    }

    public int[][] getPostion() {
        return postion;
    }
    
    
}
