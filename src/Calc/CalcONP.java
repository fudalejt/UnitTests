package Calc;
import java.util.LinkedList;

public class CalcONP {
	
	private Stack stack = new Stack(100);
	private int index = 0;
	static int DOT = 46;
	static int PLUS = 43;
	static int MINUS = 45;
	static int TIMES = 42;
	static int INTO = 47;
		
	public static void main(String[] args) {
		CalcONP calc = new CalcONP();		
		System.out.println(calc.calculate("(2.5 + 2)"));
	}
	
	public double calculate(String expression){		
		LinkedList<String> symbols = convertExprToSymbolList(expression);				
		LinkedList<String> onpExpr = convertSymbolListToONP(symbols);		
		return resultFromONP(onpExpr);
	}	
	
	private LinkedList<String> convertExprToSymbolList(String expression){
		byte[] b = expression.getBytes();		
		LinkedList<String> symbols = new LinkedList<String>();	
		String newEl = new String();
		
		for(int i = 0; i < expression.length(); i++){
			if(b[i] >= 48 && b[i] <= 57) //numbers
				newEl +=  Integer.toString(b[i]-48);
			else if(b[i] == DOT)	
			{	 	
				newEl +=  ".";
			}
			else if(b[i] == PLUS || b[i] == MINUS  || b[i] == TIMES || b[i] == INTO || b[i] == 40 || b[i] == 41){
				if(!newEl.isEmpty())
					symbols.add(newEl);
				newEl = new String(Character.toString((char)b[i]));
				symbols.add(newEl);
				newEl = new String("");				
			}		
		}
		if(!newEl.isEmpty())
			symbols.add(newEl);
		return symbols;
	}
	
	private LinkedList<String> convertSymbolListToONP(LinkedList<String> symbols){
		index = 0;
		LinkedList<String> output = new LinkedList<String>();
		onp(symbols, output);		
		return output;
	}
	
	private void onp(LinkedList<String> input, LinkedList<String> output){
		String a, c;
		c = input.get(index++);
		if(c.equals("(")){
			onp(input, output);
			a = input.get(index++);
			onp(input, output);
			index++;
			output.add(a);
		}
		else{
			output.add(c);
		}		
	}
	
	private boolean isNumber(String symbol)
	{
		byte[] symByte = symbol.getBytes();
		for(int i = 0; i < symbol.length(); i++){
			if((symByte[i] < 48 || symByte[i] > 57) && !(symByte[i] == DOT)){	
				return false;
			}
		}			
		return true;
	}
	
	private double operate(String a, String operator, String b){
		if(operator.equals("+"))
			return Double.parseDouble(a) + Double.parseDouble(b);
		else if(operator.equals("-"))
			return Double.parseDouble(a) - Double.parseDouble(b);	
		else if(operator.equals("*"))
			return Double.parseDouble(a) * Double.parseDouble(b);	
		else if(operator.equals("/"))
			return Double.parseDouble(a) / Double.parseDouble(b);	
		return 0;
	}
	
	private double resultFromONP(LinkedList<String> symbols){
		for(String symbol : symbols){
			if(isNumber(symbol))
				stack.push(symbol);
			else
			{
				String a = stack.pop();
				String b = stack.pop();
				double result = operate(b, symbol, a);
				stack.push(Double.toString(result));
			}
		}
		String result = stack.top();
		return Double.parseDouble(result);
	}
}
