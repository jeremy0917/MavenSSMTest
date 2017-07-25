package com.yjy.maventest.aop;

public class BSleep implements Sleep{

	@Override
	public void sleep() {
		System.out.println("B Sleep!");
	}
	
}
