/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Calculator {
    
    
    public static void main (String[] args){
        
      
        switch (args[1])
        {
            case ("+"):
            System.out.println( Integer.parseInt(args[0]) + Integer.parseInt(args[2]) );
            break;
                
            case("-"):
            System.out.println( Integer.parseInt(args[0]) - Integer.parseInt(args[2]) );
            break;
                
            case("x"):
            System.out.println( Float.parseFloat(args[0]) * Float.parseFloat(args[2]) );
            break;
                
            case("/"):
            System.out.println( Float.parseFloat(args[0]) / Float.parseFloat(args[2]) );
            break;
        
        }
    }    
}
