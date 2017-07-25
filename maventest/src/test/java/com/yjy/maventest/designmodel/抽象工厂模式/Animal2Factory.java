package com.yjy.maventest.designmodel.抽象工厂模式;


public class Animal2Factory extends AbstractFactory{

	@Override
	public Color getColor(String color) {
		return null;
	}

	@Override
	public Animal2 getAnimal2(String animal) {
		if (animal == null || "".equals(animal)) {
			return null;
		}
		if ("DOG".equals(animal)) {
			return new Dog();
		} else if ("CAT".equals(animal)) {
			return new Cat();
		} else if ("DUCK".equals(animal)) {
			return new Duck();
		}
		return null;
	}
	
	
}
