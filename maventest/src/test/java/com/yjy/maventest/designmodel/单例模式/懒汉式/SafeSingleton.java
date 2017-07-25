package com.yjy.maventest.designmodel.单例模式.懒汉式;

public class SafeSingleton {
	private static SafeSingleton instance;
	
	private SafeSingleton(){
		
	}
	
	public static synchronized SafeSingleton getInstance(){
		if (null == instance) {
			instance = new SafeSingleton(); 
		}
		return instance;
	}
}
