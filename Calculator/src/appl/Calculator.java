package appl;

import excp.TooBigNumberException;
import excp.ArithmeticException;
import excp.NumberFormatException;

public class Calculator{
	private double result;
	
	Calculator(){
		result=0;
	}
	
	Calculator(double x){
		result=x;
	}
	
	public double getResult() {
		return result;
	}
	
	public void Add(double x) {
		result+=x;
	}
	
	public void Subtrackt(double x) {
		result-=x;
	}
	
	public void Multiply(double x) {
		result*=x;
	}
	
	public void Divide(double x) throws ArithmeticException {
		if(x == 0) {
			throw new ArithmeticException("ArithmeticException: Dividing by 0 is not permited");
		}
		
		result/=x;
	}
	
	public void Factorial() throws TooBigNumberException {
		if(result>10) {
			throw new TooBigNumberException("TooBigNumberException: It can't be more than 10");
		}
		
		result=factorialing(result);
	}
	
	public double factorialing(double n) {
	    if (n==0)
	        return 1;
	    else
	        return (n*factorialing(n-1));
	}
}
