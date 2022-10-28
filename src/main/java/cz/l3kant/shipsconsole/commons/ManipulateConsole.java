package cz.l3kant.shipsconsole.commons;

import java.util.Scanner;

/**
 * @author l3kant
 */
public class ManipulateConsole {
    
    private final Scanner sc = new Scanner(System.in);
    
    public void writeln(String msg){
        System.out.println(msg);
    }
    
    public void write(String msg){
        System.out.print(msg);
    }
    
    public void writeEmpty(){
        System.out.println();
    }
    
    
    public String read(){
        return sc.nextLine();
    }
}
