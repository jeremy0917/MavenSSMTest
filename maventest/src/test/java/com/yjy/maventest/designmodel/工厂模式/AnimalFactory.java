package com.yjy.maventest.designmodel.工厂模式;

public class AnimalFactory {
	
	public Animal getAnimal(String animal) {
		
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
