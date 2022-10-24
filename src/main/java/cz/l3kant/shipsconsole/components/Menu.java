package cz.l3kant.shipsconsole.components;

import cz.l3kant.shipsconsole.commons.ManipulateConsole;

/**
 * @author l3kant
 */
public class Menu {
    ManipulateConsole mc = new ManipulateConsole();
    
    public int startMenu(){
        boolean displayAgain = true;
        int selOpt = 0;
        while (displayAgain) {
            String option = displayMenu();
            switch (option) {
                case "1": 
                    displayAgain = false;
                    selOpt = 1;
                    break;
                case "2": 
                    mc.writeln("Load game - under construction");
                    break;
                case "3": 
                    displayAgain = false;
                    break;
                default:
                    mc.writeln("Wrong option - try again");
            }     
        }
        return selOpt;
    }
    
    private String displayMenu() {
        mc.writeln("Ships");
        mc.writeln("-----");
        mc.writeln("1 - New game");
        mc.writeln("2 - Load last game");
        mc.writeln("3 - Quit");
        mc.writeln("");
        return mc.read();
    }
       
}
