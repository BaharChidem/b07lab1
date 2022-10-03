package project1;

import java.io.File;
import java.io.FileNotFoundException;

public class Driver {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		double c1[]= {1,2,1}, c2[] = {1,-5};
		int e1[]= {2,1,0}, e2[] = {1,0};
	
		double c3[] = {6,2,4,5};
		int e3[] = {3,2,1,4};
		
		double c4[] = {1,2,3};
		int e4[] = {5,3,1};
		
		Polynomial p1=new Polynomial(c1, e1);
		Polynomial p2=new Polynomial(c2, e2);
		
		
		Polynomial p3=p1.add(p2);
		Polynomial p4 =p1.multiply(p2);
		
		File f = new File("/Users/bahar/Desktop/test.txt");
        Polynomial b = new Polynomial(f);
        
        for(int i=0; i<b.arr.length; i++)
        {
        	System.out.println(b.arr[i]);
        	System.out.println(b.expo[i]);
        }
        
        p2.saveToFile("/Users/bahar/Desktop/test.txt");

		double num = p2.evaluate(5);
		Polynomial s = p1.add(p2); 
		if(s.hasRoot(1)) 
			   System.out.println("1 is a root of s"); 
			  else 
			   System.out.println("1 is not a root of s"); 
        
        
		
//		double [] c1 = {6,2,4,5};
//		int [] c2 = {3,2,1,4};
//		Polynomial p1 = new Polynomial(c1,c2);
//		
//		double [] c3 = {1,2,3};
//		int [] c4 = {5,3,1};
//		Polynomial p2 = new Polynomial(c3,c4);
//		Polynomial s1 = p1.add(p2);
//		
//		for(int i=0; i<s1.arr.length;i++)
//		{
//			System.out.println(s1.arr[i]);
//		}
//		System.out.println("*****************");
//		for(int i=0; i<s1.arr.length;i++)
//		{
//			System.out.println(s1.expo[i]);
//		}
//		System.out.println("*****************");
//		double [] c5 = {6,2,4};
//		int [] c6 = {3,2,1};
//		Polynomial p3 = new Polynomial(c5,c6);
//		
//		double [] c7 = {1,2,3,4};
//		int [] c8 = {5,3,1,2};
//		Polynomial p4 = new Polynomial(c7,c8);
//		Polynomial s2 = p3.add(p4);
//		
//		for(int i=0; i<s2.arr.length;i++)
//		{
//			System.out.println(s2.arr[i]);
//		}
//		System.out.println("*****************");
//		for(int i=0; i<s2.arr.length;i++)
//		{
//			System.out.println(s2.expo[i]);
//		}
		  
		  
	}
}
