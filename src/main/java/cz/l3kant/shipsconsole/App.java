package cz.l3kant.shipsconsole;

import cz.l3kant.shipsconsole.components.Menu;
import cz.l3kant.shipsconsole.components.entities.Enemy;
import cz.l3kant.shipsconsole.components.entities.Entity;
import cz.l3kant.shipsconsole.components.entities.Player;

/**
 * @author l3kant
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        Entity[] entities = new Entity[2];
        entities[0] = new Player();
        entities[1] = new Enemy();
        
        switch (menu.startMenu()){
            case 1 -> {
                for(Entity entity: entities){
                    entity.start();       
                }
            }
            case 2, 3 -> System.exit(0);
            default -> System.exit(0);
        }        
    }
    
}
