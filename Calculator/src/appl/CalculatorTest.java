package appl;

import static org.junit.Assert.*;

import org.junit.Test;

import excp.TooBigNumberException;

public class CalculatorTest {

	@Test
	public void add0intoNewCalc10() {
		Calculator calc = new Calculator(10.0);
		
		calc.Add(0);
		assertEquals(10,calc.getResult());
	}

	@Test(expected = ArithmeticException.class)
	public void shouldThrowArithmeticException() throws Exception {
		Calculator calc = new Calculator(1.0);
		calc.Divide(0);
	}
	
	@Test(expected = TooBigNumberException.class)
	public void shouldThrowTooBigNumberException() throws Exception {
		Calculator calc = new Calculator(20.0);
		calc.Factorial();
	}
}

