package com.yjy.maventest.designmodel.单例模式.饿汉式;

//饿汉式的实例是类的静态变量，只加载一次，但是类加载时就初始化，浪费内存。
public class HungrySingleton {
	private static HungrySingleton instance = new HungrySingleton();

	private HungrySingleton() {

	}

	public static HungrySingleton getInstance() {
		if (null == instance) {
			instance = new HungrySingleton();
		}
		return instance;
	}
}
