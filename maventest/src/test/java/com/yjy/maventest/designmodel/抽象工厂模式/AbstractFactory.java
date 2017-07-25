package com.yjy.maventest.designmodel.抽象工厂模式;

//创建抽象类来获取工厂
public abstract class AbstractFactory {
	public abstract Color getColor(String color);

	public abstract Animal2 getAnimal2(String animal);
}
