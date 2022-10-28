package cz.l3kant.shipsconsole;

import cz.l3kant.shipsconsole.components.Menu;
import cz.l3kant.shipsconsole.components.Player;

/**
 * @author l3kant
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        Player player = new Player();
        
        switch (menu.startMenu()){
            case 1:
                player.start();
                break;
            case 2:
                break;
            case 3:
                System.exit(0);
                break;
        }        
    }
    
}
