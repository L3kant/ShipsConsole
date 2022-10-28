package cz.l3kant.shipsconsole.components.entities;

import cz.l3kant.shipsconsole.commons.GameField;
import cz.l3kant.shipsconsole.commons.ships.Battleship;
import cz.l3kant.shipsconsole.commons.ships.Boat;
import cz.l3kant.shipsconsole.commons.ships.Cruiser;
import cz.l3kant.shipsconsole.commons.ships.Destroyer;
import cz.l3kant.shipsconsole.commons.ships.Ship;
import java.util.Random;


/**
 * @author l3kant
 */
public class Enemy extends Entity{

    Random random = new Random();
    GameField enemyFieldHidden = super.field;
    GameField enemyFieldShow = new GameField(
            enemyFieldHidden.getHeight(), 
            enemyFieldHidden.getWidth());
    
    
    @Override
    public void start() {
        for(int i = 0; i<boats.length; i++){            
            boats[i] = processCoordinates("boat");
        }
        for(int i = 0; i<destroyers.length; i++){       
            destroyers[i] = processCoordinates("destroyer");
        }
        for(int i = 0; i<cruisers.length; i++){   
            cruisers[i] = processCoordinates("cruiser"); 
        }
        for(int i = 0; i<battleships.length; i++){ 
            battleships[i] = processCoordinates("battleship");
        }
        enemyFieldShow.displayEnemyField(boats, destroyers, cruisers, 
                battleships, enemyFieldHidden);
        enemyFieldHidden.displayField();
        
    }
    
    private Ship processCoordinates(String type){
        Ship ship = null;
        int yAxis;
        int xAxis;
        boolean again = true;
        while (again) {
            try {
                xAxis = random.nextInt(1, enemyFieldHidden.getWidth() + 1);
                yAxis = random.nextInt(1, enemyFieldHidden.getHeight() + 1);
                switch(type){
                    case "boat" -> {ship = new Boat(xAxis, yAxis);}
                    case "destroyer" -> {ship = new Destroyer(xAxis, yAxis);}
                    case "cruiser" -> {ship = new Cruiser(xAxis, yAxis);}
                    case "battleship" -> {ship = new Battleship(xAxis, yAxis);}
                    default -> {ship = null;}
                }
                again = !enemyFieldHidden.setShipToField(ship);
            }catch(Exception e){
               e.printStackTrace();
            } 
        }
        
        return ship;
                
    }
    
}
