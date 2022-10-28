package cz.l3kant.shipsconsole.commons;


import cz.l3kant.shipsconsole.commons.ships.Ship;

/**
 * @author l3kant
 */
public class GameField {
    
    private final Object[][][] field;
    ManipulateConsole mc = new ManipulateConsole();
    private final int width;
    private final int height;
    private static final String SHIPSYMBOL = " #";
    private static final String PROTZONESYMBOL = " .";
    private static final String EMPTYSYMBOL = "  ";
    private boolean clrProtZone = true;

    public GameField(int height, int width) {
        this.height = height;
        this.width = width;
        this.field = createField(height, width);
    }
    
    
    private Object[][][] createField (int height, int width ){
        Object[][][] fieldMap = new Object [height + 1][width + 1][2];
        String coordinatePattern = "0";
        for(int i=0; i< fieldMap.length; i++){
            if (i == 0){
                for(int j=0; j<fieldMap[i].length; j++){
                    fieldMap[i][j][0] = coordinatePattern.substring(
                            String.valueOf(j).length()-1
                    ) + String.valueOf(j);
                    fieldMap[i][j][1] = null;                           
                            
                            
                }
            } else {
                for(int j=0; j<fieldMap[i].length; j++){
                    if (j == 0) {
                        fieldMap[i][j][0] = coordinatePattern.substring(
                            String.valueOf(i).length()-1
                        ) + String.valueOf(i);
                        fieldMap[i][j][1] = null; 
                    } else {
                        fieldMap[i][j][0] = EMPTYSYMBOL;
                        fieldMap[i][j][1] = null; 
                    }
                }
            }
            
        }
        fieldMap[0][0][0] = " \\";
        fieldMap[0][0][1] = null;
        return fieldMap;
    }
    
    public void displayField() {
        for (Object[][] field1 : field) {
            for (Object[] field11 : field1) {
                mc.write(field11[0].toString());
                mc.write("|");
            }
            mc.writeEmpty();
        }       
    }
    
    public void displayPlayerField(Ship [] boats, Ship [] destroyers, 
            Ship [] cruisers, Ship [] battleships) {
        if(clrProtZone){
            clearProtZone(this);
            clrProtZone = false;
        }
        mc.writeln("PLAYER FIELD");
        for(int i=0; i<field.length; i++){
            for (Object[] field11 : field[i]) {
                mc.write(field11[0].toString());
                mc.write("|");
            }
            switch(i){
                case 0 -> mc.writeln(EMPTYSYMBOL + "Your fleet");
                case 1 -> mc.writeln(EMPTYSYMBOL + "Boats:");
                case 2 -> mc.writeln(showShipsState(boats));
                case 3 -> mc.writeln(EMPTYSYMBOL + "Destroyers:");
                case 4 -> mc.writeln(showShipsState(destroyers));
                case 5 -> mc.writeln(EMPTYSYMBOL + "Cruisers:");
                case 6 -> mc.writeln(showShipsState(cruisers));
                case 7 -> mc.writeln(EMPTYSYMBOL + "Battleships:");
                case 8 -> mc.writeln(showShipsState(battleships));
                default -> mc.writeEmpty();
            }
        }           
    }
    
    public void displayEnemyField(Ship [] boats, Ship [] destroyers, 
            Ship [] cruisers, Ship [] battleships, GameField hiddenField) {
        if(hiddenField.clrProtZone){
            clearProtZone(hiddenField);
            hiddenField.clrProtZone = false;
        }
        mc.writeln("ENEMY FIELD");
        for(int i=0; i<field.length; i++){
            for (Object[] field11 : field[i]) {
                mc.write(field11[0].toString());
                mc.write("|");
            }
            switch(i){
                case 0 -> mc.writeln(EMPTYSYMBOL + "Enemy fleet");
                case 1 -> mc.writeln(EMPTYSYMBOL + "Boats:");
                case 2 -> mc.writeln(showShipsState(boats));
                case 3 -> mc.writeln(EMPTYSYMBOL + "Destroyers:");
                case 4 -> mc.writeln(showShipsState(destroyers));
                case 5 -> mc.writeln(EMPTYSYMBOL + "Cruisers:");
                case 6 -> mc.writeln(showShipsState(cruisers));
                case 7 -> mc.writeln(EMPTYSYMBOL + "Battleships:");
                case 8 -> mc.writeln(showShipsState(battleships));
                default -> mc.writeEmpty();
            }
        }           
    }
    
    public boolean setShipToField(Ship ship) {
        
        boolean success = true;
        
        //can be displayed
        for(int[] shipPostion: ship.getPostion()){
            
            if(shipPostion[0] <= width && shipPostion[1] <= height) {
                if (!field[shipPostion[1]][shipPostion[0]][0].equals(EMPTYSYMBOL)){
                    success = false;
                }
            } else {
                success = false;
            }
             
        }  
        
        if(success){
            //set ship on position
            setShip(ship);
            //set protection zone
            setProtZone(ship);
        }
                
        return success;
    }
    
    private void setShip(Ship ship){
        for(int[] shipPostion: ship.getPostion()){
            field[shipPostion[1]][shipPostion[0]][0] = SHIPSYMBOL;
            field[shipPostion[1]][shipPostion[0]][1] = ship; 
        }
    }
    
    private void setProtZone(Ship ship){
        for(int[] shipPostion: ship.getPostion()){
            if((shipPostion[0]-1) > 0 && 
                    field[shipPostion[1]][shipPostion[0]-1][0].equals(EMPTYSYMBOL)){
                field[shipPostion[1]][shipPostion[0]-1][0] = PROTZONESYMBOL;
            }
            if((shipPostion[0]+1) <= width && 
                    field[shipPostion[1]][shipPostion[0]+1][0].equals(EMPTYSYMBOL)){
                field[shipPostion[1]][shipPostion[0]+1][0] = PROTZONESYMBOL;
            }
            if((shipPostion[1]-1) > 0 && 
                    field[shipPostion[1]-1][shipPostion[0]][0].equals(EMPTYSYMBOL)){
                field[shipPostion[1]-1][shipPostion[0]][0] = PROTZONESYMBOL;
            }
            if((shipPostion[1]+1) <= height && 
                    field[shipPostion[1]+1][shipPostion[0]][0].equals(EMPTYSYMBOL)){
                field[shipPostion[1]+1][shipPostion[0]][0] = PROTZONESYMBOL;
            }
        }
    }
    
    private void clearProtZone(GameField gameField){
        for (Object[][] field1 : gameField.field) {
            for (Object[] field11 : field1) {
                if(field11[0].equals(PROTZONESYMBOL)){
                   field11[0] = EMPTYSYMBOL; 
                }
            }
        }
    }
    
    private String showShipsState(Ship[] ships) {
        StringBuilder fleet = new StringBuilder(EMPTYSYMBOL);
        for(Ship ship : ships){
            for(int i= 0; i<ship.lives; i++){
                fleet.append(SHIPSYMBOL.trim());
            }
            fleet.append(EMPTYSYMBOL);
        }
        return fleet.toString();                    
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    
}
