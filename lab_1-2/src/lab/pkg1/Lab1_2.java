/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab.pkg1;

/**
 *
 * @author DELL
 */
    import java.util.Scanner;
    class Complex {
    
   //attributes
    private int real;
    private int img;
    
    
    //constructors
    Complex ()            { real = img = 0; }   //default constructor
    Complex (int r,int i) { real = r;  img = i; }   

    //methods
    public void setReal (int r)  { real = r; }
    public void setImag (int i)  { img = i; }
    public int  getReal ()       { return real;} 
    public int  getImag ()       { return img; }
    public void printComplex () { 
        //System.out.printf("%d + i%d",real,img);
      //or using println fn.
        if (real>0)  
        {
         if(img>0)
            System.out.println(real+" +i"+img);
            else if (img == 0)
            System.out.println("0");
            else 
            System.out.println(real+" -i"+Math.abs(img));
        }
        else if (real == 0)
        {
            if(img>0)
            System.out.println("i"+img);
            else if (img == 0)
            System.out.println("0");
            else 
            System.out.println("-i"+Math.abs(img));    
        }
        else
        {
        if(img>0)
            System.out.println(real+" +i"+img);
            else if (img == 0)
            System.out.println(real+"0");
            else 
            System.out.println(real+" -i"+Math.abs(img)); 
        }    
    }        
    public static Complex addComplex (Complex c1,Complex c2) {
        
       Complex temp = new Complex ();
       temp.real = c1.real+c2.real;
       temp.img = c1.img+c2.img;
       return temp;
    }
    public static Complex subComplex (Complex c1,Complex c2) {
       Complex temp = new Complex ();
       temp.real = c1.real-c2.real;
       temp.img = c1.img-c2.img;
       return temp;   
    }
 }//end of Complex class


public class Lab1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Complex c1 = new Complex ();
        Complex c2 = new Complex ();
        Complex c3 = new Complex ();
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter First Complex");
        System.out.print("Enter Real Number: ");
        int r = sc.nextInt();
        c1.setReal(r);
        System.out.print("Enter Imaginary Number: ");
        int i = sc.nextInt();
        c1.setImag(i);
        System.out.println("\nEnter Second Complex");
        System.out.print("Enter Real Number: ");
        r = sc.nextInt();
        c2.setReal(r);
        System.out.print("Enter Imaginary Number: ");
        i = sc.nextInt();
        c2.setImag(i);
        System.out.print("\nC1: ");
        c1.printComplex();
        System.out.print("C2: ");
        c2.printComplex();
        c3 = Complex.addComplex(c1,c2);  //can call a static fn. without creating an object
        System.out.print("\nSum: ");     //just use <className>.<functionName>
        c3.printComplex();              
        c3 = Complex.subComplex(c1,c2);
        System.out.print("Difference: ");
        c3.printComplex();
    }
    
}
