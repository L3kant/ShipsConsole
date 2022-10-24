package cz.l3kant.shipsconsole.commons;

/**
 * @author l3kant
 */
public class GameField {
    
    private String[][] field;
    ManipulateConsole mc = new ManipulateConsole();

    public GameField(int height, int width) {
        this.field = createField(height, width);
    }
    
    
    private String[][] createField (int height, int width ){
        String[][] field = new String [height + 1][width + 1];
        for(int i=0; i< field.length; i++){
            if (i == 0){
                for(int j=0; j<field[i].length; j++){
                    field[i][j] = String.valueOf(j);
                }
            } else {
                for(int j=0; j<field[i].length; j++){
                    if (j == 0) {
                        field[i][j] = String.valueOf(i);
                    } else {
                        field[i][j] = " ";
                    }
                }
            }
            
        }
        field[0][0] = "\\";
        return field;
    }
    
    public void displayField() {
        for(int i=0; i< field.length; i++){
            for(int j=0; j<field[i].length; j++){
                mc.write(field[i][j]);
                mc.write("|");
            }
            mc.writeln("");
            for(int j=0; j<field[i].length*2; j++){
                mc.write("_");
            }
            mc.writeln("");
        }
                
    }
    
    public void setFieldValue(int xAxis, int yAxis, String value) {
        field[yAxis][xAxis] = value;
    }
}
