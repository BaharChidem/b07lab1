package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintStream;
import java.lang.*;



public class Polynomial {
	double[] arr;
	int[] expo;
	
	public Polynomial()
	{
		arr = new double[1];
		this.arr[0] = 0;
		expo = new int[1];
		this.expo[0] = 0;
	}
	
	public Polynomial(double[] num, int[] e)
	{
		arr = new double[num.length];
		for(int i=0; i<this.arr.length; i++)
		{
			this.arr[i] = num[i];
		}
		expo = new int[e.length];
		for(int i=0; i<this.expo.length; i++)
		{
			this.expo[i] = e[i];
		}
			
	}
	
	public Polynomial(File f) throws FileNotFoundException
	{
		Scanner s = new Scanner(f);
		String str = s.nextLine();
		String new_str = str.replace("-","+-");
		String[] splitted = new_str.split("[+]");
		
		double[] coeff = new double[splitted.length];
		int[] expos = new int[splitted.length];
		
		int index = 0;
		int index1 = 0;
		int count = 0;
		for(int i=0; i<splitted.length; i++)
		{
			if(splitted[i].equals(""))
			{
				count++;
				continue;
			}
			
			else if(!splitted[i].contains("x"))
			{
				coeff[index] = Double.parseDouble(splitted[i]);
				expos[index1] = 0;
				index++;
				index1++;
			}
			
			else if(splitted[i].equals("x"))
			{
				coeff[index] = 1;
				expos[index1] = 1;
				index++;
				index1++;
			}
			
			else if(splitted[i].contains("-x"))
			{
				if(splitted[i].equals("-x"))
				{
					coeff[index] = -1;
					expos[index1] = 1;
					index++;
					index1++;
				}
				
				else
				{
				String[] sub_splits1 = splitted[i]. split("x");
				coeff[index] = -1;
				expos[index1] = Integer.parseInt(sub_splits1[1]);
				index++;
				index1++;
				}
			}
			
			else if(splitted[i].length() == 2)
			{
				int pos = splitted[i].indexOf("x");
				if(pos == 0)
				{
					String[] sub_splits1 = splitted[i]. split("x");
					coeff[index] = 1;
					expos[index1] = Integer.parseInt(sub_splits1[1]);;
					index++;
					index1++;
				}
				if(pos == 1)
				{
					String[] sub_splits1 = splitted[i]. split("x");
					coeff[index] = Double.parseDouble(sub_splits1[0]);
					expos[index1] = 1;
					index++;
					index1++;
				}
			}
			
			else if(splitted[i].length() == 3 && splitted[i].contains("-"))
			{
				String[] sub_splits1 = splitted[i]. split("x");
				coeff[index] = Double.parseDouble(sub_splits1[0]);
				expos[index1] =1;
				index++;
				index1++;
			}
			
			else
			{
				String[] sub_splits = splitted[i]. split("x");
				coeff[index] = Double.parseDouble(sub_splits[0]);
				expos[index1] = Integer.parseInt(sub_splits[1]);
				index++;
				index1++;
			}
		}
		
		arr = new double[coeff.length - count];
		for(int i=0; i<arr.length; i++)
		{
			this.arr[i] = coeff[i];
		}
		
		expo = new int[expos.length - count];
		for(int i=0; i<expo.length; i++)
		{
			this.expo[i] = expos[i];
		}
		
		s.close();
		
	}
	
	public Polynomial add(Polynomial ob)
	{
		//int length1 = this.arr.length;
		//int length2 = ob.arr.length;
		
		int lenght3 = this.expo.length;
		int length4 = ob.expo.length;
		

		
		Polynomial result = null;
			int count = 0;
			for(int i =0; i<lenght3; i++)
			{
				for(int j=0; j<length4; j++)
				{
					if(this.expo[i] == ob.expo[j])
					{
						count++;
					}
				}
			}
			
			int expo_len = count + (lenght3 - count) + (length4 - count);
			int[] result_expo = new int[expo_len];
			double[] result_coeff = new double[expo_len];
			
			int index = 0;
			for(int i=0; i<lenght3; i++)
			{
				int flag = 1;
				for(int j=0; j<length4; j++)
				{
					if(this.expo[i] == ob.expo[j])
					{
						result_coeff[index] = this.arr[i] + ob.arr[j];
						result_expo[index] = this.expo[i];
						index++;
						flag = 0;
					}
				}
				if(flag == 1)
				{
					result_coeff[index] = this.arr[i];
					result_expo[index] = this.expo[i];
					index++;
				}
				
			}
			
			for(int i=0; i<length4; i++)
			{
				int flag = 1;
				for(int j=0; j<result_expo.length; j++)
				{
					if(ob.expo[i] == result_expo[j])
					{
						flag = 0;
					}
				}
				if(flag == 1)
				{
					result_expo[index] = ob.expo[i];
					result_coeff[index] = ob.arr[i];
				}
			}
			
			int count_zeros = 0;
			for(int i=0; i<result_coeff.length; i++)
			{
				if(result_coeff[i] == 0)
				{
					count_zeros++;
				}
			}
			
			double[] r_coeff = new double[result_coeff.length - count_zeros];
			int[] r_expo = new int[result_coeff.length - count_zeros];
			
			int index3 = 0;
			for(int i=0; i<result_coeff.length; i++)
			{
				if(result_coeff[i] != 0.0)
				{
					r_coeff[index3] = result_coeff[i];
					r_expo[index3] = result_expo[i];
					index3++;
				}
			}
			
			
			
			result = new Polynomial(r_coeff, r_expo);
		
		return result;
		
	}
	
	public Polynomial multiply(Polynomial ob)
	{
		int length1 = this.arr.length;
		int length2 = ob.arr.length;
		
		//int lenght3 = this.expo.length;
		//int length4 = ob.expo.length;
		
		double[] storage_coeff = new double[length1*length2];
		int[] storage_expo = new int[length1*length2];
		
		int index = 0;
		for(int i=0; i<length1; i++)
		{
			for(int j=0; j<length2; j++)
			{
				storage_coeff[index] = this.arr[i] * ob.arr[j];
				storage_expo[index] = this.expo[i] + ob.expo[j];
				index++;
			}
		}
		
		int count = 0;
		for(int i =0; i<storage_expo.length; i++)
		{
			for(int j = i+1; j<storage_expo.length; j++)
			{
				if(storage_expo[j] == -1)
				{
					continue;
				}
				
				if(storage_expo[i] == storage_expo[j])
				{
					storage_expo[j] = -1;
					storage_coeff[i] = storage_coeff[i] + storage_coeff[j];
					count++;
				}
			}
		}
		
		double[] result_coeff =  new double[storage_coeff.length - count];
		int[] result_expo = new int[storage_expo.length - count];
		
		int index2 =0;
		for(int i=0; i<storage_expo.length; i++)
		{
			if(storage_expo[i] != -1)
			{
				result_expo[index2] = storage_expo[i];
				result_coeff[index2] = storage_coeff[i];
				index2++;
			}
		}
		
		int count_zeros = 0;
		for(int i=0; i<result_coeff.length; i++)
		{
			if(result_coeff[i] == 0)
			{
				count_zeros++;
			}
		}
		
		double[] r_coeff = new double[result_coeff.length - count_zeros];
		int[] r_expo = new int[result_coeff.length - count_zeros];
		
		int index3 = 0;
		for(int i=0; i<result_coeff.length; i++)
		{
			if(result_coeff[i] != 0.0)
			{
				r_coeff[index3] = result_coeff[i];
				r_expo[index3] = result_expo[i];
				index3++;
			}
		}
		
		Polynomial result = new Polynomial(r_coeff, r_expo);
		
		return result;
		
	}
	
	public double evaluate(double x)
	{
		double result = 0;
		for(int i =0; i<this.arr.length; i++)
		{
			result = result + this.arr[i] * Math.pow(x, this.expo[i]);
		}
		return result;
	}
	
	public boolean hasRoot(double num)
	{
		if(evaluate(num) == 0)
		{
			return true;
		}
		return false;
	}
	
	public void saveToFile(String filename) throws FileNotFoundException
	{
		PrintStream ps = new PrintStream(filename);
		for(int i =0; i<this.arr.length; i++)
		{
			if(this.expo[i] == 0)
			{
				if(this.arr[i] > 0 && i != 0)
				{
					ps.print(String.valueOf("+" + this.arr[i]));
				}
				else
				{
					ps.print(String.valueOf(this.arr[i]));
				}
			}
			else
			{
				if(this.arr[i] > 0 && i != 0)
				{
					ps.print(String.valueOf("+" + this.arr[i]) + "x" + String.valueOf(this.expo[i]));
				}
				
				else
				{
				ps.print(String.valueOf(this.arr[i]) + "x" + String.valueOf(this.expo[i]));
				}
			}
		}
		ps.close();
	}
	
}
