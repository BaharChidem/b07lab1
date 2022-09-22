public class Polynomial {
	double[] arr;
	
	public Polynomial()
	{
		arr = new double[1];
		this.arr[0] = 0;
	}
	
	public Polynomial(double[] num)
	{
		arr = new double[num.length];
		for(int i=0; i<this.arr.length; i++)
		{
			this.arr[i] = num[i];
		}
	}
	
	public Polynomial add(Polynomial ob)
	{
		int length1 = this.arr.length;
		int length2 = ob.arr.length;
		double[] result_arr;
		Polynomial p = null;
		
		if(length1 > length2)
		{
			result_arr = new double[length1];
			for(int i=0; i<length2; i++)
			{
				result_arr[i] = this.arr[i] + ob.arr[i];
			}
			for(int i=length2; i<length1; i++)
			{
				result_arr[i] = ob.arr[i];
			}
			p = new Polynomial(result_arr);
		}
		
		if(length1 < length2)
		{
			result_arr = new double[length2];
			for(int i=0; i<length1; i++)
			{
				result_arr[i] = this.arr[i] + ob.arr[i];
			}
			for(int i=length1; i<length2; i++)
			{
				result_arr[i] = ob.arr[i];
			}
			p = new Polynomial(result_arr);
		}
		
		if(length1 == length2)
		{
			result_arr = new double[length2];
			for(int i=0; i<length1; i++)
			{
				result_arr[i] = this.arr[i] + ob.arr[i];
			}
			p = new Polynomial(result_arr);
			
		}
	
		return p;
	}
	
	public double evaluate(double x)
	{
		double result = 0;
		for(int i =0; i<this.arr.length; i++)
		{
			result = result + this.arr[i] * Math.pow(x, i);
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

}