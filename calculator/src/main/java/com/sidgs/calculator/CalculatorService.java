package com.sidgs.calculator;

public class CalculatorService {
	
	
	public int Calculate(String op1, String op2, String op) {
		int r=0;
		
		switch(op) {
		
			case "Add": r= Integer.parseInt(op1)+ Integer.parseInt(op2);
			break;
			
			case "Subtract": r= Integer.parseInt(op1)- Integer.parseInt(op2);
			break;
			
			case "Multiply": r= Integer.parseInt(op1)* Integer.parseInt(op2);
			break;
			
			case "Divide": r= Integer.parseInt(op1)/Integer.parseInt(op2);
			break;
			
		}
		return r;
	}
	

	
	
}
