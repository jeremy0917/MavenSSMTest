package com.yjy.maventest.aop;

public class ASleep implements Sleep{

	@Override
	public void sleep() {
		System.out.println("A Sleep!");
	}
	
}
