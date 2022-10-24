package cz.l3kant.shipsconsole;

import cz.l3kant.shipsconsole.commons.GameField;
import cz.l3kant.shipsconsole.commons.ManipulateConsole;
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
        ManipulateConsole mc = new ManipulateConsole();
        Menu menu = new Menu();
        Player player = new Player();
        
        switch (menu.startMenu()){
            case 1:
                player.start();
                break;
            case 2:
            case 3:
            default:
                mc.writeln("Exit");
        }        
    }
    
}
