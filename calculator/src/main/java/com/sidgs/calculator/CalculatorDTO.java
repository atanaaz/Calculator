package com.sidgs.calculator;

public class CalculatorDTO {

	String op1;
	String op2;
	String op;
	int res;
	
	public CalculatorDTO(String op1,String op2,String op,int res) {
		this.op1=op1;
		this.op2=op2;
		this.op=op;
		this.res=res;
		
	}
	
	public String getOp1() {
		return op1;
	}
	
	public String getOp2() {
		return op2;
	}
	public String getOp() {
		return op;
	}
	public int getResult() {
		return res;
	}
	
}
