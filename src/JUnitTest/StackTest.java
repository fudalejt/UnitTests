package JUnitTest;

import static org.junit.Assert.*;
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test;

import Calc.Stack;

public class StackTest {
	Stack stack = new Stack(10);
	
	@Test
	public void isEmpty(){
		assertEquals("Wrong returned value of isEmpty() function", stack.isEmpty(), true);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testPop(){
		stack.pop();				
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testTtop(){
		stack.top();				
	}
	
	@Test
	public void test1(){
		stack = new Stack(10);
		String symbol = new String("symbol");
		stack.push(symbol);
		assertEquals(symbol, stack.top());
		assertFalse(stack.isEmpty());
		assertEquals(symbol, stack.top());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void test2(){
		stack = new Stack(10);
		String symbol = new String("symbol");
		stack.push(symbol);
		String symbol2 = stack.pop();
		assertSame(symbol, symbol2);
		assertTrue(stack.isEmpty());
		stack.pop();
	}
	
	@Test
	public void test3(){
		String symbol1 = new String("symbol1");
		String symbol2 = new String("symbol2");
		String symbol3 = new String("symbol3");
		stack.push(symbol1);
		stack.push(symbol2);
		stack.push(symbol3);
		assertSame(stack.pop(), symbol3);
		assertSame(stack.pop(), symbol2);
		assertSame(stack.pop(), symbol1);
	}
	
	@Test
	public void test4(){		
		stack.push(null);
		assertNull(stack.pop());		
	}
	
	@Test
	public void test5(){		
		stack = new Stack(10);
		try{
			stack.pop();
		}catch(Exception e){
			e.printStackTrace();
		}
		stack.push("symbol");
		assertEquals(stack.pop(), "symbol");
	}	
	
	@After
	public void clean(){
		stack = null;
	}
}
