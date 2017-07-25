package com.yjy.maventest.designmodel.抽象工厂模式;

//创建一个工厂创造器/生成器类，通过	信息来获取工厂。
public class FactoryProducter {
	public static AbstractFactory getFactory(String factory) {
		if ("ANIMAL2".equals(factory)) {
			return new Animal2Factory();
		} else if ("COLOR".equals(factory)) {
			return new ColorFactory();
		}
		return null;
	}
}	
