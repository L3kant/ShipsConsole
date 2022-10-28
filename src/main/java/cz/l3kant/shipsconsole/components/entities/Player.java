package cz.l3kant.shipsconsole.components.entities;

import cz.l3kant.shipsconsole.commons.GameField;
import cz.l3kant.shipsconsole.commons.ManipulateConsole;
import cz.l3kant.shipsconsole.commons.ships.Battleship;
import cz.l3kant.shipsconsole.commons.ships.Boat;
import cz.l3kant.shipsconsole.commons.ships.Cruiser;
import cz.l3kant.shipsconsole.commons.ships.Destroyer;
import cz.l3kant.shipsconsole.commons.ships.Ship;

/**
 * @author l3kant
 */
public class Player extends Entity{
    
    ManipulateConsole mc = new ManipulateConsole();
    GameField playerField = super.field;
    
    @Override
    public void start(){   
                
        playerField.displayField();
        mc.writeEmpty();
        for(int i = 0; i<boats.length; i++){ 
            mc.writeln("Set position of Boat (#)- remain " + (boats.length-i));
            boats[i] = processCoordinates("boat");
            playerField.displayField();
        }
        for(int i = 0; i<destroyers.length; i++){ 
            mc.writeln("Set position of Destroyer (##)- remain " + (destroyers.length-i));
            destroyers[i] = processCoordinates("destroyer");
            playerField.displayField();
        }
        for(int i = 0; i<cruisers.length; i++){ 
            mc.writeln("Set position of Cruiser (###)- remain " + (cruisers.length-i));
            cruisers[i] = processCoordinates("cruiser");
            playerField.displayField(); 
        }
        for(int i = 0; i<battleships.length; i++){ 
            mc.writeln("Set position of Battleship (####)- remain " + (battleships.length-i));
            battleships[i] = processCoordinates("battleship");
            playerField.displayField();
        }
        mc.writeEmpty();
        mc.writeln("All ships are ready to play!");
        mc.writeEmpty();
        playerField.displayPlayerField(boats, destroyers, cruisers, battleships);
        mc.writeEmpty();
    }
    
    
    private Ship processCoordinates(String type){
        Ship ship = null;
        int yAxis;
        int xAxis;
        boolean again = true;
        while (again) {
            try {mc.writeln("Set coordinates => x-axis;y-axis");
                String coordinates = mc.read();
                xAxis = Integer.valueOf(coordinates.split(";")[0]);
                yAxis = Integer.valueOf(coordinates.split(";")[1]);
                switch(type){
                    case "boat" -> {ship = new Boat(xAxis, yAxis);}
                    case "destroyer" -> {ship = new Destroyer(xAxis, yAxis);}
                    case "cruiser" -> {ship = new Cruiser(xAxis, yAxis);}
                    case "battleship" -> {ship = new Battleship(xAxis, yAxis);}
                    default -> {ship = null;}
                }
                again = !playerField.setShipToField(ship);
            }catch(Exception e){
                mc.writeln(e.getMessage());
                mc.writeln("try again");
            } 
        }
        
        return ship;
                
    }
    
    
}
