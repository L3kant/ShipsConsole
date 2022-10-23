package cz.l3kant.shipsconsole.commons;

import java.util.Scanner;

/**
 * @author l3kant
 */
public class ManipulateConsole {
    
    private Scanner sc = new Scanner(System.in);
    
    public void write(String msg){
        System.out.println(msg);
    }
    
    public String read(){
        String response = sc.nextLine();
        return response;
    }
}
