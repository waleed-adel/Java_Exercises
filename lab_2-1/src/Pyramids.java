/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Pyramids {
    
    public static void main (String[] args){
    
       //half pyramid
        int row = Integer.parseInt(args[0]);
        for (int i=0;i<=row;i++)    
            {        
                for (int j=0;j<i;j++)
                {
                 System.out.print("*");
                }
                System.out.print("\n");
            }
       /////////////////////////////////////////////////////
        
        //full pyramid
        System.out.print("\n");
        int space = row - 1;
        for (int i=0;i<row;i++)
            { 
                for (int j=0;j<space;j++)
                {
                  System.out.print(" ");
                }
                
                for (int k=0;k<=2*i;k++)
                {
                  System.out.print("*");
                }    
                
                System.out.print("\n");
                space --;
            } 
                
    }
     
}
