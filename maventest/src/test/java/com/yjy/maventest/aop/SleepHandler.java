package com.yjy.maventest.aop;

public class SleepHandler {
	public void before(){
		System.out.println("before sleep");
	}
	
	public void after(){
		System.out.println("after sleep");
	}
}
