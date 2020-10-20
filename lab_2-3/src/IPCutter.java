/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */

import java.util.StringTokenizer;
public class IPCutter {
    
    public static void main (String[] args){
        
       
        
         StringTokenizer st = new StringTokenizer (args[0],".");
         while (st.hasMoreTokens())
         {
          System.out.println(st.nextToken());
         }
    }
}
