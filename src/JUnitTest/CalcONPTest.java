package JUnitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before; 
import org.junit.Test;

import Calc.CalcONP;

public class CalcONPTest{
	CalcONP calc;
	double expectedResult;
	
	@Before
	public void prepare(){		
		calc = new CalcONP();
	}
	
	@Test
	public void testAdd() {
		String expression = new String("((2 + 3) + 8)");
		double expected = 13;
		assertEquals(calc.calculate(expression), expected, 0.01d);
		
		expression = new String("(7.1 + (2.5 + 3.2))");
		expected = 12.8f;
		assertEquals(calc.calculate(expression), expected, 0.01d);
	}
	
	@Test
	public void testSub() {
		String expression = new String("((2 - 3) - 8)");
		double expected = -9;
		assertEquals(calc.calculate(expression), expected, 0.01d);
		
		expression = new String("((5.2 - 3.9) - 8.1)");
		expected = -6.8;
		assertEquals(calc.calculate(expression), expected, 0.01d);
	}
	
	@Test
	public void testMulti() {
		String expression = new String("(2 * (6 * 3))");
		double expected = 36;
		assertEquals(calc.calculate(expression), expected, 0.01d);
		
		expression = new String("(2.2 * (4.5 * 3.8))");
		expected = 37.62;
		assertEquals(calc.calculate(expression), expected, 0.01d);
	}
	
	@Test
	public void testDiv() {
		String expression = new String("(12 / (6 / 3))");
		double expected = 6;
		assertEquals(calc.calculate(expression), expected, 0.01d);
		
		expression = new String("(16.1 / (6.6 / 2.9))");
		expected = 7.07;
		assertEquals(calc.calculate(expression), expected, 0.01d);
	}
	
	@Test 
	public void mixedExpr(){
		String expression = new String("((11 * (6 - 3)) / 2)");
		double expected = 16.5;
		assertEquals(calc.calculate(expression), expected, 0.01d);
		
		expression = new String("((16.6 + (6.6 / 2.9)) * 4.5)");
		expected = 84.94;
		assertEquals(calc.calculate(expression), expected, 0.01d);
	}
	
	@After
	public void clean(){
		calc = null;
	}
	
}
