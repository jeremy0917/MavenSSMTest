package com.yjy.maventest.designmodel.单例模式.懒汉式;

public class UnsafeSingleton {
	private static UnsafeSingleton instance;
	
	private UnsafeSingleton() {
		
	}
	
	public static UnsafeSingleton getInstance(){
		if (null == instance) {
			instance = new UnsafeSingleton();
		}
		return instance;
	}
}
