package cz.l3kant.shipsconsole.components;

import cz.l3kant.shipsconsole.commons.ManipulateConsole;

/**
 * @author l3kant
 */
public class Menu {
    ManipulateConsole mp = new ManipulateConsole();
    
    public void startMenu(){
        boolean displayAgain = true;
        while (displayAgain) {
            String option = displayMenu();
            switch (option) {
                case "1": 
                    mp.write("New game - under construction");
                    displayAgain = true;
                    break;
                case "2": 
                    mp.write("Load game - under construction");
                    displayAgain = true;
                    break;
                case "3": 
                    mp.write("Exit");
                    displayAgain = false;
                    break;
                default:
                    displayAgain = true;
            }     
        }
    }
    
    private String displayMenu() {
        mp.write("Ships");
        mp.write("-----");
        mp.write("1 - New game");
        mp.write("2 - Load last game");
        mp.write("3 - Quit");
        mp.write("");
        return mp.read();
    }
       
}
