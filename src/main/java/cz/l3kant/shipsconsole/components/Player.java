package cz.l3kant.shipsconsole.components;

import cz.l3kant.shipsconsole.commons.GameField;
import cz.l3kant.shipsconsole.commons.ManipulateConsole;

/**
 * @author l3kant
 */
public class Player {
    
    GameField playerField = new GameField(8,8);
    ManipulateConsole mc = new ManipulateConsole();
    
    public void start(){   
        boolean setNext = true;
        boolean isFalse= true;
        while(setNext){
            playerField.displayField();
            while(isFalse){
                mc.writeln("Set coordinates => x-axis;y-axis");
                String coordinates = mc.read();
                isFalse = processCoordinates(coordinates);
            }
            playerField.displayField();
            setNext = false;
        }
    }
    
    
    private boolean processCoordinates(String userInput){
        boolean isFalse = true;
        try {
            int xAxis = Integer.valueOf(userInput.split("[/;]")[0]);
            int yAxis = Integer.valueOf(userInput.split("[/;]")[1]);
            playerField.setFieldValue(xAxis,yAxis,"X");
            isFalse = false;
        }catch(Exception e){
            mc.writeln(e.getMessage());
            mc.writeln("try again");
        }
        return isFalse;
                
    }
    
    
}
